/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.consts;

import java.util.HashMap;

import com.rpc.appian.logprocessing.application.base.ApplicationBase;
import com.rpc.appian.logprocessing.application.logger.AppLogger;

import org.apache.log4j.Logger;

/**
 *
 * @author CONRPA2
 */
public class AppConstant {

	static Logger log = AppLogger.getLogger(AppConstant.class);
	public static ApplicationBase APP_BASE_OBJ;
	public static final String BLANK_STR = "";
	public static final String SINGLE_SPACE = " ";

	public static final String LOGGING_LEVEL_ERROR = "ERROR";
	public static final String LOGGING_LEVEL_DEBUG = "DEBUG";
	public static final String LOGGING_LEVEL_WARN = "WARN";
	public static final String LOGGING_LEVEL_INFO = "INFO";

	public static final String CSV_SPLITER = ",";

	// ////////////////////
	public static String IS_USER_LOGGED_IN = "isUserLoggedIn";
	public static String LOGGED_IN_USER = "loggedInUser";
	public static String WHO_IS_LOGGED_IN = "whoIsLoggedIn";
	// //////////////////////////
	public static String ROLE_ADMIN = "Admin";
	public static String ROLE_KONE_LEAD = "Kone Lead";
	public static String ROLE_APP_USER = "Application User";
	// //////////////////////////
	public static final String ALL = "All";
	public static final String ACTIVE = "Active";
	public static final String INACTIVE = "Inactive";
	public static final String RESIGNED = "Resigned";
	public static final String CLOSED = "Closed";
	// /////////////////////////////////////////
	public static final String ENV_ALL = "All";
	public static final String ENV_SBX = "Sandbox";
	public static final String ENV_DEV = "Dev";
	public static final String ENV_INT = "UAT";
	public static final String ENV_PRD = "Production";
	// /////////////////////////////////////////
	public static final String PRIORITY_SUPER_URGENT = "Super Urgent";
	public static final String PRIORITY_URGENT = "Urgent";
	public static final String PRIORITY_HIGH = "High";
	public static final String PRIORITY_NORMAL = "Normal";
	public static final String PRIORITY_LOW = "Low";
	public static final String PRIORITY_INFORMATION = "Information";
	// /////////////////////////////////////////
	// /////////////////////////////////////////
	public static final String USERTYPE_INTERNAL = "Kone Internal";
	public static final String USERTYPE_EXTERNAL = "External User";
	public static final int USERTYPE_INTERNAL_CODE = 1;
	public static final int USERTYPE_EXTERNAL_CODE = 0;
	// /////////////////////////////////////////
	public static final String STATUS_ISSUE_CLOSED = "CLOSED";
	public static final String STATUS_ISSUE_IN_PROGRESS = "IN PROGRESS";
	public static final String STATUS_ISSUE_NO_UPDATES = "NO UPDATES";
	public static final String STATUS_ISSUE_OPEN = "OPEN";
	public static final String STATUS_ISSUE_RESOLVED = "RESOLVED";
	public static final String STATUS_ISSUE_CANCELLED = "CANCELLED";
	public static final String STATUS_ISSUE_ESCALATED = "Escalated";
	public static final String STATUS_ISSUE_DELIVERED = "Delivered";
	// ///////////
	public static final int STATUS_ALL = -99;
	public static final int STATUS_ACTIVE = 1;
	public static final int STATUS_INACTIVE = 0;
	// ////////////////
	public static final String LBL_ACTIVATE_DEACTIVATE = "Activate\\De-Activate";
	public static final String LBL_CHANGE_PASSWORD = "Change Password";
	public static final String LBL_ESCALATE_ISSUE = "Escalate Issue";
	public static final String LBL_UPDATE_ASSIGNEE = "Update Assignee";
	public static final String LBL_UPDATE_STATUS = "Update Status";
	public static final String LBL_CHANGE_PRIORITY = "Change Priority";
	public static final String LBL_CANCEL_ISSUE = "Cancel\\Reject";
	// /////////////////////////////////////////
	public static final String REQPARAM_USERS_LIST = "usersList";
	public static final String REQPARAM_ISSUES_LIST = "issuesList";
	public static final String REQPARAM_KONEAPPLICATIONS_LIST = "koneApplicationList";
	// /////////////////////////////////////////////////
	public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[*]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static int FLAGE_BLANK_VALUE = 0;
	public static int FLAGE_ALREADY_EXIST = 1;
	public static int FLAGE_INVALID_EMAIL = 2;
	public static int FLAGE_INVALID_ROLE_SELECTION = 3;
	public static String MSG_VALIDATION_BLANK_VALUE = " field is blank.";
	public static String MSG_VALIDATION_ALREADY_EXIST = " already exist in System.";
	public static String MSG_VALIDATION_INVALID_EMAIL = " not a valid email format.";
	public static String MSG_VALIDATION_INVALID_ROLE_SELECT = "External user can only have 'Application User' role.";
	// /////////////////////////////////////////
	public static final int PAGE_SIZE_5 = 5;
	public static final int PAGE_SIZE_10 = 10;
	public static final int PAGE_SIZE_20 = 20;
	public static final int PAGE_SIZE_50 = 50;
	// /////////////////////
	public static final int TRIM_DESCRIPTION = 100;
	// ///////////////////////
	// ///////////////////////
	public static final String GENERATE_BUTTON = "generate";
	public static final String DOWNLOAD_BUTTON = "download";
	// //////////////////////
	public static final String ASC = "asc";

	/**
	 * *****************************************************
	 */
	public static HashMap<Integer, String> getEnvHash() {
		HashMap<Integer, String> envHash = new HashMap<Integer, String>();
		envHash.put(0, AppConstant.ENV_ALL);
		envHash.put(1, AppConstant.ENV_SBX);
		envHash.put(2, AppConstant.ENV_DEV);
		envHash.put(3, AppConstant.ENV_INT);
		envHash.put(4, AppConstant.ENV_PRD);
		return envHash;
	}

	public static HashMap<Integer, String> getPriorityHash() {
		HashMap<Integer, String> priorityHash = new HashMap<Integer, String>();
		priorityHash.put(0, AppConstant.PRIORITY_INFORMATION);
		priorityHash.put(1, AppConstant.PRIORITY_LOW);
		priorityHash.put(2, AppConstant.PRIORITY_NORMAL);
		priorityHash.put(3, AppConstant.PRIORITY_HIGH);
		priorityHash.put(4, AppConstant.PRIORITY_URGENT);
		priorityHash.put(5, AppConstant.PRIORITY_SUPER_URGENT);
		return priorityHash;
	}

	public static HashMap<Integer, String> getUserTypeHash() {
		HashMap<Integer, String> userTypeHash = new HashMap<Integer, String>();
		userTypeHash.put(AppConstant.USERTYPE_EXTERNAL_CODE,
				AppConstant.USERTYPE_EXTERNAL);
		userTypeHash.put(AppConstant.USERTYPE_INTERNAL_CODE,
				AppConstant.USERTYPE_INTERNAL);
		return userTypeHash;
	}

	public static HashMap<Integer, String> getActiveInactiveStatusHash() {
		HashMap<Integer, String> userStatusHash = new HashMap<Integer, String>();
		userStatusHash.put(0, AppConstant.INACTIVE);
		userStatusHash.put(1, AppConstant.ACTIVE);
		return userStatusHash;
	}
}
