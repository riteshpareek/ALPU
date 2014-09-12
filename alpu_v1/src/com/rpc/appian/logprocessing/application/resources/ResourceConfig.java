package com.rpc.appian.logprocessing.application.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceConfig {

    Properties p = new Properties();

    public Properties load(String resourceName) {
        try {
            System.err.println("Resource name :: " + resourceName);
            //   InputStream is = getClass().getResourceAsStream(resourceName);
            InputStream is = new FileInputStream(resourceName);
            System.err.println("IS :: " + is);
            this.p.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.p;
    }
}
