package Testcases.Railway;

import Common.Common.JsonHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TicketPricePage;
import PageObjects.Railway.TimeTablePage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 extends TestBase {
    @Test
    public void TC15() throws Exception {
        System.out.println("TC15 - \"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        TicketPricePage ticketPricePage = new TicketPricePage();

        homePage.open();
        homePage.gotoLoginPage();
        String filePath = Utilities.getProjectPath() + "\\main\\java\\Common\\Constant\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC15 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String email = dataTC15.get("email").getAsString();
        String password = dataTC15.get("password").getAsString();
        loginPage.login(email, password);
        homePage.gotoTimeTable();
        timeTablePage.gotoTicketPrice();

        String actualPageTitle = ticketPricePage.getPageTitle();
        String expectedPageTitle = dataTC15.get("pageTitle").getAsString();
        String actualTicketTitle = ticketPricePage.getTextLblTicketInfo();
        String expectedTicketTitle = dataTC15.get("ticketTitle").getAsString();
        String actualHSPrice = ticketPricePage.getHSPrice();
        String expectedHSPrice = dataTC15.get("HSPrice").getAsString();
        String actualSSPrice = ticketPricePage.getSSPrice();
        String expectedSSPrice = dataTC15.get("SSPrice").getAsString();
        String actualSSCPrice = ticketPricePage.getSSCPrice();
        String expectedSSCPrice = dataTC15.get("SSCPrice").getAsString();
        String actualHBPrice = ticketPricePage.getHBPrice();
        String expectedHBPrice = dataTC15.get("HBPrice").getAsString();
        String actualSBPrice = ticketPricePage.getSBPrice();
        String expectedSBPrice = dataTC15.get("SBPrice").getAsString();
        String actualSBCPrice = ticketPricePage.getSBCPrice();
        String expectedSBCPrice = dataTC15.get("SBCPrice").getAsString();

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title is not displayed as expected.");
        Assert.assertEquals(actualTicketTitle, expectedTicketTitle, "Ticket table is not displayed as expected.");
        Assert.assertEquals(actualHSPrice, expectedHSPrice, "HS price is not displayed as expected.");
        Assert.assertEquals(actualSSPrice, expectedSSPrice, "SS price is not displayed as expected.");
        Assert.assertEquals(actualSSCPrice, expectedSSCPrice, "SSC price is not displayed as expected.");
        Assert.assertEquals(actualHBPrice, expectedHBPrice, "HB price is not displayed as expected.");
        Assert.assertEquals(actualSBPrice, expectedSBPrice, "SB price is not displayed as expected.");
        Assert.assertEquals(actualSBCPrice, expectedSBCPrice, "SBC price is not displayed as expected.");

    }
}
