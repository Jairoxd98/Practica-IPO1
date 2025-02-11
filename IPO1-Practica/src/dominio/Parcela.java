package dominio;

import persistencia.ParcelaDAO;
import persistencia.ReservaDAO;

public class Parcela {
	private int id;
	private String tipo;
	private int precio; 
	private String temporada;
	private String tamano;
	private String ubicacion;
	private String caracteristicas;
	private String disponibilidad;
	private ParcelaDAO parcelaDAO;
	
	public Parcela(int id, String tipo, int precio, String temporada, String tamano, String ubicacion,
			String caracteristicas, String disponibilidad) {
		super();
		this.id= id;
		this.tipo = tipo;
		this.precio = precio;
		this.temporada = temporada;
		this.tamano = tamano;
		this.ubicacion = ubicacion;
		this.caracteristicas = caracteristicas;
		this.disponibilidad = disponibilidad;
	}
	
	public Parcela(String tipo, int precio, String temporada, String tamano, String ubicacion,
			String caracteristicas, String disponibilidad) {
		this.tipo = tipo;
		this.precio = precio;
		this.temporada = temporada;
		this.tamano = tamano;
		this.ubicacion = ubicacion;
		this.caracteristicas = caracteristicas;
		this.disponibilidad = disponibilidad;
		this.parcelaDAO= new ParcelaDAO();
		
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Parcela [id="+id+", tipo=" + tipo + ", precio=" + precio + ", temporada=" + temporada + ", tamano=" + tamano
				+ ", ubicacion=" + ubicacion + ", caracteristicas=" + caracteristicas + ", disponibilidad="
				+ disponibilidad + "]";
	}
	
	public Parcela() {
		this.parcelaDAO= new ParcelaDAO();
	}
	
	public ParcelaDAO getParcelaDAO() {
		return parcelaDAO;
	}
	
	public boolean insert() {
		return parcelaDAO.insert(this);
	}

	/*
	@Override
	public boolean update() {
		return parcelaDAO.update(this);
	}

	@Override
	public boolean delete() {
		return parcelaDAO.delete(this);
	}
	*/

	
	public boolean read() {
		return parcelaDAO.read(this);
	}

	
	public boolean readAll() {
		return parcelaDAO.readAll();
	}
	
	
	
}
