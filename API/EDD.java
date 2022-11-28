package API;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mario Rios <jose.rf@culiacan.tecnm.mx>
 */
public class EDD {
	public static void ordenarID(Personaje[]personajes){
		IdComparator idC = new IdComparator();
		Arrays.sort(personajes, idC);
	}
	
	public static void ordenarNombre(Personaje[]personajes){
		Arrays.sort(personajes);
	}
	
	public static void ordenarEstatus(Personaje[]personajes)
	{
		EstatusComparator estatusC = new EstatusComparator();
		Arrays.sort(personajes, estatusC);
	}
	
	public static void ordenarEspecie(Personaje[]personajes)
	{
		SpecieComparator specieC = new SpecieComparator();
		Arrays.sort(personajes, specieC);
	}
	
	public static void ordenarGenero(Personaje[]personajes)
	{
		GenderComparator genderC = new GenderComparator();
		Arrays.sort(personajes, genderC);
	}
	
	public static void ordenarOrigen(Personaje[]personajes)
	{
		OriginComparator originC = new OriginComparator();
		Arrays.sort(personajes, originC);
	}
	
	public static void ordenarLocalizacion(Personaje[]personajes)
	{
		LocationComparator locationC = new LocationComparator();
		Arrays.sort(personajes, locationC);
	}
	
	public static void buscarId(Personaje[]personajes, int id){
		IdComparator idC = new IdComparator();
		Arrays.sort(personajes,idC);
		
		int idEncontrado = Arrays.binarySearch(personajes, new Personaje(id,null), idC);
		idEncontrado = idEncontrado*(-1);
		if(idEncontrado<0)
		{
			idEncontrado = idEncontrado*(-1);
		}
		if(idEncontrado<0)
		{
			System.out.println("Personaje no ecnontrado");			
		}
		else
		{
			System.out.println(personajes[idEncontrado].getName());			
		}
	}
	
	public static void buscarNombre(Personaje[]personajes, String nombre){
		NameComparator nameC = new NameComparator();
		Arrays.sort(personajes,nameC);
		
		int idEncontrado = Arrays.binarySearch(personajes, new Personaje(0,nombre));
		if(idEncontrado<0)
		{
			idEncontrado = idEncontrado*(-1);
			System.out.println(idEncontrado);
		}
		if(idEncontrado<0)
		{
			System.out.println("Personaje no encontrado");
		}
		else
		{
			System.out.println("ID: "+personajes[idEncontrado].getID());			
		}
	}
	
	public static void metodoBusqueda(Personaje[]personajes)
	{
		Scanner sc = new Scanner(System.in);
		int op = 0;
		System.out.println("");
		System.out.println("1- Id");
		System.out.println("2- Nombre (Solo un nombre, no se permite espaciado)");
		System.out.println("0- Cancelar");
		System.out.print("Opcion: ");
		op = sc.nextInt();
		System.out.println();
		
		switch(op)
		{
			case 0:
				break;
			case 1:
				int id = 0;
				System.out.print("Id: ");
        		id = sc.nextInt();
        		
				buscarId(personajes, id);
				break;
			case 2:
				String nombre = "";
				System.out.print("Nombre: ");
				nombre = sc.next();
				
				buscarNombre(personajes, nombre);
				break;
		}
	}
	
	public static void imprimir(Personaje[]personajes){
		if(personajes != null){
			
            for (Personaje personaje : personajes) {
                System.out.println("ID: "+personaje.getID()+" - Nombre: "+personaje.getName()+" - Status: "+personaje.getStatus()+" - Especie: "+personaje.getSpecies()
                +" - Genero: "+personaje.getGender()+" - Origen: "+personaje.getOrigin().getName()+" - Localizacion: "+personaje.getLocation().getName());
            }
        }
	}

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        ApiHelper api = new ApiHelper();
        JsonHelper jsonHelper = new JsonHelper();
        Personaje[] per = null;
        Personaje[] personajes = new Personaje[826]; // MODIFICAR A 826
        
        int contador = 0, pag = 1, contPersonaje = 0;
        int opcion = 1;
        
        String url = "https://rickandmortyapi.com/api/character?page=1";
        
        String urlTemp = api.get("https://rickandmortyapi.com/api/character?page=1");
        per = jsonHelper.convertJsonAPersonajes(urlTemp);
        System.out.println("Generando ...");
        for(contPersonaje = 0; contPersonaje<826; contPersonaje++) // MODIFICAR A <826 
        {
        	if(contador==20)
        	{
        		System.out.println("Pagina #"+pag+" completada");
        		pag++;
        		url = "https://rickandmortyapi.com/api/character?page=";
            	url = url+""+pag;
        		contador = 0;
        	}
        	
        	String datos = api.get(url);
        	per = jsonHelper.convertJsonAPersonajes(datos);
        	personajes[contPersonaje] = per[contador];
        	contador++;
        }
        
        while(opcion!=0)
        {
        	System.out.println("");
        	System.out.println("MENU");
        	System.out.println("1- Ordenar por ID");
        	System.out.println("2- Ordenar por Nombre");
        	System.out.println("3- Ordenar por Estatus");
        	System.out.println("4- Ordenar por Especie");
        	System.out.println("5- Ordenar por Genero");
        	System.out.println("6- Ordenar por Origen");
        	System.out.println("7- Ordenar por Localizacion");
        	System.out.println("8- Buscar");
        	System.out.println("9- Imprimir");
        	System.out.println("0- Salir");
        	System.out.println("");
        	System.out.print("Opcion: ");
        	opcion = sc.nextInt();

        	switch(opcion)
        	{
        	case 0: 
        		opcion = 0;
        		break;
        	case 1:
        		ordenarID(personajes);
        		break;
        	case 2:
        		ordenarNombre(personajes);
        		break;
        	case 3:
        		ordenarEstatus(personajes);
        		break;
        	case 4:
        		ordenarEspecie(personajes);
        		break;
        	case 5:
        		ordenarGenero(personajes);
        		break;
        	case 6:
        		ordenarOrigen(personajes);
        		break;
        	case 7:
        		ordenarLocalizacion(personajes);
        		break;
        	case 8:
        		metodoBusqueda(personajes);
        		break;
        	case 9:
        		imprimir(personajes);
        		break;
        	}
        	System.out.println("");
        }
    }
}