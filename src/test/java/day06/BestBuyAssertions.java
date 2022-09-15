package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BestBuyAssertions {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
        driver.get("https://www.bestbuy.com/");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
       @Test
      public void test1(){
           // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
           String actualUrl=driver.getCurrentUrl();
           String expectedUrl="https://www.bestbuy.com/";
           Assert.assertTrue(actualUrl.contains(expectedUrl));

       }
    @Test
    public void test2(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="Rest";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoWE=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoWE.isDisplayed());
    }
    @Test
    public void test4(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    WebElement fransizcaLinkiWE=driver.findElement(By.xpath("//button[@lang='fr']"));
    Assert.assertTrue(fransizcaLinkiWE.isDisplayed());
    }







}
