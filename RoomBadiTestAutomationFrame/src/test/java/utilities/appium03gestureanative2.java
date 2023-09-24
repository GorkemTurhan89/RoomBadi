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


public class appium03gestureanative2 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        AppiumDriver driver = DriverMobile.getAppiumDriver();

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
