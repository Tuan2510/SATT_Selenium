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

public class TC16 extends TestBase {
    @Test
    public void TC16 () throws Exception {
        System.out.println("TC16 - User can cancel a ticket");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();

        homePage.open();
        homePage.gotoLoginPage();
        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC16 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC16.get("email").getAsString();
        String password = dataTC16.get("password").getAsString();
        loginPage.login(email,password).gotoBookTicketPage();

        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH,5);
        String departDate = now.get(Calendar.DAY_OF_MONTH)+"/"+ now.get(Calendar.MONTH)+1 +"/"+now.get(Calendar.YEAR);
        String departFrom = dataTC16.get("departFrom").getAsString();
        String arriveAt = dataTC16.get("arriveAt").getAsString();
        String seatType = dataTC16.get("seatType").getAsString();
        String ticketAmount = String.valueOf(dataTC16.get("ticketAmount").getAsInt());
        bookTicketPage.bookTicket(departDate,departFrom, arriveAt,seatType,ticketAmount);
        Thread.sleep(5000);
        homePage.gotoMyTicket();
        myTicketPage.clickCancelButton();
        myTicketPage.clickOKAlert();

        Integer actualMsg = 1;
        Integer expectedMsg = 0;

        Assert.assertEquals(actualMsg, expectedMsg, "User cannot cancel their ticket.");
    }
}
