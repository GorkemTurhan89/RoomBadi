package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProfiliGoster {
    public ProfiliGoster(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Kişisel Bilgilerim']/parent::a")
    public WebElement kisiselBilgilerim;
    @FindBy(xpath = "//span[text()='Hesabı Sil']")
    public WebElement hesabiSil;
}
