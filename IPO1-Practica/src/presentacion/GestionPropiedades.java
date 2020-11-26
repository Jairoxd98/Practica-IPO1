package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class GestionPropiedades {

	private JFrame frmGestionPropiedades;
	private JPanel panel;
	private JButton btnCerrarSesion;
	private JButton btnAyuda;
	private JButton btnPersonalizacion;
	private JButton btnDatosPersonales;
	private JLabel lblNombreUsuario;

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
		frmGestionPropiedades.setIconImage(Toolkit.getDefaultToolkit().getImage(GestionPropiedades.class.getResource("/presentacion/choza.png")));
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
				btnCerrarSesion.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/logout (1).png")));
				btnCerrarSesion.setBounds(10, 377, 125, 23);
				panel.add(btnCerrarSesion);
			}
			{
				btnAyuda = new JButton("Ayuda");
				btnAyuda.setBackground(Color.ORANGE);
				btnAyuda.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/informacion.png")));
				btnAyuda.setBounds(10, 343, 125, 23);
				panel.add(btnAyuda);
			}
			{
				btnPersonalizacion = new JButton("Personalizacion");
				btnPersonalizacion.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/personalizacion.png")));
				btnPersonalizacion.setBackground(Color.ORANGE);
				btnPersonalizacion.setBounds(10, 309, 125, 23);
				panel.add(btnPersonalizacion);
			}
			{
				btnDatosPersonales = new JButton("Datos Personales");
				btnDatosPersonales.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/usuario.png")));
				btnDatosPersonales.setBackground(Color.ORANGE);
				btnDatosPersonales.setBounds(10, 275, 125, 23);
				panel.add(btnDatosPersonales);
			}
			{
				lblNombreUsuario = new JLabel("");
				//lblNombreUsuario.setText();
				lblNombreUsuario.setBounds(67, 223, 46, 14);
				panel.add(lblNombreUsuario);
			}
		}
	}

	public void setVisible(boolean b) {
		frmGestionPropiedades.setVisible(b);
	}
	private class BtnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Se crea una instancia de la segunda ventana (JFrame)
			login otraVentana = new login();
			//se hace visible
			otraVentana.setVisible(true);
			//se destruye la ventana actual (atributo a nivel de clase)
			frmGestionPropiedades.setVisible(false);
		}
	}
}
