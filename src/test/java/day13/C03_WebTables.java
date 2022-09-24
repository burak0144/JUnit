package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //Bir önceki class'daki adrese gidelim
    //Login() methodunu kullanarak sayfaya giriş yapalım
        //  Username : manager
        //  Password : Manager1!
     login();
    //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        int satir = 3;
        int sutun = 4;
        WebElement cell=driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satir+ " ve " +sutun+" ki text"+cell.getText());
        //PhoneNo basligindaki tumnumaralari yazdirin
        List<WebElement> priceBasligi=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        priceBasligi.forEach(t-> System.out.println(t.getText()));



}public void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        Actions actions=new Actions(driver);
        WebElement userName=driver.findElement(By.cssSelector("#UserName"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }

}