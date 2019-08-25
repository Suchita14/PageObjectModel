package RegressionTesting.Clients;

import com.InvoicePlane.Pages.Clients.AddClient;
import com.InvoicePlane.Pages.Login;
import com.InvoicePlane.Pages.Menu;
import com.InvoicePlane.Utilites.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ResourceBundle;

import static com.InvoicePlane.Utilites.Driver.DriverTypes.CHROME;
import static com.InvoicePlane.Utilites.TakeScreenShot.takeScreenshot;

public class AddClientTest {
    WebDriver driver= Driver.getDriver(CHROME);
    ExtentReports extent;
    @BeforeClass
    public void logintest()
    {
        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");
        String url= rb.getString("url");
        driver.get(url);

        Login login= new Login(driver);
        login.setTxtEmail("suchitavkokate@gmail.com");
        login.setTxtPassword("suchita1234");
        login.ClickbtnLogin();
//        driver.findElement(By.xpath("//*[@id=\"ip-navbar-collapse\"]/ul[1]/li[2]/a")).click();
  //      driver.findElement(By.xpath("//*[@id=\"ip-navbar-collapse\"]/ul[1]/li[2]/ul/li[1]/a")).click();
         extent = new ExtentReports("Report/report.html", true, NetworkMode.OFFLINE);
    }

