package primer_parcial;

import java.util.Scanner;

// Realice una funcion recursiva que reciba un numero como parametro y devuelva su digito minimo.
// Ejemplo: parametro retorno
//			  3154		 1

public class T4_E2DigitoMin 
{
	
	public static int digitoMenor(int n, int menor, int digitos, int cont)
	{	
		// Si la cantidad de digitos es menor a 1 regresa n
		if(digitos<1)
			return n;
		
		// Si el contador es menor o igual a la cantidad de digitos entra
		if(cont<=digitos)
		{
			// Toma el ultimo digito
			int ultDig = n%10;
			
			// Se divide entre 10 para recortar el entero
			n = n / 10;
			
			// Comprobacion si ultimo digito es menor que el anterior
			if(ultDig<menor)
				menor = ultDig;
			
			cont++;
			return digitoMenor(n,menor,digitos,cont);
		}
		
		// Regresa el dato menor
		return menor;
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int numero = 0, cont = 0;
		System.out.print("Introduce un numero: ");
		numero = sc.nextInt();
		
		// digitos toma la longitud de caracteres
		int digitos = (int)(Math.log10(numero));
		System.out.println("Digito Menor: "+digitoMenor(numero,100,digitos,cont));
	}

}