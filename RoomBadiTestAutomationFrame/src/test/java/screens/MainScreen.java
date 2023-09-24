package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.DriverMobile;


import java.time.Duration;

public class MainScreen {
    public MainScreen(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverMobile.getAppiumDriver(), Duration.ofSeconds(30)),this);
    }

    @AndroidFindBy(xpath =   "//android.widget.ImageView[@content-desc='Mesajlar']")
    public WebElement mainMessagesIcon;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Chrome']")
    public WebElement chromeIcon;




}





