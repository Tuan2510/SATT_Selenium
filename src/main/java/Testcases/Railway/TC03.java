package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    @Test(description = "TC03 - User cannot log into Railway with invalid password ")
    public void TC03() {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();
        System.out.println("3. Enter valid Email and invalid Password");
        System.out.println("4. Click on \"Login\" button");
        loginPage.login(Constant.USERNAME, "!@#$%^&*()");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}
