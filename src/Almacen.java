import java.util.Scanner;

public class Almacen {
	
	public Producto[][] mAlmacen;

	public Almacen(Producto[][] mAlmacen) {
		this.mAlmacen = mAlmacen;
	}

	public double calcularPrecioTotalBebidas() {
		double total = 0;
		
		for (int i = 0; i < mAlmacen.length; i++) {
			for (int j = 0; j < mAlmacen.length; j++) {
				if (mAlmacen[i][j]!=null) {
					total += mAlmacen[i][j].getPrecio();
				}
			}
		}
		return total;
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
	
	
	public void agregarProducto() {
		Scanner leer = new Scanner(System.in);
		
		
	}
	
	
	
	
	
	
	
	public Producto[][] getmAlmacen() {
		return mAlmacen;
	}

	public void setmAlmacen(Producto[][] mAlmacen) {
		this.mAlmacen = mAlmacen;
	}
	
	
	
}
