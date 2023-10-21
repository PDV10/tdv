package TPTestNG;

import org.example.Ingrediente;
import org.testng.annotations.*;

public class ejercicio1 {
    /**
     * 1. Implemente un generador de Ingredientes con 10 items.
     */

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("beforeSuite()");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("beforeTest()");

    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("preparando hamburguesa");
    }

    @DataProvider
    public Ingrediente[] Generador() {
        System.out.println("Generando ingredientes ");
        return new Ingrediente[]{
                new Ingrediente("pan","unidad", 1000, 350),
                new Ingrediente("carne","unidad", 1000, 500),
                new Ingrediente("tomate","rodajas", 1000, 100),
                new Ingrediente("lechuga","rodajas", 1000, 75),
                new Ingrediente("pepinillos","rodajas", 1000, 75),
                new Ingrediente("cheddar","rodajas", 1000, 200),
                new Ingrediente("gaseosa","vaso", 500, 300),
                new Ingrediente("adereso","sobrecito", 10000, 75),
                new Ingrediente("papas fritas","porcion", 10000, 300),
        };

    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("agregando ingrediente");
    }

    @Test(dataProvider = "Generador")
    public void TestGenerado(Ingrediente ingrediente) {
        System.out.println("Ingrediente : " + ingrediente.getNombre());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("-");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Se entrego la Hamburguesa");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("afterTest()");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("afterSuite()");
    }


}
