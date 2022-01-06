package Testcases.Railway;

import Common.Constant;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC10 extends TestBase{
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();


    @BeforeTest(description = "Pre-condition: Create and activate a new account")
    public void beforeTest(){

    }

    @Test(description = "TC10 - User can't create account with an already in-use email")
    public void TC10() throws Exception {
        System.out.println("1. Navigate to QA Railway Website");
        homePage.open();
        System.out.println("2. Click on \"Register\" tab");
        homePage.gotoRegisterPage();

        System.out.println("3. Enter information of the created account in Pre-condition");
        System.out.println("4. Click on \"Register\" button");
        registerPage.register(Constant.USERNAME, Constant.PASSWORD,Constant.PASSWORD,Constant.PID);

        String actualMsg = registerPage.getMessageError();
        String expectedMsg = "This email address is already in use.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected.");
    }
}
