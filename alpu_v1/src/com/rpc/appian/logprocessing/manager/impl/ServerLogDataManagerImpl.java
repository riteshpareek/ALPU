/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.manager.impl;

import com.rpc.appian.logprocessing.application.impl.BaseManagerImpl;
import com.rpc.appian.logprocessing.application.logger.AppLogger;
import com.rpc.appian.logprocessing.core.engine.LogAnalyzerEngine;
import com.rpc.appian.logprocessing.manager.*;
import com.rpc.appian.logprocessing.model.dao.RawLogDao;
import com.rpc.appian.logprocessing.model.pojo.RawLogPojo;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.hibernate.exception.DataException;

/**
 *
 * @author CONRPA2
 */
public class ServerLogDataManagerImpl extends BaseManagerImpl implements
		ServerLogDataManager {

	/**
	 * **** SET LOGGER
	 */
	static Logger log = AppLogger.getLogger(ServerLogDataManagerImpl.class);
	/**
	 * **** LOGGER SET
	 */
	static RawLogDao rawLogDao = (RawLogDao) getDao(BaseManagerImpl.RAW_LOG_DAO_KEY);

	static ServerLogDataManagerImpl instance;

	public ServerLogDataManagerImpl() {
	}

	@Override
	public void copyFilesFromServer() {

	}

	@Override
	public ArrayList<RawLogPojo> processLogs(String serverName) {

		ArrayList<File> candidateLogsFilesList = LogAnalyzerEngine
				.getListOfCandidateLogFiles();

		System.out.println("Size of Candidate files"
				+ candidateLogsFilesList.size());

		ArrayList<RawLogPojo> appianLogPojoList = LogAnalyzerEngine
				.getProcessedLogs(serverName, candidateLogsFilesList);

		System.out.println("Log processing done " + appianLogPojoList.size());

		return appianLogPojoList;

	}

	@Override
	public void bundleLogs(ArrayList<RawLogPojo> parocessedAppianLogObjsList) {
		System.out.println("Bundeling logs");
		try {
			for (RawLogPojo logPojoObj : parocessedAppianLogObjsList) {

				try {
					rawLogDao.saveObject(logPojoObj);
				} catch (DataException dex) {
					dex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void cleanUp() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

}
