package ABB;

public class Main 
{

	public static void main(String[] args) 
	{
		ABB arbol = new ABB(new Nodo(8));
		
		Nodo n2 = new Nodo(3);
		Nodo n3 = new Nodo(9);
		Nodo n4 = new Nodo(5);
		Nodo n5 = new Nodo(4);
		Nodo n6 = new Nodo(6);
		Nodo n7 = new Nodo(11);
		Nodo n8 = new Nodo(20);
		Nodo n9 = new Nodo(10);
		
		arbol.agregar(n2);
		arbol.agregar(n3);
		arbol.agregar(n4);
		arbol.agregar(n5);
		arbol.agregar(n6);
		arbol.agregar(n7);
		arbol.agregar(n8);
		arbol.agregar(n9);
		
		arbol.imprimir();
		System.out.println();
		arbol.buscarRecursivo(20);
		System.out.println();
		arbol.eliminar(10);
		arbol.imprimir();
		System.out.println("FIN");
	}

}