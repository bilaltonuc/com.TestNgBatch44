package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_MouseActions extends TestBase {


//Yeni bir class olusturalim: MouseActions2
//1- https://demoqa.com/droppable adresine gidelim
//2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
//3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test

    public  void Test() {
        driver.get(" https://demoqa.com/droppable");


        Actions actions=new Actions(driver);

        WebElement tasınacakDragMe= driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement tasınılacakDropMe= driver.findElement(By.xpath("//div[@id='droppable']"));

        actions.dragAndDrop(tasınacakDragMe,tasınılacakDropMe).perform();

        WebElement droplLocate=driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actualDrop=droplLocate.getText();
        String expectedDrop="Dropped!";

        Assert.assertEquals(actualDrop,expectedDrop);


    }




}
