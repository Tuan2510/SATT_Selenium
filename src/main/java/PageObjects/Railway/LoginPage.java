package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    //locators
    private final By tabHome = By.xpath("//a[@href='/Acount/Login/cshtml']");
    private final By txtUsername = By.xpath("//input[@id='username']");
    private final By txtPassword = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='login']");
    private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

    //elements
    protected WebElement getTxtUsername(){
        return Constant.WEBDRIVER.findElement(txtUsername);
    }
    protected WebElement getTxtPassword(){
        return Constant.WEBDRIVER.findElement(txtPassword);
    }
    protected WebElement getBtnLogin(){
        return Constant.WEBDRIVER.findElement(btnLogin);
    }
    protected WebElement getLblLoginErrorMsg(){ return Constant.WEBDRIVER.findElement(lblLoginErrorMsg); }

    //methods
    public HomePage login(String username, String password){
        //submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
        //land on Home page
        return new HomePage();
    }

    public HomePage loginMultipleTimes(String username, String password, Integer times){
        for (int i = 0; i < times; i++) {
            //submit login credentials
            System.out.println("count: "+(i+1)+" times");
            this.getTxtUsername().sendKeys(username);
            this.getTxtPassword().sendKeys(password);
            this.getBtnLogin().click();
        }
        //land on Home page
        return new HomePage();
    }

    public String getLoginErrorMsg(){
        try{
            return this.getLblLoginErrorMsg().getText();
        }catch (Exception e){
            return "";
        }
    }

}
