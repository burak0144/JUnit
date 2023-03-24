package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C04_Assertions {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    //Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    @Test
    public void titleTest(){
        //titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String actualTitle=driver.getTitle();
        String expecteTitle="YouTube";
        Assert.assertEquals(actualTitle,expecteTitle);
    }
    @Test
    public void imageTest(){
        //imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]")).isDisplayed());
    }
    @Test
    public void SearchBox(){
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
        //isEnabled erisilebilir demek
    }
    @Test
    public void wrongTest(){
        //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String actualTitle = driver.getTitle();
        String unexpectedTitle ="youtube";
        Assert.assertNotEquals(actualTitle,unexpectedTitle);
    }

}
