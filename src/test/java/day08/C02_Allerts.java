package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C02_Allerts {
    /*
    Bir web sirtesine girdimizde karsimiza bir uyari mesaji yada bir butona tikladigimizda bir uyari(alert)
    cikabilir. Eger bu uyarıya incele(sag tik-inspect) yaoabiliyorsak bu tur alertt'lere HTML alert denir
    ve istedigimiz locate'i alabiliriz fakat gelen uyari kutusuna mudahale (sag tik-incele) edemiyorsak
    bu tur alert'lere jd alert denir. js alert'lere mudahale edebilmek icin
    - tamam yada ok icin --> driver.switchTo().alert().accept() kullanilir
    - iptal icin --> driver.switchTo().alert().dismiss() kullanilir
    - Alert icindekiğ mesaji almak icin --> driver.switchTo().alert().getText() kullanilir
    - Alert bizde bir metin istiyorsa --> driver.switchTo().alert().sendKeys() kullanilir
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() throws InterruptedException {

//    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//    Bir metod olusturun: acceptAlert
//1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
// “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMesaj = mesaj.getText();
        String expectedMEsaj = "You successfully clicked an alert";
        Assert.assertEquals(actualMesaj, expectedMEsaj);

    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//    Bir metod olusturun: dismissAlert
//2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        //Allert uzerindeki mesaji yazdirin
        System.out.println("2.Allert mesaji = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement mesaj = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//    Bir metod olusturun: sendKeysAlert
//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
//    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        //Allert uzerindeki mesaji yazdirin
        Thread.sleep(5000);
        System.out.println("3.Butonun alert mesaji"+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Burak");
        driver.switchTo().alert().accept();

        String actualMesaj=driver.findElement(By.xpath("//p[text()='You entered: Burak']")).getText();
        String expectedMesaj="Burak";
        Assert.assertTrue(actualMesaj.contains(expectedMesaj));
    }
    @After
    public void tearDown() {
       driver.close();
    }
}