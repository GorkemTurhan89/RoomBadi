package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MessagesGoogle {
    public MessagesGoogle() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Roombadi .com']")
    public WebElement roombadiMessageBoxInMessagesGoogle;

    @FindBy(xpath = "//div[text()=' Start chat ']")
    public WebElement startChatInMessagesGoogle;

    @FindBy(xpath = "//mws-message-wrapper")
    public List<WebElement> messagesInRegardedMFromMessager;
}