    @Test(dataProvider = "getData")
    public void AddClientTest(String ClientName, String ClientSurname, String Language, String StreetAddress, String StreetAddress2, String City, String State, String Zipcode, String Country, String Gender, String BirthDate, String PhoneNumber, String FaxNumber, String MobileNumber, String EmailAddress, String WebAddress, String VATID, String TaxesCode, String expectedresult, String xpathofactualresult) throws ParseException, IOException {

        ExtentTest test= extent.startTest("AddClientTest", "To verify if the client gets added Successfully");

        Menu menu = new Menu(driver);

        test.log(LogStatus.INFO, "Browser is Opened");

        menu.clickAddClient();

        AddClient addclient = new AddClient(driver);

        test.log(LogStatus.INFO, "Add Client link has been clicked");

        addclient.setTxtClientName(ClientName);

        test. log(LogStatus.INFO, "Client's name has entered");

        addclient.setTxtClientSurname(ClientSurname);

        test. log(LogStatus.INFO, "Client's Surname has entered");

        addclient.setLanguage(Language);

        test. log(LogStatus.INFO, "Client's language has been selected");

        addclient.setTxtStreetAddress(StreetAddress);

        test. log(LogStatus.INFO, "Client's Street Address has entered");

        addclient.setTxtStreetAddress2(StreetAddress2);

        test. log(LogStatus.INFO, "Client's Street Address has entered");

        addclient.setTxtCity(City);
        test. log(LogStatus.INFO, "Client's City has entered");

        addclient.setTxtState(State);
        test. log(LogStatus.INFO, "Client's State has entered");

        addclient.setTxtZipCode(Zipcode);
        test. log(LogStatus.INFO, "Client's Zip Code has entered");

        addclient.setCountry(Country);
        test. log(LogStatus.INFO, "Client's Country has been selected");

        addclient.setGender(Gender);
        test. log(LogStatus.INFO, "Client's Gender has been selected");

        addclient.setTxtBirthdate(BirthDate);

        test. log(LogStatus.INFO, "Client's Birth Date has been selected");

        addclient.setTxtPhoneNumber(PhoneNumber);
        test. log(LogStatus.INFO, "Client's Phone Number is entered");

        addclient.setTxtFaxNumber(FaxNumber);
        test. log(LogStatus.INFO, "Client's Fax Number has entered");

        addclient.setTxtMobileNumber(MobileNumber);
        test. log(LogStatus.INFO, "Client's Mobile Address has entered");

        addclient.setTxtEmailAddress(EmailAddress);
        test. log(LogStatus.INFO, "Client's Email Address has entered");

        addclient.setTxtWebAddress(WebAddress);
        test. log(LogStatus.INFO, "Client's Web Address has entered");

        addclient.setTxtVATID(VATID);
        test. log(LogStatus.INFO, "Client's VAT ID has entered");

        addclient.setTxtTaxesCode(TaxesCode);
        test. log(LogStatus.INFO, "Client's Taxes Code has entered");

        addclient.clickBtnSave();
        test. log(LogStatus.INFO, "Save button has been clicked");

        extent.endTest(test);
        extent.flush();


        String actual="";
        try {

            actual  = driver.findElement(By.xpath(xpathofactualresult)).getText();

        }
         catch (Exception e)
         {
             actual = "";
             test.log(LogStatus.ERROR,e);

             test.log(LogStatus.INFO,"screenshot below:"+test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

         }

        try {
            Assert.assertEquals(actual, expectedresult, "My test is passed");
            test.log(LogStatus.INFO,"screenshot below:"+test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));
        }
        catch (AssertionError e)
        {
            test.log(LogStatus.FAIL,e);

            test.log(LogStatus.INFO,"screenshot below:"+test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

        }

        extent.endTest(test);
        extent.flush();
        }

        @DataProvider
    public Object[][]  getData() throws IOException {

            FileInputStream fileInputStream = new FileInputStream("Data/MyData.xls");

            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

            HSSFSheet worksheet = workbook.getSheet("Sheet1");

            int rowcount = worksheet.getPhysicalNumberOfRows();

            Object[][] data = new Object[rowcount-1][20];

            for (int i = 0; i <rowcount-1; i++) {
                HSSFRow row = worksheet.getRow(i+1);

                HSSFCell ClientName = row.getCell(0);
                if (ClientName == null)
                    data[i][0] = "";
                else {
                    ClientName.setCellType(CellType.STRING);
                    data[i][0] = ClientName.getStringCellValue();
                }

                HSSFCell ClientSurname = row.getCell(1);
                if (ClientSurname == null)
                    data[i][1] = "";
                else {
                    ClientSurname.setCellType(CellType.STRING);
                    data[i][1] = ClientSurname.getStringCellValue();
                }


                HSSFCell Language = row.getCell(2);
                if (Language == null)
                    data[i][2] = "";
                else {
                    Language.setCellType(CellType.STRING);
                    data[i][2] = Language.getStringCellValue();
                }

                HSSFCell StreetAddress = row.getCell(3);
                if (StreetAddress == null)
                    data[i][3] = "";
                else {
                    StreetAddress.setCellType(CellType.STRING);
                    data[i][3] = StreetAddress.getStringCellValue();
                }

                HSSFCell StreetAddress2 = row.getCell(4);
                if (StreetAddress2 == null)
                    data[i][4] = "";
                else {
                    StreetAddress2.setCellType(CellType.STRING);
                    data[i][4] = StreetAddress2.getStringCellValue();
                }

                HSSFCell City = row.getCell(5);
                if (City == null)
                    data[i][5] = "";
                else {
                    City.setCellType(CellType.STRING);
                    data[i][5] = City.getStringCellValue();
                }


                HSSFCell State = row.getCell(6);
                if (State == null)
                    data[i][6] = "";
                else {
                    State.setCellType(CellType.STRING);
                    data[i][6] = State.getStringCellValue();
                }


                HSSFCell ZipCode = row.getCell(7);
                if (ZipCode == null)
                    data[i][7] = "";
                else {
                    ZipCode.setCellType(CellType.STRING);
                    data[i][7] = ZipCode.getStringCellValue();
                }


                HSSFCell Country = row.getCell(8);
                if (Country == null)
                    data[i][8] = "";
                else {
                    Country.setCellType(CellType.STRING);
                    data[i][8] = Country.getStringCellValue();
                }


                HSSFCell Gender = row.getCell(9);
                if (Gender == null)
                    data[i][9] = "";
                else {
                    Gender.setCellType(CellType.STRING);
                    data[i][9] = Gender.getStringCellValue();
                }


                HSSFCell BirthDate = row.getCell(10);
                if (BirthDate == null)
                    data[i][10] = "";
                else {
                    BirthDate.setCellType(CellType.STRING);
                    data[i][10] = BirthDate.getStringCellValue();
                }


                HSSFCell PhoneNumber = row.getCell(11);
                if (PhoneNumber == null)
                    data[i][11] = "";
                else {
                    PhoneNumber.setCellType(CellType.STRING);
                    data[i][11] = PhoneNumber.getStringCellValue();
                }

                HSSFCell FaxNumber = row.getCell(12);
                if (FaxNumber == null)
                    data[i][12] = "";
                else {
                    FaxNumber.setCellType(CellType.STRING);
                    data[i][12] = FaxNumber.getStringCellValue();
                }

                HSSFCell MobileNumber = row.getCell(13);
                if (MobileNumber == null)
                    data[i][13] = "";
                else {
                    MobileNumber.setCellType(CellType.STRING);
                    data[i][13] = MobileNumber.getStringCellValue();
                }

                HSSFCell EmailAddress = row.getCell(14);
                if (EmailAddress == null)
                    data[i][14] = "";
                else {
                    EmailAddress.setCellType(CellType.STRING);
                    data[i][14] = EmailAddress.getStringCellValue();
                }

                HSSFCell WebAddress = row.getCell(15);
                if (WebAddress == null)
                    data[i][15] = "";
                else {
                    WebAddress.setCellType(CellType.STRING);
                    data[i][15] = WebAddress.getStringCellValue();
                }

                HSSFCell VATID = row.getCell(16);
                if (VATID == null)
                    data[i][16] = "";
                else {
                    VATID.setCellType(CellType.STRING);
                    data[i][16] = VATID.getStringCellValue();
                }

                HSSFCell TaxesCode = row.getCell(17);
                if (TaxesCode == null)
                    data[i][17] = "";
                else {
                    TaxesCode.setCellType(CellType.STRING);
                    data[i][17] = TaxesCode.getStringCellValue();
                }

                HSSFCell expectedresult = row.getCell(18);
                if (expectedresult == null)
                    data[i][18] = "";
                else {
                    expectedresult.setCellType(CellType.STRING);
                    data[i][18] = expectedresult.getStringCellValue();
                }

                HSSFCell xpathofactualresult = row.getCell(19);
                if (xpathofactualresult == null)
                    data[i][19] = "";
                else {
                    xpathofactualresult.setCellType(CellType.STRING);
                    data[i][19] = xpathofactualresult.getStringCellValue();
                }


            }

            return data;
            }

}
