package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssert {
//1. “http://zero.webappsecurity.com/” Adresine gidin
//2. Sign in butonuna basin
//3. Login kutusuna “username” yazin
//4. Password kutusuna “password” yazin
//5. Sign in tusuna basin

//7. “Purchase Foreign Currency” tusuna basin
//

    WebDriver driver;

    @BeforeClass
    public  void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public  void Test1() {
        driver.get("http://zero.webappsecurity.com/");
        WebElement signButton=driver.findElement(By.xpath("//button[@id='signin_button']"));
        signButton.click();
        WebElement userName=driver.findElement(By.xpath("//input[@id='user_login']"));
        userName.sendKeys("username");
        WebElement password=driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");
        WebElement click= driver.findElement(By.xpath("//input[@type='submit']"));
        click.click();
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[text()='Proceed to zero.webappsecurity.com (unsafe)']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
//8. “Currency” drop down menusunden Eurozone’u secin

        WebElement down= driver.findElement(By.xpath("(//select[@id='pc_currency'])[1]"));
        Select select=new Select(down);
        select.selectByVisibleText("Eurozone (euro)");


        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        String actualEurozone=select.getFirstSelectedOption().getText();
        String expectedValue="Eurozone (euro)";
        SoftAssert softAssertT=new SoftAssert();
        softAssertT.assertTrue(actualEurozone.equals(expectedValue));
        softAssertT.assertAll();
//10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        List<WebElement> optionList= select.getOptions();

        String actualOptionListesiStringOlarak="";
        for (WebElement each: optionList
        ) {
            actualOptionListesiStringOlarak += "\""  +   each.getText()  +   "\", ";
        }

        actualOptionListesiStringOlarak=actualOptionListesiStringOlarak.substring(0,actualOptionListesiStringOlarak.length()-2);
        String expectedListeStringOlarak="\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\", \"Switzerland (franc)\", \"China (yuan)\", \"Denmark (krone)\", \"Eurozone (euro)\", \"Great Britain (pound)\", \"Hong Kong (dollar)\", \"Japan (yen)\", \"Mexico (peso)\", \"Norway (krone)\", \"New Zealand (dollar)\", \"Sweden (krona)\", \"Singapore (dollar)\", \"Thailand (baht)\"";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualOptionListesiStringOlarak,expectedListeStringOlarak);

        softAssert.assertAll();

        System.out.println("testlerden failed olan varsa softAssert.assertAll'dan sonrasi calismaz");
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
