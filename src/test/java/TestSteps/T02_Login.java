package TestSteps;

import Pages.P02_Login_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T02_Login extends Testbase{

    P02_Login_Page R3=new P02_Login_Page();

    String HOME_PAGE_ACTUAL_URL="https://magento.softwaretestingboard.com/";
    String HOME_PAGE_excpected_URL;
    String WELCOME_FIRST_LAST_NAME;
    Boolean WELOCOME_FISRT_LAST_NAME_WORD;
    String WELCOME_WORD="Welcome, Bishoy Adel!";

    @Test(priority = 4)
    public void Login_Page_scenario1()
    {
        R3.CLICK_ON_SIGNIN_TABE();
        R3.Enter_the_Email_in_Loginpage(valid_email);
        R3.Enter_valid_password_in_loginpage(valid_password);
        R3.click_on_submit_button();
        HOME_PAGE_excpected_URL=R3.Get_homepage_url();
        Assert.assertEquals(HOME_PAGE_ACTUAL_URL,HOME_PAGE_excpected_URL);
        WELCOME_FIRST_LAST_NAME=R3.Check_welcome_first_last_name();
        WELOCOME_FISRT_LAST_NAME_WORD=WELCOME_FIRST_LAST_NAME.contains(WELCOME_WORD);
        Assert.assertTrue(WELOCOME_FISRT_LAST_NAME_WORD);


    }



}
