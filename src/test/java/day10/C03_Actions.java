package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {
@Test
    public void test1(){
    //amazon sayfasina gidelim
    //account menusunden create'e list linkine tiklayalim
    driver.get("https://www.amazon.com");

   WebElement accountList = driver.findElement(By.cssSelector("#nav-link-accountList"));

    Actions action=new Actions(driver);
    action.moveToElement(accountList).perform();
    /*
Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
 actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde html kodları
  arasında web elementi bulur ama ulaşamadığı için
   ElemenNotInteractableException: element not interactable exception'i fırlatır
 */

    driver.findElement(By.xpath("(//span[@class='nav-text'])[1]")).click();
}
}
