package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC05 - System shows message when user enters wrong password several times ")
    public void TC05() throws Exception {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Click on \"Login\" tab");
        homePage.gotoLoginPage();
        System.out.println("3. Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        System.out.println("4. Click on \"Login\" button");
        System.out.println("5. Repeat step 3 three more times.");
        loginPage.loginMultipleTimes(Constant.USERNAME, Constant.PASSWORD+"123", 4);
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}
