package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseBeforeAfter;

public class C05_MouseAction2 extends TestBaseBeforeAfter {
    @Test
    public void test() {

//    https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
//            “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragme= driver.findElement(By.cssSelector("#draggable"));
        WebElement drophere= driver.findElement(By.cssSelector("#droppable"));
        //Actions action=new Actions(driver); utilies classindan cagirdigimiz icin yoruma aldik
        action.dragAndDrop(dragme,drophere).perform();

//“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//p[text()='Dropped!']")).getText());
    }
}