package Tests;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.selenium.aj34.utils.jsonReaderInArray;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.util.List;
import java.util.Map;

public class LoginTestJSONArray extends BaseTest {

    PageObjects.HomePage homepage;
    PageObjects.LoginPage loginPage;

    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        // Get the list of maps
        List<Map<String, String>> jsonData = jsonReaderInArray.getJsonData("jsonArrayData.json");

        // Create a 2D Object array
        Object[][] data = new Object[jsonData.size()][1];

        // Populate the array with data
        for (int i = 0; i < jsonData.size(); i++) {
            data[i][0] = jsonData.get(i);
        }

        return data;
    }


    @Test(dataProvider = "loginData")
    public void readDataFromJSONArray(Map<String, String> loginData) {
        homepage = new HomePage(driver);
        homepage.click_SignUpLogin();
        loginPage = new LoginPage(driver);
        loginPage.enterLoginEmail(loginData.get("email"));
        loginPage.enterLoginPassword(loginData.get("password"));
        loginPage.clickLoginButton();
    }
}
