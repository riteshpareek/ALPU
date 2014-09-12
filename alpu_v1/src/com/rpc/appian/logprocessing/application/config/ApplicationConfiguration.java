/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.config;

import com.rpc.appian.logprocessing.application.base.ApplicationBase;
import com.rpc.appian.logprocessing.application.logger.AppLogger;
import com.rpc.appian.logprocessing.application.resources.ResourceConfig;
import com.rpc.appian.logprocessing.model.hibernate.HibernateUtil;

import java.io.File;
import java.util.Properties;

/**
 *
 * @author CONRPA2
 */
public class ApplicationConfiguration {

    private static ApplicationBase base;
    private final static String loaclCtx = "local";
    private final static String devCtx = "dev";
    private final static String qaCtx = "uat";
    private final static String prodCtx = "prod";

    private static String appConfigFile;
    private static String hibernateConfigFile;
    private static String log4jConfigFile;

    public static String getLog4jConfigFile() {
        return log4jConfigFile;
    }

    public static void setLog4jConfigFile(String log4jConfigFile) {
        ApplicationConfiguration.log4jConfigFile = log4jConfigFile;
    }

    public static String getAppConfigFile() {
        return appConfigFile;
    }

    private static void setAppConfigFile(String appConfigFile) {
        ApplicationConfiguration.appConfigFile = appConfigFile;
    }

    public static String getHibernateConfigFile() {
        return hibernateConfigFile;
    }

    private static void setHibernateConfigFile(String hibernateConfigFile) {
        ApplicationConfiguration.hibernateConfigFile = hibernateConfigFile;
    }

    public static void configure(String applicationContext, String appRealPath) {

        appRealPath = appRealPath + File.separator + "conf";

        System.out.println("Application base path is :: " + appRealPath);
        setLog4jConfigFile(appRealPath + File.separator + "log4j.properties");

        if (loaclCtx.equalsIgnoreCase(applicationContext)) {

            setAppConfigFile(appRealPath + File.separator + "envbase_local.properties");
            setHibernateConfigFile(appRealPath + File.separator + "hibernate_local.cfg.xml");
            setLog4jConfigFile(appRealPath + File.separator + "log4j_local.properties");
        } else if (devCtx.equalsIgnoreCase(applicationContext)) {

            setAppConfigFile(appRealPath + File.separator + "envbase_dev.properties");
            setHibernateConfigFile(appRealPath + File.separator + "hibernate_dev.cfg.xml");
            setLog4jConfigFile(appRealPath + File.separator + "log4j_dev.properties");
        } else if (qaCtx.equalsIgnoreCase(applicationContext)) {

            setAppConfigFile(appRealPath + File.separator + "envbase_uat.properties");
            setHibernateConfigFile(appRealPath + File.separator + "hibernate_uat.cfg.xml");
            setLog4jConfigFile(appRealPath + File.separator + "log4j_uat.properties");
        } else if (prodCtx.equalsIgnoreCase(applicationContext)) {

            setAppConfigFile(appRealPath + File.separator + "envbase_prod.properties");
            setHibernateConfigFile(appRealPath + File.separator + "hibernate_prod.cfg.xml");
            setLog4jConfigFile(appRealPath + File.separator + "log4j_prod.properties");
        }

    }

    public static ApplicationBase buildApplicationBase() {
        base = ApplicationBase.getInstance();
        System.out.println("What is base:::: " + base);

        Properties appProps = new ResourceConfig().load(appConfigFile);
        
        base.setServerNamesCsv(appProps.getProperty("target.servername.csv"));
        base.setLocalTempLogFolder(appProps.getProperty("local.temp.logs.folder"));
        base.setParsableLoggingTypes(appProps.getProperty("parse.logging.levels.csv"));
        
        base.setAppBasePath(appProps.getProperty("lp.base"));
        base.setHibernateConfigFile(hibernateConfigFile);
        base.setAppContext(appConfigFile);

        System.out.println("What is base:::: " + base.getServerNamesCsv());
        return base;

    }

    public static void buildLoggerBase() {
        AppLogger.getLogger(ApplicationConfiguration.class, log4jConfigFile);
    }

    public static void buildHibernateUtils() {
        System.err.println("Hibernate Config :: " + hibernateConfigFile);
        HibernateUtil.confiure(hibernateConfigFile);
    }
}
