package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_Authentication {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {

        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username    : admin
        //password    : admin
        //Basarili sekilde sayfaya girildigini dogrulayin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String actualAnaSayfa=driver.findElement(By.xpath("//h3[text()='Basic Auth']")).getText();
        String expectedMesaj="Basic Auth";
        Assert.assertEquals(actualAnaSayfa, expectedMesaj);
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
