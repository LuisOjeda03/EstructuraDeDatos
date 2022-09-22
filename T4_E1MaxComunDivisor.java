package primer_parcial;

import java.util.Scanner;

public class T4_E1MaxComunDivisor 
{

	public static int maxDivisor(int num1, int num2, int div, int result)
	{
		if(div>=num1 || div>=num2)
			return result;
	
		
		if((num1%div)==0 && (num2%div)==0)
		{
			num1 = num1/div;
			num2 = num2/div;
			result = result * div;
			div = 2;
			return maxDivisor(num1,num2,div,result);
		}
		else
		{
			div++;
			return maxDivisor(num1,num2,div,result);
		}
		
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int num1 = 0, num2 = 0;
		int div = 2;
		System.out.print("Ingrese No.1: ");
		num1 = sc.nextInt();
		System.out.print("Ingrese No.2: ");
		num2 = sc.nextInt();
		System.out.println("Maximo Comun Divisor: "+maxDivisor(num1,num2,div,1));
		
	}

}
