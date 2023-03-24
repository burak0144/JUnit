package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_Iframe {
    //IFrame,birwebsayfasına icine yerlestirilmis baska bir websayfasıdır
    // veya bir HTMLdokumaninin içine yerleştirilmiş baska bir HTML dokumanidir.
    //src ile almak gerekir

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
    public void test1() {
        driver.get("https://html.com/tags/iframe/");
    /*
    Bir web sitesinde bir video(youtube vb.) varsa <iframe> tag'ı içerisindeyse bu video'yu direk locate edip
    çalıştırmak dinamik olmaz çünkü link değişebilir ve locate'imiz çalışmaz.
    Bunun için bütün frame'leri bir array liste atıp index ile frame'i seçip sonrasında play tuşunu locate edip
    çalıştırabiliriz.
     */
        List<WebElement> iframeList = new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

    }
    @After
    public void tearDown() {
        //driver.close();
    }
}
