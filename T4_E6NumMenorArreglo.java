package primer_parcial;

// Realizar un algoritmo recursivo que muestre el numro menor de un arreglo

public class T4_E6NumMenorArreglo 
{

	public static int numMenor(int vect[], int pos, int menor)
	{
		if(vect.length==0)
			return 0;
			
		if(pos==vect.length)
		{
			return menor;
		}
		if(vect[pos]<menor)
			menor = vect[pos];
		
		pos++;
		return numMenor(vect,pos,menor);
	}
	
	public static void main(String[] args) 
	{
		int vect[] = {4,5,1,2,3,4,7,9,11};
		int numeroMenor = numMenor(vect,0,10000);
		System.out.println("Numero menor: "+numeroMenor);
	}

}