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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
        WebElement ddm=driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select=new Select(ddm);
        /*
DropDown menuye ulasmak icin select class'indan bir obje olustururuz
ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
butun elemanlarının sayısına ulasabiliriz
 */
        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());

        int actualDeger=ddmList.size();
        int expectedDeger=45;
        Assert.assertNotEquals(actualDeger,expectedDeger);

    }


    }

