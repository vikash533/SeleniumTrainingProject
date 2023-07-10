package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandlingFrame {
    WebDriver driver;
    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
    }
    @Test
    void testScript() throws InterruptedException {
        driver.switchTo().frame("packageListFrame");
//        driver.findElement(By.xpath("//a[.='org.openqa.selenium']")).click();
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("packageFrame");
//        driver.findElement(By.xpath("//span[.='Alert']")).click();
//        driver.switchTo().defaultContent();
//        driver.switchTo().frame("classFrame");
//        driver.findElement(By.xpath("//a[.='Instance Methods']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//ul[@title='Packages']//li"));
        WebElement temp = null;
        for (WebElement l:list
             ) {
            String text = l.getText();
            System.out.println(text);
            if(text.equalsIgnoreCase("org.openqa.selenium.bidi.browsingcontext")){
                temp=l;
            }
        }
        temp.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame("packageFrame");
        List<WebElement> list1= driver.findElements(By.xpath("//ul[@title='Classes']//li"));
        WebElement temp1=null;
        for (WebElement l1:list1)
        {
            String text1 = l1.getText();
            System.out.println(text1);
            if(text1.equalsIgnoreCase("BrowsingContext"))
            {
                temp1=l1;
            }
        }
        Thread.sleep(1000);
        temp1.click();
    }

    }

