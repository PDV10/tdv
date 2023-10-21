package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RecetaTest {

    @Test
    @DisplayName("f. No es posible realizar una receta si no se cuenta con todos los ingredientes ")
    void contieneTodosLosIngredientes(){
        Ingrediente huevo = new Ingrediente("huevo", "unidades", 10);
        Ingrediente carnePicada = new Ingrediente("Carne picada", "gramos", 10000);
        Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa", "unidades", 10);

        Receta receta = new Receta("burga", 10, 1000);
        receta.addIngrediente(new ItemReceta(huevo,2));
        receta.addIngrediente(new ItemReceta(carnePicada,2));
        receta.addIngrediente(new ItemReceta(panHamburguesa,2));

        List<ItemReceta> ingredientes = receta.getIngredientes();

        for (ItemReceta ingrediente : ingredientes) {
            Assert.assertTrue("No hay Stock suficiente", ingrediente.getCantidad() < ingrediente.getIngrediente().getStock());
        }
    }
}
