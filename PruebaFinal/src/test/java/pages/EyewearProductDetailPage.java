package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EyewearProductDetailPage {

    private static WebDriver driver;
    @FindBy(className = "add-to-cart-buttons")
    private WebElement addToCartButton;

    public EyewearProductDetailPage(WebDriver driver) {
        EyewearProductDetailPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPage getCartPage() {
        addToCartButton.click();
        return new CartPage(driver);
    }
}
