package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;


public class appium03gestureanative {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
        capabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("appPath"));
        capabilities.setCapability("appPackage", ConfigReader.getProperty("appPackage"));
        capabilities.setCapability("aapActivity", ConfigReader.getProperty("appActivity"));
        capabilities.setCapability("noReset", "true");
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL(ConfigReader.getProperty("appiumURL"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AppiumDriver driver = new AndroidDriver(appiumServerURL, capabilities);

        System.out.println("app yuklendi");


        System.out.println("Permittion Granted Blo");
        WebElement homeScreenTitle = driver.findElement(By.id("android:id/title"));
        assertTrue(homeScreenTitle.isDisplayed());

        System.out.println("Home pagee openned");

        WebElement testButton = driver.findElement(By.xpath("//android.widget.Button[@text='Test']"));
        testButton.click();

        System.out.println("Test button works");


        WebElement testAGestureTitle = driver.findElement(By.id("android:id/title"));
        assertTrue(testAGestureTitle.isDisplayed());
        System.out.println("test screen acildi...");
        driver.quit();
    }
}
