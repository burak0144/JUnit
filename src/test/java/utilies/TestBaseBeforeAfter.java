package utilies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBaseBeforeAfter {
 protected WebDriver driver;
 protected Actions action;

  @Before
    public void setUp(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      action=new Actions(driver);
  }
  @After
    public void tearDown(){
     // driver.quit();
  }
    public void tumSayfaScreenshot() throws IOException {
        TakesScreenshot tss= (TakesScreenshot) driver;

        String date=new SimpleDateFormat("yyMMddhhmmss").format(new Date());

        File tumSayfa=new File("target/screenShot/tumSayfa"+date+".jpg");

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfa);
    }
}
