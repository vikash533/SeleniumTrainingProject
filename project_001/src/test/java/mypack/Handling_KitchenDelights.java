package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
public class Handling_KitchenDelights {
    WebDriver driver;
    @BeforeClass
    void setUp(){
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://prodtestv3.fleksa.de/en");
    }
    @Test(priority = 1)
    void DisplayMenu() throws InterruptedException {
        driver.findElement(By.xpath("(//div[@id='__next']//a[.='MENU'])[1]")).click();
        WebElement cheesFry = driver.findElement(By.xpath("//h4[normalize-space()='Cheesy Fries Meat']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", cheesFry);
        List<WebElement> menuIteam = driver.findElements(By.xpath("//div[@class='hidden lg:block sticky top-24']//a[@id='view-category-20-sidebar']/following-sibling::*"));
        WebElement preferedIteam= null;
        for (WebElement iteam:menuIteam) {
           String  text= iteam.getText();
           System.out.println(text);
           if(text.equalsIgnoreCase("Cheesy Fries")){
               preferedIteam=iteam;
           }
        }
        preferedIteam.click();
        WebElement cheesy_Fries_Meat = driver.findElement(By.xpath("(//div[@id='view-category-16']//button[text()='Add  +'])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", cheesy_Fries_Meat);
        Thread.sleep(1000);
        cheesy_Fries_Meat.click();
        driver.findElement(By.xpath("//p[.='ADD TO CART 8.99 €']")).click();
        String winId = driver.getWindowHandle();
        System.out.println(winId);
        driver.switchTo().window(winId);
        driver.findElement(By.xpath("//li[2]//button[1]//div[1]//div[1]//div[2]//p[2]")).click();
        driver.findElement(By.xpath("//button[.='CONFIRM']")).click();
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }
}
