public class Cola implements ICola
{
	private Nodo inicio;
	private Nodo fin;
	private int tamanoActual;
	private int tamanoMaximo;
	
	public Cola(int tamanoMaximo)
	{
		this.tamanoMaximo = tamanoMaximo;
	} 
	
	@Override
	public Nodo eliminar(Object objeto) 
	{
		return null;
	}

	@Override
	public boolean estaVacia() 
	{
		return tamanoActual==0;
	}

	@Override
	public boolean estaLlena() 
	{
		return tamanoActual == tamanoMaximo;
	}

	@Override
	public boolean agregar(Nodo n) 
	{
		if(!estaLlena())
		{
			if(fin!=null)
			{
				fin.setSiguiente(n);
				fin = fin.getSiguiente(); // O fin = n;
			}
			else
			{
				inicio = n;
				fin = n;
			}
			tamanoActual++;
			return true;
		}
		return false;
	}

	@Override
	public void mostrar() 
	{
		Nodo nodo = inicio;
		int contador = 0;
		while(nodo != null)
		{
			System.out.println("Nodo: "+ ++contador);
			System.out.println(nodo.getDato());
			nodo = nodo.getSiguiente();
		}
	}
}