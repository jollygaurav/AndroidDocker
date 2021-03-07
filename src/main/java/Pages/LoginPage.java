package Pages;

import Utils.Base;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    MobileDriver driver;

    public LoginPage(MobileDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @FindBy(how = How.XPATH,using = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.flipkart.android:id/language_list']//android.widget.RelativeLayout[6]")
    private WebElement englishLanguage;

    public void selectLanguage() {
        click(englishLanguage);
    }
}
