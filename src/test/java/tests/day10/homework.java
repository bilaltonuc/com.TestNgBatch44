package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.swing.interop.SwingInterOpUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class homework {
    //“https://www.hepsiburada.com/” Adresine gidin
    //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //3. search kutusuna araba yazip arattirin
    //4. bulunan sonuc sayisini yazdirin
    //5. sonuc yazisinin "araba" icerdigini dogrulayin
    //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayın
    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

  }
  @Test
    public void Test() {
        driver.get("https://www.hepsiburada.com/");
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle="Türkiye'nin En Büyük Online Alışveriş Sitesi";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitle));
        WebElement search= driver.findElement(By.xpath("//input[@type='text']"));
        search.sendKeys("araba"+ Keys.ENTER);
     WebElement sonuc= driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-mainText']"));
      System.out.println(sonuc.getText());
      String actualAraba= sonuc.getText();
      String içerenKelime="araba";
      String içermeyenKelime="oto";


      softAssert.assertTrue(actualAraba.contains(içerenKelime));
      softAssert.assertFalse(actualAraba.contains(içermeyenKelime));


      softAssert.assertAll();



  }
}
