package dominio;

import java.util.Date;

import persistencia.ReservaDAO;

public class Reserva implements CRUD{
	private int id;
	private String fechaEntrada;
	private String fechaSalida;
	private String nombre;
	private String tipo;
	private String telefono;
	private String email;
	private int ocupantes;
	private String solicitud;
	private String horaEntrada;
	private String horaSalida;
	private ReservaDAO reservaDAO;
	
	
	public Reserva(int id, String fechaEntrada, String fechaSalida, String nombre, String tipo, String telefono, String email, int ocupantes,
			String solicitud, String horaEntrada, String horaSalida) {
		super();
		this.id=id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.nombre = nombre;
		this.tipo=tipo;
		this.telefono = telefono;
		this.email = email;
		this.ocupantes = ocupantes;
		this.solicitud = solicitud;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.reservaDAO= new ReservaDAO();
	}
	public Reserva() {
		this.reservaDAO= new ReservaDAO();
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ReservaDAO getReservaDAO() {
		return reservaDAO;
	}
	public void setReservaDAO(ReservaDAO reservaDAO) {
		this.reservaDAO = reservaDAO;
	}
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", nombre="
				+ nombre + ", tipo=" + tipo + ", telefono=" + telefono + ", email=" + email + ", ocupantes=" + ocupantes
				+ ", solicitud=" + solicitud + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida
				+ ", reservaDAO=" + reservaDAO + "]";
	}
	@Override
	public boolean insert() {
		return reservaDAO.insert(this);
	}

	@Override
	public boolean update() {
		return reservaDAO.update(this);
	}

	@Override
	public boolean delete() {
		return reservaDAO.delete(this);
	}

	@Override
	public boolean read() {
		return reservaDAO.read(this);
	}

	@Override
	public boolean readAll() {
		return reservaDAO.readAll();
	}
	
	
}
