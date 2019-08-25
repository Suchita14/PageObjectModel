package com.InvoicePlane.Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.InvoicePlane.Utilites.Driver.DriverTypes.CHROME;

public class Driver {

    public static WebDriver myDriver;

    private static long timeout=10;
     public enum DriverTypes
     {
         CHROME
     }

     public static WebDriver getDriver(DriverTypes d)
     {
         if (myDriver == null)
         {
             switch (d)
             {
                 case CHROME:
                     System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
                     myDriver = new ChromeDriver();
                     break;
             }

             myDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
             myDriver.manage().window().maximize();
         }
            return myDriver;
     }
}
