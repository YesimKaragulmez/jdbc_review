package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.DBUtils;

public class DBUtilsTest {
    @Before
    public void setUp() {
        DBUtils.createConnection();
    }

    @Test
    public void dbUtilsTest() throws Exception {
        //DBUtils deki metodlari nasil kullanabilirim?
        //1.Query yaz
        String query = "SELECT * FROM dbo.tHOTEL WHERE IDHotel=15;";
        //2.DBUtils deki executeQuery yi kullanarak
        DBUtils.executeQuery(query);
        //3.DBUtils deki diger metodlari kullanarak islem yapabiliriz
        System.out.println("number of row:" + DBUtils.getRowCount());
        System.out.println("current cell value:" + DBUtils.getCellValue(query));
        System.out.println("Get row list:" + DBUtils.getRowList(query));
        System.out.println("Get row map:" + DBUtils.getRowMap(query));
        //Get row map key and value olarak butun degerlerin listesini veriyor
        // query de 15 e gore
        //databaseden datayi cekip excelede atabilirsin
        System.out.println("Get query result:"+ DBUtils.getQueryResultList(query));
        System.out.println("Get column data:"+ DBUtils.getColumnData(query,"Name"));

       //15.satirdaki ismin LILLE old.dogrula
        Assert.assertEquals( DBUtils.getColumnData(query,"Name").toString(),"[LILLE]");

        //15.satirda johnson diye bir datanin olup olmadigini test et
        Assert.assertTrue(DBUtils.getRowList(query).contains("Johnson"));

    }


}
