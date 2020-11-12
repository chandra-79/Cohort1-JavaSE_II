/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author chand
 */
public class Others {

    
    public static int i = 10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println(" Before Sleep ::: " + i  + " ::: " + name );
                i++;
                TimeUnit.SECONDS.sleep(1);i++;
                System.out.println(" After Sleep :::  " + i + " ::: " +  name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread1.start();
        thread2.start();
    }

}
