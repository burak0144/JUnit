package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcell {
    @Test
    public void readExcell1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis); //Workbook objesiyle fis objesiy ile akisa aldigimiz dosyamizla bir excell dosyasi create ettik
       //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet =workbook.getSheetAt(0);//Excell dosyamizda calismak istedigimiz sayfayi bu sekilde seceriz
        //- Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);  //Sayfa1'de ki 3.satiri bu sekilde seceriz
        //- Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);//Sati secimi yapildiktan sonra hucre secimi bu sekile yapilir
        System.out.println(cell);
        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
 String expectedData="Cezayir";
 String actualData=cell.toString();
        Assert.assertEquals(expectedData, actualData);
    }
}
