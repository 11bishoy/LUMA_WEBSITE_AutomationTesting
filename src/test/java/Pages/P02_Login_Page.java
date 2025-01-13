package Pages;

import org.openqa.selenium.By;

import static TestSteps.Testbase.driver;

public class P02_Login_Page {

    By Signin_tabe=By.cssSelector("a[href=\"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/\"]");
    By Email_FIELD_LOGINPAGE=By.id("email");
    By Password_Filed_LOGINPAGE=By.id("pass");
    By Sign_In_Button_LOGINPAGE=By.id("send2");
    By welcome_First_last_name=By.className("logged-in");

        public void CLICK_ON_SIGNIN_TABE()
        {
            driver.findElement(Signin_tabe).click();
        }

        public void Enter_the_Email_in_Loginpage(String email)
        {
            driver.findElement(Email_FIELD_LOGINPAGE).sendKeys(email);
        }

        public void Enter_valid_password_in_loginpage(String password)
        {
            driver.findElement(Password_Filed_LOGINPAGE).sendKeys(password);
        }

        public void click_on_submit_button()
        {
            driver.findElement(Sign_In_Button_LOGINPAGE).click();
        }

        public String Get_homepage_url()
        {
           return driver.getCurrentUrl();
        }


        public String Check_welcome_first_last_name()
        {
            return driver.findElement(welcome_First_last_name).getText();
        }







}
