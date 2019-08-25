package UITesting.Clients;

import com.InvoicePlane.Pages.Login;
import com.InvoicePlane.Utilites.Driver;
import com.mysql.cj.xdevapi.Client;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

import static com.InvoicePlane.Utilites.Driver.DriverTypes.CHROME;

public class AddClientTest {

    WebDriver driver = Driver.getDriver(CHROME);
    Client client;

 /*   @BeforeClass
    public void logintest() {
        ResourceBundle rb = ResourceBundle.getBundle("InvoicePlane");
        String url = rb.getString("url");
        driver.get(url);
        client = new (driver);

    }

    @Test
    public void txtClientNameVisibility() {
        boolean expected= true;
        boolean actual;
        try {
            actual = addclinet.txtClientName.isEnabled();
        }
        catch (Exception e)
        {
            actual =false;
        }

        Assert.assertEquals(actual, expected);

    }
*/

}
