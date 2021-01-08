package dominio;

import persistencia.BungalowDAO;
import persistencia.ParcelaDAO;

public class Bungalow {
	private int id;
	private String tamano;
	private int capacidadMax;
	private int precio;
	private int estanciaMin;
	private String equipamiento;
	private String descripcion;
	private String disponibilidad;
	private BungalowDAO bungalowDAO;
	//Galeria
	public Bungalow(int id, String tamano, int capacidadMax, int precio, int estanciaMin, String equipamiento,
			String descripcion, String disponibilidad) {
		super();
		this.id = id;
		this.tamano = tamano;
		this.capacidadMax = capacidadMax;
		this.precio = precio;
		this.estanciaMin = estanciaMin;
		this.equipamiento = equipamiento;
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public int getCapacidadMax() {
		return capacidadMax;
	}
	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getEstanciaMin() {
		return estanciaMin;
	}
	public void setEstanciaMin(int estanciaMin) {
		this.estanciaMin = estanciaMin;
	}
	public String getEquipamiento() {
		return equipamiento;
	}
	public void setEquipamiento(String equipamiento) {
		this.equipamiento = equipamiento;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Bungalow [id="+id+", tamano=" + tamano + ", capacidadMax=" + capacidadMax + ", precio=" + precio + ", estanciaMin="
				+ estanciaMin + ", equipamiento=" + equipamiento + ", descripcion=" + descripcion + ", disponibilidad="
				+ disponibilidad + "]";
	}
	
	public Bungalow() {
		this.bungalowDAO= new BungalowDAO();
	}
	
	public BungalowDAO getBungalowDAO() {
		return bungalowDAO;
	}
	/*
	@Override
	public boolean insert() {
		return parcelaDAO.insert(this);
	}

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
		return bungalowDAO.read(this);
	}

	
	public boolean readAll() {
		return bungalowDAO.readAll();
	}
	
	
}
