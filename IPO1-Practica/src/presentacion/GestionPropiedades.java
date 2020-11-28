package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GestionPropiedades {

	private JFrame frmGestionPropiedades;
	private JPanel panel;
	private JButton btnCerrarSesion;
	private JButton btnAyuda;
	private JButton btnPersonalizacion;
	private JButton btnDatosPersonales;
	private JLabel lblNombreUsuario;
	
	private login log= new login();
	private JLabel lblFechaUltimoAcceso;
	private JLabel lblFotoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPropiedades window = new GestionPropiedades();
					window.frmGestionPropiedades.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionPropiedades() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionPropiedades = new JFrame();
		frmGestionPropiedades.setIconImage(Toolkit.getDefaultToolkit().getImage(GestionPropiedades.class.getResource("/presentacion/Icon/choza.png")));
		frmGestionPropiedades.setBounds(100, 100, 600, 450);
		frmGestionPropiedades.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			panel.setBackground(new Color(51, 153, 0));
			frmGestionPropiedades.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				btnCerrarSesion = new JButton("Cerrar Sesion");
				btnCerrarSesion.setBackground(Color.ORANGE);
				btnCerrarSesion.addActionListener(new BtnCerrarSesionActionListener());
				btnCerrarSesion.setForeground(Color.BLACK);
				btnCerrarSesion.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Icon/logout (1).png")));
				btnCerrarSesion.setBounds(10, 377, 135, 23);
				panel.add(btnCerrarSesion);
			}
			{
				btnAyuda = new JButton("Ayuda");
				btnAyuda.setBackground(Color.ORANGE);
				btnAyuda.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Icon/informacion.png")));
				btnAyuda.setBounds(10, 343, 135, 23);
				panel.add(btnAyuda);
			}
			{
				btnPersonalizacion = new JButton("Personalizacion");
				btnPersonalizacion.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Icon/personalizacion.png")));
				btnPersonalizacion.setBackground(Color.ORANGE);
				btnPersonalizacion.setBounds(10, 309, 135, 23);
				panel.add(btnPersonalizacion);
			}
			{
				btnDatosPersonales = new JButton("Datos Personales");
				btnDatosPersonales.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Icon/usuario.png")));
				btnDatosPersonales.setBackground(Color.ORANGE);
				btnDatosPersonales.setBounds(10, 275, 135, 23);
				panel.add(btnDatosPersonales);
			}
			{
				lblNombreUsuario = new JLabel(log.getUser()); 
				lblNombreUsuario.setBounds(65, 217, 46, 14);
				panel.add(lblNombreUsuario);
			}
			{
				lblFechaUltimoAcceso = new JLabel(cogeHora());
				lblFechaUltimoAcceso.setHorizontalAlignment(SwingConstants.CENTER);
				lblFechaUltimoAcceso.setBounds(10, 248, 135, 14);
				panel.add(lblFechaUltimoAcceso);
			}
			{
				lblFotoUsuario = new JLabel("");
				lblFotoUsuario.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Imagenes/perfil.png")));
				lblFotoUsuario.setBounds(25, 207, 30, 30);
				panel.add(lblFotoUsuario);
			}
		}
	}
	
	public String cogeHora() {
		Calendar calendario = Calendar.getInstance();
		int hora, minutos, segundos, dia, mes, año;
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		dia = calendario.get(Calendar.DATE);
		mes = calendario.get(Calendar.MONTH);
		año = calendario.get(Calendar.YEAR);
		
		return hora + ":" + minutos + ":" + segundos + " - " + dia + "/" + mes + "/" + año;
	}
	public void setVisible(boolean b) {
		frmGestionPropiedades.setVisible(b);
	}
	private class BtnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//se hace visible
			log.setVisible(true);
			//se destruye la ventana actual (atributo a nivel de clase)
			frmGestionPropiedades.setVisible(false);
		}
	}
}
