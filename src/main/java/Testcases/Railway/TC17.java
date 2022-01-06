package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utils;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Calendar;

public class TC17 extends TestBase{
    @BeforeTest(description = "Pre-condition: Create and activate a new account")
    public void beforeTest(){

    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() throws Exception {
        String filePath = Utils.getProjectPath() + "\\Data\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate = dataTC17.get("departDate").getAsString();
        String departFrom = dataTC17.get("departFrom").getAsString();
        String arriveAt = dataTC17.get("arriveAt").getAsString();
        String seatType = dataTC17.get("seatType").getAsString();
        String ticketAmount = dataTC17.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departDate, departFrom, arriveAt, seatType, ticketAmount}
        };
        return object;
    }

    HomePage homePage = new HomePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC17 - User can't book more than 10 tickets", dataProvider = "data-provider")
    public void TC17(String departDate,String departFrom,String arriveAt,String seatType,String ticketAmount) {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();

        System.out.println("4. Book 10 tickets");
        System.out.println("5. Click on \"Book ticket\" tab again");
        System.out.println("6. Book one more ticket");
        String autoDepartDate = Utils.createDepartDate();
        bookTicketPage.bookTicketMultipleTimes(autoDepartDate,departFrom, arriveAt,seatType,ticketAmount,11);

        String actualErrorMsg = bookTicketPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualValidationErrorMsg = bookTicketPage.getTicketAmountValidationErrorMessage();
        String expectedValidationErrorMsg = "You have booked 10 tickets. You can book no more.";


        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualValidationErrorMsg, expectedValidationErrorMsg, "Validation error message is not displayed as expected.");
    }
}
