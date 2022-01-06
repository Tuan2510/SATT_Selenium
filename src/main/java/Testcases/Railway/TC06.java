package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 extends TestBase{
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC06 - User is redirected to Home page after logging out ")
    public void TC06() throws Exception {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Login with valid Email and Password");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        System.out.println("3. Click on \"Contact\" tab");
        homePage.gotoContactPage();
        System.out.println("4. Click on \"Log out\" tab");
        homePage.loggingOut();

        String actualMsg = homePage.getPageTitle();
        String expectedMsg = Constant.HOME_PAGE_TITLE;

        Assert.assertFalse(homePage.isDisplayedTabLogout(),"Tab Logout is not disappear after logging out");
        Assert.assertEquals(actualMsg, expectedMsg, "Error that user cannot logging out.");
    }
}
