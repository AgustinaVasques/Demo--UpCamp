package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static WebDriver driver;

    public HomePage(WebDriver driver){
        HomePage.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = )
}
