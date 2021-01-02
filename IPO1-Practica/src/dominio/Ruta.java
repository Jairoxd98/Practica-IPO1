package dominio;

import java.util.Date;

public class Ruta {
	private String nombre;
	private String horaInicio;
	private String horaFin;
	private Date dia;
	private String monitor;//
	private String encuentro;
	private int minParticipantes;
	private int maxParticipantes;
	private String descripcion;
	//Mapa
	public Ruta(String nombre, String horaInicio, String horaFin, Date dia, String monitor, String encuentro,
			int minParticipantes, int maxParticipantes, String descripcion) {
		super();
		this.nombre = nombre;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.dia = dia;
		this.monitor = monitor;
		this.encuentro = encuentro;
		this.minParticipantes = minParticipantes;
		this.maxParticipantes = maxParticipantes;
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getEncuentro() {
		return encuentro;
	}
	public void setEncuentro(String encuentro) {
		this.encuentro = encuentro;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Ruta [nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", dia=" + dia
				+ ", monitor=" + monitor + ", encuentro=" + encuentro + ", minParticipantes=" + minParticipantes
				+ ", maxParticipantes=" + maxParticipantes + ", descripcion="
				+ descripcion + "]";
	}
	
}
