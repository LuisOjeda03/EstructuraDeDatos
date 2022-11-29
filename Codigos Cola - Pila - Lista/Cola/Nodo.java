
public class Nodo 
{
	private Nodo siguiente;
	private Object dato;
	
	public Nodo(Object dato)
	{
		this.setDato(dato);
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Object getDato() {
		return dato;
	}

	public void setDato(Object dato) {
		this.dato = dato;
	}
	
	
	
}