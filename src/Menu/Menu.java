package Menu;

import java.util.Scanner;

public class Menu {

	public int mostrarMenu() {
		int opc =0;
		Scanner leer = new Scanner(System.in);
		do {
			System.out.println("::::::::::::::::::::::: ALMACEN :::::::::::::::::::::::");
			System.out.println(": 1-Calcular precio de todas las bebidas              :");
			System.out.println(": 2-Calcular el precio total de una marca de bebida   :");
			System.out.println(": 3-Calcular el precio total de una estantería        :");
			System.out.println(": 4-Agregar producto                                  :");
			System.out.println(": 5-Eliminar un producto                              :");
			System.out.println(": 6-Mostrar información                               :");
			System.out.println(": 7-Salir                                             :");
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
			try {
				opc = leer.nextInt();
			} catch (Exception e) {
				System.out.println("Error al leer la opción, opción no válida");
			}
			if (opc<1 || opc>7) {
				System.err.println("Error al leer la opción, opción no válida");
			}
		} while (opc<1 || opc >7);
		return opc;
	}
	
	
	
}
