/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.base;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author CONRPA2
 *
 *
 */
public interface BaseDao {

    public static final String OP_EQUAL = "=";
    public static final String OP_GREATER_THEN = ">";
    public static final String OP_LESS_THEN = "<";
    public static final String OP_LIKE = "like";
    public static final String OP_GREATER_THEN_OR_EQUAL = ">=";
    public static final String OP_LESS_THEN_OR_EQUAL = "<=";
    public static final String OP_NOT = "not";
    public static final String OP_NOT_EQUAL = "<>";
    public static final String OP_NOT_LIKE = "not like";
    public static final String OP_IS = "is";
    public static final String OP_IS_NOT = "is not";
    public static final String CONDI_AND = "AND";
    public static final String CONDI_OR = "OR";

    Session getSession() throws RuntimeException;

    Query getQuery(Class clazz, String whereClause) throws RuntimeException;

    boolean saveObject(Object obj) throws RuntimeException;

    boolean updateObject(Object obj) throws RuntimeException;

    boolean deleteObject(Object obj) throws RuntimeException;

    List getAllObjects(Class pojoClass, String orderBy, String order) throws RuntimeException;

    List getAllObjects(Class pojoClass, String orderBy) throws RuntimeException;

    List getAllObjects(Class pojoClass) throws RuntimeException;

    Object getObject(Class pojoClass, String columnName, Object value, String op) throws RuntimeException;

    List getObjects(Class pojoClass, String columnName, Object value, String op, String orderBy, String order) throws RuntimeException;

    List getObjects(Class pojoClass, String columnName, Object value, String op, String orderBy) throws RuntimeException;

    List getObjects(Class pojoClass, String columnName, Object value, String op) throws RuntimeException;
}
