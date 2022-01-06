package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC04() throws Exception {
        System.out.println("TC04 - User is redirected to Book ticket page after logging in ");

        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();

        String actualLoginTitle = homePage.getPageTitle();
        String expectedLoginTitle = Constant.LOGIN_PAGE_TITLE;

        System.out.println("3. Login with valid account");
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        String actualTitle = homePage.getPageTitle();
        String expectedTitle = Constant.BOOK_TICKET_PAGE_TITLE;

        Assert.assertEquals(actualLoginTitle, expectedLoginTitle, "Error that User is not directed to Login page.");
        Assert.assertEquals(actualTitle, expectedTitle, "Error that User is not directed to Book Ticket page.");
    }
}
