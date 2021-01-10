package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import dominio.Ruta;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JSeparator;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

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
	private Color colorRojo = Color.RED;
	private Color colorDefectoBotones;
	private JTextField txtMaxParticipantes;
	private JTextField txtMinParticipantes;
	private JSeparator separator;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private int MODO;
	//Imagen en la que se cargará el fichero seleccionado por el usuario
	private ImageIcon imagen;
	private JButton btnDisenarRuta;
	private JButton btnBorrarMapa;
	private panelDiseñoRutas pDRutas= new panelDiseñoRutas();
	
	/**
	 * Create the panel.
	 */
	public panelGestionRutas() {
		setLayout(null);
		{
			toolBar = new JToolBar();
			toolBar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			toolBar.setBounds(0, 0, 650, 41);
			add(toolBar);
			{
				btnAnadir = new JButton("Añadir");
				btnAnadir.setToolTipText("Añadir ruta nueva");
				btnAnadir.addActionListener(new BtnAnadirActionListener());
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
				btnGuardar.setToolTipText("Guardar datos");
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
				btnDisenarRuta = new JButton("Cargar");
				btnDisenarRuta.setBackground(new Color(124, 252, 0));
				btnDisenarRuta.setToolTipText("Cargar Mapa Ruta");
				btnDisenarRuta.addActionListener(new BtnDisenarRutaActionListener());
				btnDisenarRuta.setVisible(false);
				btnDisenarRuta.setIcon(new ImageIcon(panelGestionRutas.class.getResource("/presentacion/Icon/cargarMapa.png")));
				toolBar.add(btnDisenarRuta);
			}
			{
				btnBorrarMapa = new JButton("Borrar");
				btnBorrarMapa.setVisible(false);
				btnBorrarMapa.setToolTipText("Borrar mapa de la ruta");
				btnBorrarMapa.addActionListener(new BtnBorrarMapaActionListener());
				btnBorrarMapa.setIcon(new ImageIcon(panelGestionRutas.class.getResource("/presentacion/Icon/cargarMapa.png")));
				btnBorrarMapa.setBackground(new Color(220, 20, 60));
				toolBar.add(btnBorrarMapa);
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
					lstRutas.addListSelectionListener(new LstRutasListSelectionListener());
					lstRutas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					DefaultListModel modeloLista = new DefaultListModel();
					lstRutas.setModel(modeloLista);
					
					for (int i = 0; i < list.size(); i++) {
						modeloLista.addElement(list.get(i).getNombre());
					}

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
					txtDia.setToolTipText("El formato debe ser: DD/MM/YYYY");
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
	
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			vaciarCajas();
			lblFoto.setIcon(null);
			enableText(true);
			MODO=1;
			JOptionPane.showMessageDialog(null,"Para añadir una ruta rellena todos los campos y pulsa Guardar");
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultListModel modeloLista= (DefaultListModel) lstRutas.getModel();
			int indice = lstRutas.getSelectedIndex();
			if(indice!=-1) {
				enableText(true);
				MODO=0;
			}else {
				JOptionPane.showMessageDialog(null,"Debes seleccionar una ruta para modificarla");
			}
		}
	}
	
	public void actualizaList(int n) {
		list.get(n).setNombre(txtNombre.getText());
		list.get(n).setId(Integer.parseInt(txtId.getText()));
		list.get(n).setHoraInicio(txtHoraInicio.getText());
		list.get(n).setHoraFin(txtHoraFin.getText());
		list.get(n).setDia(ParseFecha(txtDia.getText()));
		list.get(n).setMonitor(txtMonitor.getText());
		list.get(n).setEncuentro(txtEncuentro.getText());
		list.get(n).setMinParticipantes(Integer.parseInt(txtMinParticipantes.getText()));
		list.get(n).setMaxParticipantes(Integer.parseInt(txtMaxParticipantes.getText()));
		list.get(n).setDescripcion(txtDescripcion.getText());
	}
	public static Date ParseFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex){
            System.out.println(ex);
        }
        return fechaDate;
    }
	
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar la ruta seleccionada?", "Cuidado",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultListModel modeloLista= (DefaultListModel) lstRutas.getModel();
				int indice = lstRutas.getSelectedIndex();
				if(indice!=-1) {
					modeloLista.remove(indice);
					list.remove(indice);
					//Para Actualizar la lista de Diseño Rutas
					ArrayList<Ruta> listRuta= pDRutas.getList();
					listRuta.remove(indice);
					JList lstRutas = pDRutas.getpanel();
					DefaultListModel modeloLista2= (DefaultListModel) lstRutas.getModel();
					modeloLista2.remove(indice);
				}else {
					JOptionPane.showMessageDialog(null,"Debes seleccionar una ruta para eliminarla");
				}
				lblFoto.setIcon(null);
				enableText(false);
				vaciarCajas();
				
			} else {

			}
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(comprobarVacio()) {//Si hay algun campo vacio
				JOptionPane.showMessageDialog(btnGuardar, "No has rellanado todos los campos.","Campos sin rellenar",JOptionPane.ERROR_MESSAGE);
			}else {//Si no los guarda, 	
				if(MODO==1) {//Cuando Guardas una ruta que estas añadiendo
					Ruta ruta = new Ruta(Integer.parseInt(txtId.getText()),txtNombre.getText(),txtHoraInicio.getText(),txtHoraFin.getText(),ParseFecha(txtDia.getText()),txtMonitor.getText(),txtEncuentro.getText(),Integer.parseInt(txtMinParticipantes.getText()),Integer.parseInt(txtMaxParticipantes.getText()),txtDescripcion.getText());
					//ruta.insert();
					list.add(ruta);
					DefaultListModel modeloLista= (DefaultListModel) lstRutas.getModel();
					modeloLista.addElement(list.get(list.size()-1).getNombre());
					lstRutas.setSelectedIndex(list.size()-1);
					lstRutas.ensureIndexIsVisible(list.size()-1);
					
					//Para Actualizar la lista de Diseño Rutas
					ArrayList<Ruta> listRuta= pDRutas.getList();
					listRuta.add(ruta);
					JList lstRutas = pDRutas.getpanel();
					DefaultListModel modeloLista2= (DefaultListModel) lstRutas.getModel();
					modeloLista2.addElement(list.get(list.size()-1).getNombre());
					
					}else {//Cuando Guardas una ruta que estas modificando
						
						DefaultListModel modeloLista= (DefaultListModel) lstRutas.getModel();
						
						int indice = lstRutas.getSelectedIndex();
						if(indice!=-1) {
							String nombre = txtNombre.getText();
							if(!nombre.equals(list.get(indice).getNombre())) {
								modeloLista.setElementAt(txtNombre.getText(), indice);
							}
							actualizaList(indice);
							
							//Para Actualizar la lista de Diseño Rutas
							JList lstRutas = pDRutas.getpanel();
							DefaultListModel modeloLista2= (DefaultListModel) lstRutas.getModel();
							modeloLista2.setElementAt(txtNombre.getText(), indice);
							
							JOptionPane.showMessageDialog(null,"Has modificado correctamente la ruta "+txtNombre.getText());
						}
					}
					resetearFondo();
					enableText(false);
			}
		}
	}
	
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vaciarCajas();
		}
	}
	
	private class LstRutasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			int j= lstRutas.getSelectedIndex();
			if(j!=-1) {
				txtId.setText(list.get(j).getId()+"");
				txtNombre.setText(list.get(j).getNombre());
				txtHoraInicio.setText(list.get(j).getHoraInicio());
				txtHoraFin.setText(list.get(j).getHoraFin());
				txtDia.setText(list.get(j).getDia()+"");
				txtMonitor.setText(list.get(j).getMonitor());
				txtEncuentro.setText(list.get(j).getEncuentro());
				txtMinParticipantes.setText(list.get(j).getMinParticipantes()+"");
				txtMaxParticipantes.setText(list.get(j).getMaxParticipantes()+"");
				txtDescripcion.setText(list.get(j).getDescripcion());
				ponerMapa(list.get(j).getNombre());
				enableText(false);
				resetearFondo();
			}
		}
	}
	private class BtnDisenarRutaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new ImageFilter());
			int valorDevuelto = fcAbrir.showOpenDialog(btnDisenarRuta);
			//Recoger el nombre del fichero seleccionado por el usuario
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				//lblFoto.setIcon(new ImageIcon(file.getAbsolutePath()));
				Image imagenOriginal;
				try {
					imagenOriginal = ImageIO.read(file);
					Image imagenEscalada = imagenOriginal.getScaledInstance(lblFoto.getWidth(),lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
					ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
					lblFoto.setIcon(iconoLabel);
				} catch (IOException ei) {
					ei.printStackTrace();
				}
			}
		}
	}
	
	private class BtnBorrarMapaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblFoto.setIcon(null);
			lblFoto.revalidate();
		}
	}
	private void ponerMapa(String nombre) {
		ImageIcon miniatura = null;
		try {
			miniatura = new ImageIcon(getClass().getClassLoader().getResource("presentacion/Imagenes/"+nombre+".png"));

		} catch (Exception e) {
			miniatura = new ImageIcon(getClass().getClassLoader().getResource("presentacion/Icon/cargarMapa.png"));
		} finally {
			Image image = miniatura.getImage();
			imagen = new ImageIcon(image);
		}

		lblFoto.setIcon(imagen);
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
		btnDisenarRuta.setVisible(b);
		btnBorrarMapa.setVisible(b);
	}
	private void vaciarCajas() {//Metodo universal para vaciar todos los JTextField
		JTextField caja;
		for (int i = 0; i < pnlInfoRuta.getComponentCount(); i++) {
			if(pnlInfoRuta.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfoRuta.getComponent(i);
				caja.setText("");
			}
		}
		lblFoto.setIcon(null);
		lblFoto.revalidate();
		txtDescripcion.setText("");
	}
	
	public boolean comprobarVacio() {
		JTextField caja;
		for (int i = 0; i < pnlInfoRuta.getComponentCount(); i++) {
			if(pnlInfoRuta.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfoRuta.getComponent(i);
				if(caja.getText().length()==0) {
					caja.setBackground(colorRojo);
					return true;
				}
			}
		}
		return false;
	}
	public void cargarDatos(int n) {
		txtNombre.setText(list.get(n).getNombre());
		txtId.setText(list.get(n).getId()+"");
		txtHoraInicio.setText(list.get(n).getHoraInicio());
		txtHoraFin.setText(list.get(n).getHoraFin());
		txtDia.setText(list.get(n).getDia()+"");
		txtMonitor.setText(list.get(n).getMonitor());
		txtEncuentro.setText(list.get(n).getEncuentro());
		txtMinParticipantes.setText(list.get(n).getMinParticipantes()+"");
		txtMaxParticipantes.setText(list.get(n).getMaxParticipantes()+"");
		txtDescripcion.setText(list.get(n).getDescripcion());
		ponerMapa(list.get(n).getNombre());
		lblFoto.setToolTipText("Mapa "+list.get(n).getNombre());
		resetearFondo();
	}
	
	public boolean resetearFondo() {
		JTextField caja;
		for (int i = 0; i < pnlInfoRuta.getComponentCount(); i++) {
			if(pnlInfoRuta.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfoRuta.getComponent(i);
				caja.setBackground(colorDefectoBotones);
			}
		}
		return false;
	}
}
