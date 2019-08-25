package com.InvoicePlane.Pages.Clients;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddClient {
    WebDriver driver;

    @FindBy (name = "client_name")
    WebElement txtClientName;

    @FindBy (name = "client_surname")
    WebElement txtClientSurname;

    @FindBy(xpath ="//*[@id=\"select2-client_language-container\"]")
    WebElement containerLanguage;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchbox1;

    @FindBy(name = "client_address_1")
    WebElement txtStreetAddress;

    @FindBy(name = "client_address_2")
    WebElement txtStreetAddress2;

    @FindBy(name = "client_city")
    WebElement txtCity;

    @FindBy(name = "client_state")
    WebElement txtState;

    @FindBy(name = "client_zip")
    WebElement txtZipCode;

    @FindBy(xpath = "//*[@id='select2-client_country-container']")
    WebElement containerCountry;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchbox;

    @FindBy(xpath = "//*[@id=\"select2-client_gender-container\"]")
    WebElement containerGender;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchbox2;

    @FindBy(name = "client_birthdate")
    WebElement txtBirthdate;

    @FindBy(name = "client_phone")
    WebElement txtPhoneNumber;

    @FindBy(name="client_fax")
    WebElement txtFaxNumber;

    @FindBy(name= "client_mobile")
    WebElement txtMobileNumber;

    @FindBy(name = "client_email")
    WebElement txtEmailAddress;

    @FindBy(name = "client_web")
    WebElement txtWebAddress;

    @FindBy(name = "client_vat_id")
    WebElement txtVATID;

    @FindBy(name = "client_tax_code")
    WebElement txtTaxesCode;

    @FindBy(name = "btn_submit")
    WebElement btnSave;

    @FindBy(name = "btn_cancel")
    WebElement btnCancel;

    public AddClient(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void setTxtClientName(String ClientName)

    {
        txtClientName.sendKeys(ClientName);
    }

    public void setTxtClientSurname(String ClientSurname)
    {
        txtClientSurname.sendKeys(ClientSurname);
    }

    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchbox1.sendKeys(language);
        driver.findElement(By.xpath("//li[contains(text(),'"+language+"')]")).click();
    }

   public void setTxtStreetAddress(String StreetAddress)
   {
       txtStreetAddress.sendKeys(StreetAddress);
   }

   public void setTxtStreetAddress2(String StreetAddress2)
    {
        txtStreetAddress2.sendKeys(StreetAddress2);
    }

    public void setTxtCity(String City)
    {
        txtCity.sendKeys(City);
    }

    public void setTxtState(String State)
    {
        txtState.sendKeys(State);
    }
    public void setTxtZipCode(String ZipCode)
    {
        txtZipCode.sendKeys(ZipCode);
    }

    public void setCountry(String country)
    {
        containerCountry.click();
        searchbox.sendKeys(country);
    driver.findElement(By.xpath("//li[text()='"+country+"']")).click();
    }

    public void setGender(String gender)
    {
        containerGender.click();
        searchbox2.sendKeys(gender);
        driver.findElement(By.xpath("//li[contains(text(),'"+gender+"')]")).click();

        //driver.findElement(By.xpath("//li[contains(text(),'"+language+"')]")).click();
    }


    public void setTxtBirthdate (String setDateStr) throws ParseException {
        driver.findElement(By.id("client_birthdate")).click();

       // String setDateStr= "27/10/2018";   //dd/MM/yyyy

        String currDateStr = driver.findElement(By.xpath("//th[@class='datepicker-switch']")).getText();  //MMMMM yyyy

        Date setDate= new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);

        Date currDate= new SimpleDateFormat("MMMM yyyy").parse(currDateStr);


        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();

        boolean isFuture= true;

        if (monthDiff<0) {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }
        for (int i=0; i<monthDiff; i++)

        {
            if (isFuture)
                driver.findElement(By.xpath("//th[@class='next']")).click();
            else
                driver.findElement(By.xpath("//th[@class='prev']")).click();
        }

        String day;

        day = new SimpleDateFormat("dd").format(setDate);

        driver.findElement(By.xpath("//*[text()='"+Integer.parseInt(day)+"']")).click();


    }
    public void setTxtPhoneNumber(String PhoneNumber)
    {
        txtPhoneNumber.sendKeys(PhoneNumber);
    }
    public void setTxtFaxNumber(String FaxNumber)
    {
        txtFaxNumber.sendKeys(FaxNumber);
    }
    public void setTxtMobileNumber(String MobileNumber)
    {
        txtMobileNumber.sendKeys(MobileNumber);
    }
    public void setTxtEmailAddress(String EmailAddress)
    {
        txtEmailAddress.sendKeys(EmailAddress);
    }
    public void setTxtWebAddress(String WebAddress)
    {
        txtWebAddress.sendKeys(WebAddress);
    }
    public void setTxtVATID(String VATID)
    {
        txtVATID.sendKeys(VATID);
    }
    public void setTxtTaxesCode(String TaxesCode)
    {
        txtTaxesCode.sendKeys(TaxesCode);
    }
    public void clickBtnSave()
    {
        btnSave.click();
    }
    public void clickBtnCancel()
    {
        btnCancel.click();
    }
}

