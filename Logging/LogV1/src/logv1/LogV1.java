/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logv1;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author chand
 */
public class LogV1 {
    private static final Logger LOGGER = Logger.getLogger(LogV1.class.getName());

    public static void main(String[] args) {

            LOGGER.info(" Info Message From App");
            System.out.println(" Application Output ");
            LOGGER.info(" Info Message From App");
    }
    
}
