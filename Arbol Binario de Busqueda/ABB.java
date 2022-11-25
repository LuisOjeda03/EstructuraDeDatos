package ABB;

// Arbol binario de busqueda
public class ABB 
{
	private Nodo raiz;

	public ABB(Nodo raiz)
	{
		this.raiz = raiz;
	}
	
	public Nodo getRaiz() 
	{
		return raiz;
	}

	public void setRaiz(Nodo raiz) 
	{
		this.raiz = raiz;
	}
	
	public void agregar(int dato)
	{
		agregar(new Nodo(dato));
	}
	
	public void agregar(Nodo n)
	{
		if(raiz == null)
		{
			raiz = n;
		}
		else
		{
			agregar(n,raiz);
		}
	}
	
	private void agregar(Nodo n, Nodo actual)
	{
		if(actual.getDato() > n.getDato())
		{
			if(actual.getIzquierdo()!=null)
			{
				agregar(n, actual.getIzquierdo());
			}
			else
			{
				 actual.setIzquierdo(n);
			}
		}
		else
		{
			if(actual.getDerecho()!=null)
			{
				agregar(n, actual.getDerecho());
			}
			else
			{
				actual.setDerecho(n);
			}
		}
		
	}
	
	// metodo reemplazar
	public Nodo nodoReemplazo(Nodo nodoR)
	{
		Nodo rempPadre = nodoR;
		Nodo reemplazo = nodoR;
		Nodo temp = nodoR.getDerecho();
		
		while(temp!=null)
		{
			rempPadre = reemplazo;
			reemplazo = temp;
			temp = temp.getIzquierdo();
		}
		if(reemplazo!=nodoR.getDerecho())
		{
			rempPadre.setIzquierdo(reemplazo.getDerecho());
			reemplazo.setDerecho(nodoR.getDerecho());
		}
		
		return reemplazo;
	}
	
	public boolean eliminar(int dato)
	{
		Nodo temp = raiz;
		Nodo padre = raiz;
		boolean hijoIzquierdo = true;
		
		while(temp.getDato()!=dato)
		{
			padre = temp;
			if(dato<temp.getDato())
			{
				hijoIzquierdo = true;
				temp = temp.getIzquierdo();
			}
			else
			{
				hijoIzquierdo = false;
				temp = temp.getDerecho();
			}
			if(temp == null)
			{
				return false;
			}
		} // Fin de while
		if(temp.getIzquierdo()==null && temp.getDerecho()==null)
		{
			if(temp==raiz)
			{
				raiz = null;
			}
			else if(hijoIzquierdo)
			{
				padre.setIzquierdo(null);
			}
			else
			{
				padre.setDerecho(null);
			}
				
		}
		else if(temp.getDerecho()==null)
		{
			if(temp==raiz)
			{
				raiz = temp.getIzquierdo();
			}
			else if(hijoIzquierdo)
			{
				padre.setIzquierdo(temp.getIzquierdo());
			}
			else
			{
				padre.setDerecho(temp.getIzquierdo());
			}
				
		}
		else if(temp.getIzquierdo()==null)
		{
			if(temp==raiz)
			{
				raiz = temp.getDerecho();
			}
			else if(hijoIzquierdo)
			{
				padre.setIzquierdo(temp.getDerecho());
			}
			else
			{
				padre.setDerecho(temp.getDerecho());
			}
		}
		else
		{
			Nodo reemplazo = nodoReemplazo(temp);
			
			if(temp==raiz)
			{
				raiz = reemplazo;
			}
			else if(hijoIzquierdo)
			{
				padre.setIzquierdo(reemplazo);
			}
			else
			{
				padre.setDerecho(reemplazo);
			}
			reemplazo.setIzquierdo(temp.getIzquierdo()); // IMPORTANTE
		}
		return true;
	}
	
	
	
	public void imprimir()
	{
		imprimeArbol(raiz);
	}
	
	private void imprimeArbol(Nodo n)
	{
		if(n!=null)
		{
			System.out.println(n.getDato());
			imprimeArbol(n.getDerecho());
			imprimeArbol(n.getIzquierdo());
			
		}
	}
	
	public void buscar(int dato)
	{
		buscarNodo(dato);
	}
	
	private Nodo buscarNodo(int dato)
	{
		Nodo actual = raiz;
		while(actual!=null && actual.getDato()!=dato)
		{
			if(actual.getDato()>dato)
				actual = actual.getIzquierdo();
			else
				actual = actual.getDerecho();
		}
		return actual;
	}
	
	public void buscarRecursivo(int dato)
	{
		Nodo actual = raiz;
		buscarNodoRecursivo(dato,actual);
	}
	
	private Nodo buscarNodoRecursivo(int dato, Nodo actual)
	{
		while(actual!=null && actual.getDato()!=dato)
		{
			if(actual.getDato()>dato)
				return buscarNodoRecursivo(dato,actual.getIzquierdo());
			else
				return buscarNodoRecursivo(dato,actual.getDerecho());
		}
		System.out.println(actual.toString());
		return actual;
	}
	
}