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

public class TC14 extends TestBase {

//    @BeforeTest(description = "Pre-condition: Create and activate a new account")
//    public void beforeTest(){
//
//    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() throws Exception {
        System.out.println("1");
        String filePath = Utils.getProjectPath() + "\\Data\\data.json";
        System.out.println("2");
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        System.out.println("3");
        JsonObject dataTC14 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departDate = dataTC14.get("departDate").getAsString();
        String departFrom = dataTC14.get("departFrom").getAsString();
        String arriveAt = dataTC14.get("arriveAt").getAsString();
        String seatType = dataTC14.get("seatType").getAsString();
        String ticketAmount = dataTC14.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departDate, departFrom, arriveAt, seatType, ticketAmount}
        };
        return object;
    }

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(description = "TC14 - User can book many tickets at a time", dataProvider = "data-provider")
    public void TC14(String departDate,String departFrom,String arriveAt,String seatType,String ticketAmount) {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account ");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on 'Book ticket' tab");
        homePage.gotoBookTicketPage();

        System.out.println("4. Select a Depart date from the list");
        System.out.println("5. Select 'Nha Trang' for 'Depart from' and 'Sài Gòn' for 'Arrive at'.");
        System.out.println("6. Select 'Soft seat with air conditioner' for 'Seat type'");
        System.out.println("7. Select '5' for 'Ticket amount'");
        System.out.println("8. Click on 'Book ticket' button");
        String autoDepartDate = Utils.createDepartDate();
        bookTicketPage.bookTicket(autoDepartDate, departFrom, arriveAt, seatType, ticketAmount);

        String actualMsg = bookTicketPage.getSuccessMessage();
        String expectedMsg = "Ticket booked successfully!";
        String actualDepartDate = bookTicketPage.getTicketDepartDate();
        String expectedDepartDate = autoDepartDate;
        String actualDepartStation = bookTicketPage.getTicketDepartStation();
        String expectedDepartStation = departFrom;
        String actualArriveStation = bookTicketPage.getTicketArriveStation();
        String expectedArriveStation = arriveAt;
        String actualSeatType = bookTicketPage.getTicketSeatType();
        String expectedSeatType = seatType;
        String actualTicketAmount = bookTicketPage.getTicketAmount();
        String expectedTicketAmount = String.valueOf(ticketAmount);

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
        Assert.assertEquals(actualDepartDate, expectedDepartDate, "Depart date is not displayed as expected.");
        Assert.assertEquals(actualDepartStation, expectedDepartStation, "Depart Station is not displayed as expected.");
        Assert.assertEquals(actualArriveStation, expectedArriveStation, "Arrive Station is not displayed as expected.");
        Assert.assertEquals(actualSeatType, expectedSeatType, "Seat type is not displayed as expected.");
        Assert.assertEquals(actualTicketAmount, expectedTicketAmount, "Ticket amount is not displayed as expected.");
    }
}
