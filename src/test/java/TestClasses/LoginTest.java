package TestClasses;

import Driver.DriverInit;
import Pages.LoginPage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest {
    MobileDriver driver;
    DriverInit driverInitiator;
    LoginPage loginPageObject;

    @BeforeTest
    public void driverInit() throws MalformedURLException {
        driverInitiator= new DriverInit();
        driver = driverInitiator.createDriver();
        loginPageObject = new LoginPage(driver);
    }

    @Test
    public void openApp(){
        loginPageObject.selectLanguage();
    }
}
