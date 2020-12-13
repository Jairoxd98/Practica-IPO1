package dominio;

public class Bungalow {
	private String tamano;
	private int cpacidadMax;
	private double precio;
	private int estanciaMin;
	private String eqipamiento;
	private String descripcion;
	private String disponibilidad;
	//Galeria
	public Bungalow(String tamano, int cpacidadMax, double precio, int estanciaMin, String eqipamiento,
			String descripcion, String disponibilidad) {
		super();
		this.tamano = tamano;
		this.cpacidadMax = cpacidadMax;
		this.precio = precio;
		this.estanciaMin = estanciaMin;
		this.eqipamiento = eqipamiento;
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public int getCpacidadMax() {
		return cpacidadMax;
	}
	public void setCpacidadMax(int cpacidadMax) {
		this.cpacidadMax = cpacidadMax;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getEstanciaMin() {
		return estanciaMin;
	}
	public void setEstanciaMin(int estanciaMin) {
		this.estanciaMin = estanciaMin;
	}
	public String getEqipamiento() {
		return eqipamiento;
	}
	public void setEqipamiento(String eqipamiento) {
		this.eqipamiento = eqipamiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	@Override
	public String toString() {
		return "Bungalow [tamano=" + tamano + ", cpacidadMax=" + cpacidadMax + ", precio=" + precio + ", estanciaMin="
				+ estanciaMin + ", eqipamiento=" + eqipamiento + ", descripcion=" + descripcion + ", disponibilidad="
				+ disponibilidad + "]";
	}
	
	
}
