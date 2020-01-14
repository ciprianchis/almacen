import Menu.Menu;

public class Main {

	public static void main(String[] args) {
		
		int opcion = 0;
		
		Menu menu = new Menu();
		
		Almacen a = new Almacen();		
		
		a.inicializarmAlmacen();
		
		do {
			switch (opcion = menu.mostrarMenu()) {
			case 1:
				a.calcularPrecioTotalBebidas();
				break;
			case 2:
				a.calcularPrecioTotalPorMarca();
				break;
			case 3:
				a.calcularPrecioEstanteria();
				break;
			case 4:
				a.agregarProducto();
				break;
			case 5:
				a.eliminarProducto();
				break;
			case 6:
				a.mostrarInformacion();
				break;

			default: System.err.println("ERROR DESCONOCIDO");
				break;
			}
		} while (true);

	}

}
