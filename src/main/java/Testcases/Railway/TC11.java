package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase{
    @Test
    public void TC11() throws Exception {
        System.out.println("TC11 - User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();

        homePage.open();
        homePage.gotoRegisterPage();
        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC11 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC11.get("email").getAsString();
        registerPage.register(email, "","","");

        String actualErrorMsg = registerPage.getMessageError();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualPasswordErrorMsg = registerPage.getPasswordMessageError();
        String expectedPasswordErrorMsg = "Invalid password length";
        String actualPIDErrorMsg = registerPage.getPIDMessageError();
        String expectedPIDErrorMsg = "Invalid ID length";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualPasswordErrorMsg, expectedPasswordErrorMsg, "Password error message is not displayed as expected.");
        Assert.assertEquals(actualPIDErrorMsg, expectedPIDErrorMsg, "PID error message is not displayed as expected.");
    }
}
