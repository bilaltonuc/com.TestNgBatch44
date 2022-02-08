package tests.day12;

import org.openqa.selenium.By;
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
    public  void Test() {
        driver.get("https://www.amazon.com/");
        Actions actions=new Actions(driver);

        WebElement locate= driver.findElement(By.tagName("//div[@class='nav-line-1-container']"));
        actions.moveToElement(locate).perform();


    }
}
