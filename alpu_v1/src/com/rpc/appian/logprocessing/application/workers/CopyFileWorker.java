/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.workers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CONRPA2
 */
public class CopyFileWorker implements Runnable {

    String serverName;

    public CopyFileWorker() {
    }

    public CopyFileWorker(String serverName) {
        setServerName(serverName);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1000l);
                System.out.println("Call shell script here" + getServerName());
            } catch (InterruptedException ex) {
                Logger.getLogger(CopyFileWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return this.serverName;
    }
}
