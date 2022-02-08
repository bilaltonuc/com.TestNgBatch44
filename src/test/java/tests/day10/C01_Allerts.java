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

public class C01_Allerts {
    WebDriver driver;

   //Bir class olusturun: Alerts ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //“You successfully clicked an alert” oldugunu test edin.
   // ●
   // Bir metod olusturun: dismissAlert

    //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");



    }
    @Test
    public  void aceeptAlert() {
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
       WebElement sonucYazı= driver.findElement(By.xpath("//p[@id='result']"));
       String actualSonucYazısı=sonucYazı.getText();
       String expectedSonucYazısı="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazısı,expectedSonucYazısı);

    }

    @Test
    public void dismissAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        WebElement sonucYazısıı= driver.findElement(By.xpath("//p[@id='result']"));
        String actualYazı=sonucYazısıı.getText();
        String  içermeyenKelime="successfuly";
        Assert.assertFalse(actualYazı.contains(içermeyenKelime));
    }
    @Test
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin. ● Bir metod olusturun: sendKeysAlert
    public void sendKeysAlert() {
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("bilal" );
        driver.switchTo().alert().accept();
        WebElement yazııı= driver.findElement(By.xpath("//p[@id='result']"));
        String actualİsim= yazııı.getText();
        String expectedİsim="bilal";
        Assert.assertTrue(actualİsim.contains(expectedİsim));


    }
   // ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

@AfterClass
    public void tearDown() {
        driver.close();
}




}
