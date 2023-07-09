package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandlingCheckboxes {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testScript() throws InterruptedException {
        //driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        List<WebElement> allOptions = driver.findElements(By.xpath("//div[@id='checkbox-example']//label/input"));
        wait.until(ExpectedConditions.visibilityOfAllElements(allOptions));
        int noofCheckBox = allOptions.size();
        for (int i=1;i<noofCheckBox;i++){
            allOptions.get(i).click();
        }
       for (int i=0;i<noofCheckBox;i++){
           if(allOptions.get(i).isSelected()){
               allOptions.get(i).click();
           }
       }

    }
}
