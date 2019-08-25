package UITesting;

import com.InvoicePlane.Pages.Login;
import com.InvoicePlane.Utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

import static com.InvoicePlane.Utilites.Driver.DriverTypes.CHROME;

public class LoginTest {

    WebDriver driver = Driver.getDriver(CHROME);
Login login;

//int a;
    @BeforeClass
    public void logintest() {
        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");
        String url = rb.getString("url");
        driver.get(url);
      login = new Login(driver);
  //    a=10;
    }


    @Test
    public void txtEmailVisibility() {
    boolean expected= true;
        boolean actual;
    try {
         actual = login.txtEmail.isEnabled();
    }
    catch (Exception e)
    {
     actual =false;
    }

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void txtPasswordVisibility() {
        boolean expected= true;
        boolean actual;
        try {
            actual = login.txtPassword.isEnabled();
        }
        catch (Exception e)
        {
            actual =false;
        }

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void btnLoginVisibility() {
        boolean expected= true;
        boolean actual;
        try {
            actual = login.btnLogin.isEnabled();
        }
        catch (Exception e)
        {
            actual =false;
        }

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void lblEmailVisibility() {
        boolean expected= true;
        boolean actual;
        try {
            actual = login.lblEmail.isDisplayed();
        }
        catch (Exception e)
        {
            actual =false;
        }

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void lblPasswordVisibility() {
        boolean expected= true;
        boolean actual;
        try {
            actual = login.lblPassword.isDisplayed();
        }
        catch (Exception e)
        {
            actual =false;
        }

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void btnForgotPasswordVisibility() {
        boolean expected= true;
        boolean actual;
        try {
            actual = login.btnForgotPassword.isEnabled();
        }
        catch (Exception e)
        {
            actual =false;
        }

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void lblLoginVisibility() {
        boolean expected = true;
        boolean actual;
        try {
            actual = login.txtLogin.isDisplayed();
        } catch (Exception e) {
            actual = false;
        }

        Assert.assertEquals(actual, expected);


    }

    //Email Spelling

    @Test
    public void lblEmailTest() {
        String expected = "Email";
        String actual;
        try {
            actual = login.lblEmail.getText();
        } catch (Exception e) {
            actual = "";
        }

        Assert.assertEquals(actual, expected);


    }

    @Test
    public void lblPasswordTest() {
        String expected = "Password";
        String actual;
        try {
            actual = login.lblPassword.getText();
        } catch (Exception e) {
            actual = "";
        }

        Assert.assertEquals(actual, expected);

    }


    @Test
    public void lblLoginTest() {
        String expected = "Login";
        String actual;
        try {
            actual = login.lblLogin.getText();
        } catch (Exception e) {
            actual = "";
        }

        Assert.assertEquals(actual, expected);


    }


    @Test
    public void txtEmailWatermark() {
        String expected = "Email";
        String actual;
        try {
            actual = login.txtEmail.getAttribute("placeholder");
        } catch (Exception e) {
            actual = "";
        }

        Assert.assertEquals(actual, expected);

    }


    @Test
    public void txtPasswordWatermark() {
        String expected = "Password";
        String actual;
        try {
            actual = login.txtPassword.getAttribute("placeholder");
        }

        catch (Exception e)
        {
            actual = "";
        }

        Assert.assertEquals(actual, expected);


    }

    @Test
    public void btnLoginColorTest()
    {

        String expectedColor= "#2C8EDD";

        WebElement lblLogin= driver.findElement(By.xpath("//*[@id=\"login\"]/form/button"));

        String rgbcolor= lblLogin.getCssValue("background-color");

        System.out.println(rgbcolor);

        String actualHexColor= Color.fromString(rgbcolor).asHex();

        System.out.println(actualHexColor);

    }


}