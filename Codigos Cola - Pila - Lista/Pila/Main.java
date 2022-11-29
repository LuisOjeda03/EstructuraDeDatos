package ejerciciosClase;

public class Main {

	public static void main(String[] args) 
	{
		Nodo n1 = new Nodo("CAJA 1");
		Nodo n2 = new Nodo("CAJA 2");
		Nodo n3 = new Nodo("CAJA 3");
		Nodo n4 = new Nodo("CAJA 4");
		Nodo n5 = new Nodo("CAJA 5");
		
		Pila pila = new Pila();
		
		pila.agregar(n1);
		pila.agregar(n2);
		pila.agregar(n3);
		pila.agregar(n4);
		pila.agregar(n5);
		
		pila.mostrar();
		
		/*
		System.out.println("------- ELIMINAR ------");
		System.out.println();
		pila.eliminar();
		
		System.out.println("------- MOSTRAR ------");
		System.out.println();
		pila.mostrar();
		System.out.println("");
		System.out.println("------- AGREGAR ------");
		pila.agregar(n4);
		pila.mostrar();
		System.out.println("------- ELIMINAR 2 ------");
		pila.eliminar();
		pila.eliminar();
		pila.mostrar();
		System.out.println("------- AGREGAR 1 ------");
		pila.agregar(n3);
		pila.mostrar();
		*/
		
	}
	// tinyurl.com/MarioRios

}