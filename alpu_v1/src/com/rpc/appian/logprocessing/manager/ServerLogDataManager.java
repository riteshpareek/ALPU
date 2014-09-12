/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.manager;

import java.util.ArrayList;

import org.quartz.JobExecutionContext;

import com.rpc.appian.logprocessing.application.base.BaseManager;
import com.rpc.appian.logprocessing.model.pojo.RawLogPojo;

/**
 *
 * @author CONRPA2
 */
public interface ServerLogDataManager extends BaseManager {

    public void copyFilesFromServer();

    public ArrayList<RawLogPojo>  processLogs(String serverName);

    public void bundleLogs(ArrayList<RawLogPojo> parocessedAppianLogObjsList);

    public void cleanUp();

}
