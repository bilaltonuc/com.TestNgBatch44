package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_Task {
    //1. http://zero.webappsecurity.com/ Adresine gidin



    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin




    WebDriver driver;
@BeforeClass
        public void setUp(){



        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://zero.webappsecurity.com/");
    }

        @Test
    public void Test1() {

        //2. Sign in butonuna basin
                WebElement signButton=driver.findElement(By.xpath("//button[@id='signin_button']"));
            signButton.click();
            //3. Login kutusuna “username” yazin
            //4. Password kutusuna “password.” yazin
            WebElement userName=driver.findElement(By.xpath("//input[@id='user_login']"));
          userName.sendKeys("username");
            WebElement password=driver.findElement(By.xpath("//input[@id='user_password']"));
            password.sendKeys("password");
            //5. Sign in tusuna basin
            WebElement click= driver.findElement(By.xpath("//input[@type='submit']"));
            click.click();
            driver.findElement(By.xpath("//button[@id='primary-button']")).click();
            driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
            driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
            driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

            //8. “Currency” drop down menusunden Eurozone’u secin
            WebElement eurozone= driver.findElement(By.xpath("//select[@id='pc_currency']"));
            Select select=new Select(eurozone);
            select.selectByValue("EUR");
            //9. “amount” kutusuna bir sayi girin
            WebElement amout=driver.findElement(By.xpath("//input[@id='pc_amount']"));
            amout.sendKeys("26");
            //10. “US Dollars” in secilmedigini test edin
            WebElement us= driver.findElement(By.id("pc_inDollars_true"));
            Assert.assertFalse(us.isSelected());

            //11. “Selected currency” butonunu secin
            driver.findElement(By.id("pc_inDollars_false")).click();
            //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
            driver.findElement(By.id("pc_calculate_costs")).click();

            //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
           // WebElement varMı=driver.findElement(By.xpath("(//h2[@class='board-header'])[1]"));







    }

}
