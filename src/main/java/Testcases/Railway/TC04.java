package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 extends TestBase{
    @Test
    public void TC04() throws Exception {
        System.out.println("TC04 - User is redirected to Book ticket page after logging in ");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.open();
        homePage.gotoBookTicketPage();

        String actualLoginTitle = homePage.getPageTitle();
        String expectedLoginTitle = Constant.LOGIN_PAGE_TITLE;

        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC04 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC04.get("email").getAsString();
        String password = dataTC04.get("password").getAsString();
        loginPage.login(email, password);

        String actualTitle = homePage.getPageTitle();
        String expectedTitle = Constant.BOOK_TICKET_PAGE_TITLE;

        Assert.assertEquals(actualLoginTitle,expectedLoginTitle, "Error that User is not directed to Login page.");
        Assert.assertEquals(actualTitle,expectedTitle, "Error that User is not directed to Book Ticket page.");
    }
}
