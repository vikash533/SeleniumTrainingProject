package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandelStatic_DynamicWebTabel {
    WebDriver driver;
    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

    }
    @Test
    void testScript()  {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        //Total no of rows
        //approch
        int totalRows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println(totalRows);
        //if we have single tabel then we approch like that
//        int rows = driver.findElements(By.tagName("tr")).size();
//        System.out.println(rows);
        //Total no columns in a tabel
        int noColmn = driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
        System.out.println(noColmn);
        //Read specipic row and column data
       String text= driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]/td[3]")).getText();
       System.out.println(text);
       //Read data form all the rows and columns
        for(int i=2;i<=totalRows;i++ ){
            for (int j=1;j<=noColmn;j++){
                String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td["+j+"]")).getText();
                System.out.print(data+"\t");
            }
            System.out.println();
        }
        for(int i=2;i<=totalRows;i++){
           String text1= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[2]")).getText();
           //System.out.println(text1);
           if(text1.equalsIgnoreCase("Amit")){
              System.out.println(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[1]")).getText());
           }
        }
        int sum = 0;
        for(int i=2;i<=totalRows;i++){
            String data=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]/td[4]")).getText();
            int a=Integer.parseInt(data);
            System.out.println(a);
            sum=sum+a;
        }
        System.out.println("sum of book price is :"+sum);
    }
}
