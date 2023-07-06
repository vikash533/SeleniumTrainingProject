package mypack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdown {
    WebDriver driver;
    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }
    @Test
    void testScript1(){
        WebElement drp= driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select s = new Select(drp);
        s.selectByVisibleText("AED");
    }
    @AfterTest
    void tearDown(){
        driver.close();
    }
}
