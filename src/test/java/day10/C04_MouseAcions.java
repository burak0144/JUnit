package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseBeforeAfter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class C04_MouseAcions extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {

     //  https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
     // Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan=driver.findElement(By.cssSelector("#hot-spot"));
        Actions action=new Actions(driver);
        action.contextClick(ciziliAlan).perform();
     //  Alert’te cikan yazinin “You selected a context menu” oldugunu
     //  test edelim.
        String actualCikanYazi=driver.switchTo().alert().getText();
        String expectedMesaj="You selected a context menu";
        Assert.assertEquals(actualCikanYazi, expectedMesaj);
     //  Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

     //  Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
     //  Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        WebElement acilanSayfa=driver.findElement(By.xpath("//h1"));
      //Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());
        Assert.assertEquals("Elemental Selenium",acilanSayfa.getText());
    }
}
