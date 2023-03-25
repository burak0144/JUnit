package day07;

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
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {

        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        //olmadigini testedin
        List<WebElement> drops=driver.findElements(By.xpath("//option"));
        System.out.println("katagori sayisi = " + drops.size());
        int actual=drops.size();
        int expected=45;
        Assert.assertNotEquals(actual, expected);


    }

    @Test
    public void test02() {

        //.Kategori menusunden Books seceneginisecin
        WebElement ddm=driver.findElement(By.cssSelector("#searchDropdownBox"));
        ddm.sendKeys("Books");

        //.Arama kutusuna Java yazin vearatin
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        //.Bulunan sonuc sayisiniyazdirin
        WebElement sonuSayisiWE=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] sonucSayisiArr=sonuSayisiWE.getText().split(" ");
        System.out.println("Sonuc Sayisi:"+sonucSayisiArr[3]);
        //.Sonucun Java kelimesini icerdigini testedin
        WebElement resultWE=driver.findElement(By.xpath("//span[text()='\"Java\"']"));
        String actualResult=resultWE.getText();
        String expectedResult="\"Java\"";
        Assert.assertEquals(actualResult,expectedResult);

    }


    }
