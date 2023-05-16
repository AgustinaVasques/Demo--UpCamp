package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenPage {

    private static WebDriver driver;
    @FindBy(linkText = "SHIRTS")
    private WebElement shirts;

    public MenPage(WebDriver driver) {
        MenPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShirtsPage getShirts() {
        shirts.click();
        return new ShirtsPage(driver);
    }

}
