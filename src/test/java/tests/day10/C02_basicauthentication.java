package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_basicauthentication {

    // 1- Bir class olusturun : BasicAuthentication
    //    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    //    //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    //    //
    //    //	Html komutu : https://username:password@URL
    //    //	Username     : admin
    //    // 	password      : admin
    //    //
    //    //4- Basarili sekilde sayfaya girildigini dogrulayin
    WebDriver driver;
    @BeforeClass
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void Test() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement test= driver.findElement(By.tagName("p"));
        String actualTest= test.getText();
        String expectedTest="Congratulations!";
        Assert.assertTrue(actualTest.contains(expectedTest));
        Assert.assertTrue(test.isDisplayed());
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
