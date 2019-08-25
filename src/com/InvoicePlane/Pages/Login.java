package com.InvoicePlane.Pages;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    @FindBy (name = "email")
    public WebElement txtEmail;

    @FindBy (name = "password")
    public WebElement txtPassword;

    @FindBy (xpath = "//*[@id=\"login\"]/form/button")
    public WebElement btnLogin;

    @FindBy (xpath = "//*[@id=\"login\"]/form/div[1]/label")
    public WebElement lblEmail;

    @FindBy(xpath = "//*[@id=\"login\"]/form/div[2]/label")
    public WebElement lblPassword;

    @FindBy(xpath = "//*[@id=\"login\"]/form/a")
    public WebElement btnForgotPassword;

    @FindBy(xpath = "//*[@id=\"login\"]/h1")
    public WebElement txtLogin;

    @FindBy(xpath = "//*[@id=\"login\"]/h1")
    public WebElement lblLogin;

    public Login(WebDriver driver)

    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void setTxtEmail(String username)

    {
        txtEmail.sendKeys(username);
    }
    public void setTxtPassword(String password)

    {
        txtPassword.sendKeys(password);
    }
    public void ClickbtnLogin()

    {
        btnLogin.click();
    }

    public void getlblEmail(String Email)
    {
        lblEmail.getText();
    }

    public void getlblPassword(String Password)
    {
        lblPassword.getText();
    }

    public void ClickbtnForgotPassword()

    {
        btnForgotPassword.click();
    }

    public void gettxtLogin(String Login)
    {
        txtLogin.getText();
    }

    public void getlblLogin(String Login)
    {
        lblLogin.getText();
    }
}
