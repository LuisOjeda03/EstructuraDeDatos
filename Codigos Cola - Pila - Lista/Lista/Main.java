package clase;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main 
{

	public static void main(String[] args) 
	{
		ArrayList array = new ArrayList<Integer>();
		array.add(new Integer(15));
		array.add(25);
		array.add("30");
		
		int cantidad = array.size();
		
		for(int x = 0; x < cantidad; x++)
		{
			System.out.println(array.get(x));
		}
		System.out.println("---------------");
		for (Object object : array) 
		{
			System.out.println(object);
		}
		System.out.println("---------------");
		LinkedList listaL = new LinkedList<Integer>();
		listaL.add(new Integer(15));
		listaL.add(25);
		listaL.add("30");
		for (Object object : listaL) {
			System.out.println(object);
		}

	}

}