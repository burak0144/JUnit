package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcell {
    @Test
    public void name() throws IOException {


    //- Dosya yolunu bir String degiskene atayalim
    String dosyaYolu="src/resources/ulkeler.xlsx";
    //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    FileInputStream fis=new FileInputStream(dosyaYolu);
    //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //- WorkbookFactory.create(fileInputStream)
    Workbook workbook= WorkbookFactory.create(fis); //Workbook objesiyle fis objesiy ile akisa aldigimiz dosyamizla bir excell dosyasi create ettik

    //- Sheet objesi olusturun workbook.getSheetAt(index)
    //- Row objesi olusturun sheet.getRow(index)
    //- Cell objesi olusturun row.getCell(index)
        String actualData=workbook.
                getSheetAt(0).
                getRow(3).
                getCell(3).
                toString();
        System.out.println(actualData);
}
}