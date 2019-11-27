package com.bowang.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String date2String(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat();
        String format = sdf.format(date);
        return format;
    }
}
