/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rpc.appian.logprocessing.application.base.BaseDao;
import com.rpc.appian.logprocessing.application.consts.AppConstant;
import com.rpc.appian.logprocessing.application.logger.AppLogger;
import com.rpc.appian.logprocessing.model.hibernate.HibernateUtil;

/**
 *
 * @author CONRPA2
 *
 *
 */
public class BaseDaoImpl implements BaseDao {

    /**
     * **** SET LOGGER
     */
    static Logger log = AppLogger.getLogger(BaseDaoImpl.class);

    /**
     * **** LOGGER SET
     */
    @Override
    public Session getSession() {
        return HibernateUtil.getSession();
    }

    @Override
    public Query getQuery(Class clazz, String whereClause) throws RuntimeException {
        Session session = getSession();
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(" from ").append(clazz.getCanonicalName()).append(" ").append(whereClause);
            return session.createQuery(sb.toString());
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    ////////////////////////////////////////////
    @Override
    public boolean saveObject(Object obj) throws RuntimeException {
        Session session = getSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(obj);
            session.flush();
            tx.commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public boolean updateObject(Object obj) throws RuntimeException {

        Session session = getSession();
        try {
            Transaction tx = session.beginTransaction();
            session.update(obj);
            session.flush();
            tx.commit();
            return true;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public boolean deleteObject(Object obj) throws RuntimeException {

        Session session = getSession();
        try {
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            session.flush();
            tx.commit();
            return true;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////
    @Override
    public List getAllObjects(Class pojoClass, String orderBy, String order) throws RuntimeException {

        Session session = getSession();
        try {
            StringBuilder queryStr = new StringBuilder();
            queryStr.append(" FROM " + pojoClass.getCanonicalName());

            if (orderBy != null) {
                queryStr.append(" ORDER BY " + orderBy + " " + order);
            }

            Query query = session.createQuery(queryStr.toString());
            return query.list();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public List getAllObjects(Class pojoClass, String orderBy) throws RuntimeException {
        return getAllObjects(pojoClass, orderBy, AppConstant.ASC);
    }

    @Override
    public List getAllObjects(Class pojoClass) throws RuntimeException {
        return getAllObjects(pojoClass, null);
    }

    @Override
    public Object getObject(Class pojoClass, String columnName, Object value, String op) throws RuntimeException {
        Session session = getSession();
        try {
            StringBuilder queryStr = new StringBuilder();
            if (value == null) {
                queryStr.append("from ").append(pojoClass.getCanonicalName()).append(" pojo  " + "WHERE  pojo.").append(columnName).append(" ").append(op).append(" null");
            } else {
                queryStr.append("from ").append(pojoClass.getCanonicalName()).append(" pojo " + "WHERE pojo.").append(columnName).append(" ").append(op).append(" :value");
            }

            Query query = session.createQuery(queryStr.toString());

            if (value != null) {
                query.setParameter("value", value);
            }
            return query.uniqueResult();

        } catch (HibernateException he) {
            throw new RuntimeException(he);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    throw new RuntimeException(he);
                }
            }
        }
    }

    public List getObjects(Class pojoClass, HashMap<String, Object> columnValueHash, HashMap<String, String> columnOperationHash,
            String condition) throws RuntimeException {
        Session session = getSession();
        try {
            StringBuilder queryStr = new StringBuilder();

            queryStr.append("FROM ").append(pojoClass.getCanonicalName())
                    .append(" pojo ")
                    .append(" WHERE ");


            Iterator<String> columnItr = columnValueHash.keySet().iterator();


            int counter = 0;

            while (columnItr.hasNext()) {
                String columnName = columnItr.next();
                if (counter++ > 0) {
                    queryStr.append(" ").append(condition).append(" ");
                }
                queryStr.append(" pojo.").append(columnName).append(" ").append(columnOperationHash.get(columnName)).append(" :").append(columnName);
            }

            Query query = session.createQuery(queryStr.toString());

            columnItr = columnValueHash.keySet().iterator();
            while (columnItr.hasNext()) {
                String columnName = columnItr.next();
                Object value = columnValueHash.get(columnName);


                query.setParameter(columnName, value);
            }
            return query.list();

        } catch (HibernateException he) {
            throw new RuntimeException(he);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    throw new RuntimeException(he);
                }
            }
        }
    }

    @Override
    public List getObjects(Class pojoClass, String columnName, Object value, String op, String orderBy, String order) throws RuntimeException {
        Session session = getSession();

        try {
            StringBuilder queryStr = new StringBuilder();
            queryStr.append("FROM ").append(pojoClass.getCanonicalName()).append(" pojo ");

            if (value == null) {
                queryStr.append("WHERE pojo.").append(columnName).append(" ").append(op).append(" null");
            } else {
                queryStr.append("WHERE pojo.").append(columnName).append(" ").append(op).append(" :value");
            }

            if (orderBy != null) {
                queryStr.append(" ORDER BY ").append(orderBy).append(AppConstant.SINGLE_SPACE).append(order);
            }
            Query query = session.createQuery(queryStr.toString());

            if (value != null) {
                query.setParameter("value", value);
            }
            return query.list();

        } catch (HibernateException he) {
            throw new RuntimeException(he);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he) {
                    throw new RuntimeException(he);
                }
            }
        }
    }

    @Override
    public List getObjects(Class pojoClass, String columnName, Object value, String op, String orderBy) throws RuntimeException {
        return getObjects(pojoClass, columnName, value, op, orderBy, AppConstant.ASC);
    }

    @Override
    public List getObjects(Class pojoClass, String columnName, Object value, String op) throws RuntimeException {
        return getObjects(pojoClass, columnName, value, op, null, null);

    }
}
