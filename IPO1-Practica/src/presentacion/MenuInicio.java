package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import java.awt.CardLayout;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import dominio.Usuario;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class MenuInicio {

	JFrame frmMenuInicio;
	private JPanel panel;
	private JButton btnCerrarSesion;
	private JButton btnAyuda;
	private JButton btnPersonalizacion;
	private JButton btnDatosPersonales;
	
	private login log= new login();
	private JLabel lblFechaUltimoAcceso;
	private JSplitPane splitPane;
	private JPanel panelCard;
	private JSplitPane splitPaneIzquierda;
	private JScrollPane scrollPane;
	private JTree tree;
	private JPanel panelBotones;
	private JLabel lblNombreUsuario;
	private JLabel lblFotoUsuario;
	private JPanel pnlDatosPersonales;
	private JPanel pnlPersonalizacion;
	private JPanel pnlGestionReservas;
	private JPanel pnlGestionEmpleados;
	private JPanel pnlGestionRutas;
	private JPanel pnlDiseñoRutas;
	private JPanel pnlGestionPropiedades;
	private JPanel pnlActividades;
	private static MenuInicio window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {							//Cuando se ejecuta solo esta ventana sin entrar por el login
					Usuario usuario = new Usuario("01234567T", "Alba", "Arias", "987654321", "Calle", "Alba@gmail.es", "03-01-2000", "Alba", "123");
					window = new MenuInicio(usuario);
					window.frmMenuInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuInicio(Usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Usuario usuario) {
		frmMenuInicio = new JFrame();
		frmMenuInicio.getContentPane().setBackground(Color.DARK_GRAY);
		frmMenuInicio.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuInicio.class.getResource("/presentacion/Icon/choza.png")));
		frmMenuInicio.setBounds(100, 100, 850, 500);
		frmMenuInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		{
			panel = new JPanel();
			panel.setBackground(new Color(0, 128, 0));
			frmMenuInicio.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				splitPane = new JSplitPane();
				splitPane.setDividerSize(0);
				splitPane.setBorder(null);
				splitPane.setBounds(10, 11, 814, 439);
				panel.add(splitPane);
				{
					panelCard = new JPanel();
					splitPane.setRightComponent(panelCard);
					panelCard.setLayout(new CardLayout(0, 0));
					{
						pnlGestionReservas = new panelGestionReservas();
						panelCard.add(pnlGestionReservas, "Reservas");
					}
					{
						pnlGestionPropiedades = new panelGestionPropiedades();
						panelCard.add(pnlGestionPropiedades, "Propiedades");
					}
					{
						pnlGestionEmpleados = new panelGestionEmpleados();
						panelCard.add(pnlGestionEmpleados, "Empleados");
					}
					{
						pnlActividades = new paneGestionActividades();
						panelCard.add(pnlActividades, "Actividades");
					}
					{
						pnlGestionRutas = new panelGestionRutas();
						panelCard.add(pnlGestionRutas, "Rutas");
					}
					{
						pnlDiseñoRutas = new panelDiseñoRutas();
						panelCard.add(pnlDiseñoRutas, "Diseño rutas");
					}
					{
						pnlDatosPersonales = new panelDatosPersonales(usuario);
						panelCard.add(pnlDatosPersonales, "Datos Personales");
					}
					{
						pnlPersonalizacion = new panelPersonalizacion();
						panelCard.add(pnlPersonalizacion, "Personalizacion");
					}
				}
				{
					splitPaneIzquierda = new JSplitPane();
					splitPaneIzquierda.setDividerSize(0);
					splitPaneIzquierda.setBorder(null);
					splitPaneIzquierda.setOrientation(JSplitPane.VERTICAL_SPLIT);
					splitPane.setLeftComponent(splitPaneIzquierda);
					{
						scrollPane = new JScrollPane();
						scrollPane.setBorder(null);
						scrollPane.setMaximumSize(new Dimension(200, 120));
						scrollPane.setMinimumSize(new Dimension(150, 70));
						splitPaneIzquierda.setLeftComponent(scrollPane);
						{
							tree = new JTree();
							tree.addTreeSelectionListener(new TreeTreeSelectionListener());
							tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
							tree.setForeground(new Color(0, 128, 0));
							tree.setModel(new DefaultTreeModel(
								new DefaultMutableTreeNode("Gestion") {
									{
										DefaultMutableTreeNode node_1;
										node_1 = new DefaultMutableTreeNode("Reservas");
										add(node_1);
										node_1 = new DefaultMutableTreeNode("Propiedades");
										add(node_1);
										node_1 = new DefaultMutableTreeNode("Empleados");
										add(node_1);
										node_1 = new DefaultMutableTreeNode("Actividades");
										add(node_1);
										node_1 = new DefaultMutableTreeNode("Rutas");
											node_1.add(new DefaultMutableTreeNode("Diseño rutas"));
										add(node_1);
									}
								}
							));
							tree.setBorder(null);
							tree.setBackground(new Color(0, 128, 0));
							scrollPane.setViewportView(tree);
							tree.setCellRenderer(new MiRenderizadoArbol());
						}
					}
					{
						panelBotones = new JPanel();
						panelBotones.setForeground(new Color(0, 128, 0));
						panelBotones.setMinimumSize(new Dimension(165, 225));
						panelBotones.setBorder(null);
						panelBotones.setBackground(new Color(0, 128, 0));
						splitPaneIzquierda.setRightComponent(panelBotones);
						panelBotones.setLayout(null);
						{
							lblFechaUltimoAcceso = new JLabel(cogeHora());
							lblFechaUltimoAcceso.setBounds(10, 58, 135, 14);
							panelBotones.add(lblFechaUltimoAcceso);
							lblFechaUltimoAcceso.setHorizontalAlignment(SwingConstants.CENTER);
							lblFechaUltimoAcceso.setForeground(Color.BLACK);
						}
						{
							btnDatosPersonales = new JButton("Datos Personales");
							btnDatosPersonales.addActionListener(new BtnDatosPersonalesActionListener());
							btnDatosPersonales.setBounds(0, 83, 155, 23);
							panelBotones.add(btnDatosPersonales);
							btnDatosPersonales.setIcon(new ImageIcon(MenuInicio.class.getResource("/presentacion/Icon/usuario.png")));
							btnDatosPersonales.setBackground(Color.ORANGE);
							btnDatosPersonales.setForeground(Color.BLACK);
						}
						{
							btnPersonalizacion = new JButton("Personalizacion");
							btnPersonalizacion.addActionListener(new BtnPersonalizacionActionListener());
							btnPersonalizacion.setBounds(0, 117, 155, 23);
							panelBotones.add(btnPersonalizacion);
							btnPersonalizacion.setIcon(new ImageIcon(MenuInicio.class.getResource("/presentacion/Icon/personalizacion.png")));
							btnPersonalizacion.setBackground(Color.ORANGE);
							btnPersonalizacion.setForeground(Color.BLACK);
						}
						{
							btnAyuda = new JButton("Ayuda");
							btnAyuda.addActionListener(new BtnAyudaActionListener());
							btnAyuda.setBounds(0, 151, 155, 23);
							panelBotones.add(btnAyuda);
							btnAyuda.setBackground(Color.ORANGE);
							btnAyuda.setForeground(Color.BLACK);
							btnAyuda.setIcon(new ImageIcon(MenuInicio.class.getResource("/presentacion/Icon/informacion.png")));
						}
						{
							btnCerrarSesion = new JButton("Cerrar Sesion");
							btnCerrarSesion.setBounds(0, 185, 155, 23);
							panelBotones.add(btnCerrarSesion);
							btnCerrarSesion.setBackground(Color.ORANGE);
							btnCerrarSesion.addActionListener(new BtnCerrarSesionActionListener());
							btnCerrarSesion.setForeground(Color.BLACK);
							btnCerrarSesion.setIcon(new ImageIcon(MenuInicio.class.getResource("/presentacion/Icon/logout (1).png")));
						}
						{
							lblNombreUsuario = new JLabel(usuario.getNombre());
							lblNombreUsuario.setOpaque(true);
							lblNombreUsuario.setForeground(new Color(0, 0, 0));
							lblNombreUsuario.setBackground(new Color(0, 128, 0));
							lblNombreUsuario.setBounds(81, 27, 46, 14);
							panelBotones.add(lblNombreUsuario);
						}
						{
							lblFotoUsuario = new JLabel("");
							lblFotoUsuario.setIcon(new ImageIcon(MenuInicio.class.getResource("/presentacion/Imagenes/"+usuario.getNombre()+".png")));
							lblFotoUsuario.setBounds(20, 17, 30, 30);
							panelBotones.add(lblFotoUsuario);
						}
					}
				}
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
	
	public void setVisibleHora(boolean v) {
		lblFechaUltimoAcceso.setVisible(v);
	}
	
	public void setVisible(boolean b) {
		frmMenuInicio.setVisible(b);
	}
	private class BtnCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//se hace visible
			log.setVisible(true);
			//se destruye la ventana actual (atributo a nivel de clase)
			frmMenuInicio.setVisible(false);
		}
	}
	private class FrmInicioWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			JOptionPane.showMessageDialog(frmMenuInicio, "Gracias por utilizar nuestra aplicación", "Cerrar la aplicación",JOptionPane.PLAIN_MESSAGE);
		}
	}
	private class BtnAyudaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(java.awt.Desktop.isDesktopSupported()) {
				java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
				if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
					try {
						java.net.URI urlAyuda = new java.net.URI("https://youtu.be/64XoTxV73fY");
						desktop.browse(urlAyuda);
					} catch (IOException | URISyntaxException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	private class BtnDatosPersonalesActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((CardLayout) panelCard.getLayout()).show(panelCard, "Datos Personales");
		}
	}
	private class TreeTreeSelectionListener implements TreeSelectionListener {
		public void valueChanged(TreeSelectionEvent e) {
			String nodo = (e.getPath().getLastPathComponent()).toString();
			switch (nodo)
			{
			case "Reservas":
			case "Propiedades":
			case "Empleados":
			case "Actividades":
			case "Rutas":
			case "Diseño rutas":
			((CardLayout) panelCard.getLayout()).show(panelCard, nodo);
			}
		}
	}
	private class BtnPersonalizacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((CardLayout) panelCard.getLayout()).show(panelCard, "Personalizacion");
		}
	}
	
	public MenuInicio pasa() {
		return window;
	}
	
	
}
