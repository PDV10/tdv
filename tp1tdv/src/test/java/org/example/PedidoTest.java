package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    @Test
    @DisplayName("e. La venta de productos o elaboración de estos dejan una ganancia mayor al 20% ")
    void GanaciasMayoresAl20(){
        Producto pepsi = new ProductoBasico("pepsi", 800,1000);
        Producto doritos = new ProductoBasico("doritos", 650,850);

        Pedido pedido = new Pedido();
        pedido.agregarItem(new ItemPedido(1,pepsi));
        pedido.agregarItem(new ItemPedido(1,doritos));

        float costoPedido = pedido.getCostoDelPedido();
        float totalPedido = pedido.totalPedido();

        float ganancia = totalPedido - costoPedido;
        float porcentaje = costoPedido * 20 / 100;

        System.out.println("costo : "+ costoPedido);
        System.out.println("total : "+ totalPedido);
        System.out.println("ganancia : "+ ganancia);
        System.out.println("dinero necesario para generar ganancias: "+ porcentaje);

        Assert.assertFalse("las ganancias no superan el 20%", ganancia < porcentaje );
    }
}
