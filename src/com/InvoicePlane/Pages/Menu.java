package com.InvoicePlane.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

WebDriver driver;

    @FindBy (xpath = "//*[text()='Clients']")
    WebElement lnkClients;

    @FindBy (xpath = "//*[text()='Add Client']")
    WebElement lnkAddClient;

    @FindBy (xpath = "//*[text()='View Clients']")
    WebElement lnkViewClients;


    @FindBy (xpath = "//*[text()='Quotes']")
    WebElement lnkQuotes;

    @FindBy (xpath = "//*[text()='Create Quote']")
    WebElement lnkCreateQuote;

    @FindBy (xpath = "//*[text()='View Quotes']")
    WebElement lnkViewQuotes;


    @FindBy (xpath = "//*[text()='Invoices']")
    WebElement lnkInvoices;

    @FindBy (xpath = "//*[text()='Create Invoice']")
    WebElement lnkCreateInvoice;

    @FindBy (xpath = "//*[text()='View Invoices']")
    WebElement lnkViewInvoices;

    @FindBy (xpath = "//*[text()='View Recurring Invoices']")
    WebElement lnkViewRecurringInvoices;

public Menu(WebDriver driver)


    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }


    public void clickAddClient()
    {
        lnkClients.click();
        lnkAddClient.click();
    }

    public void clickViewClient()
    {
        lnkClients.click();
        lnkViewClients.click();
    }


    public void clickCreateQuote()
    {
        lnkQuotes.click();
        lnkCreateQuote.click();
    }

    public void clickViewQuotes()
    {
        lnkQuotes.click();
        lnkViewQuotes.click();
    }

    public void clickCreateInvoice()
    {
        lnkInvoices.click();
        lnkCreateInvoice.click();
    }

    public void clickViewInvoices()
    {
        lnkInvoices.click();
        lnkViewInvoices.click();
    }

    public void clickViewRecurringInvoices()
    {
        lnkInvoices.click();
        lnkViewRecurringInvoices.click();
    }


}
