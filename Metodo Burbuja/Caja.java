package Caja_Burbuja;

/*
 *  Elaborar un programa que incorpore en un vector
 *  de 10 elementos sus operaciones basicas:
 *  insertar
 *  eliminar
 *  ordenar
 *  buscar
 */

public class Caja implements ICaja
{
	private int[] elementos;
	private int indice;
	
	public Caja(){
		elementos = new int[10];
		indice = 0;
	}
	
	@Override
	public boolean insertar(int valor) {
		if(indice>9)
			return false;
		elementos[indice] = valor;
		indice++;
		return true;
	}

	@Override
	public void eliminar(int indice) {
		if(elementos[indice] != 0){
			
			for (int x=indice; x<elementos.length - 1; x++){
				elementos[indice] = elementos[x+1];
				indice++;
			}
		}
	}

	@Override
	public void ordenar() 
	{

		for(int i = 0; i < elementos.length - 1; i++)
		{
			for (int j = 0; j < elementos.length - 1; j++)
			{
				int e1 = elementos[j];
				int e2 = elementos[j+1];

				if(e1>e2)
				{
					int temp = e1;
					elementos[j] = e2;
					elementos[j+1] = temp;
				}
			}
		}
	}

	@Override
	public boolean buscar(int valor) {
		return false;
	}

	@Override
	public void mostrarDatos() {
		for (int i: elementos){
			System.out.println(i);
		}
		
	}
	
}