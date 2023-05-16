package dataProviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "login-data")
    public static Object[][] getLoginData() {
        return new Object[][]{
                {"pepe@gmail.com", "contra123"},
                {"pedro@gmail.com", "senha123"}
        };
    }

}
