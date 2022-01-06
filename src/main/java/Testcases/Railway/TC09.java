package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase{
    @Test
    public void TC09() throws Exception {
        System.out.println("TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.open();
        homePage.gotoLoginPage();
        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC09 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC09.get("email").getAsString();
        String password = dataTC09.get("password").getAsString();
        String newPassword = dataTC09.get("new_password").getAsString();
        String confirmPassword = dataTC09.get("confirm_password").getAsString();
        loginPage.login(email, password).gotoChangePasswordPage();

        ChangePasswordPage changePasswordPage = new ChangePasswordPage();
        changePasswordPage.changePassword(password,newPassword,confirmPassword);

        String actualMsg = changePasswordPage.getMessageError();
        String expectedMsg = "Password change failed. Please correct the errors and try again.";
        String actualConfirmPasswordErrorMsg = changePasswordPage.getConfirmPasswordMessageError();
        String expectedConfirmPasswordErrorMsg = "The password confirmation does not match the new password.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualConfirmPasswordErrorMsg, expectedConfirmPasswordErrorMsg, "Confirm error message is not displayed as expected.");
    }
}
