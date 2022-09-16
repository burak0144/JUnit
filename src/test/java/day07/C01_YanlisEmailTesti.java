package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_YanlisEmailTesti {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
    @After
    public void tearDown(){
       driver.close();
    }
    @Test
    public void test01() {
        //http://automationpractice.com/index.php sayfasina gidelim
        driver.get("https://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address”
        driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Invalid email");
        driver.findElement(By.xpath("//i[@class='icon-user left']")).click();
         // uyarisi ciktigini test edelim
        WebElement invalidWE=driver.findElement(By.xpath("//li[text()='Invalid email address.']"));
        String actualWord=invalidWE.getText();
        String expectedWord="Invalid email address.";
        Assert.assertEquals(actualWord,expectedWord);
    }
}
