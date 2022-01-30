package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethod {
WebDriver driver;

    //Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.
    //1. Test : Amazon ana sayfaya gittiginizi test edin


   @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));




    }
    @Test
    public void logoTest(){
        driver.get("https://www.amazon.com");
        WebElement amazon= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazon.isDisplayed());

    }
    @Test( dependsOnMethods = "logoTest")
    public  void aramaTest1(){
        //2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        //arama yapin ve aramanizin gerceklestigini Test edin
       WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
       String actualTitle= driver.getTitle();
       String arananKelime="Nutella";
       Assert.assertTrue(actualTitle.contains(arananKelime));
        //3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
        //$14.99 oldugunu test edin

    }
    @Test(dependsOnMethods = "aramaTest1")
    public void Test3() {
       WebElement fiyat=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
       fiyat.click();
       WebElement fiyat1= driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']"));
       String actualFiyat= fiyat1.getText();
       String expectedFiyat="$14.99";
       Assert.assertTrue(actualFiyat.equals(expectedFiyat));

    }
    @AfterClass
    public void tearDown() {
       driver.close();
    }

}
