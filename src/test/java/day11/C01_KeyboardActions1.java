package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseBeforeAfter;

public class C01_KeyboardActions1 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
      //  Bir Class olusturalim KeyboardActions1
      //  https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
      //  Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        Actions actions=new Actions(driver);
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(aramaKutusu).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("7").sendKeys("1")
                .sendKeys(Keys.ENTER).perform();

      //  aramanin gerceklestigini test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("//span[text()='\"samsung A71\"']"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
    }
}
