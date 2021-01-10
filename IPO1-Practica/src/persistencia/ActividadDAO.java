package persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Actividad;

public class ActividadDAO {

	private ArrayList<Actividad> listaActividades;
	
	public ActividadDAO() {
		this.listaActividades=new ArrayList<Actividad>();
	}
	
	public ArrayList<Actividad> getListaActividades(){
		return this.listaActividades;
	}
	
	
	public boolean insert(Actividad actividad) {
		boolean correcto=false;
		
		try {
			Agente.getAgente().modificar("INSERT INTO actividad VALUES('"+actividad.getNombre()+"',"
					+actividad.getHoraInicio()+"',"+ actividad.getHoraFin()+"',"+actividad.getDia()+"',"
					+ actividad.getMonitor()+"'," + actividad.getMinParticipantes()+"',"+ actividad.getMaxParticipantes()+"',"
					+ actividad.getPrecioHora()+"',"+ actividad.getPrecioMes()+"',"+ actividad.getDestinado()+"',"+ actividad.getDescripcion()+";");
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
	
	public boolean update(Actividad actividad) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("UPDATE actividad SET nombre='"+actividad.getNombre()+"',"
										+actividad.getHoraInicio()+"',"+ actividad.getHoraFin()+"',"+actividad.getDia()+"',"
										+ actividad.getMonitor()+"'," + actividad.getMinParticipantes()+"',"+ actividad.getMaxParticipantes()+"'," 
										+ actividad.getPrecioHora()+"',"+ actividad.getPrecioMes()+"',"+ actividad.getDestinado()+"',"+ actividad.getDescripcion()+";");
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
	
	public boolean delete(Actividad actividad) {
		
		boolean correcto = false;
		
		try {
			Agente.getAgente().modificar("DELETE FROM actividad WHERE nombre='"+actividad.getNombre()+"';");
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
	
	public boolean read(Actividad actividad) {
		boolean correcto=false;
		ResultSet resultado;
		try {
			resultado=Agente.getAgente().leer("SELECT FROM actividad WHERE nombre='"+actividad.getNombre()+"';");
			while(resultado.next()) {
				actividad.setNombre(resultado.getString(1));
				actividad.setHoraInicio(resultado.getString(2));
				actividad.setHoraFin(resultado.getString(3));
				actividad.setDia(resultado.getString(4));
				actividad.setMonitor(resultado.getString(5));
				actividad.setMinParticipantes(resultado.getInt(6));
				actividad.setMaxParticipantes(resultado.getInt(7));
				actividad.setPrecioHora(resultado.getDouble(8));
				actividad.setPrecioMes(resultado.getDouble(9));
				actividad.setDestinado(resultado.getString(10));
				actividad.setDescripcion(resultado.getString(11));
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
			resultado=Agente.getAgente().leer("SELECT * FROM actividad;");
			
			while(resultado.next()) {
				Actividad actividad =new Actividad();
				actividad.setNombre(resultado.getString(1));
				actividad.setHoraInicio(resultado.getString(2));
				actividad.setHoraFin(resultado.getString(3));
				actividad.setDia(resultado.getString(4));
				actividad.setMonitor(resultado.getString(5));
				actividad.setMinParticipantes(resultado.getInt(6));
				actividad.setMaxParticipantes(resultado.getInt(7));
				actividad.setPrecioHora(resultado.getDouble(8));
				actividad.setPrecioMes(resultado.getDouble(9));
				actividad.setDestinado(resultado.getString(10));
				actividad.setDescripcion(resultado.getString(11));
				
				listaActividades.add(actividad);
				
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
