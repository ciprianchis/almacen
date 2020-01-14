import java.util.Iterator;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Almacen {
	
	public Producto[][] mAlmacen;

	public Almacen(Producto[][] mAlmacen) {
		this.mAlmacen = mAlmacen;
	}
	
	public Almacen() {
		
	}

	
	public void inicializarmAlmacen(){
		mAlmacen = new Producto[10][10];
	}
	public void calcularPrecioTotalBebidas() {
		double total = 0;
		
		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if (mAlmacen[i][j]!=null) {
					total += mAlmacen[i][j].getPrecio();
				}
			}
		}
			
		System.out.println("El precio total es: " + total);
		
	}
	
	public double calcularPrecioTotalPorMarca() {
		double total = 0;
		String marca = "";
		Scanner leer = new Scanner(System.in);
		
		System.out.println("Elija la marca cuyo precio desea calcular");
		marca = leer.nextLine();
		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if ((mAlmacen[i][j]!=null)&&(mAlmacen[i][j].getMarca().equalsIgnoreCase(marca))) {
					total += mAlmacen[i][j].getPrecio();
				}
			}
		}
		return total;
	}
	
	
	
	public String calcularPrecioEstanteria() {
		Scanner leer =new Scanner(System.in);
		double precio = 0;
		int estanteria = 0;
		
		System.out.println("Elija una estantería");	
		
		for (int i = estanteria; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				precio = +mAlmacen[i][j].getPrecio();
			}
			break;
		}
		return "La estantería " + estanteria + "tiene un valor de " + precio + "$";
	}
	
		
	private boolean verificaId(int identificador) {
		boolean registrado = false;
		
		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if (mAlmacen[i][j].getIdentificador()== identificador) {
					registrado = true;
				}
			}
		}
		return registrado;
	}
	
	public void agregarProducto() {
		Scanner leer = new Scanner(System.in);
		int tipo=0;
		int identificador = 0;
		double litros = 0;
		double precio = 0;
		double porcentaje = 0;
		String marca = "";
		String origen = "";
		String promocion = "";
		
		System.out.println("El producto que desea añadir es 'Agua'(1) o 'Bebida Azucarada'(2) ");
		tipo = leer.nextInt();
		System.out.println("Identificador del producto:");
		identificador = leer.nextInt();
		

		leer = new Scanner(System.in);
		System.out.println("Litros del producto:");
		litros = leer.nextDouble();
		leer = new Scanner(System.in);
		System.out.println("Precio del producto:");
		precio = leer.nextDouble();
		leer = new Scanner(System.in);
		System.out.println("Marca del producto:");
		marca = leer.nextLine();
		leer = new Scanner(System.in);
		
		if (tipo==1) {
			System.out.println("Origen del producto:");
			origen = leer.nextLine();
			leer = new Scanner(System.in);
			
			Agua a = new Agua(identificador, litros, precio, marca, origen);
			
			for (int i = 0; i < mAlmacen.length; i++) {
				for (int j = 0; j < mAlmacen.length; j++) {
					mAlmacen[i][j] = a;
					break;
				}
			}

		}
		if (tipo == 2) {
			System.out.println("Porcentaje de azucar del producto:");
			porcentaje = leer.nextDouble();
			leer = new Scanner(System.in);
			System.out.println("Tiene promoción el producto:(si o no)");
			promocion = leer.nextLine();
			leer = new Scanner(System.in);
			if (promocion.equalsIgnoreCase("si")) {
				BebidaAzucar Beb = new BebidaAzucar(identificador, litros, precio, marca, porcentaje, true);
				for (int i = 0; i < mAlmacen.length; i++) {
					for (int j = 0; j < mAlmacen.length; j++) {
						mAlmacen[i][j] = Beb;
						break;
					}
				}
			}
			if (promocion.equalsIgnoreCase("no")) {
				BebidaAzucar Beb = new BebidaAzucar(identificador, litros, precio, marca, porcentaje, false);
				for (int i = 0; i < mAlmacen.length; i++) {
					for (int j = 0; j < mAlmacen.length; j++) {
						mAlmacen[i][j] = Beb;
						break;
					}
				}
			}
			if (!(promocion.equalsIgnoreCase("no"))&&!(promocion.equalsIgnoreCase("si"))) {
				System.out.println("Datos de la promoción no son válidos");
			}
		}
		
		if ((tipo!=1)&&(tipo!=2)) {
			System.out.println("Elemento no conocido");
		}
	}
	
	
	public void eliminarProducto() {
		Scanner leer = new Scanner(System.in);
		int identificador = 0;
		
		System.out.println("Elija el producto a eliminar mediante el identifocador");
		identificador = leer.nextInt();
		
		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if (mAlmacen[i][j]!=null) {
					if (mAlmacen[i][j].getIdentificador()==identificador) {
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
				if (mAlmacen[i][j]!=null) {
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











