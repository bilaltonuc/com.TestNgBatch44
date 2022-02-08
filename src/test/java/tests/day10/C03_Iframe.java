package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_Iframe {
    //● Bir class olusturun: IframeTest
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    //● Bir metod olusturun: iframeTest
    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //○ Text Box’a “Merhaba Dunya!” yazin.
    //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //dogrulayin ve konsolda yazdirin
        WebDriver driver;
        @BeforeClass

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void Ifare() {

        driver.get("https://the-internet.herokuapp.com/iframe");
       WebElement bul= driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
       softAssert.assertTrue(bul.isEnabled(),"erısım yok");
       WebElement ıfare= driver.findElement(By.tagName("iframe"));
       driver.switchTo().frame(ıfare);


       WebElement hello= driver.findElement(By.tagName("p"));
       hello.clear();
       hello.sendKeys("merhaba dunya");

       driver.switchTo().defaultContent();


       WebElement click= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
       click.click();

       WebElement yazı= driver.findElement(By.xpath("//p[text()='Sponsored by ']"));
       softAssert.assertTrue(yazı.isDisplayed(),"görünmuyor");







        softAssert.assertAll();




    }
    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
