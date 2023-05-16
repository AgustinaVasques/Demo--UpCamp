package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

    private static WebDriver driver;
    @FindBy(className = "price")
    public WebElement price;

    public ProductDetailPage(WebDriver driver) {
        ProductDetailPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPrice() {
        return price.getText();
    }
}
