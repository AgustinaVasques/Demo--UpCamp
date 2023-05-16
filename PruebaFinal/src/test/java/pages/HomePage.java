package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static WebDriver driver;
    @FindBy(css = "#nav > ol > li.level0.nav-2.parent")
    private WebElement men;
    @FindBy(css = "#nav > ol > li.level0.nav-3.parent")
    private WebElement accesories;
    @FindBy(css = "#nav > ol > li.level0.nav-5.parent")
    private WebElement sale;

    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MenPage getMenPage() {
        men.click();
        return new MenPage(driver);
    }

    public AccesoriesPage getAccesoriesPage() {
        accesories.click();
        return new AccesoriesPage(driver);
    }

    public SalePage getSalePage() {
        sale.click();
        return new SalePage(driver);
    }
}
