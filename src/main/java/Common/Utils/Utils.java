package Common.Utils;

import Common.Constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Calendar;

public class Utils {

    public void scrollDownToElement(WebElement element){
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String randomEmailAddressByTime(){
        Calendar now = Calendar.getInstance();
        String hour = String.valueOf(now.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(now.get(Calendar.MINUTE));
        String second = String.valueOf(now.get(Calendar.SECOND));
        String millis = String.valueOf(now.get(Calendar.MILLISECOND));
        String emailAddress = hour+minute+second+millis+"@mail.com";
        System.out.println(emailAddress);
        return String.valueOf(emailAddress);
    }
}
