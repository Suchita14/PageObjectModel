package com.InvoicePlane.Utilites;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {

    public static String convertedDate(String dateStr) throws ParseException {
        String convertedDate="";

        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sd1.parse(dateStr);


        SimpleDateFormat sd2 = new SimpleDateFormat("dd/MM/yyyy");

        convertedDate = sd2.format(date);

        return convertedDate;

    }
}
