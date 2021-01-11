package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import dominio.Reserva;


public class PanelDatosReservas extends JFrame {

	private JPanel pnlInfo;
	private JLabel lblId;
	private JLabel lblFechaEntrada;
	private JLabel lblFechaSalida;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblOcupantes;
	private JLabel lblSolicitud;
	private JLabel lblHoraEntrada;
	private JLabel lblHoraSalida;
	private static JTextField txtNombre;
	private static JTextField txtFechaEntrada;
	private static JTextField txtTelefono;
	private static JTextField txtEmail;
	private static JTextField txtHoraEntrada;
	private static JTextField txtHoraSalida;
	private static JTextField txtSolicitud;
	private static JTextField txtTipo;
	private static JTextField txtOcupantes;
	private static JTextField txtFechaSalida;
	private static JTextField txtId;
	private JButton btnGuardar;
	private static Reserva reserva;
	private static ArrayList<Reserva> list = panelGestionReservas.getListReserva(); //Lista de reservas
	private static JTable miTabla = panelGestionReservas.getpanel(); //Tabla de reservas
	private static int n = panelGestionReservas.getRow(); //Fila seleccionada de reservas
	private static int MODO = panelGestionReservas.getModo();
	private Color colorBlanco = new Color(255, 255, 255);
	private Color colorResaltado = new Color(255, 255, 210);
	private Color colorRojo = Color.RED;
	private Color colorDefectoBotones;
	private JButton btnLimpiar;
	private static PanelDatosReservas frame= new PanelDatosReservas();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frame= new PanelDatosReservas() ;
					frame.setVisible(true);
					if(MODO==1) {
						cargarDatos(n); //Para Cargar los datos en las cajas del pane de la reserva a modificar
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelDatosReservas() {
		setTitle("Datos de Reservas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PanelDatosReservas.class.getResource("/presentacion/Icon/choza.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		pnlInfo = new JPanel();
		pnlInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlInfo);
		pnlInfo.setLayout(null);
		{
			lblId = new JLabel("ID:");
			lblId.setBounds(246, 30, 46, 14);
			pnlInfo.add(lblId);
		}
		{
			lblFechaEntrada = new JLabel("Fecha entrada:");
			lblFechaEntrada.setBounds(23, 78, 90, 14);
			pnlInfo.add(lblFechaEntrada);
		}
		{
			lblFechaSalida = new JLabel("Fecha salida:");
			lblFechaSalida.setBounds(246, 78, 90, 14);
			pnlInfo.add(lblFechaSalida);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(23, 30, 79, 14);
			pnlInfo.add(lblNombre);
		}
		{
			lblTipo = new JLabel("Tipo:");
			lblTipo.setBounds(246, 122, 46, 14);
			pnlInfo.add(lblTipo);
		}
		{
			lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(23, 122, 79, 14);
			pnlInfo.add(lblTelefono);
		}
		{
			lblEmail = new JLabel("Email:");
			lblEmail.setBounds(23, 262, 79, 14);
			pnlInfo.add(lblEmail);
		}
		{
			lblOcupantes = new JLabel("Ocupantes:");
			lblOcupantes.setBounds(23, 167, 70, 14);
			pnlInfo.add(lblOcupantes);
		}
		{
			lblSolicitud = new JLabel("Solicitud:");
			lblSolicitud.setBounds(246, 167, 79, 14);
			pnlInfo.add(lblSolicitud);
		}
		{
			lblHoraEntrada = new JLabel("Hora entrada:");
			lblHoraEntrada.setBounds(23, 217, 90, 14);
			pnlInfo.add(lblHoraEntrada);
		}
		{
			lblHoraSalida = new JLabel("Hora salida:");
			lblHoraSalida.setBounds(246, 217, 82, 14);
			pnlInfo.add(lblHoraSalida);
		}
		{
			txtNombre = new JTextField();
			txtNombre.addFocusListener(new MiFocusListener());
			txtNombre.setBounds(112, 27, 93, 20);
			pnlInfo.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtFechaEntrada = new JTextField();
			txtFechaEntrada.addFocusListener(new MiFocusListener());
			txtFechaEntrada.setBounds(112, 75, 93, 20);
			pnlInfo.add(txtFechaEntrada);
			txtFechaEntrada.setColumns(10);
		}
		{
			txtTelefono = new JTextField();
			txtTelefono.addFocusListener(new MiFocusListener());
			txtTelefono.setBounds(112, 119, 93, 20);
			pnlInfo.add(txtTelefono);
			txtTelefono.setColumns(10);
		}
		{
			txtEmail = new JTextField();
			txtEmail.addFocusListener(new MiFocusListener());
			txtEmail.setColumns(10);
			txtEmail.setBounds(94, 259, 111, 20);
			pnlInfo.add(txtEmail);
		}
		{
			txtHoraEntrada = new JTextField();
			txtHoraEntrada.addFocusListener(new MiFocusListener());
			txtHoraEntrada.setColumns(10);
			txtHoraEntrada.setBounds(112, 214, 93, 20);
			pnlInfo.add(txtHoraEntrada);
		}
		{
			txtHoraSalida = new JTextField();
			txtHoraSalida.addFocusListener(new MiFocusListener());
			txtHoraSalida.setColumns(10);
			txtHoraSalida.setBounds(326, 214, 92, 20);
			pnlInfo.add(txtHoraSalida);
		}
		{
			txtSolicitud = new JTextField();
			txtSolicitud.addFocusListener(new MiFocusListener());
			txtSolicitud.setColumns(10);
			txtSolicitud.setBounds(326, 164, 92, 20);
			pnlInfo.add(txtSolicitud);
		}
		{
			txtTipo = new JTextField();
			txtTipo.addFocusListener(new MiFocusListener());
			txtTipo.setColumns(10);
			txtTipo.setBounds(326, 119, 92, 20);
			pnlInfo.add(txtTipo);
		}
		{
			txtOcupantes = new JTextField();
			txtOcupantes.addFocusListener(new MiFocusListener());
			txtOcupantes.setColumns(10);
			txtOcupantes.setBounds(112, 164, 93, 20);
			pnlInfo.add(txtOcupantes);
		}
		{
			txtFechaSalida = new JTextField();
			txtFechaSalida.addFocusListener(new MiFocusListener());
			txtFechaSalida.setColumns(10);
			txtFechaSalida.setBounds(326, 75, 92, 20);
			pnlInfo.add(txtFechaSalida);
		}
		{
			txtId = new JTextField();
			txtId.addFocusListener(new MiFocusListener());
			txtId.setColumns(10);
			txtId.setBounds(326, 27, 92, 20);
			pnlInfo.add(txtId);
		}
		{
			btnGuardar = new JButton("Guardar");
			btnGuardar.setToolTipText("Guardar datos reserva");
			btnGuardar.addActionListener(new BtnGuardarActionListener());
			btnGuardar.setIcon(new ImageIcon(PanelDatosReservas.class.getResource("/presentacion/Icon/guardar.png")));
			btnGuardar.setBounds(246, 253, 111, 32);
			pnlInfo.add(btnGuardar);
		}
		{
			btnLimpiar = new JButton("");
			btnLimpiar.addActionListener(new BtnLimpiarActionListener());
			btnLimpiar.setToolTipText("Vaciar cajas de texto");
			btnLimpiar.setIcon(new ImageIcon(PanelDatosReservas.class.getResource("/presentacion/Icon/limpio.png")));
			btnLimpiar.setBounds(380, 253, 38, 32);
			pnlInfo.add(btnLimpiar);
		}
		if(MODO==1) {
			cargarDatos(n); //Para Cargar los datos en las cajas del pane de la reserva a modificar
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(comprobarVacio()) {//Si hay algun campo vacio
				JOptionPane.showMessageDialog(btnGuardar, "No has rellanado todos los campos.","Campos sin rellenar",JOptionPane.ERROR_MESSAGE);
			}else {//Si no, los guarda,
				
				if(MODO==0) {//Cuando Guardas una reserva que estas añadiendo
					Reserva reserva = new Reserva(Integer.parseInt(txtId.getText()), txtFechaEntrada.getText(), txtFechaSalida.getText(), txtNombre.getText(), txtTipo.getText(),txtTelefono.getText(),txtEmail.getText(),Integer.parseInt(txtOcupantes.getText()),txtSolicitud.getText(),txtHoraEntrada.getText(),txtHoraSalida.getText());
					//reserva.insert();
					list.add(reserva);
					MiModeloTablaReservas modeloTablaReservas = (MiModeloTablaReservas) miTabla.getModel();
					Object[] fila= {list.get(list.size()-1).getId(), list.get(list.size()-1).getNombre(), list.get(list.size()-1).getFechaEntrada(), list.get(list.size()-1).getFechaSalida(), list.get(list.size()-1).getOcupantes(), list.get(list.size()-1).getTipo()};
					modeloTablaReservas.aniadeFila(fila);
					modeloTablaReservas.fireTableDataChanged();
					miTabla.getSelectedRow();
					}else {//Cuando Guardas una reserva que estas modificando
						
						//cargarDatos(n); //Para Cargar los datos en las cajas del pane de la reserva a modificar
						MiModeloTablaReservas modeloTablaReservas = (MiModeloTablaReservas) miTabla.getModel();
						
						if (n != -1) {
							String id= txtId.getText()+"";
							String nombre = txtNombre.getText();
							String fechaEntrada = txtFechaEntrada.getText();
							String fechaSalida = txtFechaSalida.getText();
							String ocupantes= txtId.getText()+"";
							String tipo = txtTipo.getText();
							
							/*if(!nombre.equals(list.get(n-1).getNombre())) {
								modeloTablaEmpleados.setValueAt(txtNombre.getText(), miTabla.getSelectedRow(), 0);
							}*/
							modeloTablaReservas.setValueAt(txtId.getText(), n, 0);
							modeloTablaReservas.setValueAt(txtNombre.getText(), n, 1);
							modeloTablaReservas.setValueAt(txtFechaEntrada.getText(), n, 2);
							modeloTablaReservas.setValueAt(txtFechaSalida.getText(), n, 3);
							modeloTablaReservas.setValueAt(txtOcupantes.getText(), n, 4);
							modeloTablaReservas.setValueAt(txtTipo.getText(), n, 5);

							actualizaList(n);
						}
						modeloTablaReservas.fireTableDataChanged();
					}
					
				vaciarCajas();	
				resetearFondo();
				//frame.setVisible(false);
				JOptionPane.showMessageDialog(null,"Reserva cargada correctamente");
			}
		}
	}
	public void actualizaList(int j) {
		list.get(j).setId(Integer.parseInt(txtId.getText()));
		list.get(j).setFechaEntrada(txtFechaEntrada.getText());
		list.get(j).setFechaSalida(txtFechaSalida.getText());
		list.get(j).setNombre(txtNombre.getText());
		list.get(j).setTipo(txtTipo.getText());
		list.get(j).setTelefono(txtTelefono.getText());
		list.get(j).setEmail(txtEmail.getText());
		list.get(j).setOcupantes(Integer.parseInt(txtOcupantes.getText()));
		list.get(j).setSolicitud(txtSolicitud.getText());
		list.get(j).setHoraEntrada(txtHoraEntrada.getText());
		list.get(j).setHoraSalida(txtHoraSalida.getText());
	}
	public static void cargarDatos(int j) {
		txtId.setText(list.get(j).getId()+"");
		txtFechaEntrada.setText(list.get(j).getFechaEntrada());
		txtFechaSalida.setText(list.get(j).getFechaSalida());
		txtNombre.setText(list.get(j).getNombre());
		txtTipo.setText(list.get(j).getTipo());
		txtTelefono.setText(list.get(j).getTelefono());
		txtEmail.setText(list.get(j).getEmail());
		txtOcupantes.setText(list.get(j).getOcupantes()+"");
		txtSolicitud.setText(list.get(j).getSolicitud());
		txtHoraEntrada.setText(list.get(j).getHoraEntrada());
		txtHoraSalida.setText(list.get(j).getHoraSalida());
		//resetearFondo();
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
	private class BtnLimpiarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			vaciarCajas();
		}
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
	private void vaciarCajas() {//Metodo universal para vaciar todos los JTextField
		JTextField caja;
		for (int i = 0; i < pnlInfo.getComponentCount(); i++) {
			if(pnlInfo.getComponent(i).getClass().getName().equals("javax.swing.JTextField")) {
				caja=(JTextField)pnlInfo.getComponent(i);
				caja.setText("");
			}
		}
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
