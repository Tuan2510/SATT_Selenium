package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase{
    @Test
    public void TC06() throws Exception {
        System.out.println("TC06 - User is redirected to Home page after logging out ");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.open();
        homePage.gotoLoginPage();
        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC06 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC06.get("email").getAsString();
        String password = dataTC06.get("password").getAsString();
        loginPage.login(email, password);
        homePage.loggingOut();

        String actualMsg = homePage.getPageTitle();
        String expectedMsg = Constant.HOME_PAGE_TITLE;

        Assert.assertFalse(homePage.isDisplayedTabLogout(),"Tab Logout is not disappear after logging out");
        Assert.assertEquals(actualMsg, expectedMsg, "Error that user cannot logging out.");
    }
}
