package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Flipkart_Autosuggestion {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
    }
    @Test(invocationCount = 1)
    void testScript(){
        driver.findElement(By.xpath("//button[.='✕']")) .click();
         driver.findElement(By.name("q")).sendKeys("iphone");
            List<WebElement> autosuggestion = driver.findElements(By.xpath("//ul/li"));
            for (WebElement suggestion:autosuggestion) {
                String text= suggestion.getText();
                System.out.println(text);
                }
    }
    @AfterTest
    void tearDown()
    {
        driver.close();
    }
}
