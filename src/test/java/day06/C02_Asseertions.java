package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Asseertions {
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Her 3 test de amazon sayfasına gitmeyi gerektirdiğinden bu kodu BeforeClass'a yazıyoruz.
        //Amazon sayfasina git
        driver.get("https://amazon.com");

    }
    @AfterClass
    public static void tearDown(){
     driver.close();
    }

    @Test
    public void test(){

        //url'in "amazon" icergini test et
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
    @Test
    public void test2(){
        //farkli test method'u olustur
        //Title'in 'facebook' icermedigini test et
        String actualTitle=driver.getTitle();
        String expectedTitle="facebook";
       Assert.assertFalse(actualTitle.contains(expectedTitle));


    }
    @Test
    public void test3(){
        //farkli test method'u olustur
        //sol ust kosede amazon logosunun gorundugunu test et
        WebElement amazonLogosu=driver.findElement(By.cssSelector("#nav-logo"));
         Assert.assertTrue(amazonLogosu.isDisplayed());
    }

}
