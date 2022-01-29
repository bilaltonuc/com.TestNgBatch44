package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C4_DropDownAmazon {

    //● https://www.amazon.com/ adresine gidin.


    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }
    @Test
    public void Test1() {
        WebElement aramaKutusu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(aramaKutusu);
        List<WebElement> optionSayı=select.getOptions();
        int actualSayı=optionSayı.size();
        int expectedSayı=45;
        Assert.assertEquals(actualSayı,expectedSayı,"45 değil");

        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        //oldugunu test edin4




    }
    @Test
    public void Test2() {
        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        //2. Arama kutusuna Java yazin ve aratin
        //3. Bulunan sonuc sayisini yazdirin
        //4. Sonucun Java kelimesini icerdigini test edin


        WebElement aramaKatagorisi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(aramaKatagorisi);
        select.selectByIndex(5);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        WebElement sonuc=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonuc.getText());
        String actualSonuc=sonuc.getText();
        String içerenKelime="java";
        Assert.assertTrue(actualSonuc.contains(içerenKelime),"java içermiyor");


    }
}
