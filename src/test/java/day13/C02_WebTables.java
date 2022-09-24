package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseBeforeAfter;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {


    @Test
    public void test1() {
     //  login() metodun oluşturun ve oturum açın.
        login();
     //          https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
     //  Username : manager
     //  Password : Manager1!
     //          table( ) metodu oluşturun
     //  Tüm table body’sinin boyutunu(sutun sayisi) bulun.
       List<WebElement>sutunSayisi=driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("sutun sayisi :"+sutunSayisi.size());
     //          Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın
        WebElement basliklar=driver.findElement(By.xpath("//thead//tr"));
        System.out.println("basliklar :"+basliklar.getText());
        WebElement body=driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body: "+body.getText());
     //  printRows( ) metodu oluşturun //tr
     //  table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement>satirList=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Tablodaki satir sayisi :"+satirList.size());
     //          Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        satirList.forEach(t-> System.out.println(t.getText()));
     //  4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody//tr[4]")).getText());

    }

    public void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        Actions actions=new Actions(driver);
        WebElement userName=driver.findElement(By.cssSelector("#UserName"));
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();
    }
}
