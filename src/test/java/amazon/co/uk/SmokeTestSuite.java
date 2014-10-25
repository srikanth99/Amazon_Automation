package amazon.co.uk;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

/**
 * Created by Sairam on 25/10/2014.
 */
public class SmokeTestSuite extends BaseTest{
 //Test Data-----------------------
   Random random=new Random();
   String EmailId="Chandu"+random.nextInt()+"@gmail.com";
   String Name="Chandu"+random.nextInt();
   String Password="Chandu123";
   String searchItem="IPhone";
   String changeStockTo="3";

   String addressline1="1"+random.nextInt(999),addressline2="Wakefield Courts";
   String City="City",County="County Name",Postcode="IT3 4NH",phone="07895448861";

   SignInPage signInPage=new SignInPage();
   HomePage homePage=new HomePage();
   AbstractPage abstractPage=new AbstractPage();

@Test
public void buyItemsAsNewUser()
{
    //Navigating to SignIn Page
    driver.findElement(By.cssSelector("#nav-your-account > span.nav-button-title.nav-button-line2")).isDisplayed();
    driver.findElement(By.cssSelector("#nav-your-account > span.nav-button-title.nav-button-line2")).click();
    signInPage.SignInAsNewUser(EmailId,Name,Password);
    homePage.searchItem(searchItem);
    abstractPage.selectItemFromSearchList();
    homePage.checkStockAndContinueToCheckoutAndEditQuantity(changeStockTo);
    signInPage.SignInAsNewUser(EmailId,Name,Password);
    abstractPage.enterDeliveryAddressAndGoToPaymentPage(Name,addressline1,addressline2,City,County,Postcode,phone);
}

@Test
public void registerAsNewUser()
{
    driver.findElement(By.cssSelector("#nav-your-account > span.nav-button-title.nav-button-line2")).isDisplayed();
    //Navigating to SignIn Page
    driver.findElement(By.cssSelector("#nav-your-account > span.nav-button-title.nav-button-line2")).click();
    signInPage.SignInAsNewUser(EmailId,Name,Password);
    homePage.signOut();
}

}
