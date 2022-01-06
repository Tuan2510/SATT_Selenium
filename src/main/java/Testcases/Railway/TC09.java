package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.GeneralPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    GeneralPage generalPage = new GeneralPage();

    @Test(description = "TC09 - User can't change password when \"New Password\" and \"Confirm Password\" are different.")
    public void TC09() throws Exception {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("3. Click on \"Change Password\" tab");
        generalPage.gotoChangePasswordPage();

        System.out.println("4. Enter valid information into \"Current Password\" textbox but enter \"a123:\"/{}!@$\\\" into \"New Password\" textbox and \"b456:\"/{}!@$\\\" into \"Confirm Password\" textbox.");
        changePasswordPage.changePassword(Constant.PASSWORD,"a123:\"/{}!@$\\","b456:\"/{}!@$\\");

        String actualErrorMsg = changePasswordPage.getMessageError();
        String expectedErrorMsg = "Password change failed. Please correct the errors and try again.";
        String actualConfirmPasswordErrorMsg = changePasswordPage.getConfirmPasswordMessageError();
        String expectedConfirmPasswordErrorMsg = "The password confirmation does not match the new password.";

        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualConfirmPasswordErrorMsg, expectedConfirmPasswordErrorMsg, "Confirm error message is not displayed as expected.");
    }
}
