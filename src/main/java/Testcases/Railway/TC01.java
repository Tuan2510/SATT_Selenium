package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase{
    @Test
    public void TC01() throws Exception {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.open();
        homePage.gotoLoginPage();

        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC01 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC01.get("email").getAsString();
        String password = dataTC01.get("password").getAsString();

        String actualMsg = loginPage.login(email, password).getWelcomeMessage();
        String expectedMsg = "Welcome " + email;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected.");
    }

}
