package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


      // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");
      // 2- arama kutusunu locate edelim
       WebElement aramaKutusu=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
      // 3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
      // 4- Bulunan sonuc sayisini yazdiralim
     List< WebElement> sonucYazisiWE=driver.findElements(By.xpath("//span[text()='1-16 of 248 results for']"));
       String sonucYazisi=sonucYazisiWE.get(0).getText(); //String ifade
       String [] sonucSayisiArr=sonucYazisi.split(" ");//splitte sonuc array verir
        System.out.println("Sonuc Sayisi"+sonucSayisiArr[2]);
      // 5- Ilk urunu tiklayalim
      WebElement ilkUrun= driver.findElement(By.xpath("//img[@class='s-image']"));
      ilkUrun.click();
      // 6- Sayfadaki tum basliklari yazdiralim
        System.out.println(driver.getTitle());

    }
}
