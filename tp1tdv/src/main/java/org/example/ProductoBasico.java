package org.example;

public class ProductoBasico extends Producto implements Consumible {

	public ProductoBasico(String nombre, float precioUnitarioCompra, float precioUnitarioVenta) {
		super(nombre, precioUnitarioCompra, precioUnitarioVenta);

	}


	@Override
	public void consumirStock(int cantidad) {


	}

	@Override
	public void reponerStock(int cantidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getStock() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String toString() {
		return nombre;
	}

	//@Override
	public void despachar(int cantidad) {
		Almacen.ExtraerConsumibles(this, cantidad);

	}


	@Override
	public float getPrecioCompra() {
		return this.precioUnitarioCompra;
	}
}
