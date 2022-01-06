package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11 extends TestBase{
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "TC11 - User can't create account while password and PID fields are empty")
    public void TC11() throws Exception {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();

        System.out.println("3. Enter valid email address and leave other fields empty");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register(Constant.USERNAME, "","","");

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
