/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rpc.appian.logprocessing.model.pojo;

import java.util.Date;

import com.rpc.appian.logprocessing.application.impl.BasePojoImpl;

/**
 *
 * @author CONRPA2
 */
public class RawLogPojo extends BasePojoImpl {

	private long id;
	private Date loggingTime;
	private String loggingType;
	private String loggingLevel;
	private String logMessage;
	private String serverName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getLoggingTime() {
		return loggingTime;
	}

	public void setLoggingTime(Date loggingTime) {
		this.loggingTime = loggingTime;
	}

	public String getLoggingType() {
		return loggingType;
	}

	public void setLoggingType(String loggingType) {

		this.loggingType = loggingType;
	}

	public String getLoggingLevel() {
		return loggingLevel;
	}

	public void setLoggingLevel(String loggingLevel) {
		this.loggingLevel = loggingLevel;
	}

	public String getLogMessage() {
		return logMessage;
	}

	public void setLogMessage(String logMessage) {
		this.logMessage = logMessage;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public void print() {

		System.out.println(this.loggingLevel + "\t" + this.loggingType + "\t"
				+ this.logMessage + "\t" + this.loggingTime);
	}

}
