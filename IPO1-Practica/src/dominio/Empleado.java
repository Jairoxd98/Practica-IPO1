package dominio;

public class Empleado {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String correo;
	private String idiomas;
	private String formacion;
	//Foto
	public Empleado(String nombre, String apellidos, String telefono, String correo, String idiomas, String formacion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.correo = correo;
		this.idiomas = idiomas;
		this.formacion = formacion;
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
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", correo="
				+ correo + ", idiomas=" + idiomas + ", formacion=" + formacion + "]";
	}
	
	
}
