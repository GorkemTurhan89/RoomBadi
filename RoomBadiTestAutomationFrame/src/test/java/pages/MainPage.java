package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@id='headlessui-menu-button-:r11m:']")
    public WebElement personalButton;
    @FindBy(xpath = "//h4[text()='Giriş Yap']/parent::button")
    public WebElement girisYapButton;
    @FindBy(id = "//input[@id='headlessui-combobox-input-:r12a:']")
    public WebElement countryPhoneAreaCodeSelection;
    @FindBy(xpath = "//input[@inputmode='numeric']")
    public WebElement phoneNumberArea;
    @FindBy(css = "span.text-sm.text-white.font-medium")
    public WebElement girisyapButtonInGirisYapMenu;
}
