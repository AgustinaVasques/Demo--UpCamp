package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PantsAndDenimPage {

    private static WebDriver driver;
    @FindBy(linkText = "PARK AVENUE PLEAT FRONT TROUSERS")
    private WebElement parkAvenuePleatFrontTrousers;
    @FindBy(linkText = "ADD TO CART")
    private WebElement addToCartButton;

    public PantsAndDenimPage(WebDriver driver) {
        PantsAndDenimPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductDetailPage getProductDetailOfParkAvenuePleatFrontTrousers() {
        parkAvenuePleatFrontTrousers.click();
        return new ProductDetailPage(driver);
    }

    public CartPage getCartPage() {
        addToCartButton.click();
        return new CartPage(driver);
    }
}
