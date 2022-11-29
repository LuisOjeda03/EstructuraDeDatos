package ejerciciosClase;

public class Pila implements Ipila
{
	private int tamanoActual;
	private int tamanoMaximo;
	private Nodo inicio;
	private Nodo fin;
	
	Pila()
	{
		this(9);
	}
	
	Pila(int tamanoMax)
	{
		tamanoMaximo = tamanoMax;
	}
	
	public boolean pilaLlena()
	{
		return tamanoActual == tamanoMaximo;
	}
	
	public boolean pilaVacia()
	{
		return tamanoActual == 0;
	}
	
	@Override
	public void agregar(Nodo nodo) 
	{
		if(!pilaLlena())
		{
			if(fin!=null)
			{
				fin.setSiguiente(nodo);
				fin = fin.getSiguiente(); // ?
			}
			else
			{
				inicio = nodo;
				fin = nodo;
			}
			tamanoActual++;
		}
		else
			System.out.println("Pila Llena");
	}
	
	@Override
	public void eliminar() 
	{
		if(!pilaVacia() || tamanoActual>1)
		{
			Nodo nodo = inicio;
			int contador = 0;
			
			while(nodo!=null)
			{
				if(nodo.getSiguiente()!=null)
					contador++;
				nodo = nodo.getSiguiente();
			}
			int max = 0;
			nodo = inicio;
			
			while(nodo !=null)
			{
				if(max == contador - 1)
				{
					fin = nodo;
					nodo.setSiguiente(null);
					tamanoActual--;
					max++;
				}
				else
				{
					nodo = nodo.getSiguiente();
					max++;
				}	
			}
		}
		if(tamanoActual==1)
		{
			inicio = null;
			fin = null;
		}
		if(tamanoActual==0)
			System.out.println("Pila Vacia");
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