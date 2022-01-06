package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyTicketPage {
    //locators
    private final By btnCancelTicket = By.xpath("//input[@value='Cancel']");

    //elements
    protected WebElement getBtnCancelTicket() {
        return Constant.WEBDRIVER.findElement(btnCancelTicket);
    }

    //methods
    public void clickCancelButton() {
        WebElement btnCancel = this.getBtnCancelTicket();
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", btnCancel);
        btnCancel.click();
    }

    public void clickOKAlert() {
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
    }
}
