package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpPage {
    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement signUpName;
    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement signUpLastName;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement signUpEmail;
    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birthDate;
    @FindBy(xpath = "//label[text()='Erkek']")
    public WebElement genderMale;
    @FindBy(xpath = "//*[text()='Sonraki Adım']/parent::button")
    public WebElement nextButton;
    @FindBy(xpath = "//input[@placeholder='Evcil hayvan']")
    public WebElement petInput;
    @FindBy(xpath = "//input[@placeholder='Misafir']")
    public WebElement misafirButton;
    @FindBy(xpath = "//input[@placeholder='Temizlik']")
    public WebElement temizlikButton;
    @FindBy(xpath = "//label[@for='smokingStatus_1']")
    public WebElement smokingYes;
    @FindBy(xpath = "//span[text()='Kaydet']/parent::button")
    public WebElement kaydet2;
    @FindBy(xpath = "///h5")
    public WebElement kayitOlusturulduMessage;
    @FindBy(xpath = "//*[text()='Tamam']/parent::button")
    public WebElement tamamButton;
}
