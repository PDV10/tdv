package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    @DisplayName("b. No se puede crear un usuario con un correo electrónico inválido (contiene @) ")
    void TestCorreoElectronico() throws SinSaldoException{
        Usuario pato = new Usuario("pato", 0, 1350, "patogmail.com");

        Assert.assertTrue(pato.getEmail().contains("@"));
    }

    @Test
    @DisplayName("d. Un pedido reduce en saldo de un usuario ")
    void SeReduceElSaldoDelUsuario(){
        Usuario pato = new Usuario("pato", 0, 2350, "patogmail.com");

        Producto cocucha = new ProductoBasico("cocucha", 800,0);
        Producto papitas = new ProductoBasico("papitas", 650,0);

        Pedido pedido = new Pedido();
        pedido.setUsuario(pato);
        pedido.agregarItem(new ItemPedido(1,cocucha));
        pedido.agregarItem(new ItemPedido(1,papitas));

        float saldoAnterior = pato.getSaldo();


        try {
            pedido.solicitarPedido();

            //ordenesActuales.agregar(pedido);
            pedido.prepararPedido();
            pedido.terminarPedido();
            pedido.entregarPedido();
        } catch (SinSaldoException e) {
            throw new RuntimeException(e);
        }
        float saldoActual = pato.getSaldo();
        System.out.println("Total del pedido: " + pedido.totalPedido());
        System.out.println("Saldo anterior: " + saldoAnterior);
        System.out.println("Saldo actual: " + saldoActual);

        Assert.assertEquals("No se descuenta Saldo al usuario" + saldoAnterior,saldoActual);

    }
}
