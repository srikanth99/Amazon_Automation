package amazon.co.uk;

import org.openqa.selenium.By;

/**
 * Created by Sairam on 25/10/2014.
 */
public class SignInPage extends BasePage{

public void SignInAsNewUser(String EmailId,String Name,String pwd )
{
    //SignIn As New User

        driver.findElement(By.id("ap_email")).sendKeys(EmailId);
        driver.findElement(By.id("ap_signin_create_radio")).click();
        driver.findElement(By.id("signInSubmit-input")).click();
        driver.findElement(By.id("ap_customer_name")).sendKeys(Name);
        driver.findElement(By.id("ap_email_check")).sendKeys(EmailId);
        driver.findElement(By.id("ap_password")).sendKeys(pwd);
        driver.findElement(By.id("ap_password_check")).sendKeys(pwd);
        driver.findElement(By.id("continue-input")).click();

    }


    public void forgotPassword()
    {

    }

    public void updateEmailId()
    {

    }


    public void navigateToYourAccount()
    {

    }
}
