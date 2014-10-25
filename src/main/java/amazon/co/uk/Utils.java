package amazon.co.uk;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sairam on 25/10/2014.
 */
public class Utils extends BasePage{


    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectFromDropDown(By addressType, String residential) {

        Select select=new Select(driver.findElement(addressType));
        select.selectByVisibleText(residential);

    }
}
