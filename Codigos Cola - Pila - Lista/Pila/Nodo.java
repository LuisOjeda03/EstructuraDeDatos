package ejerciciosClase;

public class Nodo 
{
	private Object dato;
	private Nodo nodoSiguiente;
	
	Nodo(Object objeto)
	{
		dato = objeto;
	}

	public Object getDato() 
	{
		return dato;
	}

	public void setDato(Object dato) 
	{
		this.dato = dato;
	}

	public Nodo getSiguiente() {
		return nodoSiguiente;
	}

	public void setSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
}