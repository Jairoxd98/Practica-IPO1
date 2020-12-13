package dominio;

import java.util.Date;

public class Reserva {
	private Date fechaEntrada;
	private Date fechaSalida;
	private String nombre;
	private String telefono;
	private String email;
	private int ocupantes;
	private String solicitud;
	private String horaEntrada;
	private String horaSalida;
	public Reserva(Date fechaEntrada, Date fechaSalida, String nombre, String telefono, String email, int ocupantes,
			String solicitud, String horaEntrada, String horaSalida) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.ocupantes = ocupantes;
		this.solicitud = solicitud;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOcupantes() {
		return ocupantes;
	}
	public void setOcupantes(int ocupantes) {
		this.ocupantes = ocupantes;
	}
	public String getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	public String getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	@Override
	public String toString() {
		return "Reserva [fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", nombre=" + nombre
				+ ", telefono=" + telefono + ", email=" + email + ", ocupantes=" + ocupantes + ", solicitud="
				+ solicitud + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + "]";
	}
	
	
}
