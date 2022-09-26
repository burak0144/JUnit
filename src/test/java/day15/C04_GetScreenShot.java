package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilies.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasina gidelim tum sayfanin resmini alalim
        driver.get("https://www.hepsiburada.com");
        TakesScreenshot ts= (TakesScreenshot) driver;
        //bir web sayfasinin resmini alabilmek icin TakesScreenshot class'indan obje olusturup gecici bir File class'indan
        //degiskene TakesScreenshot'tan olusturdugum obje'den ts.getScreenshotAs methodunu kullanarak gecici bir file olustururuz

       String date=new SimpleDateFormat("yyMMddhhmmss").format(new Date());

        File tumSayfaResmi=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranResmi/allPage"+date+".jpeg"));
    }
}
