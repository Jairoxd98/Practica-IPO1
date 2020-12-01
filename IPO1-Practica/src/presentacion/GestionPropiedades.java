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

public class GestionPropiedades {

	private JFrame frmGestionPropiedades;
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
			panel.setBackground(new Color(0, 128, 0));
			frmGestionPropiedades.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				splitPane = new JSplitPane();
				splitPane.setDividerSize(0);
				splitPane.setBorder(null);
				splitPane.setBounds(10, 11, 564, 389);
				panel.add(splitPane);
				{
					panelCard = new JPanel();
					splitPane.setRightComponent(panelCard);
					panelCard.setLayout(new CardLayout(0, 0));
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
							tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
							tree.setForeground(new Color(0, 128, 0));
							tree.setModel(new DefaultTreeModel(
								new DefaultMutableTreeNode("Gestion ") {
									{
										DefaultMutableTreeNode node_1;
										node_1 = new DefaultMutableTreeNode("Propiedades");
											node_1.add(new DefaultMutableTreeNode("Añadir"));
											node_1.add(new DefaultMutableTreeNode("Modificar"));
										add(node_1);
										node_1 = new DefaultMutableTreeNode("Personal");
											node_1.add(new DefaultMutableTreeNode("Añadir"));
											node_1.add(new DefaultMutableTreeNode("Modificar"));
										add(node_1);
										node_1 = new DefaultMutableTreeNode("Actividades");
											node_1.add(new DefaultMutableTreeNode("Añadir"));
											node_1.add(new DefaultMutableTreeNode("Modificar"));
										add(node_1);
										node_1 = new DefaultMutableTreeNode("Rutas");
											node_1.add(new DefaultMutableTreeNode("Añadir"));
											node_1.add(new DefaultMutableTreeNode("Modificar"));
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
						panelBotones.setMinimumSize(new Dimension(150, 225));
						panelBotones.setBorder(null);
						panelBotones.setBackground(new Color(0, 128, 0));
						splitPaneIzquierda.setRightComponent(panelBotones);
						panelBotones.setLayout(null);
						{
							lblFechaUltimoAcceso = new JLabel(cogeHora());
							lblFechaUltimoAcceso.setBounds(10, 58, 135, 14);
							panelBotones.add(lblFechaUltimoAcceso);
							lblFechaUltimoAcceso.setHorizontalAlignment(SwingConstants.CENTER);
						}
						{
							btnDatosPersonales = new JButton("Datos Personales");
							btnDatosPersonales.setBounds(10, 83, 135, 23);
							panelBotones.add(btnDatosPersonales);
							btnDatosPersonales.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Icon/usuario.png")));
							btnDatosPersonales.setBackground(Color.ORANGE);
						}
						{
							btnPersonalizacion = new JButton("Personalizacion");
							btnPersonalizacion.setBounds(10, 117, 135, 23);
							panelBotones.add(btnPersonalizacion);
							btnPersonalizacion.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Icon/personalizacion.png")));
							btnPersonalizacion.setBackground(Color.ORANGE);
						}
						{
							btnAyuda = new JButton("Ayuda");
							btnAyuda.setBounds(10, 151, 135, 23);
							panelBotones.add(btnAyuda);
							btnAyuda.setBackground(Color.ORANGE);
							btnAyuda.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Icon/informacion.png")));
						}
						{
							btnCerrarSesion = new JButton("Cerrar Sesion");
							btnCerrarSesion.setBounds(10, 185, 135, 23);
							panelBotones.add(btnCerrarSesion);
							btnCerrarSesion.setBackground(Color.ORANGE);
							btnCerrarSesion.addActionListener(new BtnCerrarSesionActionListener());
							btnCerrarSesion.setForeground(Color.BLACK);
							btnCerrarSesion.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Icon/logout (1).png")));
						}
						{
							lblNombreUsuario = new JLabel("Jairo");
							lblNombreUsuario.setOpaque(true);
							lblNombreUsuario.setForeground(new Color(0, 0, 0));
							lblNombreUsuario.setBackground(new Color(0, 128, 0));
							lblNombreUsuario.setBounds(81, 27, 46, 14);
							panelBotones.add(lblNombreUsuario);
						}
						{
							lblFotoUsuario = new JLabel("");
							lblFotoUsuario.setIcon(new ImageIcon(GestionPropiedades.class.getResource("/presentacion/Imagenes/perfil.png")));
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
	private class FrmInicioWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			JOptionPane.showMessageDialog(frmGestionPropiedades, "Gracias por utilizar nuestra aplicación", "Cerrar la aplicación",JOptionPane.PLAIN_MESSAGE);
		}
	}
}
