package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
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
    @FindBy(xpath ="//img[@src=\'/assets/icons/home.svg\']/parent::a")
    public WebElement houseIcon;
    @FindBy(xpath = "//img[@src=\'/assets/icons/face.svg\']/parent::a")
    public WebElement faceIcon;
    @FindBy(xpath = "//div[starts-with(@class,'relative hidden h-11 max-w-full grow rounded-lg text-base ')]//div[starts-with(@id,'headlessui-combobox-button')]/input")
    public WebElement searchBox;

}
