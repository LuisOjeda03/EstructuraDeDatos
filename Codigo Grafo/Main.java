package Grafo;

import java.io.*;
import java.util.*;

public class Main {

	public static boolean processRequest(Scanner in, Grafo g)
	{
		try
		{
			System.out.println("Introduzca nodo inicial: ");
			String startName = in.nextLine();
			
			System.out.println("Introduzca nodo destino: ");
			String destName = in.nextLine();
			
			System.out.println("Introduzca algoritmo (u, d, n, a): ");
			String alg = in.nextLine();
			
			if(alg.equals("u"))
				g.unweighted(startName);
			else if(alg.equals("d"))
				g.dijkstra(startName);
			else if(alg.equals("n"))
				g.negative(startName);
			else if(alg.equals("a"))
				g.acyclic(startName);
			
			g.printPath(destName);	
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		catch(GraphException e)
		{
			System.err.println(e);
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Grafo g = new Grafo();
		
		try
		{
			FileReader fin = new FileReader("C:\\Users\\luiso\\OneDrive\\Escritorio\\GrafoArchivo.txt");
			Scanner graphFile = new Scanner(fin);
			
			String line;
			while(graphFile.hasNextLine())
			{
				line = graphFile.nextLine();
				StringTokenizer st = new StringTokenizer(line);
				
				try
				{
					if(st.countTokens()!=3)
					{
						System.err.println("Saltando error de linea "+line);
						continue;
					}
					String source = st.nextToken();
					String dest = st.nextToken();
					int cost = Integer.parseInt(st.nextToken());
					g.addEdge(source, dest, cost);
				}
				catch(NumberFormatException e)
				{
					System.err.println("Saltando error de linea "+line);
				}
			}
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
		System.out.println("Leyendo archivo... ");
		
		Scanner in = new Scanner(System.in);
		while(processRequest(in,g))
		{
			
		}

	}

}
