package TPTestNG;

import org.example.Ingrediente;
import org.testng.Assert;
import org.testng.annotations.*;


public class Ejercicio2 {
    public final static int CANT_CARACTERES = 10;
    /**
     * Implemente un test consumidor de ingredientes aleatorio que
     * compruebe que su nombre no exceda los 10 caracteres
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
        Ingrediente[] ingredientes = new Ingrediente[]{
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
        int poss = (int)Math.floor(Math.random() * 9);
        Ingrediente ingre =  ingredientes[poss];
        System.out.println("poss: "+ poss);

        Ingrediente[] ingrediente = new Ingrediente[]{ingre};
        return ingrediente;
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("agregando ingrediente");
    }

    @Test(dataProvider = "Generador")
    public void TestGenerado(Ingrediente ingrediente) {
        System.out.println(ingrediente.getNombre().length());
        System.out.println("ingrediente: "+ ingrediente.getNombre());
        Assert.assertTrue(ingrediente.getNombre().length() < CANT_CARACTERES,"el nombre del ingredientes supera la cantidad de caracteres");
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
