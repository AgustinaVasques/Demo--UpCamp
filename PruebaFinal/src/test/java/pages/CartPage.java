package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private static WebDriver driver;
    @FindBy(id = "shopping-cart-table")
    private WebElement shoppingCartTable;

    public CartPage(WebDriver driver) {
        CartPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getShoppingCartTable() {
        return this.shoppingCartTable;
    }
}
