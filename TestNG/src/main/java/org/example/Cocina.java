package org.example;

import java.util.List;

public class Cocina  extends Thread {
	static List<Pedido> pedidos;
	static public void setPedidos(List<Pedido> pedidos) {
		Cocina.pedidos=pedidos;
	}
	public void run() {
		while(true) {
			/*for(int i = 0; i<pedidos.size(); i++) {
			if(pedidos.)
		}
		if(pe)
			 */
			System.out.println("cocina");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void cocinar (Receta r) throws SinSuficientesIngredientesException {
		if(Almacen.esPosibleCocinar(r)) {
			for (ItemReceta item : r.getIngredientes())
				Almacen.ExtraerConsumibles(item.getIngrediente(), item.getCantidad());
		}
		else
			throw new SinSuficientesIngredientesException();
	}
}





