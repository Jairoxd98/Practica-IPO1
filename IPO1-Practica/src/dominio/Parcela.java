package dominio;

public class Parcela {
	private String tipo;
	private double precio; 
	private String temporada;
	private String tamano;
	private String ubicacion;
	private String caracteristicas;
	private String disponibilidad;
	
	public Parcela(String tipo, double precio, String temporada, String tamano, String ubicacion,
			String caracteristicas, String disponibilidad) {
		super();
		this.tipo = tipo;
		this.precio = precio;
		this.temporada = temporada;
		this.tamano = tamano;
		this.ubicacion = ubicacion;
		this.caracteristicas = caracteristicas;
		this.disponibilidad = disponibilidad;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamaño) {
		this.tamano = tamaño;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Parcela [tipo=" + tipo + ", precio=" + precio + ", temporada=" + temporada + ", tamano=" + tamano
				+ ", ubicacion=" + ubicacion + ", caracteristicas=" + caracteristicas + ", disponibilidad="
				+ disponibilidad + "]";
	}
	
	
	
}
