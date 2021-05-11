package com.gdgu.ekart.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDate {
    public static Date strToDate(String strDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(strDate);
        } catch(ParseException e) {
            return null;
        }
    }
}
