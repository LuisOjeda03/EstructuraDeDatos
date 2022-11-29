public class main {

	public static void main(String[] args)
	{
		Nodo n1 = new Nodo("Primer Nodo");
		Nodo n2 = new Nodo("Segundo Nodo");
		Nodo n3 = new Nodo(false);
		Nodo n4 = new Nodo(55);
		
		Cola cola = new Cola(2);
		cola.agregar(n1);
		cola.agregar(n2);
		cola.agregar(n3);
		cola.agregar(n4);
		
		cola.mostrar();
	}

}