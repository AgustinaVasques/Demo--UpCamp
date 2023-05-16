package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;


public class MagnetoTest {

        private WebDriver driver;
        private String email;
        private String password;
        private String baseUrl;

        @DataProvider
        public static Object[][] products() {
                return new Object[][]{};
        }


        @BeforeClass(alwaysRun = true)
        @Parameters({"email", "password"})
        public void setUp(@Optional String email, @Optional String password) throws Exception {
                System.setProperty("webdriver.chrome.driver", System.getProperty("chromeDriverPath", "C:\\Users\\agusv\\Downloads\\chromedriver_win32\\chromedriver.exe"));
                driver = new ChromeDriver();
                baseUrl = System.getProperty("baseUrl", "http://magento-demo.lexiconn.com/customer/account/login/");
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                this.email = email;
                this.password = password;
        }

        @Test
//        @Test(dataProvider = "products", dataProviderClass = ProductsData.class)
//        public void test(String product,String price) throws Exception {
//                driver.get(baseUrl);
//                HomePage homePage = new HomePage(driver);
//                ProductSearchPage productSearchPage = homePage.search(product);
//                ProductPage productPage = productSearchPage.clickProduct(product);
//                assertEquals(productPage.getPrice(), price);
//        }

        @Test
        public void test(String email, String password) throws Exception {
                driver.get(baseUrl);
                LoginPage loginPage = new LoginPage(driver);
                ProductSearchPage productSearchPage = homePage.search(product);
                ProductPage productPage = productSearchPage.clickProduct(product);
                assertEquals(productPage.getPrice(), price);
        }        
        
        @Test(dataProvider = "products", dataProviderClass = ProductsData.class)
        public void test(String product,String price) throws Exception {
                driver.get(baseUrl);
                HomePage homePage = new HomePage(driver);
                ProductSearchPage productSearchPage = homePage.search(product);
                ProductPage productPage = productSearchPage.clickProduct(product);
                assertEquals(productPage.getPrice(), price);
        }






        String userName = new userName(
        WebDriver driver = new ChromeDriver();
        System.setPoperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        //email
        driver.manage.window.maximize();
        driver.get("http://magento-demo.lexiconn.com/customer/account/login/");
        driver.findElement(By.id("email"));
        WebElement username = driver.findElement(By.id("email"));

        //password
        driver.findElement(By.id("pass"));
        WebElement username = driver.findElement(By.id("pass"));

}
