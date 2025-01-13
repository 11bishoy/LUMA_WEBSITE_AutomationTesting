package TestSteps;

import Pages.P03_Landing_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class T03_Landing extends Testbase{



    String CART_NO;
    P03_Landing_Page R4=new P03_Landing_Page();
    List<Boolean>dollarsign_exist=new ArrayList<>();
    List<Boolean>pricein_double=new ArrayList<>();
    List<Boolean>ADD_TO_CARD_APPERANCE=new ArrayList<>();
    List<Boolean>ADD_TO_CARD_IS_CLICKABLE=new ArrayList<>();


    @Test(priority = 5)
    /*
    **********TC1: Validate That Hot Sellers is displayed and each card contains Price in $****
    1.open URL: https://magento.softwaretestingboard.com/
    2.Scroll Down to Hot Sellers Section
    3.Observe each card is displayed with Price
    ******************************Expected Results:*************************************
    1.Each card should display price in $
    2.Each card should display price as Double not Integer (Advanced Level)
     */
    public void Landing_page_scenario1() throws InterruptedException {

        R4.Scroll_down();
        dollarsign_exist=R4.Productprice_check_cost_in_dollar();
        pricein_double=R4.Productprice_in_double();
        for(int i=0;i<=5;i++)
        {
            Assert.assertTrue(dollarsign_exist.get(i));
            System.out.println(dollarsign_exist.get(i));
            Assert.assertTrue(pricein_double.get(i));
        }
    }

 @Test(priority = 6)

 /*

 *************TC2: Validate That each card contains “Add to Cart” button and clickable*************
    1.open URL: https://magento.softwaretestingboard.com/
    2.Scroll Down to Hot Sellers Section
    3.Observe each card contains “Add to Cart”
  ********************Expected Results:*************************************
    1.Each card should display “Add to Cart” button and it should be clickable

  */
    public void Landing_page_scenario2() throws InterruptedException {

        R4.Scroll_down();
        ADD_TO_CARD_APPERANCE= R4.checkeach_card_contain_ADD_TO_CART();
        for(int i=0;i<ADD_TO_CARD_APPERANCE.size();i++)
        {
            Assert.assertTrue(ADD_TO_CARD_APPERANCE.get(i));
            System.out.println(ADD_TO_CARD_APPERANCE.get(i));
        }

     ADD_TO_CARD_IS_CLICKABLE=R4.check_Add_To_Cart_is_Clickable();
     for(int i=0;i<ADD_TO_CARD_IS_CLICKABLE.size();i++)
     {
         Assert.assertTrue(ADD_TO_CARD_IS_CLICKABLE.get(i));
         System.out.println(ADD_TO_CARD_IS_CLICKABLE.get(i));
     }

    }

    @Test(priority = 7)

    /*
    TC3: Validate That Guest user can add product to cart
     1.open URL: https://magento.softwaretestingboard.com/
     2.Scroll Down to Hot Sellers Section
     3.Hover on Card “Breathe-Easy Tank”
     4.Select Size “M”
     5.Select Color
     6.Click on “Add to Cart” button
  *******************Expected Results:************************
    1.Product should be added to cart successfully
    2.Cart icon should display number 1
     */
    public void Landing_page_scenario3() throws InterruptedException {

        R4.Scroll_down();
        R4.MOVE_TO_CARD_Breath_EasyTank();
        R4.Select_size(Breathe_Easy_Tank);
        R4.Select_color();
        R4.click_AddToCart();
        CART_NO=R4.CHECK_CART_NO();
        Assert.assertEquals("1",CART_NO);

    }


}
