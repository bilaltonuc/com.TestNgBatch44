package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_MouseActions extends TestBase {

//Yeni bir class olusturalim: MouseActions3
//1- https://www.amazon.com/ adresine gidelim
//2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
//mouse’u bu menunun ustune getirelim
//3- “Create a list” butonuna basalim
//4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim


    @Test
    public void test01() throws InterruptedException {

        //2- https://www.amazon.com sayfasina gidelim
        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin
        // ve Enter’a basarak arama yaptirin
        //4- aramanin gerceklestigini test edin

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("samsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();


        Thread.sleep(5000);
    }
}
