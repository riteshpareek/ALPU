/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rpc.appian.logprocessing.application.utils;

import java.util.Date;

/**
 *
 * @author CONRPA2
 */
public class DateUtils {

    static boolean isLogFirstDateIsGreaterThenSecond(Date firstDate, Date secondDate) {

        if (firstDate.compareTo(secondDate) > 0) {
            return true;
        }
        return false;
    }

}
