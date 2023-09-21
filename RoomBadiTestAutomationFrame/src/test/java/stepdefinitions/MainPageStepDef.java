package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        buttonToSend.sendKeys(what);
    }
}
