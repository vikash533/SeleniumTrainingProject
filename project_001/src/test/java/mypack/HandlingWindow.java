package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class HandlingWindow {
    WebDriver driver;
    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://secure.indeed.com/auth?hl=en_IN&co=IN&continue=https%3A%2F%2Fin.indeed.com%2Fq-naukri-com-l-bengaluru%2C-karnataka-jobs.html%3Fvjk%3D95017c9e162a92ea&tmpl=desktop&service=mob&from=gnav-util-jobsearch--indeedmobile&jsContinue=https%3A%2F%2Fin.indeed.com%2Fq-naukri-com-l-bengaluru%2C-karnataka-jobs.html%3Fq%3Dnaukri+com%26l%3Dbengaluru%2C+karnataka%26vjk%3D95017c9e162a92ea&empContinue=https%3A%2F%2Faccount.indeed.com%2Fmyaccess&_ga=2.129414600.577060341.1688970602-1543664772.1688970602");
    }
    @Test
    void testScript(){
    driver.findElement(By.xpath("//button[@id='login-google-button']")).click();
    driver.findElement(By.xpath("//button[@id='apple-signin-button']")).click();
    driver.findElement(By.xpath("//button[@id='login-facebook-button']")).click();
        Set<String> winIds = driver.getWindowHandles();
        int count = winIds.size();
        Reporter.log(String.valueOf(count),true);
        for (String id:winIds
             ) {
            System.out.println(id);
            String title = driver.switchTo().window(id).getTitle();
            System.out.println(title);
           if(title.equalsIgnoreCase("Facebook")||title.equalsIgnoreCase("Sign in with Apple ID")){

               driver.close();
           }

        }
    }
}
