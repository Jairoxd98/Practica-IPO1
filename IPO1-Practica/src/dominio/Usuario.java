package dominio;

import persistencia.UsuarioDAO;

public class Usuario implements CRUD{
	private String DNI;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String domicilio;
	private String correo;
	private String fecha;
	private String usuario;
	private String contrasena;
	private UsuarioDAO usuarioDAO;
	
	public Usuario() {
		this.usuarioDAO=new UsuarioDAO();
	}
	
	public Usuario(String DNI, String nombre, String apellidos,String telefono, String domicilio, String correo,
			String fecha, String usuario, String contrasena) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.correo = correo;
		this.fecha = fecha;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public boolean insert() {
		return usuarioDAO.insert(this);
	}

	@Override
	public boolean update() {
		return usuarioDAO.update(this);
	}

	@Override
	public boolean delete() {
		return usuarioDAO.delete(this);
	}

	@Override
	public boolean read() {
		return usuarioDAO.read(this);
	}

	@Override
	public boolean readAll() {
		return usuarioDAO.readAll();
	}
	
}
