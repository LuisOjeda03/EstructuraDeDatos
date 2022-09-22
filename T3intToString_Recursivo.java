package primer_parcial;

import java.util.Scanner;

/* Convertir un dato entero (int) a su representacion 
 * en cadena de caracteres (String) utilizando un metodo recursivo.
 */
public class T3intToString_Recursivo 
{
	public static String intToString(int num, int digitos, int cont)
	{
		if(num<0)
			return num +"";
		
		if(cont<=digitos)
		{
			int digito = num%10;
			cont++;
			
			return intToString(num/10, digitos, cont) + ""+digito;
		}
		return "";
	}
	
	public static void main(String[] args) 
	{
		int num = 0, cont = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Ingrese un numero a convertir: ");
		num = sc.nextInt();
		int digitos = (int)(Math.log10(num));
		System.out.println("Resultado en caracteres: "+intToString(num, digitos, cont));
	}

}