package mypack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingAlert {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void testScript() throws InterruptedException {
//    driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
//    Thread.sleep(500);
//    driver.switchTo().alert().accept();
    driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
    Thread.sleep(500);
    driver.switchTo().alert().accept();
    driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
    Thread.sleep(500);
        Alert alertType = driver.switchTo().alert();
        alertType.sendKeys("selenium");
        alertType.accept();
    }
}
