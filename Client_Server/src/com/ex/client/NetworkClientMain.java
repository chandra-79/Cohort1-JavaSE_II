package com.ex.client;

import java.util.*;
import java.util.concurrent.*;

public class NetworkClientMain{
    
    public static void main(String [] args){
       
        ExecutorService es = Executors.newCachedThreadPool();
        
        Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();
        
        String host = "localhost";
        
        for(int port = 10000; port < 10010; port++){
            RequestResponse lookup = new RequestResponse(host, port);
            NetworkClientCallable callable = new NetworkClientCallable(lookup);
            Future<RequestResponse> future = es.submit(callable);
            callables.put(lookup, future);
        }
        
        es.shutdown();
        
        try{
            es.awaitTermination(5, TimeUnit.SECONDS);
        }catch(InterruptedException ex){
            System.out.println(" Stopped Waiting Early");
        }
        
        for(RequestResponse lookup : callables.keySet()){
            Future<RequestResponse> future = callables.get(lookup);
            
            try{
                lookup = future.get();
                System.out.println( lookup.host + " :" + lookup.port + " " + lookup.response);
            }catch(ExecutionException | InterruptedException ex){
                System.out.println(" Error talking to " + lookup.host + " : " + lookup.port);
            }
        }
    }
}