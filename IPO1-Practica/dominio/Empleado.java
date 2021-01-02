package dominio;

import persistencia.EmpleadoDAO;

public class Empleado implements CRUD{
	private String DNI;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String correo;
	private String idiomas;
	private String formacion;
	private EmpleadoDAO empleadoDAO;
	//Foto
	public Empleado(String DNI, String nombre, String apellidos, String telefono, String correo, String idiomas, String formacion) {
		super();
		this.DNI=DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.idiomas = idiomas;
		this.formacion = formacion;
	}
	public Empleado() {
		this.empleadoDAO = new EmpleadoDAO();
	}
	
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	public String getFormacion() {
		return formacion;
	}
	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}
	public EmpleadoDAO getEmpleadoDAO() {
		return empleadoDAO;
	}
	public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}
	
	@Override
	public String toString() {
		return "Empleado [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", correo=" + correo + ", idiomas=" + idiomas + ", formacion=" + formacion + ", empleadoDAO="
				+ empleadoDAO + "]";
	}
	@Override
	public boolean insert() {
		return empleadoDAO.insert(this);
	}

	@Override
	public boolean update() {
		return empleadoDAO.update(this);
	}

	@Override
	public boolean delete() {
		return empleadoDAO.delete(this);
	}

	@Override
	public boolean read() {
		return empleadoDAO.read(this);
	}

	@Override
	public boolean readAll() {
		return empleadoDAO.readAll();
	}
	
	
}
