
public final class BebidaAzucar extends Producto{

	private double porcentaje;
	private boolean promocion;
	
	
	public BebidaAzucar(int identificador, double litros, double precio, String marca, double porcentaje,
			boolean promocion) {
		super(identificador, litros, precio, marca);
		this.porcentaje = porcentaje;
		this.promocion = promocion;
	}


	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public boolean isPromocion() {
		return promocion;
	}

	public void setPromocion(boolean promocion) {
		this.promocion = promocion;
	}

	public double getPrecio() {
		if(promocion) {
			return super.getPrecio() * 0.9;
		}else {
			return super.getPrecio();
		}
		
		
	}

	@Override
	public String toString() {
		return "\n" + "AZUCARADA" + super.toString() + "\n" + "Azucar:" + porcentaje + "%" + "\n" +"En promocion:" + promocion;
	}


	
	
}
