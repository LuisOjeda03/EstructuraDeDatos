package primer_parcial;

import java.util.Scanner;

public class T4_E5NumBinarioDecimal 
{

	public static int convertDecimal(int binario, int digitos, int cont, int resultado)
	{
		if(binario<0)
			return 0;
		
		if(cont<=digitos)
		{			
			int digito = binario%10;
			binario = binario/10;
			int expo = (int) (Math.pow(2, cont));
		
			if(digito==1)
			{
				resultado = resultado + expo;
			}
			cont++;
			return convertDecimal(binario, digitos, cont, resultado);
		}
		
		return resultado;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int numero = 0;
		
		System.out.print("Ingrese un numero binario: ");
		numero = sc.nextInt();
		int digitos = (int)(Math.log10(numero));
		System.out.println("Resultado: "+convertDecimal(numero,digitos,0,0));
	}
}