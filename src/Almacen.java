import java.util.Iterator;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Almacen {

	public Producto[][] mAlmacen;

	public Almacen() {
		mAlmacen = new Producto[10][10];
	}

	

	public void calcularPrecioTotalBebidas() {
		double total = 0;

		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if (mAlmacen[i][j] != null) {
					total += mAlmacen[i][j].getPrecio();
				}
			}
		}

		System.out.println("El precio total es: " + total);

	}

	public void calcularPrecioTotalPorMarca() {
		double total = 0;
		String marca = "";
		Scanner leer = new Scanner(System.in);

		System.out.println("Elija la marca cuyo precio desea calcular");
		try {
			marca = leer.nextLine();
		} catch (Exception e) {
			System.err.println("Error al leer los datos");
		}

		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if ((mAlmacen[i][j] != null) && (mAlmacen[i][j].getMarca().equalsIgnoreCase(marca))) {
					total += mAlmacen[i][j].getPrecio();
				}
			}
		}
		System.out.println("El precio de la marca asciende a: " + total);
	}

	public String calcularPrecioEstanteria() {
		Scanner leer = new Scanner(System.in);
		double precio = 0;
		int estanteria = 0;

		System.out.println("Elija una estantería");
		try {
			estanteria = leer.nextInt();
		} catch (Exception e) {
			System.err.println("Error al leer los datos");
		}
		for (int i = estanteria; i < mAlmacen.length; i++) {
			precio = +mAlmacen[i][estanteria].getPrecio();
			break;
		}
		return "La estantería " + estanteria + "tiene un valor de " + precio + "$";
	}

	private boolean verificaId(int identificador) {
		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if ((mAlmacen[i][j] != null) && (mAlmacen[i][j].getIdentificador() == identificador)) {
					return true;

				}
			}
		}
		return false;
	}
	

	public void agregarProducto() {
		Scanner leer = new Scanner(System.in);
		int tipo = 0;
		int identificador = 0;
		double litros = 0;
		double precio = 0;
		double porcentaje = 0;
		String marca = "";
		String origen = "";
		String promocion = "";

		System.out.println("El producto que desea añadir es 'Agua'(1) o 'Bebida Azucarada'(2) ");
		try {
			tipo = leer.nextInt();
		} catch (Exception e) {
			System.err.println("Error al leer el tipo de producto");
		}
		leer = new Scanner(System.in);
		if ((tipo != 1) && (tipo != 2)) {
			System.out.println("Elemento no conocido");
			return;
		}
		do {
			System.out.println("Identificador del producto:");
			identificador = leer.nextInt();
		} while (verificaId(identificador) == true);

		leer = new Scanner(System.in);
		System.out.println("Litros del producto:");
		try {
			litros = leer.nextDouble();
		} catch (Exception e) {
			System.err.println("Error al leer los litros del producto");
		}
		leer = new Scanner(System.in);
		System.out.println("Precio del producto:");
		try {
			precio = leer.nextDouble();
		} catch (Exception e) {
			System.err.println("Error al leer el precio del producto");
		}
		leer = new Scanner(System.in);
		System.out.println("Marca del producto:");
		try {
			marca = leer.nextLine();
		} catch (Exception e) {
			System.err.println("Error al leer la marca del producto");
		}

		leer = new Scanner(System.in);

		if (tipo == 1) {
			System.out.println("Origen del producto:");
			origen = leer.nextLine();
			leer = new Scanner(System.in);

			Agua a = new Agua(identificador, litros, precio, marca, origen);

			for (int i = 0; i < mAlmacen.length; i++) {
				for (int j = 0; j < mAlmacen.length; j++) {
					if (mAlmacen[i][j] == null) {
						mAlmacen[i][j] = a;
						return;
					}

				}
			}

		}
		if (tipo == 2) {
			BebidaAzucar Beb;
			System.out.println("Porcentaje de azucar del producto:");

			porcentaje = leer.nextDouble();
			leer = new Scanner(System.in);
			System.out.println("Tiene promoción el producto:(si o no)");
			promocion = leer.nextLine();
			leer = new Scanner(System.in);
			if (promocion.equalsIgnoreCase("si")) {
				 Beb = new BebidaAzucar(identificador, litros, precio, marca, porcentaje, true);
				
			}else {
				 Beb = new BebidaAzucar(identificador, litros, precio, marca, porcentaje, false);
			}
			
				
				
			
			if (!(promocion.equalsIgnoreCase("no")) && !(promocion.equalsIgnoreCase("si"))) {
				System.out.println("Datos de la promoción no son válidos");
			}
			
			for (int i = 0; i < mAlmacen.length; i++) {
				for (int j = 0; j < mAlmacen.length; j++) {
					if (mAlmacen[i][j] == null) {
						mAlmacen[i][j] = Beb;
						return;
					}
				}
			}
		}

	}

	public void eliminarProducto() {
		Scanner leer = new Scanner(System.in);
		int identificador = 0;

		System.out.println("Elija el producto a eliminar mediante el identifocador");
		identificador = leer.nextInt();

		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen[i].length; j++) {
				if (mAlmacen[i][j] != null) {
					if (mAlmacen[i][j].getIdentificador() == identificador) {
						mAlmacen[i][j] = null;
					}
				}
			}
		}
		System.out.println("El producto fue eliminado");
	}

	public void mostrarInformacion() {
		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if (mAlmacen[i][j] != null) {
					System.out.println(mAlmacen[i][j].toString());
				}
			}
		}
	}

	public Producto[][] getmAlmacen() {
		return mAlmacen;
	}

	public void setmAlmacen(Producto[][] mAlmacen) {
		this.mAlmacen = mAlmacen;
	}

}
