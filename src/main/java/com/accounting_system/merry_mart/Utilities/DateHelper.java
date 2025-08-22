package com.accounting_system.merry_mart.Utilities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd";

    // Convert Date to String
    public static String formatDate(Date date) {
        if (date == null) return null;
        return new SimpleDateFormat(DEFAULT_FORMAT).format(date);
    }

    // Convert String to Date
    public static Date parseDate(String dateStr) {
        if (dateStr == null) return null;
        try {
            return new SimpleDateFormat(DEFAULT_FORMAT).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
