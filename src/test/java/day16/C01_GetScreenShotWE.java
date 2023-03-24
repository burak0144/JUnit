package day16;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilies.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C01_GetScreenShotWE extends TestBaseBeforeAfter {
    @Test
    public void test01() throws IOException {
        //amazon sayfasina gidin
        driver.get("https://www.amazon.com");
        //nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //arama sonucunun resmini alalim
        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu=aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranResmi/WebSS.jpeg"));
    }
}
