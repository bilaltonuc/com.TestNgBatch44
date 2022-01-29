package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    //Bir class oluşturun: DropDown
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

    WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void Test1() {
        driver.get(" https://the-internet.herokuapp.com/dropdown");
        WebElement locate= driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select select=new Select(locate);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> optinList=select.getOptions();
        for (WebElement each:optinList
             ) {
            System.out.println(each.getText());
        }






        //5. Dropdown’un boyutunu bulun,  Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        int actualSize=optinList.size();
        int expectedSize=4;
        Assert.assertEquals(actualSize,expectedSize,"opsiyon sayısı beklentileri karşılamıyor");



    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
