package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AutoSuggestion {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    void setUP(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
    }
    @Test
    void testScript(){
        driver.findElement(By.name("q")).sendKeys("java");
        List<WebElement> allOptions = driver.findElements(By.xpath("//ul[@class='G43f7e']//li"));
        for (WebElement option:allOptions) {
           String text = option.getText();
           System.out.println(text);
           if(text.equalsIgnoreCase("javascript")){
               option.click();
           }
        }
    }
    @AfterTest
    void tearDown(){
        driver.close();
    }
}
