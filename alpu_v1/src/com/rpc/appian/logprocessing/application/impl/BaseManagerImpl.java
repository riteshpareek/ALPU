/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.impl;

import com.rpc.appian.logprocessing.application.base.BaseDao;
import com.rpc.appian.logprocessing.application.base.BaseManager;
import com.rpc.appian.logprocessing.model.dao.RawLogDao;

/**
 *
 * @author CONRPA2
 */
public abstract class BaseManagerImpl implements BaseManager {

	protected static BaseDao getDao(String key) {
		if (RAW_LOG_DAO_KEY.equalsIgnoreCase(key)) {
			return RawLogDao.getDao();
		}
		return null;
	}
}
