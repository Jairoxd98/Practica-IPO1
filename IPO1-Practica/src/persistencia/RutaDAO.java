package persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Ruta;

public class RutaDAO {

	private ArrayList<Ruta> listaRutas;
	
	public RutaDAO() {
		this.listaRutas=new ArrayList<Ruta>();
	}
	
	public ArrayList<Ruta> getListaRutas(){
		return this.listaRutas;
	}
	
	
	public boolean insert(Ruta ruta) {
		boolean correcto=false;
		
		try {
			Agente.getAgente().modificar("INSERT INTO ruta VALUES('"+ruta.getId()+"','"+ruta.getNombre()+"',"
					+ruta.getHoraInicio()+"',"+ ruta.getHoraFin()+"',"+ruta.getDia()+"',"
					+ ruta.getMonitor()+"',"+ ruta.getEncuentro()+"',"
					+ ruta.getMinParticipantes()+"',"+ ruta.getMaxParticipantes()+"',"+ ruta.getDescripcion()+";");
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
	
	public boolean update(Ruta ruta) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("UPDATE ruta SET id='"+ruta.getId()+"','"+ruta.getNombre()+"',"
					+ruta.getHoraInicio()+"',"+ ruta.getHoraFin()+"',"+ruta.getDia()+"',"
					+ ruta.getMonitor()+"',"+ ruta.getEncuentro()+"',"
					+ ruta.getMinParticipantes()+"',"+ ruta.getMaxParticipantes()+"',"+ ruta.getDescripcion()+";");
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
	
	public boolean delete(Ruta ruta) {
		
		boolean correcto = false;
		
		try {
			Agente.getAgente().modificar("DELETE FROM ruta WHERE id='"+ruta.getId()+"';");
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
	
	public boolean read(Ruta ruta) {
		boolean correcto=false;
		ResultSet resultado;
		try {
			resultado=Agente.getAgente().leer("SELECT FROM ruta WHERE id='"+ruta.getId()+"';");
			while(resultado.next()) {
				ruta.setId(resultado.getInt(1));
				ruta.setNombre(resultado.getString(2));
				ruta.setHoraInicio(resultado.getString(3));
				ruta.setHoraFin(resultado.getString(4));
				ruta.setDia(resultado.getDate(5));
				ruta.setMonitor(resultado.getString(6));
				ruta.setEncuentro(resultado.getString(7));
				ruta.setMinParticipantes(resultado.getInt(8));
				ruta.setMaxParticipantes(resultado.getInt(9));
				ruta.setDescripcion(resultado.getString(10));
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
			resultado=Agente.getAgente().leer("SELECT * FROM ruta;");
			
			while(resultado.next()) {
				Ruta ruta =new Ruta();
				ruta.setId(resultado.getInt(1));
				ruta.setNombre(resultado.getString(2));
				ruta.setHoraInicio(resultado.getString(3));
				ruta.setHoraFin(resultado.getString(4));
				ruta.setDia(resultado.getDate(5));
				ruta.setMonitor(resultado.getString(6));
				ruta.setEncuentro(resultado.getString(7));
				ruta.setMinParticipantes(resultado.getInt(8));
				ruta.setMaxParticipantes(resultado.getInt(9));
				ruta.setDescripcion(resultado.getString(10));
				
				listaRutas.add(ruta);
				
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
