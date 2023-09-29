package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[starts-with(@class,'relative inline-block text-left')]//button[starts-with(@id,'headlessui-menu-button-:r')]")
    public WebElement personalButton;
    @FindBy(xpath = "//h4[text()='Giriş Yap']/parent::button")
    public WebElement girisYapButton;
    @FindBy(id = "//input[@id='headlessui-combobox-input-:r12a:']")
    public WebElement countryPhoneAreaCodeSelection;
    @FindBy(xpath = "//input[@inputmode='numeric']")
    public WebElement phoneNumberArea;
    @FindBy(css = "span.text-sm.text-white.font-medium")
    public WebElement girisyapButtonInGirisYapMenu;

    //switch icons
    @FindBy(xpath = "//a[text()='Ev / Oda İlanları']")
    public WebElement evOdaIlanlari;
    @FindBy(xpath = "//a[text()='Ev Arkadaşı İlanları']")
    public WebElement evArkadasIlanlari;
    @FindBy(xpath = "//div[starts-with(@class,'relative hidden h-11 max-w-full grow rounded-lg text-base ')]//div[starts-with(@id,'headlessui-combobox-button')]/input")
    public WebElement searchBox;


    //RoomBadi sms entry page

    @FindBy(xpath = "//form//div//input")
    public WebElement firstSpaceToSendSMS;//form[@data-gtm-form-interact-id='1']//input[@data-gtm-form-interact-field-id='1']
    @FindBy(xpath = "//form[@data-gtm-form-interact-id='1']//input")
    public List<WebElement> listofSpaceToSendSMS;//use if firstSpaceToSendSMS not works;

    @FindBy(xpath = "//div[@class='mt-5']/button")
    public WebElement numaraniziDogrulayinButton;

    @FindBy(xpath = "//span[text()='Devam Et']/parent::button")
    public WebElement devamEtButton;
    @FindBy(xpath = "//span[text()='Çıkış Yap']/parent::button")
    public WebElement cikisYapEtButton;


    @FindBy(xpath = "//span[text()='Yeni İlan']/parent::button[starts-with(@class,'relative')]")
    public WebElement yeniIlanButton;

}
