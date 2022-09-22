package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.TestBaseBeforeAfter;

public class C03_SenkranizasyonWait extends TestBaseBeforeAfter {
    @Test
    public void implicitlyWaitTest1() {
      // Bir class olusturun : WaitTest
      // Iki tane metod olusturun : implicitWait() , explicitWait()

      // https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
      // Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
      //  “It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
      //         Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
      // It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }

    @Test
    public void explicitlWaitTest2() {

    }
}
