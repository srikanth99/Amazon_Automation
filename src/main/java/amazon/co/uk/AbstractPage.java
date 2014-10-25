package amazon.co.uk;

import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * Created by Sairam on 25/10/2014.
 */
public class AbstractPage extends BasePage{

    Utils utils=new Utils();

    public void enterDeliveryAddressAndGoToPaymentPage(String Name,String addressline1,String addressline2,String City,String County,String Postcode,String phone)
    {
        Assert.assertEquals("Enter a new delivery address.", driver.findElement(By.cssSelector("h2")).getText());

        driver.findElement(By.id("enterAddressFullName")).sendKeys(Name);
        driver.findElement(By.id("enterAddressAddressLine1")).sendKeys(addressline1);
        driver.findElement(By.id("enterAddressAddressLine2")).sendKeys(addressline2);
        driver.findElement(By.id("enterAddressCity")).sendKeys(City);
        utils.selectFromDropDown(By.id("enterAddressStateOrRegion"),County);
        driver.findElement(By.id("enterAddressPhoneNumber")).sendKeys(phone);
        driver.findElement(By.id("enterAddressPostalCode")).sendKeys(Postcode);
        utils.selectFromDropDown(By.id("AddressType"),"Residential");
        driver.findElement(By.name("isBillingAddress")).click();
        driver.findElement(By.xpath("//*[@id='newShippingAddressFormFromIdentity']/div[1]/div/form/div[6]/span/span/input")).click();
    }


    public void selectItemFromSearchList()
    {

    }
}
