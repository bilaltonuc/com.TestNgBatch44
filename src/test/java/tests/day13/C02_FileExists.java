package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists extends  TestBase{

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.home")); // C:\Users\Lenovo


        // masaustundeki Deneme klasorunun Path'ini istesem
        // "C:\Users\Lenovo\Desktop\Deneme\selenium.xlsx"

        // Yani dinamik olarak masaustumdeki Deneme klasorunun path'ini yazmak istersem

        String path = System.getProperty("user.home") + "\\Desktop\\Deneme\\selenium.xlsx";

        System.out.println(path);

        System.out.println("user.dir  : " + System.getProperty("user.dir"));

        // Masaustunde Deneme klasoru icerisinde selenium.xlsx isminde bir dosya oldugunu test edin
        // *********** masaustunde Deneme klasoru ve icinde selenium.xlsx olmazsa CALISMAZ********
        // 1- once bu dosyaya ulasmak icin gerekli dinamik path olusturalim

        String dosyaYolu = System.getProperty("user.home") + "\\Desktop\\Deneme\\selenium.xlsx";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        // projemizde pom.xml oldugunu test edin
        //C:\Users\Lenovo\B44-QA-TR\06-Selenium\com.TestNGBatch44\pom.xml

        System.out.println(System.getProperty("user.dir")); // projemin yolunu verir
        //C:\Users\Lenovo\B44-QA-TR\06-Selenium\com.TestNGBatch44

        String pomPath = System.getProperty("user.dir") + "\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));


    }
}