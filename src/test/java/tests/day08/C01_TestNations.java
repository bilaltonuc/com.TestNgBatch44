package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_TestNations {
//1) Bir class oluşturun: YoutubeAssertions
//2) https://www.youtube.com adresine gidin
//3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin



//○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static   WebDriver driver;

    @BeforeClass
  public static void setup() {
      WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
     driver.get("https:www.youtube.com");

  }


   @Test

    public void youtube1() {
       //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
       String actualTest= driver.getTitle();
       String expectedTitle="YouTube";
       Assert.assertEquals(actualTest,expectedTitle);


   }


    @Test

    public void youtube2() {
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin

        WebElement imageTest= driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
        Assert.assertTrue(imageTest.isDisplayed());

     //   Assert.assertTrue(imageTest.isDisplayed());

    }

    @Test

    public void youtube3() {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBul=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBul.isEnabled());


    }




}
