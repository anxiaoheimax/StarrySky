package com.sky.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换
 */
public class DateUtil {
    /**
     *String to Date
     * @param str 字符串  时间
     * @return    返回时间对象
     */
    public static Date StringtoDate(String str){
        try {
            return (Date) new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Date to String
     * @param date 时间对象
     * @return     时间字符串
     */
    public static String DatetoString(Date date){

        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
    }



}
