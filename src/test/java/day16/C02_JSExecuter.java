package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilies.TestBaseBeforeAfter;

public class C02_JSExecuter extends TestBaseBeforeAfter {
    @Test
    public void test01() {

    //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //asagidaki carers butonunu gorunceye kadar js ile scroll yapalim
        WebElement carrers=driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carrers);
        //Carrers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",carrers);

}
}