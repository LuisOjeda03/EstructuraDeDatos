package Caja_Burbuja;

public class Main {

	public static void main(String[] args) {
		Caja c = new Caja();
		c.insertar(7);
		c.insertar(1);
		c.insertar(9);
		c.insertar(11);
		c.insertar(3);
		c.insertar(4);
		c.insertar(6);
		c.mostrarDatos();
		System.out.println("--------------------");
		c.eliminar(1);
		c.mostrarDatos();
		System.out.println("--------------------");
		c.ordenar();
		c.mostrarDatos();
		System.out.println("Fin");
	}
}