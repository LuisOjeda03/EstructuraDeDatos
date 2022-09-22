package primer_parcial;

import java.util.Scanner;

public class T4_E3CajasCamiones 
{
	public static int trasporteCajas(int cajas, int capacidad, int camiones)
	{
		if(cajas==0)
			return camiones;
		
		if(cajas>=capacidad)
		{
			cajas = cajas - capacidad;
			camiones++;
			return trasporteCajas(cajas,capacidad,camiones);
		}
		if(cajas>0 && cajas<=capacidad)
		{
			camiones++;
			return camiones;
		}
		
		return camiones;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int cajas = 0, capacidad = 0;
		System.out.print("Cajas a desplazar: ");
		cajas = sc.nextInt();
		System.out.print("Capacidad por camion (cajas): ");
		capacidad = sc.nextInt();
		System.out.println("Cantidad de camiones a ocupar: "+trasporteCajas(cajas, capacidad,0));
		
	}
}