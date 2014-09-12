/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.rpc.appian.logprocessing.application.consts.AppConstant;
import com.rpc.appian.logprocessing.model.pojo.RawLogPojo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.ArrayUtils;

public class FileUtil {

	public static final String LOGFILE_DB = "db";
	public static final String LOGFILE_GW = "gw";
	public static final String LOGFILE_APPLICATION = "application";

	Date currentDate = new Date(System.currentTimeMillis() - 4800 * 1000);

	public static File[] getRecursiveListOfAllFiles(String folderPath,
			File[] listOfFiles) {

		if (listOfFiles == null) {
			listOfFiles = new File[] {};
		}
		File logsFolder = new File(folderPath);
		listOfFiles = (File[]) ArrayUtils.addAll(listOfFiles,
				logsFolder.listFiles());

		for (File file : logsFolder.listFiles()) {

			if (file.isDirectory()) {
				System.out.println(file.getAbsolutePath());
				listOfFiles = getRecursiveListOfAllFiles(
						file.getAbsolutePath(), listOfFiles);
			}
		}
		return listOfFiles;
	}

	public static boolean wasFileModifiedAfter(Date fileModificationDate,
			Date date) {
		if (fileModificationDate.getTime() > date.getTime()) {
			return true;
		}
		return false;
	}

	public static ArrayList<RawLogPojo> readAndParse(File file,
			String parsableLoggingTypesCsv, Date parsableTimeStamp, String serverName) {

		ArrayList<RawLogPojo> appianLogPojoList = new ArrayList<RawLogPojo>();

		RawLogPojo appianLogPojoObj = null;

		BufferedReader input = null;
		String line;

		String loggingType = StringUtils.substringByIndexNumber(file.getName(), 0, "_", 2);

		Date loggingDate;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String loggingLevel = null;

		try {

			input = new BufferedReader(new FileReader(file));

			while ((line = input.readLine()) != null) {
				// System.out.println("LINE IS :::::: " + line);

				try {
					loggingDate = dateFormat.parse(line.substring(0, 19));

				} catch (Exception ex) {
					continue;
				}

				if (!DateUtils.isLogFirstDateIsGreaterThenSecond(
						parsableTimeStamp, loggingDate)) {
					continue;
				}
				loggingLevel =  isContainThisLoggingLevels(line,
						parsableLoggingTypesCsv);

				if (!isStackTraceTrail(line) && loggingLevel != null) {

					appianLogPojoObj = new RawLogPojo();
					appianLogPojoObj.setLogMessage(line);
					appianLogPojoObj.setLoggingTime(loggingDate);
					appianLogPojoObj.setLoggingLevel(loggingLevel);
					appianLogPojoObj.setLoggingType(loggingType);
					appianLogPojoObj.setServerName(serverName);
				}
				appianLogPojoList.add(appianLogPojoObj);
			}

		} catch (Exception ex) {
			Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null,
					ex);
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return appianLogPojoList;
	}

	private static boolean isStackTraceTrail(String line) {
		return line.contains("at com.") || line.contains("at java.")
				|| line.contains("at org.") || line.contains("javax.");
	}

	private static String isContainThisLoggingLevels(String line,
			String parsableLoggingTypesCsv) {

		String parsableLoggingTypesArr[] = parsableLoggingTypesCsv
				.split(AppConstant.CSV_SPLITER);

		for (String string : parsableLoggingTypesArr) {
			if (line.contains(string)) {
				return string;
			}
		}
		return null;
	}

	public static void main(String[] arg) {

		String line = "C:\\RITESH\\MISCs\\LogProcessing\\destination\\Log_Files";

		System.err.println(">> "
				+ FileUtil.getRecursiveListOfAllFiles(line, null).length);
	}

}
