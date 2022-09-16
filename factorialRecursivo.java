package Pruebas;

import java.util.Scanner;

public class factorialRecursivo 
{

	public static int factorialRecursivo1(int n)
	{
		if(n>1)
			return n * factorialRecursivo1(n-1);
		else
			return 1;	
	}
	
	public static void main(String[] args)
	{
		int n = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Factorial del numero: ");
		n=sc.nextInt();
		System.out.println(factorialRecursivo1(n));
		
	}

}
