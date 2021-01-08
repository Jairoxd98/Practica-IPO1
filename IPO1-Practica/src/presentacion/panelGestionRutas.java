package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import dominio.Ruta;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;

public class panelGestionRutas extends JPanel {
	private JToolBar toolBar;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel pnlTabla;
	private JPanel pnlInfo;
	private JPanel pnlInfoRuta;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JLabel lblDia;
	private JLabel lblMonitor;
	private JLabel lblEncuentro;
	private JLabel lblMinimoDeParticipantes;
	private JLabel lblMaximoDeParticipantes;
	private JLabel lblDescripcion;
	private JLabel lblMapa;
	private JLabel lblFoto;
	private JTextArea txtDescripcion;
	private JScrollPane scrollPane;
	private JList lstRutas;
	private JTextField txtId;
	private JTextField txtMonitor;
	private JTextField txtNombre;
	private JTextField txtHoraInicio;
	private JTextField txtDia;
	private JTextField txtHoraFin;
	private JTextField txtEncuentro;
	private ArrayList<Ruta> list = cargarRuta();
	private Color colorBlanco = new Color(255, 255, 255);
	private Color colorResaltado = new Color(255, 255, 210);
	private JTextField txtMaxParticipantes;
	private JTextField txtMinParticipantes;
	private JSeparator separator;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	/**
	 * Create the panel.
	 */
	public panelGestionRutas() {
		setLayout(null);
		{
			toolBar = new JToolBar();
			toolBar.setBounds(0, 0, 650, 41);
			add(toolBar);
			{
				btnAnadir = new JButton("Añadir");
				btnAnadir.setToolTipText("Añadir ruta nueva");
				btnAnadir.addActionListener(new BtnAadirActionListener());
				btnAnadir.setIcon(new ImageIcon(panelGestionRutas.class.getResource("/presentacion/Icon/anadir2.png")));
				toolBar.add(btnAnadir);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new BtnModificarActionListener());
				btnModificar.setToolTipText("Modificar ruta seleccionada");
				btnModificar.setIcon(new ImageIcon(panelGestionRutas.class.getResource("/presentacion/Icon/editar2.png")));
				toolBar.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new BtnEliminarActionListener());
				btnEliminar.setToolTipText("Eliminar ruta seleccionada");
				btnEliminar.setIcon(new ImageIcon(panelGestionRutas.class.getResource("/presentacion/Icon/borrar.png")));
				toolBar.add(btnEliminar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.setVisible(false);
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				btnGuardar.setToolTipText("Guardar datos modificados");
				btnGuardar.setIcon(new ImageIcon(panelGestionRutas.class.getResource("/presentacion/Icon/guardar.png")));
				toolBar.add(btnGuardar);
			}
			{
				btnLimpiar = new JButton("Limpiar");
				btnLimpiar.setVisible(false);
				btnLimpiar.addActionListener(new BtnLimpiarActionListener());
				btnLimpiar.setToolTipText("Limpiar cajas de texto");
				btnLimpiar.setIcon(new ImageIcon(panelGestionRutas.class.getResource("/presentacion/Icon/limpio.png")));
				toolBar.add(btnLimpiar);
			}
			{
				separator = new JSeparator();
				toolBar.add(separator);
			}
		}
		{
			pnlTabla = new JPanel();
			pnlTabla.setBounds(10, 52, 155, 387);
			add(pnlTabla);
			pnlTabla.setLayout(new BorderLayout(0, 0));
			{
				scrollPane = new JScrollPane();
				pnlTabla.add(scrollPane, BorderLayout.CENTER);
				{
					lstRutas = new JList();
					lstRutas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					lstRutas.setModel(new AbstractListModel() {
						String[] values = new String[] {list.get(1).getNombre(), list.get(1).getNombre()};
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
					scrollPane.setViewportView(lstRutas);
				}
			}
		}
		{
			pnlInfo = new JPanel();
			pnlInfo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			pnlInfo.setBounds(175, 52, 465, 387);
			add(pnlInfo);
			pnlInfo.setLayout(null);
			{
				pnlInfoRuta = new JPanel();
				pnlInfoRuta.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Informacion de la ruta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlInfoRuta.setBounds(10, 11, 445, 241);
				pnlInfo.add(pnlInfoRuta);
				pnlInfoRuta.setLayout(null);
				{
					lblId = new JLabel("ID:");
					lblId.setBounds(25, 38, 67, 14);
					pnlInfoRuta.add(lblId);
				}
				{
					lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(25, 79, 67, 14);
					pnlInfoRuta.add(lblNombre);
				}
				{
					lblHoraInicio = new JLabel("Hora inicio:");
					lblHoraInicio.setBounds(25, 118, 67, 14);
					pnlInfoRuta.add(lblHoraInicio);
				}
				{
					lblHoraFin = new JLabel("Hora fin:");
					lblHoraFin.setBounds(260, 118, 67, 14);
					pnlInfoRuta.add(lblHoraFin);
				}
				{
					lblDia = new JLabel("Dia:");
					lblDia.setBounds(260, 79, 67, 14);
					pnlInfoRuta.add(lblDia);
				}
				{
					lblMonitor = new JLabel("Monitor:");
					lblMonitor.setBounds(260, 38, 67, 14);
					pnlInfoRuta.add(lblMonitor);
				}
				{
					lblEncuentro = new JLabel("Encuentro:");
					lblEncuentro.setBounds(113, 160, 75, 14);
					pnlInfoRuta.add(lblEncuentro);
				}
				{
					lblMinimoDeParticipantes = new JLabel("Minimo de participantes:");
					lblMinimoDeParticipantes.setBounds(257, 199, 146, 14);
					pnlInfoRuta.add(lblMinimoDeParticipantes);
				}
				{
					lblMaximoDeParticipantes = new JLabel("Maximo de participantes:");
					lblMaximoDeParticipantes.setBounds(25, 202, 153, 14);
					pnlInfoRuta.add(lblMaximoDeParticipantes);
				}
				{
					txtId = new JTextField();
					txtId.setEditable(false);
					txtId.addFocusListener(new MiFocusListener());
					txtId.setBounds(102, 35, 86, 20);
					pnlInfoRuta.add(txtId);
					txtId.setColumns(10);
				}
				{
					txtMonitor = new JTextField();
					txtMonitor.setEditable(false);
					txtMonitor.addFocusListener(new MiFocusListener());
					txtMonitor.setBounds(337, 38, 86, 20);
					pnlInfoRuta.add(txtMonitor);
					txtMonitor.setColumns(10);
				}
				{
					txtNombre = new JTextField();
					txtNombre.setEditable(false);
					txtNombre.addFocusListener(new MiFocusListener());
					txtNombre.setBounds(102, 76, 86, 20);
					pnlInfoRuta.add(txtNombre);
					txtNombre.setColumns(10);
				}
				{
					txtHoraInicio = new JTextField();
					txtHoraInicio.setEditable(false);
					txtHoraInicio.addFocusListener(new MiFocusListener());
					txtHoraInicio.setBounds(102, 115, 86, 20);
					pnlInfoRuta.add(txtHoraInicio);
					txtHoraInicio.setColumns(10);
				}
				{
					txtDia = new JTextField();
					txtDia.setEditable(false);
					txtDia.addFocusListener(new MiFocusListener());
					txtDia.setBounds(337, 79, 86, 20);
					pnlInfoRuta.add(txtDia);
					txtDia.setColumns(10);
				}
				{
					txtHoraFin = new JTextField();
					txtHoraFin.setEditable(false);
					txtHoraFin.addFocusListener(new MiFocusListener());
					txtHoraFin.setBounds(337, 118, 86, 20);
					pnlInfoRuta.add(txtHoraFin);
					txtHoraFin.setColumns(10);
				}
				{
					txtEncuentro = new JTextField();
					txtEncuentro.setEditable(false);
					txtEncuentro.addFocusListener(new MiFocusListener());
					txtEncuentro.setBounds(195, 157, 153, 20);
					pnlInfoRuta.add(txtEncuentro);
					txtEncuentro.setColumns(10);
				}
				{
					txtMaxParticipantes = new JTextField();
					txtMaxParticipantes.setEditable(false);
					txtMaxParticipantes.addFocusListener(new MiFocusListener());
					txtMaxParticipantes.setBounds(176, 199, 30, 20);
					pnlInfoRuta.add(txtMaxParticipantes);
					txtMaxParticipantes.setColumns(10);
				}
				{
					txtMinParticipantes = new JTextField();
					txtMinParticipantes.setEditable(false);
					txtMinParticipantes.addFocusListener(new MiFocusListener());
					txtMinParticipantes.setColumns(10);
					txtMinParticipantes.setBounds(405, 196, 30, 20);
					pnlInfoRuta.add(txtMinParticipantes);
				}
			}
			{
				lblDescripcion = new JLabel("Descripcion:");
				lblDescripcion.setBounds(10, 263, 89, 14);
				pnlInfo.add(lblDescripcion);
			}
			{
				lblMapa = new JLabel("Mapa:");
				lblMapa.setBounds(223, 263, 55, 14);
				pnlInfo.add(lblMapa);
			}
			{
				lblFoto = new JLabel("");
				lblFoto.setToolTipText("Mapa de la ruta");
				lblFoto.setBounds(257, 263, 198, 113);
				pnlInfo.add(lblFoto);
			}
			{
				txtDescripcion = new JTextArea();
				txtDescripcion.setEditable(false);
				txtDescripcion.setBounds(10, 284, 198, 92);
				pnlInfo.add(txtDescripcion);
			}
		}

	}
	private static ArrayList<Ruta> cargarRuta() {

		Ruta ruta = new Ruta();
		boolean correcto = false;

		correcto = ruta.readAll();

		if (correcto) {
			return (ruta.getRutaDAO().getListaRutas());
		} else {
			return null;
		}
	}
	
	private class MiFocusListener extends FocusAdapter {// Metodo global para los JTextField a la hora de rellenar un campo
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(colorResaltado);
		}

		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorBlanco);
		}
	}
	
	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			enableText(true);
		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(comprobarVacio()) {//Si hay algun campo vacio
				JOptionPane.showMessageDialog(btnGuardar, "No has rellanado todos los campos.","Campos sin rellenar",JOptionPane.ERROR_MESSAGE);
			}else {//Si no los guarda, 	
				
				enableText(false);
			}
		}
	}
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vaciarCajas();
		}
	}
	public void enableText(boolean b) {
		txtId.setEditable(b);
		txtNombre.setEditable(b);
		txtHoraInicio.setEditable(b);
		txtHoraFin.setEditable(b);
		txtDia.setEditable(b);
		txtMonitor.setEditable(b);
		txtEncuentro.setEditable(b);
		txtMaxParticipantes.setEditable(b);
		txtMinParticipantes.setEditable(b);
		txtDescripcion.setEditable(b);
		btnGuardar.setVisible(b);
		btnLimpiar.setVisible(b);
	}
	private void vaciarCajas() {//Metodo universal para vaciar todos los JTextField
		JTextField caja;
		for (int i = 0; i < pnlInfo.getComponentCount(); i++) {
			if(pnlInfo.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfo.getComponent(i);
				caja.setText("");
			}
		}
		lblFoto.setIcon(null);
		lblFoto.revalidate();	
	}
	
	public boolean comprobarVacio() {
		JTextField caja;
		for (int i = 0; i < pnlInfo.getComponentCount(); i++) {
			if(pnlInfo.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfo.getComponent(i);
				if(caja.getText().length()==0) {
					return true;
				}
			}
		}
		return false;
	}
}
