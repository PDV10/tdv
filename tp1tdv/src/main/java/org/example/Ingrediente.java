package org.example;

public class Ingrediente implements Consumible{
	String nombre;
	String unidad;
	int cantidad;
	float precioCompra;

	public Ingrediente (String nombreIngrediente,String unidadDeMedida,int stockInicial, float precioCompra ) {
		this.nombre=nombreIngrediente;
		this.unidad=unidadDeMedida;
		this.cantidad=stockInicial;
		this.precioCompra = precioCompra;
	}

	public Ingrediente (String nombreIngrediente,String unidadDeMedida,int stockInicial ) {
		this.nombre=nombreIngrediente;
		this.unidad=unidadDeMedida;
		this.cantidad=stockInicial;
		this.precioCompra = 0;
	}

	public void consumirStock(int cantidad) {
		this.cantidad-=cantidad;
	}

	public void reponerStock(int cantidad) {

		this.cantidad+=cantidad;
	}

	public int getStock() {
		return cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public float getPrecioCompra() {
		return this.precioCompra;
	}

}
