package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;

public class Utils {

    public static void scrollDownToElement(WebElement element) {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollDownToElement(Select select) {
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", select);
    }

    public static String randomEmailAddressByTime() {
        Calendar now = Calendar.getInstance();
        String hour = String.valueOf(now.get(Calendar.HOUR_OF_DAY));
        String minute = String.valueOf(now.get(Calendar.MINUTE));
        String second = String.valueOf(now.get(Calendar.SECOND));
        String millis = String.valueOf(now.get(Calendar.MILLISECOND));
        String emailAddress = hour + minute + second + millis + "@mail.com";
        return emailAddress;
    }

    public static String getProjectPath() {
        //return "E:\\IdeaProjects\\SeleniumLevel1\\src";
        return System.getProperty("user.dir") + "\\src\\main\\java";
    }

    public static String createDepartDate() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, 5);
        String autoDepartDate = Integer.parseInt(String.valueOf(now.get(Calendar.MONTH))) + 1 + "/" + Integer.parseInt(String.valueOf(now.get(Calendar.DAY_OF_MONTH))) + "/" + now.get(Calendar.YEAR);
        return autoDepartDate;
    }
}
