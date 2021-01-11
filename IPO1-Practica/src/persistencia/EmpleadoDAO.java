package persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Empleado;

public class EmpleadoDAO {

	private ArrayList<Empleado> listaEmpleados;
	
	public EmpleadoDAO() {
		this.listaEmpleados=new ArrayList<Empleado>();
	}
	
	public ArrayList<Empleado> getListaEmpleados(){
		return this.listaEmpleados;
	}
	
	
	public boolean insert(Empleado empleado) {
		boolean correcto=false;
		
		try {
			Agente.getAgente().modificar("INSERT INTO empleado VALUES('"+empleado.getDNI()+"','"+empleado.getNombre()+"','"+empleado.getApellidos()+"','"
					+empleado.getTelefono()+"','"+ empleado.getCorreo()+"','"+ empleado.getIdiomas()+"','"+ empleado.getFormacion()+"');");
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
	
	public boolean update(Empleado empleado) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("UPDATE empleado SET nombre='"+empleado.getNombre()+"',apellidos='"+empleado.getApellidos()+"',telefono='"
					+empleado.getTelefono()+"',correo='"+ empleado.getCorreo()+"',idiomas='"+ empleado.getIdiomas()+"',formacion='"+ empleado.getFormacion()+"' WHERE DNI='"+empleado.getDNI()+"';");
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
	
	public boolean delete(Empleado empleado) {
		
		boolean correcto = false;
		
		try {
			Agente.getAgente().modificar("DELETE FROM empleado WHERE DNI='"+empleado.getDNI()+"';");
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
	
	public boolean read(Empleado empleado) {
		boolean correcto=false;
		ResultSet resultado;
		try {
			resultado=Agente.getAgente().leer("SELECT FROM empleado WHERE DNI='"+empleado.getDNI()+"';");
			while(resultado.next()) {
				empleado.setDNI(resultado.getString(1));
				empleado.setNombre(resultado.getString(2));
				empleado.setApellidos(resultado.getString(3));
				empleado.setTelefono(resultado.getString(4));
				empleado.setCorreo(resultado.getString(5));
				empleado.setIdiomas(resultado.getString(6));
				empleado.setFormacion(resultado.getString(7));
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
			resultado=Agente.getAgente().leer("SELECT * FROM empleado;");
			
			while(resultado.next()) {
				Empleado empleado=new Empleado();
				empleado.setDNI(resultado.getString(1));
				empleado.setNombre(resultado.getString(2));
				empleado.setApellidos(resultado.getString(3));
				empleado.setTelefono(resultado.getString(4));
				empleado.setCorreo(resultado.getString(5));
				empleado.setIdiomas(resultado.getString(6));
				empleado.setFormacion(resultado.getString(7));
				
				listaEmpleados.add(empleado);
				
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
