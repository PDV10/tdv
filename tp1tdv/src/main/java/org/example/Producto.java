package org.example;

public abstract class Producto {
	static int nextID;
	int id;
	float precioUnitarioCompra;
	float precioUnitarioVenta;
	String nombre;

	public float getPrecioUnitarioCompra() {
		return precioUnitarioCompra;
	}

	public void setPrecioUnitarioCompra(float precioUnitarioCompra) {
		this.precioUnitarioCompra = precioUnitarioCompra;
	}

	public float getPrecioUnitarioVenta() {
		return precioUnitarioVenta;
	}

	public void setPrecioUnitarioVenta(float precioUnitarioVenta) {
		this.precioUnitarioVenta = precioUnitarioVenta;
	}

	public Producto(String nombre, float precioUnitarioCompra, float precioUnitarioVenta) {
		this.precioUnitarioCompra = precioUnitarioCompra;
		this.precioUnitarioVenta  = precioUnitarioVenta;
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract void despachar(int cantidad);

}