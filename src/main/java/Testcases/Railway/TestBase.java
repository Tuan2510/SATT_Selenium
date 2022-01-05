package Testcases.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath()+"\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER = new ChromeDriver();
        Dimension size = new Dimension(1024, 820);
        //Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.manage().window().setSize(size);
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }
}
