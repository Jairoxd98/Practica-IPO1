package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import dominio.Actividad;
import dominio.Ruta;

public class paneGestionActividades extends JPanel {
	private JToolBar toolBar;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JPanel pnlTabla;
	private JPanel pnlInfo;
	private JScrollPane scrollPane;
	private JList lstActividades;
	private JPanel pnlInfoActividades;
	private JLabel lblNombre;
	private JLabel lblDia;
	private JLabel lblPrecioPorHora;
	private JLabel lblHoraInicio;
	private JLabel lblHoraFin;
	private JLabel lblMaximoDeParticipantes;
	private JLabel lblMinimoDeParticipantes;
	private JLabel lblMonitor;
	private JLabel lblDescripcion;
	private JLabel lblPrecioPorMes;
	private JLabel lblDestinado;
	private JTextField txtMonitor;
	private JTextField txtDia;
	private JTextField txtPrecioHora;
	private JTextField txtDestinado;
	private JTextField txtPrecioMes;
	private JTextField txtMaxParticipantes;
	private JTextField txtMinParticipantes;
	private JTextField txtNombre;
	private JTextField txtHoraFin;
	private JTextField txtHoraInicio;
	private JTextArea txtDescripcion;
	private ArrayList<Actividad> list = cargarActividad();
	private Color colorBlanco = new Color(255, 255, 255);
	private Color colorResaltado = new Color(255, 255, 210);
	private Color colorRojo = Color.RED;
	private Color colorDefectoBotones;
	private int MODO;
	
