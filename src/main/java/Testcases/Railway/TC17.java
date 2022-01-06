package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;

public class TC17 extends TestBase{
    @Test
    public void TC17() throws Exception {
        System.out.println("TC17 - User can't book more than 10 tickets");
        HomePage homePage = new HomePage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC17 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC17.get("email").getAsString();
        String password = dataTC17.get("password").getAsString();
        loginPage.login(email, password).gotoBookTicketPage();

        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH,5);
        String departDate = Integer.parseInt(String.valueOf(now.get(Calendar.MONTH)+1)) +"/"+  now.get(Calendar.DAY_OF_MONTH)+"/"+now.get(Calendar.YEAR);
        String departFrom = dataTC17.get("departFrom").getAsString();
        String arriveAt = dataTC17.get("arriveAt").getAsString();
        String seatType = dataTC17.get("seatType").getAsString();
        String ticketAmount = String.valueOf(dataTC17.get("ticketAmount").getAsInt());
        bookTicketPage.bookTicketMultipleTimes(departDate,departFrom, arriveAt,seatType,ticketAmount,11);

        String actualErrorMsg = bookTicketPage.getErrorMessage();
        String expectedErrorMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualValidationErrorMsg = bookTicketPage.getTicketAmountValidationErrorMessage();
        String expectedValidationErrorMsg = "You have booked 10 tickets. You can book no more.";


        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualValidationErrorMsg, expectedValidationErrorMsg, "Validation error message is not displayed as expected.");
    }
}
