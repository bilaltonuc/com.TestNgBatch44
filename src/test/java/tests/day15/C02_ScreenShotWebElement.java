package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotWebElement extends TestBase {


    @Test
    public void nutellaTesti() throws IOException {

        driver.get("https://www.amazon.com");
        WebElement nutellaLocate = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        nutellaLocate.sendKeys("nutella" + Keys.ENTER);
        WebElement actual = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult = actual.getText();
        System.out.println(actualResult);
        String expectedResult = "nutella";
        Assert.assertTrue(actualResult.contains(expectedResult));


        File WebElemenSs=new File("target/screenShot/webElement.jpeg");

        File gecici=actual.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(gecici,WebElemenSs);


    }
}