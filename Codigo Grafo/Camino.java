package Grafo;

public class Camino implements Comparable<Camino>{

	public Nodo dest;
	public double costo;
	
	public Camino(Nodo d, double c)
	{
		dest = d;
		costo = c;
	}
	
	public int compareTo(Camino rhs) {
		
		double otherCost = rhs.costo;
		return costo<otherCost ? -1 : costo> otherCost ? 1 : 0;
	}
}
