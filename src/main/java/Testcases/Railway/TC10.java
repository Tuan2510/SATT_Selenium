package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 extends TestBase{
    @Test
    public void TC10() throws Exception {
        System.out.println("TC10 - User can't create account with an already in-use email");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        homePage.open();
        homePage.gotoRegisterPage();
        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC10 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String inUseEmail = dataTC10.get("in_use_email").getAsString();
        String password = dataTC10.get("password").getAsString();
        String confirm_password = dataTC10.get("confirm_password").getAsString();
        String pid = dataTC10.get("pid").getAsString();
        registerPage.register(inUseEmail, password,confirm_password,pid);

        String actualMsg = registerPage.getMessageError();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}
