/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logv4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author chand
 */
public class LogV4 {

    private static final Logger LOGGER = Logger.getLogger(LogV4.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("log_v4.properties"));
              LOGGER.setLevel(Level.INFO);
        LOGGER.addHandler(new ConsoleHandler());
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }
      
        try {
            //FileHandler file name with max size and number of log files limit
            Handler fileHandler = new FileHandler("C:\\Temp\\logger.log", 20000, 5);
            fileHandler.setFormatter(new SimpleFormatter());
            //setting custom filter for FileHandler
            LOGGER.addHandler(fileHandler);
            
            for(int i=0; i<10; i++){
                //logging messages
                LOGGER.log(Level.INFO, "Msg"+i);
            }
            for(int i=0; i<10; i++){
                //logging messages
                LOGGER.log(Level.SEVERE, "Msg"+i);
            }
            LOGGER.log(Level.CONFIG, "Config data");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

    }

}
