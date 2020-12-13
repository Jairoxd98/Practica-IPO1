package dominio;

import java.util.Date;

public class Actividad /*implements CRUD*/{
	private String nombre;
	private Date dia;
	private String horaInicio;
	private String horaFin;
	private String personal;
	private int minParticipantes;
	private int maxParticipantes;
	private double precioHora;
	private double precioMes;
	private String destinado;
	private String caracteristicas;
	
	public Actividad(String nombre, Date dia, String horaInicio, String horaFin, String personal, int minParticipantes,
			int maxParticipantes, double precioHora, double precioMes, String destinado, String caracteristicas) {
		super();
		this.nombre = nombre;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.personal = personal;
		this.minParticipantes = minParticipantes;
		this.maxParticipantes = maxParticipantes;
		this.precioHora = precioHora;
		this.precioMes = precioMes;
		this.destinado = destinado;
		this.caracteristicas = caracteristicas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
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
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
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
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	@Override
	public String toString() {
		return "Actividad [nombre=" + nombre + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin
				+ ", personal=" + personal + ", minParticipantes=" + minParticipantes + ", maxParticipantes="
				+ maxParticipantes + ", precioHora=" + precioHora + ", precioMes=" + precioMes + ", destinado="
				+ destinado + ", caracteristicas=" + caracteristicas + "]";
	}
}
