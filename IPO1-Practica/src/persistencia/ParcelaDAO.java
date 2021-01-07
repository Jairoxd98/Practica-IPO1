package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Parcela;
import dominio.Reserva;



public class ParcelaDAO {

	private ArrayList<Parcela> listaParcelas;
	
	public ParcelaDAO() {
		this.listaParcelas=new ArrayList<Parcela>();
	}
	
	public ArrayList<Parcela> getListaParcelas(){
		return this.listaParcelas;
	}
	/*
	public boolean insert(Parcela parcela) {
		boolean correcto=false;
		
		try {
			Agente.getAgente().modificar("INSERT INTO parcela VALUES('"+parcela.getId()+"','"+parcela.getPrecio()+"',"
					+reserva.getFechaSalida()+"',"+ reserva.getNombre()+"',"+ reserva.getTipo()+"',"+ reserva.getTelefono()+"',"+reserva.getEmail()+"',"
					+ reserva.getOcupantes()+"',"+ reserva.getSolicitud()+"',"
					+ reserva.getHoraEntrada()+"',"+ reserva.getHoraSalida()+";");
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
	
		public boolean update(Reserva reserva) {
		boolean correcto = false;
		try {
			Agente.getAgente().modificar("UPDATE reserva SET nombre='"+reserva.getNombre()+"','"+reserva.getFechaEntrada()+"',"
					+reserva.getFechaSalida()+"',"+ reserva.getTipo()+"',"+ reserva.getTelefono()+"',"+reserva.getEmail()+"',"
					+ reserva.getOcupantes()+"',"+ reserva.getSolicitud()+"',"
					+ reserva.getHoraEntrada()+"',"+ reserva.getHoraSalida()+"' WHERE id='"+reserva.getId()+"';");
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
	
	public boolean delete(Reserva reserva) {
		
		boolean correcto = false;
		
		try {
			Agente.getAgente().modificar("DELETE FROM reserva WHERE id='"+reserva.getId()+"';");
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
	
	
	*/
	public boolean read(Parcela parcela) {
		boolean correcto=false;
		ResultSet resultado;
		try {
			resultado=Agente.getAgente().leer("SELECT FROM parcelas WHERE id="+parcela.getId()+";");
			while(resultado.next()) {
				parcela.setId(resultado.getInt(1));
				parcela.setTipo(resultado.getString(2));
				parcela.setPrecio(resultado.getInt(3));
				parcela.setTemporada(resultado.getString(4));
				parcela.setTamano(resultado.getString(5));
				parcela.setUbicacion(resultado.getString(6));
				parcela.setCaracteristicas(resultado.getString(7));
				parcela.setDisponibilidad(resultado.getString(9));
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
			resultado=Agente.getAgente().leer("SELECT * FROM parcela;");
			
			while(resultado.next()) {
				Parcela parcela=new Parcela();
				parcela.setId(resultado.getInt(1));
				parcela.setTipo(resultado.getString(2));
				parcela.setPrecio(resultado.getInt(3));
				parcela.setTemporada(resultado.getString(4));
				parcela.setTamano(resultado.getString(5));
				parcela.setUbicacion(resultado.getString(6));
				parcela.setCaracteristicas(resultado.getString(7));
				parcela.setDisponibilidad(resultado.getString(9));
				
				listaParcelas.add(parcela);
				
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
