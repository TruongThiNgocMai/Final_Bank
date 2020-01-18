package pages;

import org.openqa.selenium.WebElement;
import runner.TestRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Created by kimthao.
 */
public class CommonPage {

    public void closeAlertPopup() {
        try {
            TestRunner.driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public String getAlertPopup() {
        return TestRunner.driver.switchTo().alert().getText();
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean exists(WebElement element) {
        if (!element.getText().equals(""))
            return true;
        else
            return false;
    }

    public String formatDateTime(String dateTime) throws ParseException {
        String userDateFormat = "MMM dd, yyyy hh:mm";
        DateFormat sdf = new SimpleDateFormat(userDateFormat);
        Date date = null;
        try {
            date = sdf.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
    }

    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }

}
