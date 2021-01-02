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
			Agente.getAgente().modificar("INSERT INTO usuario VALUES('"+usuario.getDNI()+"','"+usuario.getNombre()+"',"
					+usuario.getApellidos()+"',"+ usuario.getTelefono()+"',"+usuario.getDomicilio()+"',"
					+ usuario.getCorreo()+"',"+ usuario.getFecha()+"',"
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
					+ usuario.getCorreo()+"',"+ usuario.getFecha()+"',"
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
			Agente.getAgente().modificar("DELETE FROM usuario WHERE DNI='"+usuario.getDNI()+"';");
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
				usuario.setFecha(resultado.getString(7));
				usuario.setUsuario(resultado.getString(8));
				usuario.setContrasena(resultado.getString(9));
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
			resultado=Agente.getAgente().leer("SELECT * FROM usuario;");
			
			while(resultado.next()) {
				Usuario usuario=new Usuario();
				usuario.setDNI(resultado.getString(1));
				usuario.setNombre(resultado.getString(2));
				usuario.setApellidos(resultado.getString(3));
				usuario.setTelefono(resultado.getString(4));
				usuario.setDomicilio(resultado.getString(5));
				usuario.setCorreo(resultado.getString(6));
				usuario.setFecha(resultado.getString(7));
				usuario.setUsuario(resultado.getString(8));
				usuario.setContrasena(resultado.getString(9));
				
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
