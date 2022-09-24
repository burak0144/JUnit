package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilies.TestBaseBeforeAfter;

import java.util.List;
import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {

    @Test
    public void test() {
        //-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //tum cookie’leri listeleyin
        Set<Cookie> cookies =driver.manage().getCookies();
        System.out.println(cookies);
        int sayac=1;
        for (Cookie  w:cookies
             ) {
            System.out.println(sayac+". cookie :"+w);
            System.out.println(sayac+". name :"+w.getName());
            System.out.println(sayac+". value :"+w.getValue());
            sayac++;
        }
        //-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi=cookies.size();
        Assert.assertTrue(cookieSayisi>5);
        //-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin  5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        for (Cookie w:cookies
             ) {
            if(w.getName().equals("i118n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }
        //-eklediginiz cookie’nin sayfaya eklendigini test edin
        Cookie yeniCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);
        cookies=driver.manage().getCookies();
        System.out.println();
        int sayac1=1;
        for (Cookie  w:cookies
        ) {
            System.out.println(sayac1+". cookie :"+w);
            System.out.println(sayac1+". name :"+w.getName());
            System.out.println(sayac1+". value :"+w.getValue());
            sayac1++;
        }
        //ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        cookies = driver.manage().getCookies();
        sayac = 1;
        for (Cookie w:cookies) {
            System.out.println(sayac+". cookie : "+w);
            System.out.println(sayac+". name : "+w.getName());
            System.out.println(sayac+". value : "+w.getValue());
            sayac++;
        }
        Assert.assertFalse(cookies.contains(driver.manage().getCookieNamed("skin")));

        //tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        Assert.assertTrue(cookies.isEmpty());
    }
}
