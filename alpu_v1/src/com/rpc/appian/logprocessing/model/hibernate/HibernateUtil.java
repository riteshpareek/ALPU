/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.model.hibernate;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author CONRPA2
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static String hibernateCfg;
    private static HibernateUtil instance;

    public static void confiure(String hibernateConfig) {
        if (instance == null) {
            try {
                hibernateCfg = hibernateConfig;

                File cfgFile = new File(hibernateCfg);
                System.out.println(">>>> " + hibernateCfg + " >>> " + cfgFile);
                
                Configuration config = new Configuration().configure(cfgFile);
                
                sessionFactory = config.buildSessionFactory();
            } catch (Throwable ex) {
                // Log the exception. 
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
    }

    static {
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] asdf) {
        HibernateUtil.getSession();
    }
}
