package Utils;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class Base {
    MobileDriver driver;
    public Base(MobileDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element){
        element.click();
    }

}
