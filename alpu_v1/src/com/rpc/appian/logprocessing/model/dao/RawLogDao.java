package com.rpc.appian.logprocessing.model.dao;

import org.apache.log4j.Logger;

import com.rpc.appian.logprocessing.application.base.BaseDao;
import com.rpc.appian.logprocessing.application.impl.BaseDaoImpl;
import com.rpc.appian.logprocessing.application.logger.AppLogger;

public class RawLogDao extends BaseDaoImpl implements BaseDao{
	

    /**
     * **** SET LOGGER
     */
    static Logger log = AppLogger.getLogger(RawLogDao.class);

    RawLogDao() {
    }

    static RawLogDao instance = null;

    public static RawLogDao getDao() {
        if (instance == null) {
            instance = new RawLogDao();
        }
        return instance;
    }


}
