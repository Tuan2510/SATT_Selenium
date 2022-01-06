package PageObjects.Railway;

import Common.Constant;
import Common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    //locators
    private final By tabHome = By.xpath("//a[@href='/Acount/Login/cshtml']");
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //elements
    protected WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(txtUsername);
    }

    protected WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    protected WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    protected WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
    }

    //methods
    public void login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }

    public void loginMultipleTimes(String username, String password, Integer times) {
        for (int i = 0; i < times; i++) {
            Utils.scrollDownToElement(this.getTxtUsername());
            this.getTxtUsername().sendKeys("");
            this.getTxtUsername().sendKeys(username);
            Utils.scrollDownToElement(this.getTxtPassword());
            this.getTxtPassword().sendKeys("");
            this.getTxtPassword().sendKeys(password);
            this.getBtnLogin().click();
        }
    }

    public String getLoginErrorMsg() {
        return this.getLblLoginErrorMsg().getText();
    }

}
