package dominio;

import java.util.Date;

import persistencia.ActividadDAO;
import persistencia.RutaDAO;

public class Actividad implements CRUD{
	private String nombre;
	private String horaInicio;
	private String horaFin;
	private String dia;
	private String monitor;
	private int minParticipantes;
	private int maxParticipantes;
	private double precioHora;
	private double precioMes;
	private String destinado;
	private String descripcion;
	private ActividadDAO actividadDAO;
	
	public Actividad(String nombre, String horaInicio, String horaFin, String dia, String monitor, int minParticipantes,
			int maxParticipantes, double precioHora, double precioMes, String destinado, String descripcion) {
		super();
		this.nombre = nombre;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.dia = dia;
		this.monitor = monitor;
		this.minParticipantes = minParticipantes;
		this.maxParticipantes = maxParticipantes;
		this.precioHora = precioHora;
		this.precioMes = precioMes;
		this.destinado = destinado;
		this.descripcion = descripcion;
		this.actividadDAO=new ActividadDAO();
	}
	public Actividad() {
		this.actividadDAO=new ActividadDAO();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public int getMinParticipantes() {
		return minParticipantes;
	}
	public void setMinParticipantes(int minParticipantes) {
		this.minParticipantes = minParticipantes;
	}
	public int getMaxParticipantes() {
		return maxParticipantes;
	}
	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}
	public double getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	public double getPrecioMes() {
		return precioMes;
	}
	public void setPrecioMes(double precioMes) {
		this.precioMes = precioMes;
	}
	public String getDestinado() {
		return destinado;
	}
	public void setDestinado(String destinado) {
		this.destinado = destinado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ActividadDAO getActividadDAO() {
		return actividadDAO;
	}
	public void setActividadDAO(ActividadDAO actividadDAO) {
		this.actividadDAO = actividadDAO;
	}
	@Override
	public String toString() {
		return "Actividad [nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", dia=" + dia
				+ ", monitor=" + monitor + ", minParticipantes=" + minParticipantes + ", maxParticipantes="
				+ maxParticipantes + ", precioHora=" + precioHora + ", precioMes=" + precioMes + ", destinado="
				+ destinado + ", descripcion=" + descripcion + "]";
	}
	
	@Override
	public boolean insert() {
		return actividadDAO.insert(this);
	}

	@Override
	public boolean update() {
		return actividadDAO.update(this);
	}

	@Override
	public boolean delete() {
		return actividadDAO.delete(this);
	}

	@Override
	public boolean read() {
		return actividadDAO.read(this);
	}

	@Override
	public boolean readAll() {
		return actividadDAO.readAll();
	}
	
}
