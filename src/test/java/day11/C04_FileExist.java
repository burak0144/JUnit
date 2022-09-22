package day11;

import org.junit.Assert;
import org.junit.Test;
import utilies.TestBaseBeforeAfter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileExist {
    @Test
    public void test1() {
        /*
        String farkliBolum = System.getProperty("user.home");
        //"C:\Users\burak\Desktop\yeni.txt" --> masa üstündeki dosyanın yolu
        String ortakBolum = "C:\Users\burak\Desktop\yeni.txt";
        String masaUstuDosyaYolu = farkliBolum+ortakBolum; // Masaüstündeki dosya yolunu gösterir
        System.out.println(masaUstuDosyaYolu); //C:\Users\burak\Desktop\yeni.txt
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
 */
        String dosyaYolu = "C:\\Users\\burak\\Desktop\\yeni.txt";
        //System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
         /*
 Bir Web sitesinden indirdigimiz yada windows icinde
 olusturdugumuz dosyanin indigini yada orda oldugunu
 test edebilmek icin o dosyanin uzerine shift tusuna
 basili olarak sag click yapip dosyanin yolunu kopyalayıp
 bir String degiskene atariz ve dosyayi dogrulamak icin
 Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
 Bu methodu kullaniriz.
*/
    }
}
