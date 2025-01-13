package Pages;

import org.openqa.selenium.By;

import static TestSteps.Testbase.driver;
public class P01_Register_Page {

    By First_name_field= By.name("firstname");
    By LAST_NAME_field=By.name("lastname");
    By Email_field=By.name("email");
    By Password_field=By.name("password");
    By Confirm_password_field=By.name("password_confirmation");
    By Creat_an_account_button=By.className("submit");
    By this_requred_field=By.cssSelector("div [id=\"password-confirmation-error\"]");
    By Please_enter_the_same_value_again=By.id("password-confirmation-error");
    By  ACCOUNTINFORMATION_NAME= By.cssSelector("div.box-content>p");
    By  ACCOUNTINFORMATION_EMAIL=By.cssSelector("div.box-content>p");


    public  String GET_URL_OF_CREATACOUNT_PAGE()
    {
        return driver.getCurrentUrl();
    }
    public void Enter_First_name(String FIRST_NAME)
    {
        driver.findElement(First_name_field).sendKeys(FIRST_NAME);
    }
    public  void Enter_Last_name(String LAST_NAME)
    {
        driver.findElement(LAST_NAME_field).sendKeys(LAST_NAME);
    }
    public  void Enter_EMAIL(String EMAIL)
    {
        driver.findElement(Email_field).sendKeys(EMAIL);
    }
    public  void Enter_Password(String password)
    {
        driver.findElement(Password_field).sendKeys(password);
    }
    public void Enter_Confirmed_Password(String Confirmed_Password)
    {
        driver.findElement(Confirm_password_field).sendKeys(Confirmed_Password);
    }
    public void Click_Creat_ACCOUNT()
    {
        driver.findElement(Creat_an_account_button).click();
    }

    public String GET_This_is_required_field()
    {
        return driver.findElement(this_requred_field).getText();
    }
    public  String GET_Please_enter_the_same_value_again()
    {
        return driver.findElement(Please_enter_the_same_value_again).getText();
    }
    public  String Get_contact_information_firstname()
    {
        return driver.findElement(ACCOUNTINFORMATION_NAME).getText();

    }

    public  String Get_contact_information_lastname()
    {
        return driver.findElement(ACCOUNTINFORMATION_NAME).getText();

    }

    public  String Get_contact_information_email()
    {
        return driver.findElement(ACCOUNTINFORMATION_EMAIL).getText();

    }





}
