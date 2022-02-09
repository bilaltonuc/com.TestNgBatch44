package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {


    @Test
    public void ısExıstTesti () {
        // //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //    //2. Iki tane metod oluşturun : isExist( ) ve downloadTest( )
        //    //3. downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
        //    //		- https://the-internet.herokuapp.com/download adresine gidelim.
        //    //		- code.txt dosyasını indirelim
        //    //4. Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
       String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\sample.pdf";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));




    }

        @Test
        public void downLoadTesti () throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement locate= driver.findElement(By.xpath("//a[text()='sample.pdf']"));
        locate.click();
        Thread.sleep(5000);



        }


    }


