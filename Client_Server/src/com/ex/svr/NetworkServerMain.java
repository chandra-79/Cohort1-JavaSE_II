package com.ex.svr;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class NetworkServerMain {

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        List <Runnable> runners = new ArrayList<>();
        
        for(int port = 10000; port < 10010; port++){
            Runnable runs;
            try{
                runs = new PriceRangeServer(port, 20,110);
                runners.add(runs);
            }catch(IOException e){
                System.out.println(" Port :::: " + port + " already in use");
            }
            
            for(Runnable r : runners ){
                es.execute(r);
            }
            
            try{
                Thread.sleep(500);
            }catch(InterruptedException ie){
                ie.printStackTrace();
            }
            
            try{
                System.in.read();
            }catch(IOException ex){
                System.out.println( " Exception in read " + ex.getMessage());
            }
                
                
                System.out.println(" &&&&&&&&&&&&&&&&& Quitting &&&&&&&&&&&&&&&&&&");
                        es.shutdown();
            }
                
        }
    }
    