	/**
	 * Create the panel.
	 */
	public paneGestionActividades() {
		setLayout(new BorderLayout(0, 0));
		{
			toolBar = new JToolBar();
			toolBar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			add(toolBar, BorderLayout.NORTH);
			{
				btnAnadir = new JButton("Añadir");
				btnAnadir.addActionListener(new BtnAnadirActionListener());
				btnAnadir.setIcon(new ImageIcon(paneGestionActividades.class.getResource("/presentacion/Icon/anadir2.png")));
				btnAnadir.setToolTipText("Añadir nueva Actividad");
				toolBar.add(btnAnadir);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new BtnModificarActionListener());
				btnModificar.setIcon(new ImageIcon(paneGestionActividades.class.getResource("/presentacion/Icon/editar2.png")));
				btnModificar.setToolTipText("Modificar actividad seleccionada");
				toolBar.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new BtnEliminarActionListener());
				btnEliminar.setIcon(new ImageIcon(paneGestionActividades.class.getResource("/presentacion/Icon/borrar.png")));
				btnEliminar.setToolTipText("Eliminar actividad seleccionada");
				toolBar.add(btnEliminar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				btnGuardar.setIcon(new ImageIcon(paneGestionActividades.class.getResource("/presentacion/Icon/guardar.png")));
				btnGuardar.setVisible(false);
				btnGuardar.setToolTipText("Guardar datos");
				toolBar.add(btnGuardar);
			}
			{
				btnLimpiar = new JButton("Limpiar");
				btnLimpiar.addActionListener(new BtnLimpiarActionListener());
				btnLimpiar.setIcon(new ImageIcon(paneGestionActividades.class.getResource("/presentacion/Icon/limpio.png")));
				btnLimpiar.setVisible(false);
				btnLimpiar.setToolTipText("Limpiar cajas de texto");
				toolBar.add(btnLimpiar);
			}
		}
		{
			pnlInfo = new JPanel();
			add(pnlInfo, BorderLayout.CENTER);
			pnlInfo.setLayout(null);
			{
				pnlTabla = new JPanel();
				pnlTabla.setBounds(0, 0, 110, 409);
				pnlInfo.add(pnlTabla);
				pnlTabla.setLayout(new BorderLayout(0, 0));
				{
					scrollPane = new JScrollPane();
					scrollPane.setMinimumSize(new Dimension(15, 15));
					pnlTabla.add(scrollPane, BorderLayout.CENTER);
					{
						lstActividades = new JList();
						lstActividades.addListSelectionListener(new LstActividadesListSelectionListener());
						lstActividades.setCellRenderer(new OtroListCellRenderer());
						lstActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						DefaultListModel modeloLista = new DefaultListModel();
						lstActividades.setModel(modeloLista);
						
						for (int i = 0; i < list.size(); i++) {
							modeloLista.addElement(list.get(i).getNombre());
						}
						scrollPane.setViewportView(lstActividades);
					}
				}
			}
			{
				pnlInfoActividades = new JPanel();
				pnlInfoActividades.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Informacion de la actividad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlInfoActividades.setBounds(120, 11, 495, 387);
				pnlInfo.add(pnlInfoActividades);
				pnlInfoActividades.setLayout(null);
				{
					lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(40, 33, 67, 14);
					pnlInfoActividades.add(lblNombre);
				}
				{
					lblDia = new JLabel("Dia:");
					lblDia.setBounds(40, 77, 46, 14);
					pnlInfoActividades.add(lblDia);
				}
				{
					lblPrecioPorHora = new JLabel("Precio por hora:");
					lblPrecioPorHora.setBounds(40, 118, 98, 14);
					pnlInfoActividades.add(lblPrecioPorHora);
				}
				{
					lblHoraInicio = new JLabel("Hora inicio:");
					lblHoraInicio.setBounds(40, 166, 67, 14);
					pnlInfoActividades.add(lblHoraInicio);
				}
				{
					lblHoraFin = new JLabel("Hora fin:");
					lblHoraFin.setBounds(277, 166, 67, 14);
					pnlInfoActividades.add(lblHoraFin);
				}
				{
					lblMaximoDeParticipantes = new JLabel("Maximo de participantes:");
					lblMaximoDeParticipantes.setBounds(40, 212, 153, 14);
					pnlInfoActividades.add(lblMaximoDeParticipantes);
				}
				{
					lblMinimoDeParticipantes = new JLabel("Minimo de participantes:");
					lblMinimoDeParticipantes.setBounds(277, 215, 146, 14);
					pnlInfoActividades.add(lblMinimoDeParticipantes);
				}
				{
					lblMonitor = new JLabel("Monitor:");
					lblMonitor.setBounds(277, 33, 67, 14);
					pnlInfoActividades.add(lblMonitor);
				}
				{
					lblDescripcion = new JLabel("Descripcion:");
					lblDescripcion.setBounds(40, 258, 89, 14);
					pnlInfoActividades.add(lblDescripcion);
				}
				{
					lblPrecioPorMes = new JLabel("Precio por mes:");
					lblPrecioPorMes.setBounds(277, 118, 98, 14);
					pnlInfoActividades.add(lblPrecioPorMes);
				}
				{
					lblDestinado = new JLabel("Destinado:");
					lblDestinado.setBounds(277, 77, 67, 14);
					pnlInfoActividades.add(lblDestinado);
				}
				{
					txtMonitor = new JTextField();
					txtMonitor.setEditable(false);
					txtMonitor.addFocusListener(new MiFocusListener());
					txtMonitor.setColumns(10);
					txtMonitor.setBounds(369, 33, 86, 20);
					pnlInfoActividades.add(txtMonitor);
				}
				{
					txtDia = new JTextField();
					txtDia.setEditable(false);
					txtDia.addFocusListener(new MiFocusListener());
					txtDia.setColumns(10);
					txtDia.setBounds(132, 74, 86, 20);
					pnlInfoActividades.add(txtDia);
				}
				{
					txtPrecioHora = new JTextField();
					txtPrecioHora.setEditable(false);
					txtPrecioHora.addFocusListener(new MiFocusListener());
					txtPrecioHora.setColumns(10);
					txtPrecioHora.setBounds(132, 115, 86, 20);
					pnlInfoActividades.add(txtPrecioHora);
				}
				{
					txtDestinado = new JTextField();
					txtDestinado.setEditable(false);
					txtDestinado.addFocusListener(new MiFocusListener());
					txtDestinado.setColumns(10);
					txtDestinado.setBounds(369, 74, 86, 20);
					pnlInfoActividades.add(txtDestinado);
				}
				{
					txtPrecioMes = new JTextField();
					txtPrecioMes.setEditable(false);
					txtPrecioMes.addFocusListener(new MiFocusListener());
					txtPrecioMes.setColumns(10);
					txtPrecioMes.setBounds(369, 115, 86, 20);
					pnlInfoActividades.add(txtPrecioMes);
				}
				{
					txtMaxParticipantes = new JTextField();
					txtMaxParticipantes.setEditable(false);
					txtMaxParticipantes.addFocusListener(new MiFocusListener());
					txtMaxParticipantes.setColumns(10);
					txtMaxParticipantes.setBounds(188, 209, 30, 20);
					pnlInfoActividades.add(txtMaxParticipantes);
				}
				{
					txtMinParticipantes = new JTextField();
					txtMinParticipantes.setEditable(false);
					txtMinParticipantes.addFocusListener(new MiFocusListener());
					txtMinParticipantes.setColumns(10);
					txtMinParticipantes.setBounds(425, 212, 30, 20);
					pnlInfoActividades.add(txtMinParticipantes);
				}
				{
					txtNombre = new JTextField();
					txtNombre.addFocusListener(new MiFocusListener());
					txtNombre.setEditable(false);
					txtNombre.setColumns(10);
					txtNombre.setBounds(132, 30, 86, 20);
					pnlInfoActividades.add(txtNombre);
				}
				{
					txtHoraFin = new JTextField();
					txtHoraFin.setEditable(false);
					txtHoraFin.addFocusListener(new MiFocusListener());
					txtHoraFin.setColumns(10);
					txtHoraFin.setBounds(369, 163, 86, 20);
					pnlInfoActividades.add(txtHoraFin);
				}
				{
					txtHoraInicio = new JTextField();
					txtHoraInicio.addFocusListener(new MiFocusListener());
					txtHoraInicio.setEditable(false);
					txtHoraInicio.setColumns(10);
					txtHoraInicio.setBounds(132, 163, 86, 20);
					pnlInfoActividades.add(txtHoraInicio);
				}
				{
					txtDescripcion = new JTextArea();
					txtDescripcion.setEditable(false);
					txtDescripcion.setBounds(40, 283, 415, 93);
					pnlInfoActividades.add(txtDescripcion);
				}
			}
		}

	}
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			vaciarCajas();
			enableText(true);
			MODO=1;
			JOptionPane.showMessageDialog(null,"Para añadir una actividad rellena todos los campos y pulsa Guardar");
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultListModel modeloLista= (DefaultListModel) lstActividades.getModel();
			int indice = lstActividades.getSelectedIndex();
			if(indice!=-1) {
				enableText(true);
				MODO=0;
			}else {
				JOptionPane.showMessageDialog(null,"Debes seleccionar una actividad para modificarla");
			}
		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar la actividad seleccionada?", "Cuidado",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				DefaultListModel modeloLista= (DefaultListModel) lstActividades.getModel();
				int indice = lstActividades.getSelectedIndex();
				if(indice!=-1) {
					modeloLista.remove(indice);
					list.remove(indice);
					Actividad actividad = new Actividad(txtNombre.getText(),txtHoraInicio.getText(),txtHoraFin.getText(),txtDia.getText(),txtMonitor.getText(),Integer.parseInt(txtMinParticipantes.getText()),Integer.parseInt(txtMaxParticipantes.getText()), Double.parseDouble(txtPrecioHora.getText()), Double.parseDouble(txtPrecioMes.getText()), txtDestinado.getText(), txtDescripcion.getText());
					actividad.delete();
				}else {
					JOptionPane.showMessageDialog(null,"Debes seleccionar una actividad para eliminarla");
				}
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
				if(MODO==1) {//Cuando Guardas una actividad que estas añadiendo
					Actividad actividad = new Actividad(txtNombre.getText(),txtHoraInicio.getText(),txtHoraFin.getText(),txtDia.getText(),txtMonitor.getText(),Integer.parseInt(txtMinParticipantes.getText()),Integer.parseInt(txtMaxParticipantes.getText()), Double.parseDouble(txtPrecioHora.getText()), Double.parseDouble(txtPrecioMes.getText()), txtDestinado.getText(), txtDescripcion.getText());
					actividad.insert();
					list.add(actividad);
					DefaultListModel modeloLista= (DefaultListModel) lstActividades.getModel();
					modeloLista.addElement(list.get(list.size()-1).getNombre());
					lstActividades.setSelectedIndex(list.size()-1);
					lstActividades.ensureIndexIsVisible(list.size()-1);
					
					}else {//Cuando Guardas una actividad que estas modificando
						
						DefaultListModel modeloLista= (DefaultListModel) lstActividades.getModel();
						
						int indice = lstActividades.getSelectedIndex();
						if(indice!=-1) {
							String nombre = txtNombre.getText();
							if(!nombre.equals(list.get(indice).getNombre())) {
								modeloLista.setElementAt(txtNombre.getText(), indice);
							}
							actualizaList(indice);
							//Actividad actividad = new Actividad(txtNombre.getText(),txtHoraInicio.getText(),txtHoraFin.getText(),txtDia.getText(),txtMonitor.getText(),Integer.parseInt(txtMinParticipantes.getText()),Integer.parseInt(txtMaxParticipantes.getText()), Double.parseDouble(txtPrecioHora.getText()), Double.parseDouble(txtPrecioMes.getText()), txtDestinado.getText(), txtDescripcion.getText());
							//actividad.update();
							JOptionPane.showMessageDialog(null,"Has modificado correctamente la actividad "+txtNombre.getText());
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
	private class LstActividadesListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			int j= lstActividades.getSelectedIndex();
			if(j!=-1) {
				txtNombre.setText(list.get(j).getNombre());
				txtHoraInicio.setText(list.get(j).getHoraInicio());
				txtHoraFin.setText(list.get(j).getHoraFin());
				txtDia.setText(list.get(j).getDia()+"");
				txtMonitor.setText(list.get(j).getMonitor());
				txtMinParticipantes.setText(list.get(j).getMinParticipantes()+"");
				txtMaxParticipantes.setText(list.get(j).getMaxParticipantes()+"");
				txtPrecioHora.setText(list.get(j).getPrecioHora()+"");
				txtPrecioMes.setText(list.get(j).getPrecioMes()+"");
				txtDestinado.setText(list.get(j).getDestinado());
				txtDescripcion.setText(list.get(j).getDescripcion());
				enableText(false);
				resetearFondo();
			}
		}
	}
	public void actualizaList(int n) {
		list.get(n).setNombre(txtNombre.getText());
		list.get(n).setHoraInicio(txtHoraInicio.getText());
		list.get(n).setHoraFin(txtHoraFin.getText());
		list.get(n).setDia(txtDia.getText());
		list.get(n).setMonitor(txtMonitor.getText());
		list.get(n).setMinParticipantes(Integer.parseInt(txtMinParticipantes.getText()));
		list.get(n).setMaxParticipantes(Integer.parseInt(txtMaxParticipantes.getText()));
		list.get(n).setPrecioHora(Double.parseDouble(txtPrecioHora.getText()));
		list.get(n).setPrecioMes(Double.parseDouble(txtPrecioMes.getText()));
		list.get(n).setDestinado(txtDestinado.getText());
		list.get(n).setDescripcion(txtDescripcion.getText());
	}
	private static ArrayList<Actividad> cargarActividad() {

		Actividad actividad = new Actividad();
		boolean correcto = false;

		correcto = actividad.readAll();

		if (correcto) {
			return (actividad.getActividadDAO().getListaActividades());
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
	public void enableText(boolean b) {
		txtNombre.setEditable(b);
		txtHoraInicio.setEditable(b);
		txtHoraFin.setEditable(b);
		txtDia.setEditable(b);
		txtMonitor.setEditable(b);
		txtDestinado.setEditable(b);
		txtPrecioHora.setEditable(b);
		txtPrecioMes.setEditable(b);
		txtMaxParticipantes.setEditable(b);
		txtMinParticipantes.setEditable(b);
		txtDescripcion.setEditable(b);
		btnGuardar.setVisible(b);
		btnLimpiar.setVisible(b);
		
	}
	private void vaciarCajas() {//Metodo universal para vaciar todos los JTextField
		JTextField caja;
		for (int i = 0; i < pnlInfoActividades.getComponentCount(); i++) {
			if(pnlInfoActividades.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfoActividades.getComponent(i);
				caja.setText("");
			}
		}
		txtDescripcion.setText("");
	}
	public boolean comprobarVacio() {
		JTextField caja;
		for (int i = 0; i < pnlInfoActividades.getComponentCount(); i++) {
			if(pnlInfoActividades.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfoActividades.getComponent(i);
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
		txtHoraInicio.setText(list.get(n).getHoraInicio());
		txtHoraFin.setText(list.get(n).getHoraFin());
		txtDia.setText(list.get(n).getDia()+"");
		txtMonitor.setText(list.get(n).getMonitor());
		txtMinParticipantes.setText(list.get(n).getMinParticipantes()+"");
		txtMaxParticipantes.setText(list.get(n).getMaxParticipantes()+"");
		txtPrecioHora.setText(list.get(n).getPrecioHora()+"");
		txtPrecioMes.setText(list.get(n).getPrecioMes()+"");
		txtDestinado.setText(list.get(n).getDestinado());
		txtDescripcion.setText(list.get(n).getDescripcion());
		
		resetearFondo();
	}
	public boolean resetearFondo() {
		JTextField caja;
		for (int i = 0; i < pnlInfoActividades.getComponentCount(); i++) {
			if(pnlInfoActividades.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfoActividades.getComponent(i);
				caja.setBackground(colorDefectoBotones);
			}
		}
		return false;
	}
	
}
