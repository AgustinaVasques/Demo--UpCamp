package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EyewearPage {

    private static WebDriver driver;
    @FindBy(linkText = "RETRO CHIC EYEGLASSES")
    private WebElement retroChicEyeglasses;

    public EyewearPage(WebDriver driver) {
        EyewearPage.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public EyewearProductDetailPage getEyewearProductDetail() {
        retroChicEyeglasses.click();
        return new EyewearProductDetailPage(driver);
    }

}
