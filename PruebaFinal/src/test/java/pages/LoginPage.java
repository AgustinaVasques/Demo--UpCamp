package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    private static WebDriver driver;
    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "pass")
    private WebElement pass;
    @FindBy(id = "send2")
    private WebElement loginButton;
    @FindBy(className = "error-msg")
    private WebElement errorBanner;
    @FindAll(
            {@FindBy(id = "advice-required-entry-email"),
                    @FindBy(id = "advice-required-entry-pass")}
    )
    private List<WebElement> elementsWithErrorMessages;

    public LoginPage(WebDriver driver) {
        LoginPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEmail() {
        return email.getText();
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public String getPass() {
        return pass.getText();
    }

    public void setPass(String pass) {
        this.pass.sendKeys(pass);
    }

    public void loginClick() {
        loginButton.click();
    }

    public String getErrorBannerText() {
        return errorBanner.getText();
    }

    public List<WebElement> getElementsWithErrorMessages() {
        return elementsWithErrorMessages;
    }
}
