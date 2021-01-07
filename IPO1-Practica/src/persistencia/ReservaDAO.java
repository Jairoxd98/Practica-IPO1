package persistencia;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Reserva;

public class ReservaDAO {

	private ArrayList<Reserva> listaReservas;
	
	public ReservaDAO() {
		this.listaReservas=new ArrayList<Reserva>();
	}
	
	public ArrayList<Reserva> getListaReservas(){
		return this.listaReservas;
	}
	
	
	public boolean insert(Reserva reserva) {
		boolean correcto=false;
		
		try {
			Agente.getAgente().modificar("INSERT INTO reserva VALUES('"+reserva.getId()+"','"+reserva.getFechaEntrada()+"',"
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
	
	public boolean read(Reserva reserva) {
		boolean correcto=false;
		ResultSet resultado;
		try {
			resultado=Agente.getAgente().leer("SELECT FROM usuarios WHERE id='"+reserva.getId()+"';");
			while(resultado.next()) {
				reserva.setId(resultado.getInt(1));
				reserva.setFechaEntrada(resultado.getString(2));
				reserva.setFechaSalida(resultado.getString(3));
				reserva.setNombre(resultado.getString(4));
				reserva.setTipo(resultado.getString(5));
				reserva.setTelefono(resultado.getString(6));
				reserva.setEmail(resultado.getString(7));
				reserva.setOcupantes(resultado.getInt(8));
				reserva.setSolicitud(resultado.getString(9));
				reserva.setHoraEntrada(resultado.getString(10));
				reserva.setHoraSalida(resultado.getString(11));
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
			resultado=Agente.getAgente().leer("SELECT * FROM reserva;");
			
			while(resultado.next()) {
				Reserva reserva=new Reserva();
				reserva.setId(resultado.getInt(1));
				reserva.setFechaEntrada(resultado.getString(2));
				reserva.setFechaSalida(resultado.getString(3));
				reserva.setNombre(resultado.getString(4));
				reserva.setTipo(resultado.getString(5));
				reserva.setTelefono(resultado.getString(6));
				reserva.setEmail(resultado.getString(7));
				reserva.setOcupantes(resultado.getInt(8));
				reserva.setSolicitud(resultado.getString(9));
				reserva.setHoraEntrada(resultado.getString(10));
				reserva.setHoraSalida(resultado.getString(11));
				
				listaReservas.add(reserva);
				
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
