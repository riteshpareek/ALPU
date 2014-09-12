/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.main;

import com.rpc.appian.logprocessing.application.consts.AppConstant;
import com.rpc.appian.logprocessing.application.ApplicationContextListner;
import com.rpc.appian.logprocessing.application.jobs.ApplicationScheduler;

import com.rpc.appian.logprocessing.application.base.ApplicationBase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author CONRPA2
 */
public class AppianLogsAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new ApplicationContextListner().contextInitialized("uat");

        String[] serverNamesArr = ApplicationBase.getInstance().getServerNamesCsv().split(AppConstant.CSV_SPLITER);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (String serverName : serverNamesArr) {
            executor.execute(new ApplicationScheduler(serverName));
        }

        executor.shutdown();

    }

}
