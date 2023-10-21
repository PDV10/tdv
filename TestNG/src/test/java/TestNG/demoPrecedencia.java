package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class demoPrecedencia{



    @BeforeMethod
    public void beforeMethod() {
        System.out.println("beforeMethod()");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod()");
    }


    @DataProvider
    public Object[][] Generador() {
        System.out.println("Genero casos");
        return new Object[][]{
                new Object[]{1, "a"},
                new Object[]{2, "b"},
        };
    }

    @Test(dataProvider = "Generador")
    public void TestGenerado(Integer n, String s) {
        System.out.println("El generador provee: " + s + " -" + " - " + n);
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("afterClass()");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite()");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest()");

    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest()");
    }



    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite()");
    }


    @Test
    public void test1() {
        System.out.println("Ejecuto Test1");
    }

    @Test
    public void test2() {
        System.out.println("Ejecuto Test2");
    }

    @Test
    public void testSinEmplementar() {
        throw new RuntimeException("Este test aun no esta implementado");
    }

}