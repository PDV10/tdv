package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AlmacenTest {
    Ingrediente defaultIngrediente;
    //	static Ingrediente ingATestear[];
    static List<Ingrediente> ingATestear;

    static Mostrador mostrador = new Mostrador();

    static Producto gaseosaCola = new ProductoBasico("Coca Cola", 10, 20);
    static Producto agua = new ProductoBasico("Agua", 10, 22);
    static  Producto producto1 = new ProductoBasico("Lata Coca Cola", 10, 20);
    static Producto producto2 = new ProductoBasico("Lata Sprite", 10, 22);

    @BeforeAll
    static void InitClass() {
        ingATestear = new ArrayList<Ingrediente>();
        Ingrediente huevo = new Ingrediente("huevo", "unidades", 240);
        Ingrediente harina = new Ingrediente("harina", "gramos", 10000);
        Ingrediente papa = new Ingrediente("Papa", "gramos", 20000);
        Ingrediente sal = new Ingrediente("Sal", "gramos", 1000);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "grmos", 10000);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 100);

        /**
         * item recetas
         */
        ItemReceta ir1 = new ItemReceta(huevo, 1);
        ItemReceta ir2 = new ItemReceta(carnePicada, 100);
        ItemReceta ir3 = new ItemReceta(sal, 20);
        ItemReceta ir4 = new ItemReceta(huevo, 4);
        ItemReceta ir5 = new ItemReceta(papa, 3);
        ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);


        /**
         * Recetas
         */
        Receta tortilla = new Receta("Tortilla", 15);
        tortilla.addIngrediente(ir4);
        tortilla.addIngrediente(ir5);

        Receta hamburguesa = new Receta("hamburguesa grande", 5);
        hamburguesa.addIngrediente(ir2);
        hamburguesa.addIngrediente(ir1);
        hamburguesa.addIngrediente(ir3);
        hamburguesa.addIngrediente(ir6);

        Receta papasFritas = new Receta("papas fritas", 7);
        papasFritas.addIngrediente(ir5);
        papasFritas.addIngrediente(ir3);

        /**
         * Usuarios
         */
        Usuario usuario1 = new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
        Usuario usuario2 = new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
        Usuario usuario3 = new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
        Usuario usuario4 = new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");

        /**
         *  productos
         */

        Producto producto3 = new ProductoElaborado("Retorti", 120);
        ((ProductoElaborado) producto3).setReceta(tortilla);
        Producto producto4 = new ProductoElaborado("BIG O", 150);
        ((ProductoElaborado) producto4).setReceta(hamburguesa);
        Producto producto5 = new ProductoElaborado("PATATAS", 120);
        ((ProductoElaborado) producto3).setReceta(papasFritas);


        mostrador.setNombreOperador("Jose");
        Mostrador m2 = new Mostrador();
        m2.setNombreOperador("Maria");

        Cocina cocina= new Cocina();
        //cocina.start();

        Pedido pedido1= new Pedido();
        pedido1.setUsuario(usuario1);
        pedido1.agregarItem(new ItemPedido(1,producto1));
        pedido1.agregarItem(new ItemPedido(1, producto3));
        try {
		    pedido1.solicitarPedido();

            //Mostrador ordenesActuales = new Mostrador();

            //ordenesActuales.agregar(pedido);
            pedido1.prepararPedido();
            pedido1.terminarPedido();
            pedido1.entregarPedido();

        } catch (SinSaldoException ex) {
            System.out.println("No posee saldo suficiente");
        }
        System.out.println("Saldo Usuario "+usuario1.getSaldo());
    }

//    @BeforeEach
//    void setUp() throws Exception {
//        int cualTomamos = (int) (Math.random() * ingATestear.size());
//        defaultIngrediente = AlmacenTest.ingATestear.get(cualTomamos);
//    }
//
//    @AfterEach
//    void tearDown() throws Exception {
//    }

//    @RepeatedTest(15)
//    void testIngresarConsumibles() {
//
//        System.out.println(defaultIngrediente.toString());
//        int cantidadInicial = defaultIngrediente.getStock();
//        int cantidadAgregada = (int) (Math.random() * 100);
//        /** Me aseguro que el stock se esta actualizando bien*/
//        Almacen.IngresarConsumibles(defaultIngrediente, cantidadAgregada);
//        assertEquals(cantidadInicial + cantidadAgregada, defaultIngrediente.getStock());
//    }
//

//    @Test
//    void testExtraerConsumibles() {
//        fail("Not yet implemented");
//    }


//    @TestFactory
//    Stream<DynamicTest> dynamicTestIngredientes() {
//    return AlmacenTest.ingATestear.stream()
//            .map(dom -> DynamicTest.dynamicTest("Testing: " + dom, () -> {
//                int cantidadInicial = dom.getStock();
//                int cantidadAgregada = (int) (Math.random() * 100);
//                Almacen.IngresarConsumibles(dom, cantidadAgregada);
//                assertEquals(cantidadAgregada + cantidadInicial, dom.getStock());
//            }));
//    }

   /* @Test
    void TestUsuarioRealizoPedido(){

        Usuario pato = new Usuario("pato", 0, 1350, "pato@gmail.com");
        Usuario jere = new Usuario("jere", 0, 1350, "pato@gmail.com");

        Pedido p1 = new Pedido();
        p1.agregarItem(new ItemPedido(1,producto1));
        p1.agregarItem(new ItemPedido(1,producto2));
        p1.setUsuario(pato);

        Pedido p2 = new Pedido();
        p2.agregarItem(new ItemPedido(1,agua));
        p2.agregarItem(new ItemPedido(1,gaseosaCola));
        p2.setUsuario(pato);

        mostrador.agregarPedido(p1);
        int cantPedidos = Mostrador.getCantidadPedidos();
        mostrador.agregarPedido(p2);
        int cantPedidos2 = Mostrador.getCantidadPedidos();

        System.out.println(cantPedidos + "  -------  " + cantPedidos2);

        Assert.assertEquals(cantPedidos,cantPedidos2);
    }*/


    @Test
    void  RecetaConMasDeUnIngrediente(){
        Receta receta = new Receta("test", 1);
        /*Ingrediente ingrediente = new Ingrediente("ingrediente", "unidades", 100);
        ItemReceta ir1 = new ItemReceta(ingrediente, 1);

        receta.addIngrediente(ir1);*/

        Assert.assertTrue("Error la receta no contiene ingredientes",receta.getIngredientes().size() > 0);

    }

}