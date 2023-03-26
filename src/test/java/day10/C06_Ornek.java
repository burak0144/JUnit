package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseBeforeAfter;

public class C06_Ornek extends TestBaseBeforeAfter {
    @Test
    public void test01(){
        driver.get("https://amazon.com");
        WebElement signin =driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
        Actions actions=new Actions((driver));
        actions.moveToElement(signin).perform();
        driver.findElement(By.xpath("//span[text()='Music Library']")).click();
        WebElement library=driver.findElement(By.cssSelector("#contextMenuHoverButton"));
        actions.moveToElement(library).perform();
        driver.findElement(By.xpath("(//music-list-item[@class='hydrated'])[1]")).click();

        driver.findElement(By.xpath("//music-vertical-item[@data-key='Never Wanted To Be That GirlCarly Pearce & Ashley McBrydeundefined']")).click();
    driver.findElement(By.cssSelector("#dialogButton2")).click();
    }
}
