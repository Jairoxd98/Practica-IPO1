package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Bungalow;

public class BungalowDAO {

	

		private ArrayList<Bungalow> listaBungalows;
		
		public BungalowDAO() {
			this.listaBungalows=new ArrayList<Bungalow>();
		}
		
		public ArrayList<Bungalow> getListaBungalows(){
			return this.listaBungalows;
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
		public boolean read(Bungalow bungalow) {
			boolean correcto=false;
			ResultSet resultado;
			try {
				resultado=Agente.getAgente().leer("SELECT FROM bungalow WHERE id="+bungalow.getId()+";");
				while(resultado.next()) {
					bungalow.setId(resultado.getInt(1));
					bungalow.setTamano(resultado.getString(2));
					bungalow.setCapacidadMax(resultado.getInt(3));
					bungalow.setPrecio(resultado.getInt(4));
					bungalow.setEstanciaMin(resultado.getInt(5));
					bungalow.setEquipamiento(resultado.getString(6));
					bungalow.setDescripcion(resultado.getString(7));
					bungalow.setDisponibilidad(resultado.getString(8));
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
				resultado=Agente.getAgente().leer("SELECT * FROM bungalow;");
				
				while(resultado.next()) {
					Bungalow bungalow=new Bungalow();
					bungalow.setId(resultado.getInt(1));
					bungalow.setTamano(resultado.getString(2));
					bungalow.setCapacidadMax(resultado.getInt(3));
					bungalow.setPrecio(resultado.getInt(4));
					bungalow.setEstanciaMin(resultado.getInt(5));
					bungalow.setEquipamiento(resultado.getString(6));
					bungalow.setDescripcion(resultado.getString(7));
					bungalow.setDisponibilidad(resultado.getString(8));
					
					listaBungalows.add(bungalow);
					
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
