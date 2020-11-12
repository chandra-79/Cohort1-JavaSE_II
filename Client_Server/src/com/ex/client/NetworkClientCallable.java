package com.ex.client;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.concurrent.*;

public class NetworkClientCallable implements Callable<RequestResponse> {

    private final RequestResponse lookup;
    
    public NetworkClientCallable(RequestResponse lookup){
        this.lookup = lookup;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public RequestResponse call() throws IOException {
        try (Socket sock = new Socket(lookup.host, lookup.port);
                Scanner scanner = new Scanner(sock.getInputStream())) {
            lookup.response = scanner.next();
            return lookup;
        }
    }
}
