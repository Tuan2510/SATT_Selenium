package PageObjects.Railway;

import Common.Constant;
import Common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage {
    //locators
    String lnkCheckPrice = "//td[text()='%s']/following-sibling::td[text()='%s']/../td[count(//th[text()='Check Price']/preceding-sibling::th)+1]/a";

    //elements
    protected WebElement getLnkCheckPrice(String depart, String arrive) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(lnkCheckPrice, depart, arrive)));
    }

    //methods
    Utils utils = new Utils();

    public void gotoTicketPrice(String depart, String arrive) {
        WebElement linkCheckPrice = this.getLnkCheckPrice(depart, arrive);
        utils.scrollDownToElement(linkCheckPrice);
        linkCheckPrice.click();
    }

}
