package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03 {
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
    public void test1() throws InterruptedException {

   // Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
   // Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonwindowHandle=driver.getWindowHandle();
   // Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
   // Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://techproeducation.com");
   // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        Assert.assertFalse(driver.getTitle().contains("TECHPROEDUCATION"));
   // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");
   // Sayfa title’nin “Walmart” icerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Walmart"));
   // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonwindowHandle);
        Assert.assertTrue(driver.getTitle().contains(actualTitle));

}

    @After
    public void tearDown() {
        driver.quit();
    }}
