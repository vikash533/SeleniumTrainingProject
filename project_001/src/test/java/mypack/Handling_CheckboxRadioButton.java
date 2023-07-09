package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Handling_CheckboxRadioButton {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testScript() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("selenium");
        List<WebElement> drp = driver.findElements(By.xpath("//ul[@class='G43f7e']//div[contains(@class,'wM6W7d')]//span"));
        WebElement temp =null;
        for (WebElement d:drp
             ) {
            System.out.println(d.getText());
            if(d.getText().equalsIgnoreCase("selenium rich foods")){
                 temp = d;
            }
        }
        temp.click();
    }
}
