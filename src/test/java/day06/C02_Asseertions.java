package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_Asseertions {
   //Assert.assertTrue oldugunda contain ile method kullanilir ve ici dogru olmasi gerekir
    //Assert.assertFalse oldugunda contain ile kullanilir ve ici yanlis olmali
    //Assert.assertequals oldugunda , ile kullanilir ve ici esit olmali
    //Assert.assertNotEquals oldugunda , ile kullanilir ve ici esit olmamali
   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
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
