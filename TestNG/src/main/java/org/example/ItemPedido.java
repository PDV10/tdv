package org.example;

public class ItemPedido {
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	int cantidad;
	Producto item;
	String estado;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ItemPedido(int cantidad, Producto item) {
		super();
		this.cantidad = cantidad;
		this.item = item;
	}
	public Producto getItem() {
		return item;
	}
	public void setItem(Producto item) {
		this.item = item;
	}
	public void encargar() throws SinSuficientesIngredientesException {



	}


	public void despachar() {
		this.getItem().despachar(this.getCantidad());
	}
	public String toString() {

		String s=String.valueOf(cantidad)+" x "+item.toString();
		return s;
	}
}
