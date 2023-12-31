package utilities;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.android.nativekey.AndroidKey.*;
import static org.junit.Assert.assertTrue;


public class appium03gestureanative {
    AndroidDriver driver;
    @Test
    public void test() throws MalformedURLException, InterruptedException {

        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL(ConfigReader.getProperty("appiumURL"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
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
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);


        if (ConfigReader.getProperty("platformName").contains("Android")) {
            //if you do not provide app path, so you should provide "appPackage" and "appActivity"

            assert appiumServerURL != null;
            driver = new AndroidDriver(appiumServerURL, capabilities);
        } else if (ConfigReader.getProperty("platformName").equals("iOS")) {
            //if you do not provide app path, so you should use "bundleId"
//                desiredCapabilities.setCapability("bundleId",ConfigReader.getProperty("iosBundleId"));
            assert appiumServerURL != null;

        } else {
            throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
        }

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
        driver.pressKey(new KeyEvent(HOME));
        driver.quit();
    }
}
