package org.example;

import java.util.ArrayList;
import java.util.List;

public class StockOld {
private static List<Consumible> stock;
public static void InitStock() {
	stock=new ArrayList<Consumible>();
	
}
/*public static void AgregarStock(Consumible p, int cantidad) {
	if(stock.indexOf(p)>=0)
		p.setStock(p.getStock()+cantidad);
	else {
			p.setStock(cantidad);
			stock.add(p);
	}
}
*/
public static void AgregarStock(Consumible consumible, int cantidad) {
	if(stock.indexOf(consumible)>=0)
		consumible.reponerStock(consumible.getStock()+cantidad);
	else {
			consumible.reponerStock(cantidad);
			stock.add(consumible);
	}
}
public static boolean comprobarSuficientesIngredientes(Receta r) {
	
	boolean completo = true;
/*	for(int i=0;i<r.getIngredientes().size(); i++) {
		Producto pAux = r.getIngredientes().get(i).getProducto();
		completo=completo & (pAux.getStock() < r.getIngredientes().get(i).getCantidad());
	}*/
	return completo;
}

public static void consumirIngredientes(Receta r) {
	System.out.println("Consumiendo stock");
	for(int i=0;i<r.getIngredientes().size(); i++) {
		//Consumible pAux = r.getIngredientes().get(i).getProducto();
		//pAux.consumirStock(r.getIngredientes().get(i).getCantidad());
	}
	
}



	public static void consumirIngredientes(Consumible consumible , int cantidad) throws SinSuficientesIngredientesException {
		if(consumible.getStock()-cantidad < 0) {
			throw new SinSuficientesIngredientesException();
		} else consumible.consumirStock(cantidad);//setStock(consumible.getStock()-cantidad);
	}

}




