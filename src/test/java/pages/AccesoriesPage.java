package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {


    private static WebDriver driver;
    @FindBy(linkText = "PANTS & DENIM")
    private WebElement pantsAndDenim;

    public WomenPage(WebDriver driver) {
        WomenPage.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public PantsAndDenimPage getPantsAndDenim() {
        pantsAndDenim.click();
        return new PantsAndDenimPage(driver);
    }

}
