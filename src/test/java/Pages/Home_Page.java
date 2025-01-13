package Pages;

import org.openqa.selenium.By;

import static TestSteps.Testbase.driver;


public class Home_Page {

    By Creat_an_Account= By.cssSelector("li a[href=\"https://magento.softwaretestingboard.com/customer/account/create/\"]");

    public void Click_on_creat_acount_button()
    {
        driver.findElement(Creat_an_Account).click();
    }


}
