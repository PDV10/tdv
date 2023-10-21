package TPTestNG;

import org.example.Ingrediente;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Pruebe si es posible descontar cantidades de ingredientes aun
 * cuando esta cantidad disponible es menor a 0. ¿Como se actuaría
 * ante esta situación?
 */
public class ejercicio3 {
    public final static  int CANTIDAD = 100;

    Ingrediente[] ingredientes = new Ingrediente[]{};

    @BeforeClass
    public void BeforeClass(){
        System.out.println("ingredientes ");

    }

    @DataProvider
    public Ingrediente[] generador(){
        Ingrediente[] i = new Ingrediente[]{
                new Ingrediente("pan","unidad", -100, 350),
                new Ingrediente("carne","unidad", 1000, 500),
                new Ingrediente("tomate","rodajas", 1000, 100),
                new Ingrediente("lechuga","rodajas", 1000, 75),
                new Ingrediente("pepinillos","rodajas", 1000, 75),
        };

        System.out.println("ingredientes con stock original");
        for (Ingrediente ingrediente : i) {
            System.out.println(ingrediente) ;
        }

        ingredientes = i;
        return ingredientes;
    }



    @Test(dataProvider = "generador",invocationCount = 10)
    public void test(Ingrediente ingrediente){
        int stockAnterior = ingrediente.getStock();
       // System.out.println("stock anterior: "+stockAnterior);
        ingrediente.consumirStock(CANTIDAD);
        Assert.assertTrue(ingrediente.getStock() >= 0,"Error, el stock es negativo");
       // System.out.println("stock actual : "+ ingrediente.getStock() + "\n");
    }

    @AfterClass
    public void afterClass(){
        System.out.println( "\n" + "ingredientes con stock modificado: ");
        for (Ingrediente ingrediente : ingredientes) {
            System.out.println(ingrediente);
        }

    }

}
