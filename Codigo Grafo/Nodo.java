package Grafo;

import java.util.*;

public class Nodo {

	public String nombre;
	public List<Vertice> adj;
	public double distancia;
	public Nodo anterior;
	public int scratch;
	
	public Nodo(String nombre)
	{
		this.nombre = nombre;
		adj = new LinkedList<Vertice>();
		reset();
	}
	
	public void reset()
	{
		distancia = Grafo.INFINITY;
		anterior = null;
		scratch = 0;
	}
}
