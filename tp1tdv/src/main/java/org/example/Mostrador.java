package org.example;
import java.util.ArrayList;
import java.util.List;

public class Mostrador {
	static List<Pedido> pedidos;
	String nombreOperador;

	public Mostrador() {
		super();
		if(pedidos==null) 
			pedidos= new ArrayList<Pedido>();
	}

	public  int agregarPedido(Pedido p)  {
		p.setEstado("ENCARGADO");
		pedidos.add(p);
		int id=Pedido.getNextID();
		p.setId(id);
		Pedido.setNextID(id+1);
		System.out.println("se ha generado el pedido con el id: "+id);
		return id;
	}
	
	public static void removerUltimoPedido() {
		pedidos.remove(pedidos.size()-1);
	}

	public void cobrarPedido(Pedido p) throws SinSaldoException {
		Usuario u = p.getUsuario();
		float saldo = u.getSaldo();
		
		if((saldo - p.totalPedido()) >= 0)
			System.out.println("Cobro pedido");
		else
			throw new SinSaldoException();
	}
	
	public static int getCantidadPedidos() {
		return pedidos.size();
	}

	public String getNombreOperador() {
		return nombreOperador;
	}

	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}
}   
