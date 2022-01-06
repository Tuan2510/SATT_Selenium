package Testcases.Railway;

import Common.Constant;
import Common.Utils;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    Utils utils = new Utils();

    @Test(description = "TC07 - User can create new account")
    public void TC07() {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();

        System.out.println("3. Enter valid information into all fields");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register(utils.randomEmailAddressByTime(), Constant.PASSWORD, Constant.PASSWORD, Constant.PID);

        String actualMsg = registerPage.getMessage();
        String expectedMsg = "Thank you for registering your account.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error that user cannot register an account.");
    }
}
