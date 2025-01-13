package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static TestSteps.Testbase.driver;

public class P03_Landing_Page  {

    static String[] products =
            {"Radiant Tee","Breathe Easy Tank"
            , "Argus All Weather Tank"
            , "Hero Hoodie"
            , "Fusion Backpack"
            ,"Push It Messenger Bag"};


    By Product_price=By.cssSelector("div[class=\"price-box price-final_price\"]  span[class=\"price\"]");
    By images=By.cssSelector("img[class=\"product-image-photo\"]");
    By add_to_cart=By.cssSelector("button[title=\"Add to Cart\"] span");


    By Product_size_XS=By.cssSelector("div[option-id=\"166\"]");
    By Product_size_S=By.cssSelector("div[option-id=\"167\"]");
    By Product_Size_M= By.cssSelector("div[option-id=\"168\"]");
    By Product_Size_L= By.cssSelector("div[option-id=\"169\"]");
    By Product_Size_XL= By.cssSelector("div[option-id=\"170\"]");

    By Purle_Color=By.cssSelector("div[option-label=\"Purple\"]");
    By White_color=By.cssSelector("div[option-label=\"White\"]");
    By Yellow_color=By.cssSelector("div[option-label=\"Yellow\"]");

    By Cart_icon_number=By.cssSelector("span[class=\"counter-number\"]");

    /***************************************************************************/


    public void Scroll_down() throws InterruptedException {
        JavascriptExecutor JS=(JavascriptExecutor)driver;
        JS.executeScript("window.scrollBy(0,850);");
        Thread.sleep(5000);
    }

    /***************************************************************************/

    public List<Boolean> Productprice_check_cost_in_dollar()
    {
        List<Boolean> results= new ArrayList<>();
        List<WebElement> Price_value=driver.findElements(Product_price);

        for(int i=0; i<=5;i++)
        {
            System.out.println(products[i]+" "+Price_value.get(i).getText());
            boolean containsDollar=Price_value.get(i).getText().contains("$");
            results.add(containsDollar);
        }
        return results;

    }

    /***************************************************************************/

    public List<Boolean> Productprice_in_double()
    {
        List<Boolean> results= new ArrayList<>();
        List<WebElement> Price_value=driver.findElements(Product_price);

        for(int i=0; i<=5;i++)
        {
            boolean price_in_double=Price_value.get(i).getText().contains(".");
            results.add(price_in_double);
        }
        return results;

    }

    /***************************************************************************/
    public List<Boolean>  checkeach_card_contain_ADD_TO_CART() throws InterruptedException {

        Actions actions = new Actions(driver);
        List<Boolean> ADD_TO_CART_CHECK=new ArrayList<>();
        List<String>  ADD_TO_CART_APPEAR=new ArrayList<>();
        List<String>  PRDUCT_NAME=new ArrayList<>();

        List<WebElement> Price_value=driver.findElements(images);
        List<WebElement> ADD_CART=driver.findElements(add_to_cart);
        for(int i=0;i<=5;i++)
        {

            actions.moveToElement(Price_value.get(i)).perform();
            ADD_TO_CART_APPEAR.add(i,ADD_CART.get(i).getText());
            PRDUCT_NAME.add(i,Price_value.get(i).getAttribute("alt"));
            System.out.println("product Name : " +PRDUCT_NAME.get(i)+" "+" contain :"+" "+ADD_TO_CART_APPEAR.get(i));
            ADD_TO_CART_CHECK.add(i,ADD_TO_CART_APPEAR.get(i).contains("Add to Cart"));
            Thread.sleep(5000);
        }

        return ADD_TO_CART_CHECK;

    }
    /****************************************************************************************/

    public List<Boolean>  check_Add_To_Cart_is_Clickable() throws InterruptedException {
        Actions actions = new Actions(driver);
        List<WebElement> BUTTON=driver.findElements(add_to_cart);
        List<WebElement> ADD_TO_CART=driver.findElements(images);

        List<Boolean> ADD_TO_CART_CLICKABLE=new ArrayList<>();

        for(int i=0;i<=5;i++)
        {
            actions.moveToElement(ADD_TO_CART.get(i)).perform();
            Thread.sleep(5000);
            actions.moveToElement(BUTTON.get(i)).perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement X=wait.until(ExpectedConditions.elementToBeClickable(BUTTON.get(i)));
            ADD_TO_CART_CLICKABLE.add(i,X.isEnabled());

        }

        return ADD_TO_CART_CLICKABLE;

    }



    public void MOVE_TO_CARD_Breath_EasyTank() throws InterruptedException {
        Actions actions = new Actions(driver);
        List<WebElement> ADD_TO_CART=driver.findElements(images);
        actions.moveToElement(ADD_TO_CART.get(1)).perform();
        Thread.sleep(5000);

    }
    public void Select_size(int num)
    {
        List<WebElement> SIZE=driver.findElements(Product_Size_M);

        SIZE.get(num).click();

    }
    public void Select_color()
    {
        driver.findElement(Yellow_color).click();
    }


    public void click_AddToCart()

    {
        List<WebElement> ADD_CART=driver.findElements(add_to_cart);
        ADD_CART.get(1).click();

    }

    public String CHECK_CART_NO()
    {
        String NO=driver.findElement(Cart_icon_number).getText();
        return NO;


    }














}
