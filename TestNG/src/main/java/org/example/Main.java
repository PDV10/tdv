//package restaurant;
//
//public class Main {
//
//	public static void main(String[] args) {
//
//		Ingrediente huevo=new Ingrediente("huevo", "unidades",240);
//		Ingrediente harina=new Ingrediente("harina", "gramos",10000);
//	Ingrediente papa = new Ingrediente("Papa","gramos",20000);
//	Ingrediente sal = new Ingrediente("Sal","gramos",1000);
//	Ingrediente carnePicada = new Ingrediente("Carne picada","grmos",10000);
//	Ingrediente panHamburguesa = new Ingrediente("Pan de Hamburguesa","unidades",100);
//	Producto gaseosaCola = new ProductoBasico("Coca Cola", 10,20);
//	Producto agua = new ProductoBasico("Agua",10,22);
//	
//
//	
//	ItemReceta ir1= new ItemReceta(huevo,1);
//	ItemReceta ir2 = new ItemReceta(carnePicada, 100);
//	ItemReceta ir3 =new ItemReceta(sal, 20);
//	ItemReceta ir4 = new ItemReceta(huevo,4);
//	ItemReceta ir5 = new ItemReceta(papa, 3);
//	ItemReceta ir6 = new ItemReceta(panHamburguesa, 1);
//	
//
//	
//	Receta tortilla=new Receta("Tortilla",15);
//	tortilla.addIngrediente(ir4);
//	tortilla.addIngrediente(ir5);
//	
//	
//	Receta hamburguesa = new Receta("hamburguesa grande",5);
//	hamburguesa.addIngrediente(ir2);
//	hamburguesa.addIngrediente(ir1);
//	hamburguesa.addIngrediente(ir3);
//	hamburguesa.addIngrediente(ir6);
//	
//	Receta papasFritas = new Receta("papas fritas",7);	
//	papasFritas.addIngrediente(ir5);
//	papasFritas.addIngrediente(ir3);
//	
//	Usuario u1 =new Usuario("Homero Simpson", 0, 350, "homerojsimpson@springfield.com");
//	Usuario u2 =new Usuario("Barney Gomez", 0, 0, "el14gomez@springfield.com");
//	Usuario u3 =new Usuario("Edna Krabappel", 1, 0, "ednak@springfield.com");
//	Usuario u4 =new Usuario("Homero", 0, 0, "homerojsimpson@springfield.com");
//	
//	Producto p1= new ProductoBasico("Lata Coca Cola", 10, 20);
//	Producto p2= new ProductoBasico("Lata Sprite", 10, 22);
//	Producto p3= new ProductoElaborado("Retorti", 120);
//	((ProductoElaborado)p3).setReceta(tortilla);	
//	Producto p4= new ProductoElaborado("BIG O", 150);
//	((ProductoElaborado)p4).setReceta(hamburguesa);	
//	Producto p5= new ProductoElaborado("PATATAS", 120);
//	((ProductoElaborado)p3).setReceta(papasFritas);	
//
//	Mostrador m1= new Mostrador();
//	m1.setNombreOperador("Jose");
//	Mostrador m2= new Mostrador();
//	m2.setNombreOperador("Maria");
//	
//	
//	Cocina c= new Cocina();
//	//c.start();
//	
//	Pedido p= new Pedido();
//	p.setUsuario(u1);
//	p.agregarItem(new ItemPedido(1,p1));
//	p.agregarItem(new ItemPedido(1, p3));
//	try {
//		p.solicitarPedido();
//		
//		//Mostrador ordenesActuales = new Mostrador();
//		
//		//ordenesActuales.agregar(p);
//	
//		p.prepararPedido();
//		p.terminarPedido();
//		p.entregarPedido();
//
//		
//		
//	} catch (SinSaldoException ex) {
//		System.out.println("No posee saldo suficiente");
//	}
//	
//	System.out.println("Saldo Usuario "+u1.getSaldo());
//	}
//	
//
//}
