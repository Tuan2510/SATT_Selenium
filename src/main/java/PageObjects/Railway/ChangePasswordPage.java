package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends  GeneralPage{
    //locators
    private final By txtCurrentPassword = By.xpath("//input[@id='currentPassword']");
    private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
    private final By txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By lblMessageError = By.xpath("//p[@class='message error']");
    private final By lblConfirmPasswordMessageError = By.xpath("//label[@class='validation-error']");

    //elements
    protected WebElement getTxtCurrentPassword(){
        return Constant.WEBDRIVER.findElement(txtCurrentPassword);
    }
    protected WebElement getTxtNewPassword(){
        return Constant.WEBDRIVER.findElement(txtNewPassword);
    }
    protected WebElement getTxtConfirmPassword(){
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }
    protected WebElement getBtnChangePassword(){
        return Constant.WEBDRIVER.findElement(btnChangePassword);
    }
    protected WebElement getLblMessageError(){
        return Constant.WEBDRIVER.findElement(lblMessageError);
    }
    protected WebElement getLblConfirmPasswordMessageError(){
        return Constant.WEBDRIVER.findElement(lblConfirmPasswordMessageError);
    }

    //methods
    public void changePassword(String currentPS, String newPS, String confirmPS){
        //submit login credentials
        this.getTxtCurrentPassword().sendKeys(currentPS);
        this.getTxtNewPassword().sendKeys(newPS);
        this.getTxtConfirmPassword().sendKeys(confirmPS);
        this.getBtnChangePassword().click();
    }

    public String getMessageError(){
        try{
            return this.getLblMessageError().getText();
        }catch (Exception e){
            return "";
        }
    }

    public String getConfirmPasswordMessageError(){
        try{
            return this.getLblConfirmPasswordMessageError().getText();
        }catch (Exception e){
            return "";
        }
    }

}
