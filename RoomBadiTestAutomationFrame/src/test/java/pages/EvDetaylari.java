package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EvDetaylari {
    public EvDetaylari() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='headlessui-combobox-button-:r1g:']")
    public WebElement neredeEvAriyorsun;
    @FindBy(xpath = "//div[@class='mt-5 flex items-end']//input[@name='rent']")
    public WebElement neKadarKiraVerebilirsiniz;
    @FindBy(xpath = " //div[@class='mt-5 flex items-end']//input[@id='headlessui-combobox-input-:r28:']")
    public WebElement kiraKuru;
    @FindBy(id = "headlessui-combobox-input-:r5g:")
    public WebElement depositoVarMi;
    @FindBy(id = "headlessui-combobox-input-:r5h:")
    public WebElement kacAySureligineArkadasAra;
    @FindBy(id = "headlessui-combobox-input-:r5i:")
    public WebElement kacKisi;
    @FindBy(id = "headlessui-combobox-input-:r5j:")
    public WebElement ozelOda;

    @FindBy(xpath = "//button//span[text()='Sonraki Adım']")
    public WebElement sonrakiAdim;
}