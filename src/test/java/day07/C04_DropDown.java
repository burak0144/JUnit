package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C04_DropDown {
    WebDriver driver;
    Select select;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test01() {


//Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm=driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText()); //secim yaptigini getirir
//Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
       select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
//Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
//Tüm dropdown değerleri(value) yazdırın
        System.out.println("================");
        List<WebElement> tumDropdownList=select.getOptions();
       tumDropdownList.forEach(t-> System.out.println(t.getText()));

//Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
//False yazdırın.
        System.out.println("========");
        System.out.println("Dropdown boyutu = "+tumDropdownList.size());
        if (tumDropdownList.size()==4){
            System.out.println("True");
        }else System.out.println("False");
        Assert.assertNotEquals(tumDropdownList.size(),4);
    }
}