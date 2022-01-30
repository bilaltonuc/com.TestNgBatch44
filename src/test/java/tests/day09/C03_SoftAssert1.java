package tests.day09;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssert1 {


    @Test
    public void Test() {

        int a=10;
        int b=20;
        int c=30;
        SoftAssert ssoftAssert=new SoftAssert();
        ssoftAssert.assertTrue(a>b,"birinci yanlıs");
        ssoftAssert.assertTrue(c<b);
        ssoftAssert.assertTrue(a>b,"3.de yanlıs");

        ssoftAssert.assertAll();



    }

}
