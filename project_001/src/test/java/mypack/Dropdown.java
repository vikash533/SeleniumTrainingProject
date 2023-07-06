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
    @Test(priority = 1)
    void testScript1(){
        WebElement drp= driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
        Select s = new Select(drp);
        s.selectByVisibleText("AED");
        String text = s.getFirstSelectedOption().getText();
        System.out.println("text of selected string:  "+text);

    }
    @Test(priority = 2)
    void testScript2(){
        WebElement drp1=driver.findElement(By.cssSelector("#divpaxinfo"));
        drp1.click();
        System.out.println(drp1.getText());
        int i=1;
        while(i<4){
            driver.findElement(By.cssSelector("#hrefIncAdt")).click();
            i++;
        }
        System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());
    }
    @Test(priority = 3)
    void testScript3(){
       WebElement DeptCity = driver.findElement(By.cssSelector("span#ctl00_mainContent_ddl_originStation1_CTXTaction"));
       DeptCity.click();
       driver.findElement(By.xpath("//ul//li/a[.=' Ahmedabad (AMD)']")).click();
       System.out.println(driver.findElement(By.xpath("//ul//li/a[.=' Ahmedabad (AMD)']")).getText());
    }
    @Test(priority = 4)
    void testScript4(){
    WebElement arrivalCity = driver.findElement(By.xpath("(//a[.=' Bengaluru (BLR)'])[2]"));
    arrivalCity.click();
    System.out.println(arrivalCity.getText());
    driver.findElement(By.xpath("(//a[.='10'])[1]")).click();
    }
    @AfterTest(enabled = false)
    void tearDown(){
        driver.close();
    }
}
