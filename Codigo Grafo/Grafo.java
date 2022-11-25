package Grafo;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Grafo {
	
	public static final double INFINITY = Double.MAX_VALUE;
	
	public void addEdge(String sourceName, String destName, double costo)
	{
		Nodo n = getNodo(sourceName);
		Nodo n2 = getNodo(destName);
		n.adj.add(new Vertice(n2, costo));
	}
	
	public void printPath(String destName)
	{
		Nodo w = vertexMap.get(destName);
		if(w==null)
			throw new NoSuchElementException();
		else if(w.distancia == INFINITY)
			System.out.println(destName + " es inalcanzable");
		else
		{
			System.out.println("(El costo es: "+w.distancia+" )");
			printPath(w);
			System.out.println();
		}
	}
	
	public void unweighted(String startName)
	{
		clearAll();
		
		Nodo start = vertexMap.get(startName);
		if(start == null)
			throw new NoSuchElementException("Nodo inicial no encontrado");
		
		Queue<Nodo> q = new LinkedList<Nodo>();
		q.add(start);
		start.distancia=0;
		
		while(!q.isEmpty())
		{
			Nodo v = q.remove();
			
			for(Vertice e: v.adj)
			{
				Nodo w = e.dest;
				
				if(w.distancia==INFINITY)
				{
					w.distancia = v.distancia +1;
					w.anterior = v;
					q.add(w);
				}
			}
		}
	}
	
	public void dijkstra(String startName)
	{
		PriorityQueue<Camino> pq = new PriorityQueue<Camino>();
		
		Nodo start = vertexMap.get(startName);
		if(start==null)
			throw new NoSuchElementException("Nodo inicial no encontrado");
		
		clearAll();
		pq.add(new Camino(start,0));
		start.distancia = 0;
		
		int nodesSeen = 0;
		while(!pq.isEmpty() && nodesSeen < vertexMap.size())
		{
			Camino vrec = pq.remove();
			Nodo v = vrec.dest;
			if(v.scratch!=0)
				continue;
			
			v.scratch = 1;
			nodesSeen++;
			
			for(Vertice e : v.adj)
			{
				Nodo w = e.dest; // ERROR
				double cvw = e.costo;
				
				if(cvw < 0)
					throw new GraphException("El graf otiene vertices negativos");
				
				if(w.distancia > v.distancia + cvw)
				{
					w.distancia = v.distancia + cvw;
					w.anterior = v;
					pq.add(new Camino(w, w.distancia));
				}
			}
		}
	}
	
	public void negative(String startName)
	{
		clearAll();
		
		Nodo start = vertexMap.get(startName);
		if(start==null)
			throw new NoSuchElementException("Nodo inicial no encontrado");
		
		Queue<Nodo> q = new LinkedList<Nodo>();
		q.add(start);
		start.distancia =- 0;
		start.scratch++;
		
		while(!q.isEmpty())
		{
			Nodo v = q.remove();
			if(v.scratch++ > 2 * vertexMap.size())
				throw new GraphException("Cliclo negativo detectado");
			
			for(Vertice e: v.adj)
			{
				Nodo w = e.dest;
				double cvw = e.costo;
				
				if(w.distancia > v.distancia + cvw)
				{
					w.distancia = v.distancia + cvw;
					w.anterior = v;
					
					if(w.scratch++ % 2 == 0)
					{
						q.add(w);
					}
					else
						w.scratch--;
				}
			}
		}
	}
	
	public void acyclic(String startName)
	{
		Nodo start = vertexMap.get(startName);
		if(start == null)
			throw new NoSuchElementException("Nodo inicial no encontrado");
		clearAll();
		
		Queue<Nodo> q = new LinkedList<Nodo>();
		start.distancia = 0;
		
		Collection<Nodo> vertexSet = vertexMap.values();
		for(Nodo v: vertexSet)
		{
			for(Vertice e: v.adj)
			{
				e.dest.scratch++;
			}
		}
		
		for(Nodo v: vertexSet)
		{
			if(v.scratch==0)
				q.add(v); 
		}
		
		int iterations;
		for(iterations = 0; !q.isEmpty(); iterations++)
		{
			Nodo v = q.remove();
			
			for(Vertice e: v.adj)
			{
				Nodo w = e.dest;
				double cvw = e.costo;
				
				if(--w.scratch==0)
				{
					q.add(w);
				}
				
				if(v.distancia==INFINITY)
				{
					continue;
				}
				
				if(w.distancia> v.distancia + cvw)
				{
					w.distancia = v.distancia + cvw;
					w.anterior = v;
				}
			}
		}
		
		if(iterations!= vertexMap.size())
		{
			throw new GraphException("El grafo tiene un ciclo");
		}
		
	}
	
	private Nodo getNodo(String vertexName)
	{
		Nodo n = vertexMap.get(vertexName);
		if(n==null)
		{
			n = new Nodo(vertexName);
			vertexMap.put(vertexName, n);
		}
		return n;
	}
	
	private void printPath(Nodo dest)
	{
		if(dest.anterior != null)
		{
			printPath(dest.anterior);
			System.out.println(" a ");
		}
		System.out.println(dest.nombre);
	}
	
	private void clearAll()
	{
		for(Nodo n : vertexMap.values())
		{
			n.reset();
		}
	}
	
	private Map<String,Nodo>vertexMap = new HashMap<String,Nodo>();
}
