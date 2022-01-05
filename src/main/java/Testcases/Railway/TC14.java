package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import com.google.gson.JsonObject;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.print.Book;
import java.util.Calendar;

public class TC14 extends TestBase {
    @Test
    public void TC14() throws Exception {
        System.out.println("TC14 - User can book many tickets at a time");
        HomePage homePage = new HomePage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        homePage.open();

        homePage.gotoLoginPage();
        LoginPage loginPage = new LoginPage();
        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC14.get("email").getAsString();
        String password = dataTC14.get("password").getAsString();

        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH,5);
        String departDate = now.get(Calendar.DAY_OF_MONTH)+"/"+ now.get(Calendar.MONTH)+1 +"/"+now.get(Calendar.YEAR);
        String departFrom = dataTC14.get("departFrom").getAsString();
        String arriveAt = dataTC14.get("arriveAt").getAsString();
        String seatType = dataTC14.get("seatType").getAsString();
        String ticketAmount = String.valueOf(dataTC14.get("ticketAmount").getAsInt());

        loginPage.login(email, password).gotoBookTicketPage();
        bookTicketPage.bookTicket(departDate,departFrom, arriveAt,seatType,ticketAmount);

        String actualMsg = bookTicketPage.getSuccessMessage();
        String expectedMsg = "Ticket booked successfully!";
        String actualDepartDate = bookTicketPage.getTicketDepartDate();
        String expectedDepartDate = departDate;
        String actualDepartStation = bookTicketPage.getTicketDepartStation();
        String expectedDepartStation = departFrom;
        String actualArriveStation = bookTicketPage.getTicketArriveStation();
        String expectedArriveStation = arriveAt;
        String actualSeatType = bookTicketPage.getTicketSeatType();
        String expectedSeatType = seatType;
        String actualTicketAmount = bookTicketPage.getTicketAmount();
        String expectedTicketAmount = ticketAmount;

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart date is not displayed as expected.");
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected.");
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected.");
        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat type is not displayed as expected.");
        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket amount is not displayed as expected.");
    }
}
