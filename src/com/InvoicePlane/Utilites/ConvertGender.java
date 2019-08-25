package com.InvoicePlane.Utilites;

public class ConvertGender {
    public static String convertGender(String Gender)

    {
        String convertGender= "";

        switch (Gender)
        {
            case "0" : convertGender= "Male"; break;
            case "1" : convertGender= "Female"; break;
            case "2": convertGender= "Other"; break;
        }
        return convertGender;
    }
}
