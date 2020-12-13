package persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Usuario;

public class UsuarioDAO {

	private ArrayList<Usuario> listaUsuarios;
	
	public UsuarioDAO() {
		this.listaUsuarios=new ArrayList<Usuario>();
	}
	
	public ArrayList<Usuario> getListaUsuarios(){
		return this.listaUsuarios;
	}
	
	
	public boolean insert(Usuario usuario) {
		boolean correcto=false;
		
		try {
			Agente.getAgente().modificar("INSERT INTO usuarios VALUES('"+usuario.getDNI()+"','"+usuario.getNombre()+"',"
					+usuario.getApellidos()+"',"+ usuario.getTelefono()+"',"+usuario.getDomicilio()+"',"
					+ usuario.getCorreo()+"',"+usuario.getNacionalidad()+"',"+ usuario.getFecha()+"',"
					+ usuario.getUsuario()+"',"+ usuario.getContrasena()+";");
			correcto=true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return correcto;
	}
	
	public boolean update(Usuario usuario) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("UPDATE usuario SET nombre='"+usuario.getNombre()+"',"
					+usuario.getApellidos()+"',"+ usuario.getTelefono()+"',"+usuario.getDomicilio()+"',"
					+ usuario.getCorreo()+"',"+usuario.getNacionalidad()+"',"+ usuario.getFecha()+"',"
					+ usuario.getUsuario()+"',"+ usuario.getContrasena()+"' WHERE DNI='"+usuario.getDNI()+"';");
			correcto=true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return correcto;
	}
	
	public boolean delete(Usuario usuario) {
		
		boolean correcto = false;
		
		try {
			Agente.getAgente().modificar("DELETE FROM usuarios WHERE DNI='"+usuario.getDNI()+"';");
			correcto=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return correcto;
		
	}
	
	public boolean login(Usuario usuario) {
		ResultSet resultado;
		boolean correcto = false;

		
		try {
			String SQL = "SELECT * FROM usuario WHERE usuario='"+usuario.getUsuario()+"' AND contrasena='"+usuario.getContrasena()+"'";
			
			
			Agente.getAgente();
			resultado=Agente.getAgente().leer(SQL);
			while(resultado.next()) {
				correcto=true;
				usuario.setDNI(resultado.getString(1));
				usuario.setNombre(resultado.getString(2));
				usuario.setApellidos(resultado.getString(3));
				usuario.setTelefono(resultado.getString(4));
				usuario.setDomicilio(resultado.getString(5));
				usuario.setCorreo(resultado.getString(6));
				usuario.setNacionalidad(resultado.getString(7));
				usuario.setFecha(resultado.getString(8));
				usuario.setUsuario(resultado.getString(9));
				usuario.setContrasena(resultado.getString(10));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return correcto;
	}
	
	public boolean read(Usuario usuario) {
		boolean correcto=false;
		ResultSet resultado;
		try {
			resultado=Agente.getAgente().leer("SELECT FROM usuarios WHERE DNI='"+usuario.getDNI()+"';");
			while(resultado.next()) {
				usuario.setDNI(resultado.getString(1));
				usuario.setNombre(resultado.getString(2));
				usuario.setApellidos(resultado.getString(3));
				usuario.setTelefono(resultado.getString(4));
				usuario.setDomicilio(resultado.getString(5));
				usuario.setCorreo(resultado.getString(6));
				usuario.setNacionalidad(resultado.getString(7));
				usuario.setFecha(resultado.getString(8));
				usuario.setUsuario(resultado.getString(9));
				usuario.setContrasena(resultado.getString(10));
			}
			correcto=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return correcto;
	}
	
	public boolean readAll() {
		boolean correcto=false;
		ResultSet resultado;
		
		try {
			resultado=Agente.getAgente().leer("SELECT * FROM usuarios;");
			
			while(resultado.next()) {
				Usuario usuario=new Usuario();
				usuario.setDNI(resultado.getString(1));
				usuario.setNombre(resultado.getString(2));
				usuario.setApellidos(resultado.getString(3));
				usuario.setTelefono(resultado.getString(4));
				usuario.setDomicilio(resultado.getString(5));
				usuario.setCorreo(resultado.getString(6));
				usuario.setNacionalidad(resultado.getString(7));
				usuario.setFecha(resultado.getString(8));
				usuario.setUsuario(resultado.getString(9));
				usuario.setContrasena(resultado.getString(10));
				
				listaUsuarios.add(usuario);
				
			}
			correcto=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return correcto;
	}
	
	
}
