package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class Amazon_Autosuggestion {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");

    }
    @Test
    void testScript() throws InterruptedException {
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14");
      wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='nav-issFlyout nav-flyout']//span")));
      List<WebElement> autoSuggestion = driver.findElements(By.xpath("//div[@class='nav-issFlyout nav-flyout']//span"));
      WebElement iphone14PlusSuggestion = null;
        for (WebElement suggestion:autoSuggestion) {
                String text= suggestion.getText();
                System.out.println(text);
                if(text.equalsIgnoreCase("iphone 14 plus"))
//                    suggestion.click();
                    iphone14PlusSuggestion = suggestion;

        }
        assert iphone14PlusSuggestion != null;
        iphone14PlusSuggestion.click();
    }
    @AfterClass
    void tearDown(){
        //Thread.sleep();
        driver.close();
    }
}
