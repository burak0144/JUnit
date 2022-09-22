package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBaseBeforeAfter;

public class C02_FileExistsUpload extends TestBaseBeforeAfter {
    @Test
    public void test1() {

    //    Tests packagenin altina bir class oluşturun : C05_UploadFile
//    https://the-internet.herokuapp.com/upload adresine gidelim
    driver.get("https://the-internet.herokuapp.com/upload");
//    chooseFile butonuna basalim
    WebElement dosyaSec=driver.findElement(By.cssSelector("#file-upload"));
//    Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu="C:\\Users\\burak\\Desktop\\yeni.txt";
        dosyaSec.sendKeys(dosyaYolu);

//    Upload butonuna basalim.
        driver.findElement(By.cssSelector("#file-submit")).click();
//“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement test=driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(test.isDisplayed());
}
}