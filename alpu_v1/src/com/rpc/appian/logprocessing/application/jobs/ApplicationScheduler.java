/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.jobs;

import java.util.ArrayList;

import com.rpc.appian.logprocessing.manager.NotificationsManager;
import com.rpc.appian.logprocessing.manager.ReportsGeneratorManager;
import com.rpc.appian.logprocessing.manager.ServerLogDataManager;
import com.rpc.appian.logprocessing.manager.impl.NotificationsManagerImpl;
import com.rpc.appian.logprocessing.manager.impl.ReportsGeneratorManagerImpl;
import com.rpc.appian.logprocessing.manager.impl.ServerLogDataManagerImpl;
import com.rpc.appian.logprocessing.model.pojo.RawLogPojo;

public class ApplicationScheduler implements Runnable {

    String serverName;

    public ApplicationScheduler() {

    }

    public ApplicationScheduler(String serverName) {
        this.serverName = serverName;
    }

    ServerLogDataManager _serverLogsDataManager;
    ReportsGeneratorManager _reportsGeneratorManager;
    NotificationsManager _notificationsManager;

    @Override
    public void run() {

        wakeUpManagers();

        try {
            // _serverLogsDataManager.copyFilesFromServer();
        	ArrayList<RawLogPojo> parocessedAppianLogObjsList =  _serverLogsDataManager.processLogs(serverName);
            
        	_serverLogsDataManager.bundleLogs(parocessedAppianLogObjsList );
            
        	//_reportsGeneratorManager.generateReports();
            //_notificationsManager.sendNotifications();
            //_serverLogsDataManager.cleanUp();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void wakeUpManagers() {
        _serverLogsDataManager = new ServerLogDataManagerImpl();
        _reportsGeneratorManager = new ReportsGeneratorManagerImpl();
        _notificationsManager = new NotificationsManagerImpl();
    }
}
