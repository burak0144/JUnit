package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
     /*
    BeforeClass'la AfterClass sadece en basta 1 kere ve en sonda 1 kere calisir
    Before ile After ise her test oncesi 1 kere ve her test sonrasi 1 kere calisir
    BeforeClass'la AfterClass icin class seviyesinde Webdriver static olarak atanmali
    Before ile After'da ise Webdriver instance olarak atanmali

     */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    @Ignore("Calismasin")
    public void method1(){
        driver.get("https://amazon.com");
    }
    @Test
    public void method2(){
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3(){
        driver.get("https://hepsiburada.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
