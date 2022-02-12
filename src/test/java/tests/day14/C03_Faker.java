package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.TestBase;

public class C03_Faker extends TestBase {

    public void fakerTest() throws InterruptedException {

        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[text()='Allow All Cookies']")).click();
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));


        Actions actions=new Actions(driver);
        Faker faker=new Faker();


        String email=faker.internet().emailAddress();

        actions.click(isimKutusu)
                .sendKeys(faker.name().name())
                //“surname” giris kutusuna bir soyisim yazin
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                //“email” giris kutusuna bir email yazin
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                //“email” onay kutusuna emaili tekrar yazin
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                //Bir sifre girin
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                //Tarih icin ay secin
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")

                //Tarih icin gun secin
                .sendKeys(Keys.TAB)
                .sendKeys("15")

                //Tarih icin yil secin
                .sendKeys(Keys.TAB)
                .sendKeys("1972")
                //Cinsiyeti secin

                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)

                .perform();

        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.

        WebElement erkekSecimElementi=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement kadinSecimElementi=driver.findElement(By.xpath("//input[@value='1']"));

        Assert.assertTrue(erkekSecimElementi.isSelected());
        Assert.assertFalse(kadinSecimElementi.isSelected());


        Thread.sleep(10000);
    }
    }



