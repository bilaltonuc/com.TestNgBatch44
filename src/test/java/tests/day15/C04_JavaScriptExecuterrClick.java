package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.IOException;

public class C04_JavaScriptExecuterrClick extends TestBase {

    //// amazon.com anasayfaya gidip
    //    // sell linkine JSExecutor ile tiklayalim
    //    // ilgili sayfaya gittigimizi test edelim
@Test

public void javaScripExecuter() throws IOException {


    driver.get("https://www.amazon.com");

    JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;

    //1.adim JsExecutor objesi olusturalim ve driver'i cast edelim

    JavascriptExecutor jse=(JavascriptExecutor) driver;

    // 2. adim ilgili web elementi locate edelim

    WebElement sellelementi= driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

       javascriptExecutor.executeScript("arguments[0].click();",sellelementi);
       tumSayfaScreenshot();

}
}
