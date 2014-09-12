/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.core.engine;

import com.rpc.appian.logprocessing.application.base.ApplicationBase;
import com.rpc.appian.logprocessing.application.utils.FileUtil;
import com.rpc.appian.logprocessing.model.pojo.RawLogPojo;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author CONRPA2
 */
public class LogAnalyzerEngine {

    public static ArrayList<File> getListOfCandidateLogFiles() {
        ArrayList<File> listOfCandidateFiles = new ArrayList<>();

        Date date = new Date();

        ApplicationBase appBase = ApplicationBase.getInstance();
        System.out.println(appBase.getLocalTempLogFolder());
        
        File[] allFilesList = FileUtil.getRecursiveListOfAllFiles(appBase.getLocalTempLogFolder(), null);

        for (File file : allFilesList) {
           //if (FileUtil.wasFileModifiedAfter(new Date(file.lastModified()), date)) {
                if (!file.isDirectory()) {
                    listOfCandidateFiles.add(file);
                }
           //}
        }
        return listOfCandidateFiles;
    }

    public static ArrayList<RawLogPojo> getProcessedLogs(String serverName, ArrayList<File> candidateLogsFilesList) {

        String parsableLoggingTypes = ApplicationBase.getInstance().getParsableLoggingTypes();
        Date parsableTimeStamp = new Date();
        ArrayList<RawLogPojo> appianLogPojoList = new ArrayList<>();

        for (File file : candidateLogsFilesList) {
            System.out.println("Now Processing File :: " + file.getName());
            
            appianLogPojoList.addAll(FileUtil.readAndParse(file, parsableLoggingTypes, parsableTimeStamp, serverName));
        
        }
        return appianLogPojoList;
    }

}
