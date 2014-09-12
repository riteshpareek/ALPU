/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.base;

/**
 *
 * @author CONRPA2
 */
public class ApplicationBase {

    private static ApplicationBase instance = null;

    private ApplicationBase() {
    }

    public static ApplicationBase getInstance() {
        if (instance == null) {
            instance = new ApplicationBase();
        }
        return instance;

    }

    private String appContext;
    private String hibernateConfigFile;
    private String appBasePath;
    private String serverNamesCsv;
    private String targetServerLogFolder;
    private String localTempLogFolder;
    private String parsableLoggingTypes;


    public String getAppContext() {
        return appContext;
    }

    public void setAppContext(String appContext) {
        this.appContext = appContext;
    }

    public String getHibernateConfigFile() {
        return hibernateConfigFile;
    }

    public void setHibernateConfigFile(String hibernateConfigFile) {
        this.hibernateConfigFile = hibernateConfigFile;
    }

    public String getAppBasePath() {
        return appBasePath;
    }

    public void setAppBasePath(String appBasePath) {
        this.appBasePath = appBasePath;
    }

    public String getServerNamesCsv() {
        return serverNamesCsv;
    }

    public void setServerNamesCsv(String serverNamesCsv) {
        this.serverNamesCsv = serverNamesCsv;
    }

    public String getTargetServerLogFolder() {
        return targetServerLogFolder;
    }

    public void setTargetServerLogFolder(String targetServerLogFolder) {
        this.targetServerLogFolder = targetServerLogFolder;
    }

    public String getLocalTempLogFolder() {
        return localTempLogFolder;
    }

    public void setLocalTempLogFolder(String localTempLogFolder) {
        this.localTempLogFolder = localTempLogFolder;
    }

    public String getParsableLoggingTypes() {
       return this.parsableLoggingTypes;
    }

    public void setParsableLoggingTypes(String parsableLoggingTypes) {
        this.parsableLoggingTypes = parsableLoggingTypes;
    }
}
