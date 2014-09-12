/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application;

import com.rpc.appian.logprocessing.application.base.ApplicationBase;
import com.rpc.appian.logprocessing.application.config.ApplicationConfiguration;


/**
 *
 * @author CONRPA2
 */
public class ApplicationContextListner {

    public void contextInitialized(String env) {

        String realPath = System.getProperty("user.dir");

        ApplicationConfiguration.configure(env, realPath);
        ApplicationConfiguration.buildLoggerBase();

        ApplicationBase appBase = ApplicationConfiguration.buildApplicationBase();

        System.err.println("Application Base obj 1 : " + appBase);
        System.err.println("Application Base obj 2 : " + appBase.getServerNamesCsv());
        
        ApplicationConfiguration.buildHibernateUtils();

        System.out.println("Context set......");
    }

}
