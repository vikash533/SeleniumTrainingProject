package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HnadlingCheckBox {
    WebDriver driver;
    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.spicejet.com/");
    }
    @Test
    void testScript(){
       WebElement element =driver.findElement(By.xpath("//div[contains(text(),'Family & Friends')]"));
       System.out.println(element.getSize());
       element.click();
       System.out.println(element.isEnabled());
        List<WebElement> xyz = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']//div[@class='css-76zvg2 r-cqee49 r-n6v787 r-1ozqkpa']"));
        System.out.println(xyz.size());
        WebElement radioButton=null;
        for (WebElement e:xyz) {
            System.out.println(e.getText());
            if(e.getText().equalsIgnoreCase("Unaccompanied Minor")){
                radioButton=e;
            }

        }
        radioButton.click();
    }
}
