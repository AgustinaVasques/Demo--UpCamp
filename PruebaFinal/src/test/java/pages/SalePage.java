package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalePage {

    private static WebDriver driver;
    @FindBy(className = "note-msg")
    private WebElement noteMsg;

    public SalePage(WebDriver driver) {
        SalePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getNoteMsgText() {
        return noteMsg.getText();
    }

}
