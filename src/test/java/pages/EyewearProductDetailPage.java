package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EyewareProductDetailPage {

    private static WebDriver driver;
    @FindBy(linkText = "Add to cart")
    private WebElement addToCartButton;

    public EyewareProductDetailPage(WebDriver driver) {
        EyewareProductDetailPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPage getCartPage() {
        addToCartButton.click();
        return new CartPage(driver);
    }
}
