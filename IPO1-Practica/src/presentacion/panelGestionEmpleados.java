package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import dominio.Empleado;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class panelGestionEmpleados extends JPanel {
	private JToolBar toolBar;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel pnlInfo;
	private JPanel pnlTabla;
	private JScrollPane scrollPane;
	private JTable miTabla;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JLabel lblIdiomas;
	private JLabel lblFoto;
	private JButton btnPonerFoto;
	private JButton btnEliminarFoto;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtIdiomas;
	private ArrayList<Empleado> list = cargarEmpleado();
	private Color colorBlanco = new Color(255, 255, 255);
	private Color colorResaltado = new Color(255, 255, 210);
	private Color colorRojo = Color.RED;
	private Color colorDefectoBotones;
	private JLabel lblFormacion;
	private JTextField txtFormacion;
	private JButton btnGuardar;
	private JButton btnLimpiarText;
	private JTextField txtDNI;
	private int MODO;
	private ImageIcon imagen;
	/**
	 * Create the panel.
	 */
	public panelGestionEmpleados() {
		setLayout(null);
		{
			toolBar = new JToolBar();
			toolBar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			toolBar.setBounds(0, 0, 653, 33);
			add(toolBar);
			{
				btnAnadir = new JButton("Añadir");
				btnAnadir.addActionListener(new BtnAnadirActionListener());
				btnAnadir.setToolTipText("Añadir Reserva nueva");
				btnAnadir.setIcon(new ImageIcon(panelGestionEmpleados.class.getResource("/presentacion/Icon/anadir2.png")));
				toolBar.add(btnAnadir);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new BtnModificarActionListener());
				btnModificar.setToolTipText("Modificar Reserva seleccionada");
				btnModificar.setIcon(new ImageIcon(panelGestionEmpleados.class.getResource("/presentacion/Icon/editar2.png")));
				toolBar.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new BtnEliminarActionListener());
				btnEliminar.setToolTipText("Eliminar Reserva seleccionada");
				btnEliminar.setIcon(new ImageIcon(panelGestionEmpleados.class.getResource("/presentacion/Icon/borrar.png")));
				toolBar.add(btnEliminar);
			}
		}
		{
			pnlInfo = new JPanel();
			pnlInfo.setBorder(new TitledBorder(null, "Datos Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlInfo.setBounds(187, 46, 453, 393);
			add(pnlInfo);
			pnlInfo.setLayout(null);
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(36, 41, 75, 14);
				pnlInfo.add(lblNombre);
			}
			{
				lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setBounds(36, 91, 64, 14);
				pnlInfo.add(lblApellidos);
			}
			{
				lblDni = new JLabel("DNI:");
				lblDni.setBounds(36, 143, 64, 14);
				pnlInfo.add(lblDni);
			}
			{
				lblTelefono = new JLabel("Telefono:");
				lblTelefono.setBounds(36, 195, 64, 14);
				pnlInfo.add(lblTelefono);
			}
			{
				lblCorreo = new JLabel("Correo:");
				lblCorreo.setBounds(36, 250, 64, 14);
				pnlInfo.add(lblCorreo);
			}
			{
				lblIdiomas = new JLabel("Idiomas:");
				lblIdiomas.setBounds(36, 351, 75, 14);
				pnlInfo.add(lblIdiomas);
			}
			{
				lblFoto = new JLabel("");
				lblFoto.setBorder(new LineBorder(new Color(0, 139, 139)));
				lblFoto.setBounds(303, 76, 134, 124);
				pnlInfo.add(lblFoto);
			}
			{
				btnPonerFoto = new JButton("");
				btnPonerFoto.addActionListener(new BtnPonerFotoActionListener());
				btnPonerFoto.setEnabled(false);
				btnPonerFoto.setToolTipText("Cargar Foto");
				btnPonerFoto.setBackground(new Color(34, 139, 34));
				btnPonerFoto.setIcon(new ImageIcon(panelGestionEmpleados.class.getResource("/presentacion/Icon/camara.png")));
				btnPonerFoto.setBounds(304, 214, 134, 33);
				pnlInfo.add(btnPonerFoto);
			}
			{
				btnEliminarFoto = new JButton("");
				btnEliminarFoto.addActionListener(new BtnEliminarFotoActionListener());
				btnEliminarFoto.setEnabled(false);
				btnEliminarFoto.setToolTipText("Eliminar Foto");
				btnEliminarFoto.setIcon(new ImageIcon(panelGestionEmpleados.class.getResource("/presentacion/Icon/camara.png")));
				btnEliminarFoto.setBackground(new Color(255, 69, 0));
				btnEliminarFoto.setBounds(303, 257, 135, 33);
				pnlInfo.add(btnEliminarFoto);
			}
			{
				txtNombre = new JTextField();
				txtNombre.addFocusListener(new MiFocusListener());
				txtNombre.setEditable(false);
				txtNombre.setBounds(135, 38, 108, 20);
				pnlInfo.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtApellidos = new JTextField();
				txtApellidos.addFocusListener(new MiFocusListener());
				txtApellidos.setEditable(false);
				txtApellidos.setText("");
				txtApellidos.setBounds(135, 88, 108, 20);
				pnlInfo.add(txtApellidos);
				txtApellidos.setColumns(10);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.addFocusListener(new MiFocusListener());
				txtTelefono.setEditable(false);
				txtTelefono.setBounds(135, 192, 108, 20);
				pnlInfo.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				txtCorreo = new JTextField();
				txtCorreo.addFocusListener(new MiFocusListener());
				txtCorreo.setEditable(false);
				txtCorreo.setBounds(135, 247, 108, 20);
				pnlInfo.add(txtCorreo);
				txtCorreo.setColumns(10);
			}
			{
				txtIdiomas = new JTextField();
				txtIdiomas.addFocusListener(new MiFocusListener());
				txtIdiomas.setEditable(false);
				txtIdiomas.setBounds(135, 348, 290, 20);
				pnlInfo.add(txtIdiomas);
				txtIdiomas.setColumns(10);
			}
			{
				lblFormacion = new JLabel("Formacion:");
				lblFormacion.setBounds(36, 296, 86, 14);
				pnlInfo.add(lblFormacion);
			}
			{
				txtFormacion = new JTextField();
				txtFormacion.addFocusListener(new MiFocusListener());
				txtFormacion.setEditable(false);
				txtFormacion.setBounds(135, 293, 108, 20);
				pnlInfo.add(txtFormacion);
				txtFormacion.setColumns(10);
			}
			{
				btnGuardar = new JButton("");
				btnGuardar.setToolTipText("Guardar datos");
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				btnGuardar.setVisible(false);
				btnGuardar.setIcon(new ImageIcon(panelGestionEmpleados.class.getResource("/presentacion/Icon/guardar.png")));
				btnGuardar.setBounds(392, 25, 45, 40);
				pnlInfo.add(btnGuardar);
			}
			{
				btnLimpiarText = new JButton("");
				btnLimpiarText.setToolTipText("Limpiar cajas de texto");
				btnLimpiarText.setVisible(false);
				btnLimpiarText.addActionListener(new BtnLimpiarTextActionListener());
				btnLimpiarText.setIcon(new ImageIcon(panelGestionEmpleados.class.getResource("/presentacion/Icon/limpio.png")));
				btnLimpiarText.setBounds(303, 25, 45, 40);
				pnlInfo.add(btnLimpiarText);
			}
			{
				/*
				 MaskFormatter formatoDNI;
				try {
					formatoDNI = new MaskFormatter("########'-U");
					formatoDNI.setPlaceholderCharacter('X');
					fftpDNI = new JFormattedTextField(formatoDNI);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 */
				txtDNI = new JTextField();
				txtDNI.setEditable(false);
				txtDNI.setBounds(135, 140, 108, 20);
				pnlInfo.add(txtDNI);
				txtDNI.setColumns(10);
			}
		}
		{
			pnlTabla = new JPanel();
			pnlTabla.setBounds(10, 46, 177, 393);
			add(pnlTabla);
			pnlTabla.setLayout(new BorderLayout(0, 0));
			{
				scrollPane = new JScrollPane();
				pnlTabla.add(scrollPane, BorderLayout.CENTER);
				{
					miTabla = new JTable();
					miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					MiModeloTablaEmpleados modeloTabla = new MiModeloTablaEmpleados();
					miTabla.setModel(modeloTabla);
					
					for(int i = 0; i<list.size();i++) {
						Object[] fila= {list.get(i).getNombre(), list.get(i).getFormacion()};
						modeloTabla.aniadeFila(fila);
					}
					
					ListSelectionModel rowSM = miTabla.getSelectionModel();
					rowSM.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							ListSelectionModel lsm = (ListSelectionModel) e.getSource();
							if (!lsm.isSelectionEmpty()) {
								MiModeloTablaEmpleados modeloTablaEmpleados = (MiModeloTablaEmpleados) miTabla.getModel();
								int n= miTabla.getSelectedRow();
								if (n != -1)
								{
									cargarDatos(n);
									
									enableText(false);
								}
							}
						}
					});
					
					scrollPane.setViewportView(miTabla);
				}
			}
		}

	}
	public void cargarDatos(int n) {
		txtNombre.setText(list.get(n).getNombre());
		txtFormacion.setText(list.get(n).getFormacion());
		txtDNI.setText(list.get(n).getDNI());
		txtApellidos.setText(list.get(n).getApellidos());
		txtTelefono.setText(list.get(n).getTelefono());
		txtCorreo.setText(list.get(n).getCorreo());
		txtIdiomas.setText(list.get(n).getIdiomas());
		//lblFoto.setIcon(new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Imagenes/"+list.get(n).getNombre()+".png")));
		ponerMapa(list.get(n).getNombre());
		lblFoto.setToolTipText("Foto "+list.get(n).getNombre());
		resetearFondo();
	}
	private void ponerMapa(String nombre) {
		ImageIcon miniatura = null;
		try {
			miniatura = new ImageIcon(getClass().getClassLoader().getResource("presentacion/Imagenes/"+nombre+".png"));

		} catch (Exception e) {
			miniatura = new ImageIcon(getClass().getClassLoader().getResource("presentacion/Icon/user.png"));
		} finally {
			Image image = miniatura.getImage();
			imagen = new ImageIcon(image);
		}

		lblFoto.setIcon(imagen);
	}
	
	private static ArrayList<Empleado> cargarEmpleado() {

		Empleado empleado = new Empleado();
		boolean correcto = false;

		correcto = empleado.readAll();

		if (correcto) {
			return (empleado.getEmpleadoDAO().getListaEmpleados());
		} else {
			return null;
		}
	}
	
	private static ArrayList<Empleado> anadirEmpleado(Empleado empleado) {

		boolean correcto = false;

		correcto = empleado.insert();

		if (correcto) {
			return (empleado.getEmpleadoDAO().getListaEmpleados());
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
	
	private class BtnPonerFotoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new ImageFilter());
			int valorDevuelto = fcAbrir.showOpenDialog(btnPonerFoto);
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
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private class BtnEliminarFotoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblFoto.setIcon(null);
			lblFoto.revalidate();
		}
	}
	
	public void enableText(boolean b) {
		txtNombre.setEditable(b);
		txtApellidos.setEditable(b);
		txtDNI.setEditable(b);
		txtFormacion.setEditable(b);
		txtTelefono.setEditable(b);
		txtCorreo.setEditable(b);
		txtIdiomas.setEditable(b);
		btnPonerFoto.setEnabled(b);
		btnEliminarFoto.setEnabled(b);
		btnGuardar.setVisible(b);
		btnLimpiarText.setVisible(b);
	}
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Para añadir un empleado rellena todos los campos y pulsa Guardar");
			vaciarCajas();
			lblFoto.setIcon(null);
			enableText(true);
			MODO=1;
		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar el empleado seleccionado?", "Cuidado",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				MiModeloTablaEmpleados modeloTablaEmpleados = (MiModeloTablaEmpleados) miTabla.getModel();
				int n= miTabla.getSelectedRow();
				if (n != -1) {
					modeloTablaEmpleados.eliminaFila(miTabla.getSelectedRow());
					modeloTablaEmpleados.fireTableDataChanged();
					list.remove(n);
					Empleado empleado = new Empleado(txtDNI.getText(),txtNombre.getText(),txtApellidos.getText(),txtTelefono.getText(),txtCorreo.getText(),txtIdiomas.getText(),txtFormacion.getText());
					empleado.delete();
				}else {
					JOptionPane.showMessageDialog(null,"Debes seleccionar un empleado para eliminarlo");
				}
				lblFoto.setIcon(null);
				enableText(false);
				vaciarCajas();
			} else {

			}
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MiModeloTablaEmpleados modeloTablaEmpleados = (MiModeloTablaEmpleados) miTabla.getModel();
			int n= miTabla.getSelectedRow();
			if(n!=-1) {
				enableText(true);
				MODO=0;
			}else {
				JOptionPane.showMessageDialog(null,"Debes seleccionar un empleado para modificarlo");
			}
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(comprobarVacio()) {//Si hay algun campo vacio
				JOptionPane.showMessageDialog(btnGuardar, "No has rellanado todos los campos.","Campos sin rellenar",JOptionPane.ERROR_MESSAGE);
			}else {//Si no, los guarda, 	
				if(MODO==1) {//Cuando Guardas un empleado que estas añadiendo
				Empleado empleado = new Empleado(txtDNI.getText(),txtNombre.getText(),txtApellidos.getText(),txtTelefono.getText(),txtCorreo.getText(),txtIdiomas.getText(),txtFormacion.getText());
				empleado.insert();
				list.add(empleado);
				MiModeloTablaEmpleados modeloTablaEmpleados = (MiModeloTablaEmpleados) miTabla.getModel();
				Object[] fila= {list.get(list.size()-1).getNombre(), list.get(list.size()-1).getFormacion()};
				modeloTablaEmpleados.aniadeFila(fila);
				modeloTablaEmpleados.fireTableDataChanged();
				miTabla.getSelectedRow();
				}else {//Cuando Guardas un empleado que estas modificando
					MiModeloTablaEmpleados modeloTablaEmpleados = (MiModeloTablaEmpleados) miTabla.getModel();
					int n= miTabla.getSelectedRow();
					if (n != -1) {
						String nombre = txtNombre.getText();
						String formacion = txtFormacion.getText();
						if(!nombre.equals(list.get(n-1).getNombre())) {
							modeloTablaEmpleados.setValueAt(txtNombre.getText(), miTabla.getSelectedRow(), 0);
						}
						if(!formacion.equals(list.get(n-1).getFormacion())) {
							modeloTablaEmpleados.setValueAt(txtFormacion.getText(), miTabla.getSelectedRow(), 1);
						}
						
						actualizaList(n);
						
						Empleado empleado = new Empleado(txtDNI.getText(),txtNombre.getText(),txtApellidos.getText(),txtTelefono.getText(),txtCorreo.getText(),txtIdiomas.getText(),txtFormacion.getText());
						empleado.update();
					}
					modeloTablaEmpleados.fireTableDataChanged();
					JOptionPane.showMessageDialog(null,"Has modificado correctamente al empleado "+txtNombre.getText());
				}
				resetearFondo();
				enableText(false);
			}
		}
	}
	public void actualizaList(int n) {
		list.get(n).setNombre(txtNombre.getText());
		list.get(n).setFormacion(txtFormacion.getText());
		list.get(n).setDNI(txtDNI.getText());
		list.get(n).setApellidos(txtApellidos.getText());
		list.get(n).setTelefono(txtTelefono.getText());
		list.get(n).setCorreo(txtCorreo.getText());
		list.get(n).setIdiomas(txtIdiomas.getText());
	}
	private class BtnLimpiarTextActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vaciarCajas();	
		}
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
					caja.setBackground(colorRojo);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean resetearFondo() {
		JTextField caja;
		for (int i = 0; i < pnlInfo.getComponentCount(); i++) {
			if(pnlInfo.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfo.getComponent(i);
				caja.setBackground(colorDefectoBotones);
			}
		}
		return false;
	}
}