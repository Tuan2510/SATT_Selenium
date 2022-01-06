package Testcases.Railway;

import Common.*;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC08 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    Utils utils = new Utils();
    String username = utils.randomEmailAddressByTime();

    @BeforeTest(description = "Pre-condition: Create a new account but do not activate it")
    public void beforeTest(){
//        System.out.println("1. Navigate to QA Railway Website");
//        homePage.open();
//
//        System.out.println("2. Click on \"Register\" tab");
//        homePage.gotoRegisterPage();
//
//        System.out.println("3. Enter valid information into all fields");
//        System.out.println("4. Click on \"Register\" button");
//        registerPage.register(username, Constant.PASSWORD, Constant.PASSWORD, Constant.PID);
    }

    @Test(description = "TC08 - User can't login with an account hasn't been activated")
    public void TC08() {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();

        System.out.println("3. Enter valid information into all fields");
        System.out.println("4. Click on \"Register\" button");
        loginPage.login(username, Constant.PASSWORD);

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}
