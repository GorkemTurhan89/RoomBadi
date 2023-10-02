package stepdefinitions;


import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import screens.Screens;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static io.appium.java_client.android.nativekey.AndroidKey.BACK;
import static io.appium.java_client.android.nativekey.AndroidKey.HOME;
import static org.junit.Assert.assertTrue;


public class AppiumStepDef extends ReusableMethods {
    static AppiumDriver appiumDriver;
    AndroidDriver androidDriver;
    DesiredCapabilities capabilities;
    URL appiumServerURL;

    @Given("user opens phone")
    public void userOpensPhone() throws MalformedURLException, InterruptedException {
        test();
        gestureApp();
    }

    @And("user goes and checks the sms")//bu alan şu an icin kullanılmıyor tekrar kullanilabilir
    public void userGoesAndChecksTheSms() {
        androidDriver.pressKey(new KeyEvent(HOME));
        androidDriver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Mesajlar']")).click();
        androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Roombadi']")).click();
        bekle(2);
        List<WebElement> elementList = androidDriver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text']"));
        WebElement smsElement = elementList.get(elementList.size() - 1);
        String smsNumber = smsElement.getText().replaceAll("\\D", "");
        Driver.getDriver().findElements(By.xpath("//form//div//input")).get(1).sendKeys(smsNumber);
        Driver.getDriver().findElement(By.xpath("//div[@class='mt-5']/button")).click();
        androidDriver.pressKey(new KeyEvent(BACK));
        androidDriver.pressKey(new KeyEvent(HOME));
        androidDriver.quit();

    }


    @Test
    public void test() throws MalformedURLException, InterruptedException {

        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL(ConfigReader.getProperty("appiumURL"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        capabilities = new DesiredCapabilities();
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
            androidDriver = new AndroidDriver(appiumServerURL, capabilities);


        } else if (ConfigReader.getProperty("platformName").equals("iOS")) {
            //if you do not provide app path, so you should use "bundleId"
//                desiredCapabilities.setCapability("bundleId",ConfigReader.getProperty("iosBundleId"));
            assert appiumServerURL != null;
            appiumDriver = new IOSDriver(appiumServerURL, capabilities);
        } else {
            throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
        }

        System.out.println("app yuklendi");

    }


    public void gestureApp() {

        System.out.println("Permittion Granted Blo");

        WebElement homeScreenTitle = androidDriver.findElement(By.id("android:id/title"));
        assertTrue(homeScreenTitle.isDisplayed());

        System.out.println("Home pagee openned");

        WebElement testButton = androidDriver.findElement(By.xpath("//android.widget.Button[@text='Test']"));
        testButton.click();

        System.out.println("Test button works");


        WebElement testAGestureTitle = androidDriver.findElement(By.id("android:id/title"));
        assertTrue(testAGestureTitle.isDisplayed());
        System.out.println("test screen acildi...");

        androidDriver.pressKey(new KeyEvent(HOME));


    }

    @Test
    public void demoApp() throws MalformedURLException, InterruptedException {
        test();
        androidDriver.pressKey(new KeyEvent(HOME));
        bekle(2);
        WebElement appDemoClick = androidDriver.findElement(By.xpath("//android.widget.RelativeLayout[@content-desc='wdio demo app']"));
        WebElement swipeDemoAppin = androidDriver.findElement(By.xpath("//android.widget.Button[@content-desc='Swipe']"));
        appDemoClick.click();
        bekle(2);
        swipeDemoAppin.click();

    }

    public static void scrollSwipe(String pageDirection, double scrollRatio) {
        Duration scrollDur = Duration.ofMillis(300);
        if (scrollRatio < 0 | scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 -1");
        }
        Dimension size = appiumDriver.manage().window().getSize();
        System.out.println("size = " + size);

        Point midpoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));

        int bottom = midpoint.y + (int) (midpoint.y * scrollRatio);
        int top = midpoint.y - (int) (midpoint.y * scrollRatio);
        int left = midpoint.x - (int) (midpoint.x * scrollRatio);
        int right = midpoint.x + (int) (midpoint.x * scrollRatio);

        System.out.println("midpoint = " + midpoint);

        switch (pageDirection.toLowerCase()) {
            case "up":
                swipe(new Point(midpoint.x, top), new Point(midpoint.x, bottom), scrollDur);
                break;
            case "down":
                swipe(new Point(midpoint.x, bottom), new Point(midpoint.x, top), scrollDur);
                break;
            case "left":
                swipe(new Point(left, midpoint.y), new Point(right, midpoint.y), scrollDur);
                break;
            case "right":
                swipe(new Point(right, midpoint.y), new Point(left, midpoint.y), scrollDur);
                break;
        }
    }


    protected static void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumDriver.perform(ImmutableList.of(swipe));
    }
}
