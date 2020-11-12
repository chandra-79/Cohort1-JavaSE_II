package com.ex.svr;

import java.io.*;
import java.net.*;



public class PriceRangeServer implements Runnable {

    private String price;
    private ServerSocket ss;
    
    public PriceRangeServer(int port, int low, int high) throws IOException{
        ss = new ServerSocket(port);
        ss.setSoTimeout(250);
        double d = Math.random() * (high - low) + low;
        price = String.format("%.2f",d);
    }
    
    public void accept() throws IOException{
    
        System.out.println(" Incoming connections on Port " + ss.getLocalPort());
        while(!Thread.interrupted()){
            try(Socket sock = ss.accept();
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()))){
                        try{
                            Thread.sleep(2000);
                        }catch(InterruptedException ex){
                            return;
                    }
                        bw.write(price);
            }catch(SocketTimeoutException ste){
                
            }
        }
        System.out.println(" done accepting new requests !!!!");
    }
    
    @Override 
    public void run() {
        try{
            accept();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
