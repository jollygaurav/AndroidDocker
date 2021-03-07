package Driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInit {

    AndroidDriver driver;
    String apkPath= "/opt/flipkart.apk";
    public AndroidDriver createDriver() throws MalformedURLException {
        System.setProperty("host","docker-machine");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");
        caps.setCapability(MobileCapabilityType.APP,apkPath);
        caps.setCapability("clearSystemFiles","true");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
        caps.setCapability(MobileCapabilityType.NO_RESET,"true");
        caps.setCapability("appPackage","com.flipkart.android");
        caps.setCapability("appActivity","com.flipkart.android.SplashActivity");
        driver =  new AndroidDriver(new URL("http://192.168.99.100:4723/wd/hub"),caps);

        return driver;
    }
}
