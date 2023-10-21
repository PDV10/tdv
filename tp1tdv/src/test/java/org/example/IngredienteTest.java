package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

public class IngredienteTest {

    @Test
    @DisplayName("g- La reposición de stock aumenta el número de ítems disponibles. ")
    void SeReponeStock(){
        Ingrediente ingrediente = new Ingrediente("ingrediente", "unidades", 240);

        int StockInicial = ingrediente.getStock();
        int cantReponer = 0;
        if(cantReponer > 0){
            ingrediente.reponerStock(cantReponer);
        }else {
            System.out.println("error la cantidad a reponer no puede ser negativa");
        }

        int StockActual = ingrediente.getStock();

        Assert.assertTrue("No se repuso stock correctamente", StockInicial < StockActual);

    }

}
