
public interface ICola 
{
	public boolean estaVacia();
	public boolean estaLlena();
	public boolean agregar(Nodo n);
	public Nodo eliminar(Object o);
	
	// TODO
	// public Nodo buscar(Nodo n);
	// public Nodo buscar(int indice);
	
	// Solo para imprimir los elementos existentes
	public void mostrar();
	
	/*
	Nodo eliminar(Object objeto);
	Nodo eliminar(int indice);
	Boolean agregar(Nodo n);
	Boolean estaLlena();
	Boolean estaVacia();
	Nodo buscar(int indice);
	Object buscar(Object o);
	Nodo buscar(Nodo o);
	int tamanoActual();
	int tamanoMaximo();
	*/
}