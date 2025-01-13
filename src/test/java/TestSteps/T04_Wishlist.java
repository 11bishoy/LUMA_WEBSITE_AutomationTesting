package TestSteps;

import Pages.P02_Login_Page;
import Pages.P03_Landing_Page;
import Pages.P04_Wishlist_Page;
import org.testng.Assert;
import org.testng.annotations.Test;



public class T04_Wishlist extends Testbase{

    P04_Wishlist_Page R5=new P04_Wishlist_Page();
    P04_Wishlist_Page R9=new P04_Wishlist_Page();
    P03_Landing_Page R6=new P03_Landing_Page();
    P02_Login_Page R7=new P02_Login_Page();
    String  lOGIN_PAGE_URL="https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS93aXNobGlzdC9pbmRleC9hZGQv/";
    String Wish_List_PAGE_URL="https://magento.softwaretestingboard.com/wishlist/index/index/wishlist_id/78939/";


/*

************TC1: Validate that Guest user can’t add any product to Wishlist***********
    1.open URL: https://magento.softwaretestingboard.com/
    2.Scroll Down to Hot Sellers Section
    3.Hover on any card and click on “Add to Wishlist” button
************************Expected Results:********************
1.User should be navigated to login page

 */
    @Test(priority = 8)
    public void WishList_page_scenario1() throws InterruptedException {
        R6.Scroll_down();
        R5.ADD_To_wishlist(Radiant_Tee);
        String Expected=R5.GET_Current_Url();
        Assert.assertEquals(Expected,lOGIN_PAGE_URL);
        Thread.sleep(3000);
        driver.navigate().back();
    }


    /*
        TC2: Validate That Logged in user can add any product to Wishlist
    Precondition: Logged in user
        1.open URL: https://magento.softwaretestingboard.com/
        2.Scroll Down to Hot Sellers Section
        3.Hover on any card and click on “Add to Wishlist” button
    Expected Results:
        1.User should be navigated to My Wishlist page with the same product added to Wishlist from landing page

     */


    @Test(priority = 9)
    public void WishList_page_scenario2() throws InterruptedException {


        R7.CLICK_ON_SIGNIN_TABE();
        R7.Enter_the_Email_in_Loginpage(valid_email);
        R7.Enter_valid_password_in_loginpage(valid_password);
        R7.click_on_submit_button();
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        R6.Scroll_down();
        R5.ADD_To_wishlist(Hero_Hoodie);
        String ACTUAL_Url_wishList_page=R5.GET_Current_Url();
        Assert.assertEquals(ACTUAL_Url_wishList_page,Wish_List_PAGE_URL);
        String TEXT=R5.Product_HasBeenAddedToYourWishlist_Tap();
       System.out.println(TEXT);
       String SELECTED_PRODUCT_TOWHSILIST=R5.NAME_OF_selected_product_wishlist();
       System.out.println(SELECTED_PRODUCT_TOWHSILIST);
       Assert.assertTrue(TEXT.contains(SELECTED_PRODUCT_TOWHSILIST));

    }

}
