package Testcases.Railway;

import Common.Constant;
import Common.JsonHelper;
import Common.Utils;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TicketPricePage;
import PageObjects.Railway.TimeTablePage;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC15 extends TestBase {
    @BeforeTest(description = "Pre-condition: Create and activate a new account")
    public void beforeTest(){

    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() throws Exception {
        String filePath = Utils.getProjectPath() + "\\Data\\data.json";
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTC15 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String pageTitle = dataTC15.get("pageTitle").getAsString();
        String ticketTitle = dataTC15.get("ticketTitle").getAsString();
        String HSPrice = dataTC15.get("HSPrice").getAsString();
        String SSPrice = dataTC15.get("SSPrice").getAsString();
        String SSCPrice = dataTC15.get("SSCPrice").getAsString();
        String HBPrice = dataTC15.get("HBPrice").getAsString();
        String SBPrice = dataTC15.get("SBPrice").getAsString();
        String SBCPrice = dataTC15.get("SBCPrice").getAsString();

        Object[][] object = new Object[][]{
                {pageTitle, ticketTitle, HSPrice, SSPrice, SSCPrice, HBPrice, SBPrice, SBCPrice}
        };
        return object;
    }

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    TimeTablePage timeTablePage = new TimeTablePage();
    TicketPricePage ticketPricePage = new TicketPricePage();

    @Test(description = "TC15 - \"Ticket price\" page displays with ticket details after clicking on \"check price\" link in \"Train timetable\" page", dataProvider = "data-provider")
    public void TC15(String pageTitle,String ticketTitle,String HSPrice,String SSPrice,String SSCPrice,String HBPrice,String SBPrice,String SBCPrice) {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();

        System.out.println("2. Login with a valid account");
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        System.out.println("3. Click on \"Timetable\" tab");
        homePage.gotoTimeTable();

        System.out.println("4. Click on \"check price\" link of the route from \"Đà Nẵng\" to \"Sài Gòn\"");
        timeTablePage.gotoTicketPrice("Đà Nẵng", "Sài Gòn");

        String actualPageTitle = ticketPricePage.getPageTitle();
        String expectedPageTitle = pageTitle;
        String actualTicketTitle = ticketPricePage.getTextLblTicketInfo();
        String expectedTicketTitle = ticketTitle;
        String actualHSPrice = ticketPricePage.getHSPrice();
        String expectedHSPrice = HSPrice;
        String actualSSPrice = ticketPricePage.getSSPrice();
        String expectedSSPrice = SSPrice;
        String actualSSCPrice = ticketPricePage.getSSCPrice();
        String expectedSSCPrice = SSCPrice;
        String actualHBPrice = ticketPricePage.getHBPrice();
        String expectedHBPrice = HBPrice;
        String actualSBPrice = ticketPricePage.getSBPrice();
        String expectedSBPrice = SBPrice;
        String actualSBCPrice = ticketPricePage.getSBCPrice();
        String expectedSBCPrice = SBCPrice;

        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Page title is not displayed as expected.");
        Assert.assertEquals(actualTicketTitle, expectedTicketTitle, "Ticket title is not displayed as expected.");
        Assert.assertEquals(actualHSPrice, expectedHSPrice, "HS price is not displayed as expected.");
        Assert.assertEquals(actualSSPrice, expectedSSPrice, "SS price is not displayed as expected.");
        Assert.assertEquals(actualSSCPrice, expectedSSCPrice, "SSC price is not displayed as expected.");
        Assert.assertEquals(actualHBPrice, expectedHBPrice, "HB price is not displayed as expected.");
        Assert.assertEquals(actualSBPrice, expectedSBPrice, "SB price is not displayed as expected.");
        Assert.assertEquals(actualSBCPrice, expectedSBCPrice, "SBC price is not displayed as expected.");

    }
}
