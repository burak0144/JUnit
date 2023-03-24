package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_Junit {

    //method olusturtuk, burada junit ile testlerimizi yapabilmek icin üzerine @ annotations dedigimiz @ isaretini
// koyuyoruz ve test yazıyoruz
//run tusu main method yazarsak veya test notasyonunu yazarsak cıkar.
//JUnit ten run yaparsak buradaki bütün methodlar calisir yani aynı anda birden fazla yerin testini yapabiliriz.
    //kod calıstıktan sonar asağıda kac saniyede calıstğı ve test passed seklinde cıkar.
    protected static WebDriver driver;
    @Test
    public void method1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    }
    @Test
    public void method2(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://techproeducation.com");

    }
    @Test
    public void method3(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://hepsiburada.com");

    }

}
