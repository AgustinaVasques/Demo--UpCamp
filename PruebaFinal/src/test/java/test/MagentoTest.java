package test;

import dataProviders.LoginDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;


public class MagentoTest {

    private WebDriver driver;
    private String email;
    private String password;
    private String baseUrl;
    private String loginUrl;

    @DataProvider
    public static Object[][] products() {
        return new Object[][]{};
    }


    @BeforeClass(alwaysRun = true)
    @Parameters({"email", "password"})
    public void setUp(@Optional String email, @Optional String password) throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("chromeDriverPath", "C:\\Users\\agusv\\Downloads\\chromedriver_win32\\chromedriver.exe"));
        driver = new ChromeDriver();
        loginUrl = System.getProperty("baseUrl", "http://magento-demo.lexiconn.com/customer/account/login/");
        baseUrl = System.getProperty("baseUrl", "http://magento-demo.lexiconn.com");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        this.email = email;
        this.password = password;
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }

    @Test
    public void testLoginWithoutData() throws Exception {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginClick();
        List<WebElement> elementsWithErrorMessagesOfRequiredFields = loginPage.getElementsWithErrorMessages();
        assertNotNull(elementsWithErrorMessagesOfRequiredFields);
        assertEquals(2, elementsWithErrorMessagesOfRequiredFields.size());
    }

    @Test
    public void addOneElementToCart() {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        AccesoriesPage accesoriesPage = homePage.getAccesoriesPage();
        EyewearPage eyewearPage = accesoriesPage.getEyewearPage();
        EyewearProductDetailPage eyewearProductDetailPage = eyewearPage.getEyewearProductDetail();
        CartPage cartPage = eyewearProductDetailPage.getCartPage();
        WebElement cartTable = cartPage.getShoppingCartTable();
        List<WebElement> tableRows = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(cartTable, By.tagName("tr")));
        assertNotNull(tableRows);
        String productName = tableRows.get(2).findElement(By.className("product-name")).getText();
        assertEquals("RETRO CHIC EYEGLASSES", productName);
    }

    @Test
    public void testEmptySalePage() {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        SalePage salePage = homePage.getSalePage();
        assertEquals("There are no products matching the selection.", salePage.getNoteMsgText());
    }

    @Test(dataProvider = "login-data", dataProviderClass = LoginDataProvider.class)
    public void testLoginDataWithNonExistentUser(String email, String pass) {
        driver.get(loginUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(email);
        loginPage.setPass(pass);
        loginPage.loginClick();
        String errorMessage = loginPage.getErrorBannerText();
        assertEquals("Invalid login or password.", errorMessage);
    }

    @Test
    public void testEmptyShirtPage() {
        driver.get(baseUrl);
        HomePage homePage = new HomePage(driver);
        MenPage menPage = homePage.getMenPage();
        ShirtsPage shirtsPage = menPage.getShirts();
        assertEquals("There are no products matching the selection.", shirtsPage.getNoteMsgText());
    }

//    @Attachment(type = "image/png")
//    @AfterMethod(alwaysRun = true)
//    public byte[] takeScreenshot() throws Exception {
//        byte[] image = new byte[0];
//        try {
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            image = screenshot.getScreenshotAs(OutputType.BYTES);
//            System.out.println("Successfully captured a screenshot");
//        } catch (Exception e) {
//            System.out.println("Exception while taking screenshot " + e.getMessage());
//        }
//        return image;
//
//    }

}
