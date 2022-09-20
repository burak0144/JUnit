package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeTest02 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test1()  {


//http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    driver.get("http://demo.guru99.com/test/guru99home/");
//sayfadaki iframe sayısını bulunuz.
//ilk iframe'deki (Youtube) play butonuna tıklayınız.
//ilk iframe'den çıkıp ana sayfaya dönünüz
//ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
//tıklayınız.
     }
    @After
    public void tearDown() {
        //driver.quit();
    }
}
