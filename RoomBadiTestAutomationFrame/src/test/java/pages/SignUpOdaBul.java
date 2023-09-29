package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignUpOdaBul {

    public SignUpOdaBul() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[starts-with(@class,'relative')]/input[starts-with(@placeholder,'Mahalle')]")
    public WebElement odaMahalle;
    @FindBy(xpath = "///input[@name='dateOfMove']")
    public WebElement dateOfMove;
    @FindBy(xpath = "//input[@placeholder='Ay']")
    public WebElement neKadarKalacaksiniz;
    @FindBy(xpath = "//input[@name='rent']")
    public WebElement kira;
    @FindBy(id = "headlessui-combobox-input-:r1c:")
    public WebElement kuruSecin;
    @FindBy(id = "headlessui-combobox-input-:r1f:")
    public WebElement yasAraligiSecin;
    @FindBy(id = "headlessui-combobox-input-:r1i:")
    public WebElement arananCinsiyetiSecin;
}
