
public final class Agua extends Producto{

	private String origen;

	public Agua(int identificador, double litros, double precio, String marca, String origen) {
		super(identificador, litros, precio, marca);
		this.origen = origen;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "\n" + "MINERAL" + super.toString() + "\n" + "Origen: " + origen;
	}
	
	
	
	
	
}
