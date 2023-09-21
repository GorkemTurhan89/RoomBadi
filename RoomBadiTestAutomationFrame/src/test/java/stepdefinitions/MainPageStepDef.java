package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.Pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

//TODO Buton locatini güncelle
public class MainPageStepDef extends ReusableMethods {
    @BeforeAll
    public static void beforeAll() {
        // Runs before all scenarios
    }

    @AfterAll
    public static void afterAll() {
        // Runs after all scenarios
    }

    Pages pages = new Pages();
    Faker faker = new Faker();
    Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).withMessage("Ignoring No Such Element Exception").ignoring(NoSuchElementException.class);

    @Given("user goes to {string}")
    public void user_goes_to(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }


    @Given("click to {string}")
    public void click_to(String button) throws InterruptedException {
        Thread.sleep(3);
        WebElement buttonToClick = getElement(button);
        buttonToClick.click();

    }

    @Given("close WebSite")
    public void closeTheWebcite() {
        bekle(3);
        Driver.getDriver().close();

    }

    public void isVisible(String nameOfVisibleElement) {
        WebElement elementToDisplayed = getElement(nameOfVisibleElement);
        wait.until(ExpectedConditions.visibilityOf(elementToDisplayed));
        assertTrue(elementToDisplayed.isDisplayed());

    }

    public WebElement getElement(String elementName) {
        WebElement tempElement = null;
        switch (elementName) {
            case "countryPhoneAreaCodeSelection":
                tempElement = pages.mainPage().countryPhoneAreaCodeSelection;
                break;
            case "girisYapButton":
                tempElement = pages.mainPage().girisYapButton;
                break;
            case "girisyapButtonInGirisYapMenu":
                tempElement = pages.mainPage().girisyapButtonInGirisYapMenu;
                break;
            case "personalButton":
                tempElement = pages.mainPage().personalButton;
                break;
            case "phoneNumberArea":
                tempElement = pages.mainPage().phoneNumberArea;
                break;
        }
        return tempElement;
    }

    public String getFaker(String text) {

        switch (text) {
            case "fakeName":
                text = faker.name().name();
                break;
            case "fakeSubject":
                text = faker.funnyName().name();
                break;
            case "fakeEmail":
                text = faker.internet().emailAddress();
                break;
            case "fakeMessage":
                text = faker.lorem().paragraph();
                break;
        }
        return text;
    }

    @And("user type in {string} to {string}")
    public void userTypeInTo(String toWhere, String what) {
        WebElement buttonToSend = getElement(toWhere);
        wait.until(ExpectedConditions.visibilityOf(buttonToSend));
        if(what.contains("configphone")){
            what = ConfigReader.getProperty("userphonenumber");
        }
        buttonToSend.sendKeys(what);
    }

    @And("user waits for {string}")
    public void userWaitsFor(String second) {

        int integersecond = Integer.parseInt(second);
        bekle(integersecond);
    }

    @And("user goes and checks the sms")
    public void userGoesAndChecksTheSms() {
        HashMap<String,String> windowHandles =openNewWindowAndHandle();
        Driver.getDriver().switchTo().window(windowHandles.get("SecondMessageWindowHandle"));
        Driver.getDriver().get(ConfigReader.getProperty("messageUrl"));

    }

    private static HashMap<String,String> openNewWindowAndHandle() {
        HashMap<String,String> handlesMap = new HashMap<>();
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Set<String> allHandles =Driver.getDriver().getWindowHandles();
        String messageWindowHandle;
        for (String a : allHandles){
            if(a.equals(mainWindowHandle)){
                System.out.println("First Main Window Handle:"+mainWindowHandle);
                handlesMap.put("FirstMainWindowHandle",mainWindowHandle);
            }else {
                messageWindowHandle = a;
                System.out.println("Second Message Window Handle"+messageWindowHandle);
                handlesMap.put("SecondMessageWindowHandle",messageWindowHandle);
            }
        }return  handlesMap;
    }
}
