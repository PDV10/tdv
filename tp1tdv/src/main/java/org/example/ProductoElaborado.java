package org.example;

import java.util.List;

public class ProductoElaborado extends Producto {

Receta receta;
public Receta getReceta() {
	return receta;
}

public void setReceta(Receta receta) {
	this.receta = receta;
}

public String getNombreComercial() {
	return nombreComercial;
}

public void setNombreComercial(String nombreComercial) {
	this.nombreComercial = nombreComercial;
}

public int getTiempoDeCoccion() {
	return tiempoDeCoccion;
}

public void setTiempoDeCoccion(int tiempoDeCoccion) {
	this.tiempoDeCoccion = tiempoDeCoccion;
}

String nombreComercial;
int tiempoDeCoccion;

	public ProductoElaborado(String nombre,float precioUnitarioVenta) {
		super(nombre, 0, precioUnitarioVenta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void despachar(int cantidad) {
		Receta r = this.getReceta();
		for(int i= 0;i<r.getIngredientes().size();i++) {
			ItemReceta ingredienteActual = r.getIngredientes().get(i);
			Almacen.ExtraerConsumibles(ingredienteActual.getIngrediente(), ingredienteActual.getCantidad()*cantidad);
		}

	}
	public String toString() {
		return nombre;
	}

}
