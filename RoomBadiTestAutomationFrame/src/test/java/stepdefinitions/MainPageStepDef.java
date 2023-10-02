package stepdefinitions;

import com.github.javafaker.Faker;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pages.Pages;
import screens.Screens;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.assertTrue;

//TODO Buton locatini güncelle
public class MainPageStepDef extends ReusableMethods {

    AppiumStepDef appiumStepDef = new AppiumStepDef();
    Pages pages = new Pages();
    Screens screens = new Screens();
    Faker faker = new Faker();
    Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).withMessage("Ignoring No Such Element Exception").ignoring(NoSuchElementException.class);

    @Given("user goes to {string}")
    public void user_goes_to(String url) {
        bekle(3);
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
        Driver.getDriver().quit();

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
            case "numaraniziDogrulayinButton":
                tempElement = pages.mainPage().numaraniziDogrulayinButton;
                break;
            case "devamEtButton":
                tempElement = pages.mainPage().devamEtButton;
                break;
            case "cikisYapEtButton":
                tempElement = pages.mainPage().cikisYapEtButton;
                break;
            case "evArkadasIlanlari":
                tempElement = pages.mainPage().evArkadasIlanlari;
                break;
            case "evOdaIlanlari":
                tempElement = pages.mainPage().evOdaIlanlari;
                break;
            case "yeniIlanButton":
                tempElement = pages.mainPage().yeniIlanButton;
                break;
            case "sonrakiAdimButton":
                tempElement = pages.yeniIlanPage().sonrakiAdimButton;
                break;
            case "neredeEvAriyorsun":
                tempElement = pages.evDetaylari().neredeEvAriyorsun;
                break;
            case "neKadarKiraVerebilirsiniz":
                tempElement = pages.evDetaylari().neKadarKiraVerebilirsiniz;
                break;
            case "kiraKuru":
                tempElement = pages.evDetaylari().kiraKuru;
                break;
            case "depositoVarMi":
                tempElement = pages.evDetaylari().depositoVarMi;
                break;
            case "kacAySureligineArkadasAra":
                tempElement = pages.evDetaylari().kacAySureligineArkadasAra;
                break;
            case "kacKisi":
                tempElement = pages.evDetaylari().kacKisi;
                break;
            case "depositoozelOdaVarMi":
                tempElement = pages.evDetaylari().ozelOda;
                break;
            case "sonrakiAdim":
                tempElement = pages.evDetaylari().sonrakiAdim;
                break;
            case "signUpName":
                tempElement = pages.signUpPage().signUpName;
                break;
            case "signUpLastName":
                tempElement = pages.signUpPage().signUpLastName;
                break;
            case "signUpEmail":
                tempElement = pages.signUpPage().signUpEmail;
                break;
            case "birthDate":
                tempElement = pages.signUpPage().birthDate;
                break;
            case "genderMale":
                tempElement = pages.signUpPage().genderMale;
                break;
            case "nextButton":
                tempElement = pages.signUpPage().nextButton;
                break;
            case "petInput":
                tempElement = pages.signUpPage().petInput;
                break;
            case "misafirButton":
                tempElement = pages.signUpPage().misafirButton;
                break;
            case "temizlikButton":
                tempElement = pages.signUpPage().temizlikButton;
                break;
            case "smokingYes":
                tempElement = pages.signUpPage().smokingYes;
                break;
            case "kaydet2":
                tempElement = pages.signUpPage().kaydet2;
                break;
            case "kayitOlusturulduMessage":
                tempElement = pages.signUpPage().kayitOlusturulduMessage;
                break;
            case "tamamButton":
                tempElement = pages.signUpPage().tamamButton;
                break;
            case "evOdaBulInSignUp":
                tempElement = pages.signUpPage().evOdaBulInSignUp;
                break;
            case "odaMahalle":
                tempElement = pages.signUpOdaBul().odaMahalle;
                break;
            case "kisiselBilgilerim":
                tempElement = pages.profiliGoster().kisiselBilgilerim;
                break;
            case "hesabiSil":
                tempElement = pages.profiliGoster().hesabiSil;
                break;
            case "dateOfMove":
                tempElement = pages.signUpOdaBul().dateOfMove;
                break;
            case "neKadarKalacaksiniz":
                tempElement = pages.signUpOdaBul().neKadarKalacaksiniz;
                break;
            case "kira":
                tempElement = pages.signUpOdaBul().kira;
                break;
            case "kuruSecin":
                tempElement = pages.signUpOdaBul().kuruSecin;
                break;
            case "yasAraligiSecin":
                tempElement = pages.signUpOdaBul().yasAraligiSecin;
                break;
            case "arananCinsiyetiSecin":
                tempElement = pages.signUpOdaBul().arananCinsiyetiSecin;
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
        if (what.contains("configphone")) {
            what = ConfigReader.getProperty("userphonenumber");
        }
        buttonToSend.sendKeys(what);
    }

    @And("user waits for {string}")
    public void userWaitsFor(String second) {

        int integersecond = Integer.parseInt(second);
        bekle(integersecond);
    }


    //down not functional for now
    public void androidMessageSeekerOnline() {
        HashMap<String, String> windowHandles = openNewWindowAndGetHandles();
        android_message_onweb(windowHandles);
    }

    private void android_message_onweb(HashMap<String, String> windowHandles) {
        Driver.getDriver().switchTo().window(windowHandles.get("SecondMessageWindowHandle"));
        Driver.getDriver().get(ConfigReader.getProperty("messageUrl"));
        pages.messagesGoogle().roomBadiMessageBoxTitleToClick.click();
//switched and navigated to message url
        assertTrue(pages.messagesGoogle().roomBadiMessageBoxTitleToConfirm.isDisplayed());
        System.out.println("SMS can be viewed");
        WebElement lastRoomBadiMessageElement = pages.messagesGoogle().roomBadiSendSMSs.get(pages.messagesGoogle().roomBadiSendSMSs.size());
        String lastSmsofRoombadi = lastRoomBadiMessageElement.getText();

        //get back to roombadi url
        Driver.getDriver().switchTo().window(windowHandles.get("FirstMainWindowHandle"));
        pages.mainPage().firstSpaceToSendSMS.sendKeys(lastSmsofRoombadi);
    }

    private static HashMap<String, String> openNewWindowAndGetHandles() {
        HashMap<String, String> handlesMap = new HashMap<>();
        String mainWindowHandle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Set<String> allHandles = Driver.getDriver().getWindowHandles();
        String messageWindowHandle;
        for (String a : allHandles) {
            if (a.equals(mainWindowHandle)) {
                System.out.println("First Main Window Handle:" + mainWindowHandle);
                handlesMap.put("FirstMainWindowHandle", mainWindowHandle);
            } else {
                messageWindowHandle = a;
                System.out.println("Second Message Window Handle" + messageWindowHandle);
                handlesMap.put("SecondMessageWindowHandle", messageWindowHandle);
            }
        }
        return handlesMap;
    }


    @And("user type in {string} to chose one")
    public void userTypeInToChoseOne(String toWhere) {
        WebElement buttonToSend = getElement(toWhere);
        wait.until(ExpectedConditions.visibilityOf(buttonToSend));
        buttonToSend.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    @And("checks the {string}")
    public void checksThe(String messageElement) {
        bekle(2);
        WebElement elementToCheck = getElement(messageElement);
        String textToCheck = elementToCheck.getText();
        System.out.println("Text to check" + textToCheck);
        assertTrue(textToCheck.contains("Başarıyla"));
    }

    @And("user type in {string} to {string} and enters")
    public void userTypeInToAndEnters(String toWhere, String what) {
        WebElement buttonToSend = getElement(toWhere);
        wait.until(ExpectedConditions.visibilityOf(buttonToSend));
        if (what.contains("configphone")) {
            what = ConfigReader.getProperty("userphonenumber");
        }
        buttonToSend.sendKeys(what + Keys.ARROW_DOWN );
        bekle(2);
        buttonToSend.sendKeys(Keys.TAB);

    }

    @And("alerti kabul et")
    public void alertiKabulEt() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @And("change to {string}")
    public void changeTo(String arg0) {
        switch (arg0) {
            case "frame":
                Driver.getDriver().switchTo().frame(0);
                break;
            case "parentFrame":
                Driver.getDriver().switchTo().parentFrame();
                break;

        }
    }

    @And("user schrolldown")
    public void userSchrolldown() {
        scrollEnd();
    }
}
