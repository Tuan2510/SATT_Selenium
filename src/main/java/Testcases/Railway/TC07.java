package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Utils.Utils;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase{
    @Test
    public void TC07() throws Exception {
        System.out.println("TC07 - User can create new account");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        Utils utils = new Utils();

        homePage.open();
        homePage.gotoRegisterPage();
        homePage.open();
        homePage.gotoRegisterPage();

        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC07 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String password = dataTC07.get("password").getAsString();
        String reEnterPassword = dataTC07.get("re_enter_password").getAsString();
        String pid = dataTC07.get("pid").getAsString();
        registerPage.register(utils.randomEmailAddressByTime(),password,reEnterPassword,pid);

        String actualMsg = registerPage.getMessage();
        String expectedMsg = "Thank you for registering your account.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error that user cannot register an account.");
    }
}
