package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandlingWindowsAutomationpractice {
    WebDriver driver;
    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
    }
    @Test
    void testScript() throws InterruptedException {
    driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("selenium");
    driver.findElement(By.xpath("//input[@type='submit' and @class='wikipedia-search-button']")).click();
        List<WebElement> suggestion = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div"));

        for (WebElement sugg:suggestion
             ) {
            String text = sugg.getText();
            System.out.println(text);
            Thread.sleep(2000);
            sugg.click();

        }


    }
}
