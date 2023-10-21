package org.example;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	static int nextID=0;

	List<ItemPedido> items;
	Usuario usuario;
	String estado;
	int id;
	public Pedido() {
		super();
		items = new ArrayList<ItemPedido>();
		this.items = items;
		this.usuario = usuario;
	}
	public static int getNextID() {
		return nextID;
	}

	public static void setNextID(int nextID) {
		Pedido.nextID = nextID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido(List<ItemPedido> items, Usuario usuario) {
		super();
		this.items = items;
		this.usuario = usuario;
		estado=null;
	}

	public void agregarItem(ItemPedido item) {
		if(estado==null)
			estado="ABIERTO";
		items.add(item);
		System.out.println("Item agregado "+item.toString());
	}

	void eliminarItem(ItemPedido item) {
		items.remove(item);
	}
	public float totalPedido() {
		float  acum=0.0f;
		for(int i = 0;i<items.size();i++) {
			ItemPedido item = items.get(i);
			
			acum += (item.getCantidad()) * (item.getItem().getPrecioUnitarioVenta());
		}
		
		return acum;
	}

	public float getCostoDelPedido() {
		float  acum=0.0f;
		for(int i = 0;i<items.size();i++) {
			ItemPedido item = items.get(i);

			acum += (item.getCantidad()) * (item.getItem().getPrecioUnitarioCompra());
		}

		return acum;
	}

	void solicitarPedido() throws SinSaldoException{
		float total=totalPedido();
		this.getUsuario().descontarSaldo(total);
		this.setEstado("Pagado");
		System.out.println("Pedido pagado...");
	}


	void prepararPedido() {
		this.setEstado("En preparación");
		System.out.println("Pedido aceptado en cocina... Cocinandose...");
		for(int i=0;i<getItems().size();i++) {
			//	this.getItems().get(i).getConsumible().preparar();
		}
	}

	void terminarPedido() {
		this.setEstado("Listo para entregar");
		System.out.println("Pedido listo para entregar...");
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void entregarPedido() {
		this.setEstado("Entregado");
	}

}
