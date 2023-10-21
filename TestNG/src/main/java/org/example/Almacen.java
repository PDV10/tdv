package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Almacen {
	public static List<Consumible> Stock = new LinkedList<>();

	public static void IngresarConsumibles(Consumible cual, int cuanto) {
		cual.reponerStock(cuanto);

	}
	
	public static void ExtraerConsumibles(Consumible cual, int cuanto) {
		cual.consumirStock(cuanto);
	}
	
	public static boolean esPosibleCocinar(Receta r) {
		for(int i=0; i<r.ingredientes.size();i++) {
			ItemReceta item = r.getIngredientes().get(i);
			
			if (item.cantidad > item.getIngrediente().getStock())
				return false;
		}
		
		return true;
	}
	
}
