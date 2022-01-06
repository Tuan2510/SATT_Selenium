package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utils;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;

public class TC16 extends TestBase {
    @BeforeTest(description = "Pre-condition: Create and activate a new account")
    public void beforeTest() {

    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() throws Exception {
        String filePath = Utils.getProjectPath() + "\\Data\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC16 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate = dataTC16.get("departDate").getAsString();
        String departFrom = dataTC16.get("departFrom").getAsString();
        String arriveAt = dataTC16.get("arriveAt").getAsString();
        String seatType = dataTC16.get("seatType").getAsString();
        String ticketAmount = dataTC16.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departDate, departFrom, arriveAt, seatType, ticketAmount}
        };
        return object;
    }

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(description = "TC16 - User can cancel a ticket", dataProvider = "data-provider")
    public void TC16(String departDate, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Book a ticket");
        homePage.gotoBookTicketPage();
        String newDepartDate = Utils.createDepartDate();
        bookTicketPage.bookTicket(newDepartDate, departFrom, arriveAt, seatType, ticketAmount);

        System.out.println("4. Click on \"My ticket\" tab");
        homePage.gotoMyTicket();

        System.out.println("5. Click on \"Cancel\" button of ticket which user want to cancel.");
        myTicketPage.clickCancelButton();

        System.out.println("6. Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.clickOKAlert();

        Integer actualMsg = 1;
        Integer expectedMsg = 0;

        Assert.assertEquals(actualMsg, expectedMsg, "User cannot cancel their ticket.");
    }
}
