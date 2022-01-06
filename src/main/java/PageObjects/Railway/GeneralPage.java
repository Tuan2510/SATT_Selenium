package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant;
import org.testng.internal.EclipseInterface;

public class GeneralPage {
    //locators
    private final By tabHome = By.xpath("//a/span[text()='Home']");
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabTimeTable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By pageTitle = By.xpath("//div[@id='content']/h1");

    //elements
    protected WebElement getTabHome() {
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getLblWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getTitle() {
        return Constant.WEBDRIVER.findElement(pageTitle);
    }

    //methods
    public String getWelcomeMessage() {
        return this.getLblWelcomeMessage().getText();
    }

    public void loggingOut() {
        this.getTabLogout().click();
    }

    public String getPageH1() {
        return this.getTitle().getText();
    }

    public void gotoLoginPage() {
        this.getTabLogin().click();
    }

    public void gotoContactPage() {
        this.getTabContact().click();
    }

    public void gotoBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }

    public void gotoChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void gotoHomePage() {
        this.getTabHome().click();
    }

    public void gotoTimeTable() {
        this.getTabTimeTable().click();
    }

    public void gotoMyTicket() {
        this.getTabMyTicket().click();
    }

    public String getPageTitle() {
        return Constant.WEBDRIVER.getTitle();
    }

    public Boolean isDisplayedTabLogout() {
        try {
            return Constant.WEBDRIVER.findElement(tabLogout).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
