package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConvert {
    public java.sql.Date strToSD(String str) {
        java.util.Date temp = null;
        try {
            temp = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        java.sql.Date d = new java.sql.Date(temp.getTime());
        return d;
    }

    public java.util.Date strToUD(String str) {
        java.util.Date temp = null;
        try {
            temp = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public java.sql.Date uDToSD(java.util.Date d) {

        java.sql.Date temp = new java.sql.Date(d.getTime());
        return temp;
    }
}


