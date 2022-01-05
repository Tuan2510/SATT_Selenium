package PageObjects.Railway;

import Common.Constant.Constant;
import Common.Utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage{
    //locators
    String lnkCheckPrice = "//td[text()='Đà Nẵng']/following-sibling::td[text()='Sài Gòn']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";

    //elements
    protected WebElement getLnkCheckPrice(){
        return Constant.WEBDRIVER.findElement(By.xpath(lnkCheckPrice) );
    }

    //methods
    public void gotoTicketPrice(){
        try {
            WebElement linkCheckPrice = this.getLnkCheckPrice();
            Utils utils = new Utils();
            utils.scrollDownToElement(linkCheckPrice);
            linkCheckPrice.click();
        }catch (Exception e){
            System.out.println("Unable to get 'Check Price' link");
        }
    }

}
