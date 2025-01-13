package TestSteps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class Testbase {



    public static WebDriver driver;
    String valid_email="bishoyadel20171356@gmail.com";
    String valid_password="B123456#";
    int Radiant_Tee=0;
    int Breathe_Easy_Tank=1;
    int Argus_All_Weather_Tank=2;
    int Hero_Hoodie=3;
    int Fusion_Backpack=4;
    int Push_It_Messenger_Bag=5;


    @BeforeTest
    public void opendriver()
    {
        driver= new ChromeDriver();

        driver.manage().window().maximize();

    }

    @BeforeMethod
    public void navigate_to_home()
    {
        driver.get("https://magento.softwaretestingboard.com/");
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("document.body.style.zoom='60%'");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void takescreenshot(ITestResult RES) throws IOException, InterruptedException {
        if(ITestResult.FAILURE==RES.getStatus())
        {
            var camera=(TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot.toPath(), new File("C:\\Users\\bishoy\\IdeaProjects\\SignUp\\src\\main\\resources\\Screenshots"+RES.id()+".png").toPath());

        }


    }
    @AfterTest

    public void after_test() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();


    }



}
