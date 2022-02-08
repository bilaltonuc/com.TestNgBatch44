package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_faceBook  extends TestBase {
    //Yeni bir class olusturalim: D15_MouseActions4
    //1- https://www.facebook.com adresine gidelim
    //2- Yeni hesap olustur butonuna basalim
    //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //4- Kaydol tusuna basalim

    @Test
    public void Test() {
        driver.get("https://www.facebook.com");
        WebElement yenıHesap= driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        yenıHesap.click();


    }


}
