package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {

    //Tests package’inda yeni bir class olusturun: WindowHandle2 ● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //●
    //●
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
    //doğrulayın.
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void Test() {

        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement dogrula= driver.findElement(By.tagName("h3"));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(dogrula.getText().equals("Opening a new window"),"beklenenden farklı");
        String actualDeğerr=driver.getTitle();
        String expectedDeğer="The Internet";
        softAssert.assertTrue(actualDeğerr.equals(expectedDeğer));


        String windowHandleDeğeri1= driver.getWindowHandle();

     WebElement   click = driver.findElement(By.xpath("//a[text()='Click Here']"));
        click.click();
        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        String  windowHandleDeğeri2="";
        Set<String> handler=driver.getWindowHandles();

        for (String each:handler
             ) {
            if (!windowHandleDeğeri1.equals(each)) {

                windowHandleDeğeri2=each;

            }

        }
        driver.switchTo().window(windowHandleDeğeri2);
        softAssert.assertEquals(driver.getTitle(),"New Window");


        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement text= driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(text.getText(),"New Window");
        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
        //    //doğrulayın.
        driver.switchTo().window(windowHandleDeğeri1);
        softAssert.assertEquals(driver.getTitle(),"The Internet");








        softAssert.assertAll();



    }
    @AfterClass

    public void tearDown() {
        driver.quit();


    }






    }




