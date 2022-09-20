package day10;

import org.junit.Test;
import utilies.TestBaseBeforeAfter;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {
    @Test
    public void test1(){
        driver.get("https://amazon.com");
    }
}
