package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static TestSteps.Testbase.driver;

public class P04_Wishlist_Page {


    By Add_To_WishList= By.cssSelector("a[class=\"action towishlist\"]");
    By images=By.cssSelector("img[class=\"product-image-photo\"]");
    By Product_HasBeenAddedToYourWishlist_Tap=By.cssSelector("div[data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]");
    String NAME_OF_PRODUCT_ADD_TO_WISHLIST;



    public void ADD_To_wishlist(int CARD)
    {
        List<WebElement> WishList=driver.findElements(Add_To_WishList);
        List<WebElement> PRODUCT=driver.findElements(images);

        Actions actions = new Actions(driver);
        actions.moveToElement(PRODUCT.get(CARD)).perform();
        NAME_OF_PRODUCT_ADD_TO_WISHLIST=PRODUCT.get(CARD).getAttribute("alt");
        WishList.get(CARD).click();

    }







    public String GET_Current_Url()
    {
         String URL= driver.getCurrentUrl();
         return URL;
    }


    public String Product_HasBeenAddedToYourWishlist_Tap()
    {
        String wishlist_text=driver.findElement(Product_HasBeenAddedToYourWishlist_Tap).getText();
        return wishlist_text;
    }


    public String NAME_OF_selected_product_wishlist()
    {
        String NAME_0F_PRODUCT=NAME_OF_PRODUCT_ADD_TO_WISHLIST;
        return NAME_0F_PRODUCT;
    }





}
