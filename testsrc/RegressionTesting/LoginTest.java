package RegressionTesting;

import com.InvoicePlane.Pages.Login;
import com.InvoicePlane.Utilites.Driver;
import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

import static com.InvoicePlane.Utilites.Driver.DriverTypes.CHROME;

public class LoginTest {

    WebDriver driver= Driver.getDriver(CHROME);

    @Test
     public void logintest()
    {
        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");
         String url= rb.getString("url");
         driver.get(url);

        Login login= new Login(driver);
        login.setTxtEmail("someusrname");
        login.setTxtPassword("somepassword");
        login.ClickbtnLogin();
    }
}
