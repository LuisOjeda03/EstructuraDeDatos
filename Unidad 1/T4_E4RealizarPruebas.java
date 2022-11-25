package primer_parcial;

import java.util.Scanner;

// Realice 2 pruebas de escritorio de la siguiente funcion recursiva.
// Con los numeros 15 y 20

public class T4_E4RealizarPruebas 
{
	public static int misterio(int n)
	{
		if(n==1 || n==0)
			return n;
		else
			return 10*misterio(n/2)+n%2;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int num = 0;
		System.out.print("Ingrese un numero: ");
		num = sc.nextInt();
		System.out.println("Resultado: "+misterio(num));
		/*
		 *  Resultados:
		 *  La funcion recibe un numero decimal, y lo convierte a binario.
		 *  
		 *  No. 		Resultado Binario
		 *  15				   1111
		 *  20 				   10100
		 *  
		 *  Comprobacion
		 *  
		 *  No.			16	8	4	2	1
		 *  15				1	1	1	1
		 *  20			1	0	1	0	0
		 */
	}

}
