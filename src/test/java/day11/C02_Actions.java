package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBaseBeforeAfter;

public class C02_Actions extends TestBaseBeforeAfter {
    @Test
    public void name() {


   // 1- https://www.facebook.com adresine gidelim
     driver.get("http://www.facebook.com");
   //  2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
    //  3- Ad, soyad, mail ve sifre kutularina deger yazalim
        WebElement isim=driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        isim.sendKeys("Berk");
        action.sendKeys(Keys.TAB).
                sendKeys("Karanfil").
                sendKeys(Keys.TAB).
                sendKeys("berk@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("berk@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("12334").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("1").sendKeys(Keys.TAB).sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1991").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();



}
}