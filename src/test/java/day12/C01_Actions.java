package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Automationexercises.com adresine gidelim
//product bölümüne girelim
//ilk ürünü tıklamayalım
        Actions actions=new Actions(driver);
driver.get("https://www.automationexercise.com/");
driver.findElement(By.xpath("//a[@href='/products']")).click();


actions.sendKeys(Keys.PAGE_DOWN).perform();
driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
    }
}
