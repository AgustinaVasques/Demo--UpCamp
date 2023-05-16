package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccesoriesPage {


    private static WebDriver driver;
    @FindBy(linkText = "EYEWEAR")
    private WebElement eyewear;

    public AccesoriesPage(WebDriver driver) {
        AccesoriesPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EyewearPage getEyewearPage() {
        eyewear.click();
        return new EyewearPage(driver);
    }

}
