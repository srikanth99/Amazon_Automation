package amazon.co.uk;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sairam on 25/10/2014.
 */
public class HomePage extends BasePage{
    public StringBuffer verificationErrors = new StringBuffer();
Utils utils=new Utils();
  public void signOut()
  {
      WebElement menu=driver.findElement(By.id("nav-signin-title"));

      WebElement subMenu=driver.findElement(By.id("nav-item-signout"));
//      driver.findElement(By.cssSelector("#nav-your-account > span.nav-button-title.nav-button-line2")).click();

      Actions action=new Actions(driver);
      action.moveToElement(menu).build().perform();
      try {
          Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
//      action.click(subMenu).perform();
      subMenu.click();

  }

    public void searchItem(String searchItem)
    {
        driver.findElement(By.cssSelector("span.nav-button-title.nav-button-line2")).click();
        Assert.assertTrue(Utils.isElementPresent(By.linkText("Phones & Accessories")));
        driver.findElement(By.linkText("Phones & Accessories")).click();
        try {
            Assert.assertEquals("Phones & Accessories", driver.findElement(By.cssSelector("b")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        new Select(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div/form/table/tbody/tr/td[3]/table/tbody/tr/td[3]/div[2]/select"))).selectByVisibleText(searchItem);
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div/form/table/tbody/tr/td[4]/div[2]/input")).click();
        Assert.assertTrue(utils.isElementPresent(By.cssSelector("#result_14 > h3.newaps > a > span.lrg.bold")));
        driver.findElement(By.cssSelector("#result_14 > h3.newaps > a > span.lrg.bold")).click();

    }

public void checkStockAndContinueToCheckoutAndEditQuantity(String changeTo)
{
    //Compare the stock and check whether stock available is more than 3
//    String stock=driver.findElement(By.xpath("/html/body/div[2]/form/table[3]/tbody/tr[4]/td/div/span")).getText();
//   Assert.assertEquals("Only 7 left in stock.", driver.findElement(By.cssSelector("span.availGreen")).getText());

    driver.findElement(By.id("bb_atc_button")).click();
    driver.findElement(By.id("a-autoid-0-announce")).click();
    new Select(driver.findElement(By.id("a-autoid-2-announce"))).selectByVisibleText(changeTo);
    driver.findElement(By.name("proceedToCheckout")).click();
}

}
