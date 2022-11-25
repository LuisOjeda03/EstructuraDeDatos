package Caja_Burbuja;
public interface ICaja 
{
	public abstract boolean insertar (int valor);
	public abstract void eliminar (int indice);
	public abstract void ordenar ();
	public abstract boolean buscar (int valor);
	public abstract void mostrarDatos ();
}