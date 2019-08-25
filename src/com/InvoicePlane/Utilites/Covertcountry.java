package com.InvoicePlane.Utilites;

import org.apache.poi.hssf.record.PageBreakRecord;

public class Covertcountry {

    public static String convertCountry(String Country)

    {
        String convertCountry= "";

        switch (Country)
        {
            case "IN" : convertCountry= "India"; break;
            case "AS" : convertCountry= "American Samoa"; break;
            case "AD": convertCountry= "Andorra"; break;
            case "JP" : convertCountry= "Japan"; break;
            case "IR": convertCountry= "Iran"; break;
            case "KE": convertCountry= "Kenya"; break;
            case "IE": convertCountry= "Ireland"; break;
            case "MY": convertCountry= "Malaysia"; break;
        }
        return convertCountry;
    }
}
