/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.config;

import com.rpc.appian.logprocessing.application.resources.ResourceConfig;
import java.util.Properties;

/**
 *
 * @author CONRPA2
 */
public class EnvConfig {

    Properties envProp = new Properties();

    private String prodServerNamesCsv;
    private String uatServerNamesCsv;

    public EnvConfig() {
        setEnvProp(new ResourceConfig().load("envbase.properties"));
    }

    public Properties getEnvProp() {
        return envProp;
    }

    public void setEnvProp(Properties envProp) {
        this.envProp = envProp;
    }

    public String getProdServerNamesCsv() {
        return this.envProp.getProperty("log.prod.server.csv");
    }

    public String getUatServerNamesCsv() {
        return this.envProp.getProperty("log.uat.server.csv");
    }

}
