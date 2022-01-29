package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class C02_handleDropDown {
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test

    public void dropDown() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement dropDownn= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(dropDownn);
        select.selectByIndex(3);

        select.getFirstSelectedOption().getText();

        Thread.sleep(3000);


        select.selectByValue("search-alias=electronics-intl-ship");

        Thread.sleep(3000);

        select.selectByVisibleText("Deals");

        List<WebElement> optionList=select.getOptions();
        for (WebElement each:optionList         )
        {
            System.out.println(each.getText());
        }





    }



    @AfterMethod

    public void tearDown()     {
        driver.close();
    }





}
