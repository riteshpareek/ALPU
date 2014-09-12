/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.logger;

import com.rpc.appian.logprocessing.application.consts.AppConstant;
import com.rpc.appian.logprocessing.application.resources.ResourceConfig;
import java.io.File;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.ErrorCode;

public class AppLogger extends DailyRollingFileAppender {

    static AppLogger instance = null;
    static Logger logger = null;
    static String logConfigFileName;

    public static synchronized AppLogger getInstance() {
        if (instance == null) {
            return new AppLogger();
        }
        return instance;
    }

    public AppLogger() {
    }

    public static synchronized Logger getLogger(Class<?> clazz) {
        if (logger == null) {
        	
            PropertyConfigurator.configure(new ResourceConfig().load(logConfigFileName));
            logger = Logger.getLogger(clazz);
            logger.addAppender(getInstance());
        }
        return logger;
    }

    public static synchronized Logger getLogger(Class clazz, String resourceFilename) {
        logConfigFileName = resourceFilename;
        if (logger == null) {
            PropertyConfigurator.configure(new ResourceConfig().load(logConfigFileName));
            logger = Logger.getLogger(clazz);
            logger.addAppender(getInstance());
        }
        return logger;
    }

    @Override
    public void activateOptions() {
        if (fileName != null) {
            try {
                fileName = getNewLogFileName();
                setFile(fileName, fileAppend, bufferedIO, bufferSize);
            } catch (Exception e) {
                e.printStackTrace();
                errorHandler.error("Error while activating log options", e,
                        ErrorCode.FILE_OPEN_FAILURE);
            }
        }
    }

    private String getNewLogFileName() {
        if (fileName != null) {
            final String DOT = ".";
            final String HIPHEN = "-";


            final File logFile = new File(fileName);
            final String fileName = logFile.getName();
            String newFileName = AppConstant.BLANK_STR;
            final int dotIndex = fileName.indexOf(DOT);
            if (dotIndex != -1) {

                newFileName = fileName.substring(0, dotIndex) + HIPHEN
                        + +System.currentTimeMillis() + DOT
                        + fileName.substring(dotIndex + 1);
            } else {

                newFileName = fileName + HIPHEN + System.currentTimeMillis();
            }
            return logFile.getParent() + File.separator + newFileName;
        }
        return null;
    }
}
