package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import dominio.Parcela;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class panelDatosPropiedades extends JFrame implements ActionListener {
	private ButtonGroup botones = new ButtonGroup();
	private JTextField textFieldPrecioBungalow;
	private JTextField textFieldPrecioParcela;
	private JTextField textFieldCaracteristicas;
	private static JPanel panelParcela;
	private JPanel panelBungalow;
	private JTextField textFieldCapacidad;
	private JTextField textFieldEstancia;
	private JTextField textFieldDescripcion;
	private JRadioButton rdbtnParcela;
	private JRadioButton rdbtnBungalow;
	private JComboBox comboBoxTipoParcela;
	private JComboBox comboBoxTemporada;
	private JComboBox comboBoxTamanoParcela;
	private JComboBox comboBoxUbicacion;
	private JComboBox comboBoxTamanoBungalow;
	private JComboBox comboBoxEquipamiento;
	private JButton modificarParcela;
	private JButton modificarBungalow;
	private ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	private static panelDatosPropiedades frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new panelDatosPropiedades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public panelDatosPropiedades() {
		addWindowListener(new ThisWindowListener());
		setIconImage(Toolkit.getDefaultToolkit().getImage(panelDatosPropiedades.class.getResource("/presentacion/Icon/choza.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 443);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEleccion = new JLabel("Añade una parcela o un bungalow");
		lblEleccion.setVerticalAlignment(SwingConstants.TOP);
		lblEleccion.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEleccion.setBounds(158, 11, 223, 23);
		contentPane.add(lblEleccion);

		rdbtnParcela = new JRadioButton("Parcela");
		rdbtnParcela.setBorder(new LineBorder(new Color(0, 0, 0)));
		rdbtnParcela.setSelected(true);
		rdbtnParcela.setBounds(101, 41, 117, 23);
		rdbtnParcela.addActionListener(this);
		contentPane.add(rdbtnParcela);

		rdbtnBungalow = new JRadioButton("Bungalow");
		rdbtnBungalow.setBounds(335, 41, 117, 23);
		rdbtnBungalow.addActionListener(this);
		contentPane.add(rdbtnBungalow);

		botones.add(rdbtnBungalow);
		botones.add(rdbtnParcela);

		panelParcela = new JPanel();
		panelParcela
				.setBorder(new TitledBorder(null, "Datos Parcela", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParcela.setBounds(30, 75, 474, 306);
		panelParcela.setLayout(null);
		panelParcela.setVisible(true);

		panelBungalow = new JPanel();
		panelBungalow.setBorder(
				new TitledBorder(null, "Datos Bungalow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBungalow.setBounds(30, 75, 474, 306);
		panelBungalow.setLayout(null);
		panelBungalow.setVisible(false);

		cargarComponentesPanelParcela();
		cargarComponentesPanelBungalow();
		contentPane.add(panelParcela);
		contentPane.add(panelBungalow);
	}

	private void cargarComponentesPanelBungalow() {
		JLabel lblTamano = new JLabel("Tamano:");
		lblTamano.setBounds(38, 45, 54, 24);
		panelBungalow.add(lblTamano);

		JLabel lblCapacidad = new JLabel("Capacidad: ");
		lblCapacidad.setBounds(38, 91, 128, 14);
		panelBungalow.add(lblCapacidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(38, 129, 72, 14);
		panelBungalow.add(lblPrecio);

		JLabel lblestancia = new JLabel("Días min:");
		lblestancia.setBounds(38, 174, 72, 14);
		panelBungalow.add(lblestancia);

		JLabel lblEquipamiento = new JLabel("Equipo:");
		lblEquipamiento.setBounds(259, 174, 84, 14);
		panelBungalow.add(lblEquipamiento);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(267, 55, 105, 14);
		panelBungalow.add(lblDescripcion);

		comboBoxTamanoBungalow = new JComboBox();
		comboBoxTamanoBungalow.setModel(new DefaultComboBoxModel(new String[] { "Pequeña", "Mediana", "Grande" }));
		comboBoxTamanoBungalow.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxTamanoBungalow.setBounds(111, 45, 97, 23);
		panelBungalow.add(comboBoxTamanoBungalow);

		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setRequestFocusEnabled(true);
		textFieldCapacidad.setBounds(111, 87, 96, 20);
		panelBungalow.add(textFieldCapacidad);
		textFieldCapacidad.setColumns(10);

		textFieldPrecioBungalow = new JTextField();
		textFieldPrecioBungalow.setRequestFocusEnabled(true);
		textFieldPrecioBungalow.setBounds(111, 124, 97, 22);
		panelBungalow.add(textFieldPrecioBungalow);

		textFieldEstancia = new JTextField();
		textFieldEstancia.setRequestFocusEnabled(true);
		textFieldEstancia.setBounds(111, 169, 97, 22);
		panelBungalow.add(textFieldEstancia);

		comboBoxEquipamiento = new JComboBox();
		comboBoxEquipamiento.setModel(
				new DefaultComboBoxModel(new String[] { "Menaje", "Microondas", "Pijama", "Toallas", "Wifi", "Todo" }));
		comboBoxEquipamiento.setBounds(328, 170, 123, 22);
		panelBungalow.add(comboBoxEquipamiento);

		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(267, 88, 184, 71);
		panelBungalow.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);

		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new BtnAnadirBungalowActionListener());
		btnAnadir.setIcon(new ImageIcon(panelDatosPropiedades.class.getResource("/presentacion/Icon/anadir2.png")));
		btnAnadir.setToolTipText("Añadir Propiedad nueva");
		btnAnadir.setBounds(192, 237, 115, 31);
		panelBungalow.add(btnAnadir);
		
		

	}

	private void cargarComponentesPanelParcela() {

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(38, 45, 54, 24);
		panelParcela.add(lblTipo);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(38, 91, 47, 14);
		panelParcela.add(lblPrecio);

		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setBounds(38, 129, 72, 14);
		panelParcela.add(lblTemporada);

		JLabel lblTamano = new JLabel("Tamaño:");
		lblTamano.setBounds(38, 174, 72, 14);
		panelParcela.add(lblTamano);

		JLabel lblUbicacion = new JLabel("Ubicación:");
		lblUbicacion.setBounds(259, 174, 84, 14);
		panelParcela.add(lblUbicacion);

		JLabel lblCaracterísticas = new JLabel("Características:");
		lblCaracterísticas.setBounds(259, 50, 105, 14);
		panelParcela.add(lblCaracterísticas);

		comboBoxTipoParcela = new JComboBox();
		comboBoxTipoParcela
				.setModel(new DefaultComboBoxModel(new String[] { "Pequeña", "Mediana", "Deluxe", "Autocaravana" }));
		comboBoxTipoParcela.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxTipoParcela.setBounds(111, 45, 97, 23);
		panelParcela.add(comboBoxTipoParcela);

		textFieldPrecioParcela = new JTextField();
		textFieldPrecioParcela.setBounds(111, 87, 96, 20);
		panelParcela.add(textFieldPrecioParcela);
		textFieldPrecioParcela.setColumns(10);

		comboBoxTemporada = new JComboBox();
		comboBoxTemporada.setModel(new DefaultComboBoxModel(new String[] { "Baja", "Media", "Alta" }));
		comboBoxTemporada.setBounds(111, 124, 97, 22);
		panelParcela.add(comboBoxTemporada);

		comboBoxTamanoParcela = new JComboBox();
		comboBoxTamanoParcela.setModel(new DefaultComboBoxModel(new String[] { "Pequeña", "Mediana", "Grande" }));
		comboBoxTamanoParcela.setBounds(111, 169, 97, 22);
		panelParcela.add(comboBoxTamanoParcela);

		textFieldCaracteristicas = new JTextField();
		textFieldCaracteristicas.setBounds(259, 80, 192, 79);
		panelParcela.add(textFieldCaracteristicas);
		textFieldCaracteristicas.setColumns(10);

		comboBoxUbicacion = new JComboBox();
		comboBoxUbicacion.setModel(new DefaultComboBoxModel(
				new String[] { "Aseos", "Fregaderos", "Piscina", "Bar", "Restaurante", "Playa" }));
		comboBoxUbicacion.setBounds(328, 170, 123, 22);
		panelParcela.add(comboBoxUbicacion);

		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new BtnAnadirActionListener());
		btnAnadir.setIcon(new ImageIcon(panelDatosPropiedades.class.getResource("/presentacion/Icon/anadir2.png")));
		btnAnadir.setToolTipText("Añadir Propiedad nueva");
		btnAnadir.setBounds(192, 237, 123, 31);
		panelParcela.add(btnAnadir);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == rdbtnParcela) {
			panelParcela.setVisible(true);
			panelBungalow.setVisible(false);
		}

		if (e.getSource() == rdbtnBungalow) {
			panelParcela.setVisible(false);
			panelBungalow.setVisible(true);
		}

	}

	// Anade una parcela
	private class BtnAnadirActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// listaParcelas = cargarParcelas();
			String tipo = comboBoxTipoParcela.getSelectedItem().toString();
			String temporada = comboBoxTemporada.getSelectedItem().toString();
			String tamano = comboBoxTamanoParcela.getSelectedItem().toString();
			String caracteristicas = textFieldCaracteristicas.getText();
			String precioText = textFieldPrecioParcela.getText();
			String ubicacion = comboBoxUbicacion.getSelectedItem().toString();
			String disponibilidad = "disponible";
			// System.out.println("["+tipo+", "+temporada+", "+tamano+",
			// "+caracteristicas+", "+precioText+ ", "+disponibilidad+", "+ubicacion+"]");
			// Parcela parcela = new Parcela(tipo, precio, temporada, tamano, ubicacion,
			// caracteristicas, disponibilidad);
			// parcela.insert();

			if ((textFieldPrecioParcela.getText().equals("")) || (textFieldCaracteristicas.getText().equals(""))
					|| ((textFieldPrecioParcela.getText().equals(""))
							&& (textFieldCaracteristicas.getText().equals("")))) {
				JOptionPane.showMessageDialog(null, "Debes de completar todos los campos para añadir una parcela");
			} else {
				int precio = Integer.parseInt(precioText);
				JTable tablaParcelas = panelGestionPropiedades.getpanel();
				Object[] fila = { tipo, precio, temporada, tamano, ubicacion, caracteristicas, disponibilidad };
				MiModeloTablaParcelas tb = new MiModeloTablaParcelas();
				//System.out.println(tablaParcelas.getRowCount());
				AbstractTableModel j = (AbstractTableModel) tablaParcelas.getModel();
				((MiModeloTablaParcelas) j).aniadeFila(fila);
				j.fireTableDataChanged();
				JOptionPane.showMessageDialog(null, "La parcela se ha añadido perfectamente");
				//frame.setVisible(false);
				panelGestionPropiedades.getBtnAnadir().setEnabled(true);
				panelGestionPropiedades.getBtnEliminar().setEnabled(true);
				panelGestionPropiedades.getBtnModificar().setEnabled(true);
			}

		}

	}

	private class BtnAnadirBungalowActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String tamano = comboBoxTamanoBungalow.getSelectedItem().toString();
			String capacidadText = textFieldCapacidad.getText();
			String precioT = textFieldPrecioBungalow.getText();
			String estanciaMin = textFieldEstancia.getText();
			String descripcion = textFieldDescripcion.getText();
			String equipamiento = comboBoxEquipamiento.getSelectedItem().toString();
			String disponibilidad = "disponible";

			if ((textFieldCapacidad.getText().equals("")) || (textFieldPrecioBungalow.getText().equals(""))
					|| (textFieldEstancia.getText().equals("")) || (textFieldDescripcion.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldPrecioBungalow.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldEstancia.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldDescripcion.getText().equals(""))
					|| (textFieldPrecioBungalow.getText().equals("") && textFieldEstancia.getText().equals(""))
					|| (textFieldPrecioBungalow.getText().equals("") && textFieldDescripcion.getText().equals(""))
					|| (textFieldEstancia.getText().equals("")) && (textFieldDescripcion.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldPrecioBungalow.getText().equals("")
							&& textFieldEstancia.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldPrecioBungalow.getText().equals("")
							&& textFieldDescripcion.getText().equals(""))
					|| (textFieldPrecioBungalow.getText().equals("") && textFieldEstancia.getText().equals("")
							&& textFieldDescripcion.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldEstancia.getText().equals("")
							&& textFieldDescripcion.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldEstancia.getText().equals("")
							&& textFieldDescripcion.getText().equals("")
							&& textFieldPrecioBungalow.getText().equals(""))) {
				JOptionPane.showMessageDialog(null, "Debes de completar todos los campos para añadir un bungalow");

			}else {
				int capacidadMax = Integer.parseInt(capacidadText);
				int precio = Integer.parseInt(precioT);
				int estancia = Integer.parseInt(estanciaMin);
				JTable tablaBungalows = panelGestionPropiedades.getBungalows();
				Object [] fila = {tamano, capacidadMax,precio,estancia, equipamiento, disponibilidad};
				MiModeloTablaBungalows tb = new MiModeloTablaBungalows();
				AbstractTableModel j = (AbstractTableModel) tablaBungalows.getModel();
				((MiModeloTablaBungalows) j).aniadeFila(fila);
				j.fireTableDataChanged();
				JOptionPane.showMessageDialog(null, "El bungalow se ha añadido perfectamente");
				panelGestionPropiedades.getBtnAnadir().setEnabled(true);
				panelGestionPropiedades.getBtnEliminar().setEnabled(true);
				panelGestionPropiedades.getBtnModificar().setEnabled(true);
				//frame.setVisible(false);
			}
		}
	}
	
	public panelDatosPropiedades(String tipo, int precio, String temporada, String tamano, String ubicacion, String caracteristicas) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 443);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelParcela = new JPanel();
		panelParcela.setBorder(new TitledBorder(null, "Datos Parcela", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParcela.setBounds(30, 75, 474, 306);
		panelParcela.setLayout(null);
		panelParcela.setVisible(true);

		cargarComponentesPanelParcelaModificar(tipo, precio, temporada, tamano, ubicacion, caracteristicas);
		contentPane.add(panelParcela);
	}
	
	public panelDatosPropiedades(String tamano, int capacidad, int precio, int estancia, String equipamiento) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 443);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBungalow = new JPanel();
		panelBungalow.setBorder(
				new TitledBorder(null, "Datos Bungalow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBungalow.setBounds(30, 75, 474, 306);
		panelBungalow.setLayout(null);
		panelBungalow.setVisible(true);
		
		cargarComponentesPanelBungalowModificar(tamano, capacidad, precio, estancia, equipamiento);
		contentPane.add(panelBungalow);
		
		
	}
	
	
	
	private void cargarComponentesPanelBungalowModificar(String tamano, int capacidad, int precio, int estancia,
			String equipamiento) {
		JLabel lblTamano = new JLabel("Tamano:");
		lblTamano.setBounds(38, 45, 54, 24);
		panelBungalow.add(lblTamano);

		JLabel lblCapacidad = new JLabel("Capacidad: ");
		lblCapacidad.setBounds(38, 91, 128, 14);
		panelBungalow.add(lblCapacidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(38, 129, 72, 14);
		panelBungalow.add(lblPrecio);

		JLabel lblestancia = new JLabel("Estancia min:");
		lblestancia.setBounds(38, 174, 72, 14);
		panelBungalow.add(lblestancia);

		JLabel lblEquipamiento = new JLabel("Equipamiento:");
		lblEquipamiento.setBounds(267, 174, 65, 14);
		panelBungalow.add(lblEquipamiento);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(267, 55, 105, 14);
		panelBungalow.add(lblDescripcion);

		comboBoxTamanoBungalow = new JComboBox();
		comboBoxTamanoBungalow.setModel(new DefaultComboBoxModel(new String[] { "Pequeña", "Mediana", "Grande" }));
		comboBoxTamanoBungalow.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxTamanoBungalow.setBounds(111, 45, 97, 23);
		comboBoxTamanoBungalow.setSelectedItem(tamano);
		panelBungalow.add(comboBoxTamanoBungalow);

		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setRequestFocusEnabled(true);
		String capa = String.valueOf(capacidad);
		textFieldCapacidad.setText(capa);
		textFieldCapacidad.setBounds(111, 87, 96, 20);
		panelBungalow.add(textFieldCapacidad);
		textFieldCapacidad.setColumns(10);

		textFieldPrecioBungalow = new JTextField();
		String p = String.valueOf(precio);
		textFieldPrecioBungalow.setText(p);
		textFieldPrecioBungalow.setRequestFocusEnabled(true);
		textFieldPrecioBungalow.setBounds(111, 124, 97, 22);
		panelBungalow.add(textFieldPrecioBungalow);

		textFieldEstancia = new JTextField();
		String est = String.valueOf(estancia);
		textFieldEstancia.setText(est);
		textFieldEstancia.setRequestFocusEnabled(true);
		textFieldEstancia.setBounds(111, 169, 97, 22);
		panelBungalow.add(textFieldEstancia);

		comboBoxEquipamiento = new JComboBox();
		comboBoxEquipamiento.setModel(
				new DefaultComboBoxModel(new String[] { "Menaje", "Microondas", "Pijama", "Toallas", "Wifi", "Todo" }));
		comboBoxEquipamiento.setBounds(328, 170, 123, 22);
		panelBungalow.add(comboBoxEquipamiento);

		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(267, 88, 184, 71);
		panelBungalow.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		

		modificarBungalow = new JButton("Modificar");
		modificarBungalow.addActionListener(new BtnModificarBungalowActionListener());
		modificarBungalow.setIcon(new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/editar2.png")));
		modificarBungalow.setBounds(192, 237, 140, 31);
		panelBungalow.add(modificarBungalow);
		
		
		
	}

	private void cargarComponentesPanelParcelaModificar(String tipo, int precio, String temporada, String tamano, String ubicacion, String caracteristicas) {
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(38, 45, 54, 24);
		panelParcela.add(lblTipo);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(38, 91, 47, 14);
		panelParcela.add(lblPrecio);

		JLabel lblTemporada = new JLabel("Temporada:");
		lblTemporada.setBounds(38, 129, 72, 14);
		panelParcela.add(lblTemporada);

		JLabel lblTamano = new JLabel("Tamaño:");
		lblTamano.setBounds(38, 174, 72, 14);
		panelParcela.add(lblTamano);

		JLabel lblUbicacion = new JLabel("Ubicación:");
		lblUbicacion.setBounds(259, 174, 84, 14);
		panelParcela.add(lblUbicacion);

		JLabel lblCaracterísticas = new JLabel("Características:");
		lblCaracterísticas.setBounds(259, 50, 105, 14);
		panelParcela.add(lblCaracterísticas);

		comboBoxTipoParcela = new JComboBox();
		comboBoxTipoParcela.setModel(new DefaultComboBoxModel(new String[] { "Pequeña", "Mediana", "Deluxe", "Autocaravana" }));
		comboBoxTipoParcela.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxTipoParcela.setBounds(111, 45, 97, 23);
		comboBoxTipoParcela.setSelectedItem(tipo);
		panelParcela.add(comboBoxTipoParcela);

		textFieldPrecioParcela = new JTextField();
		textFieldPrecioParcela.setBounds(111, 87, 96, 20);
		String p = String.valueOf(precio);
		textFieldPrecioParcela.setText(p);
		panelParcela.add(textFieldPrecioParcela);
		textFieldPrecioParcela.setColumns(10);

		comboBoxTemporada = new JComboBox();
		comboBoxTemporada.setModel(new DefaultComboBoxModel(new String[] { "Baja", "Media", "Alta" }));
		comboBoxTemporada.setBounds(111, 124, 97, 22);
		panelParcela.add(comboBoxTemporada);

		comboBoxTamanoParcela = new JComboBox();
		comboBoxTamanoParcela.setModel(new DefaultComboBoxModel(new String[] { "Pequeña", "Mediana", "Grande" }));
		comboBoxTamanoParcela.setBounds(111, 169, 97, 22);
		panelParcela.add(comboBoxTamanoParcela);

		textFieldCaracteristicas = new JTextField();
		textFieldCaracteristicas.setBounds(259, 80, 192, 79);
		textFieldCaracteristicas.setText(caracteristicas);
		panelParcela.add(textFieldCaracteristicas);
		textFieldCaracteristicas.setColumns(10);

		comboBoxUbicacion = new JComboBox();
		comboBoxUbicacion.setModel(new DefaultComboBoxModel(
				new String[] { "Aseos", "Fregaderos", "Piscina", "Bar", "Restaurante", "Playa" }));
		comboBoxUbicacion.setBounds(328, 170, 123, 22);
		panelParcela.add(comboBoxUbicacion);
		
		modificarParcela = new JButton("Modificar");
		modificarParcela.addActionListener(new BtnModificarParcelaActionListener());
		modificarParcela.setIcon(new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/editar2.png")));
		modificarParcela.setBounds(192, 237, 140, 31);
		panelParcela.add(modificarParcela);
		
	}
	
	
	

	private class BtnModificarParcelaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String tipo = comboBoxTipoParcela.getSelectedItem().toString();
			String temporada = comboBoxTemporada.getSelectedItem().toString();
			String tamano = comboBoxTamanoParcela.getSelectedItem().toString();
			String caracteristicas = textFieldCaracteristicas.getText();
			String precioText = textFieldPrecioParcela.getText();
			String ubicacion = comboBoxUbicacion.getSelectedItem().toString();
			String disponibilidad = "disponible";
			
			if ((textFieldPrecioParcela.getText().equals("")) || (textFieldCaracteristicas.getText().equals(""))
					|| ((textFieldPrecioParcela.getText().equals(""))
							&& (textFieldCaracteristicas.getText().equals("")))) {
				JOptionPane.showMessageDialog(null, "Debes de completar todos los campos para modificar una parcela");
			}else {
				int precio = Integer.parseInt(precioText);
				JTable tablaParcelas = panelGestionPropiedades.getpanel();
				Object[] fila = { tipo, precio, temporada, tamano, ubicacion, caracteristicas, disponibilidad };
				MiModeloTablaParcelas tb = new MiModeloTablaParcelas();
				AbstractTableModel j = (AbstractTableModel) tablaParcelas.getModel();
				((MiModeloTablaParcelas) j).setValueAt(tipo, tablaParcelas.getSelectedRow(), 0);
				((MiModeloTablaParcelas) j).setValueAt(precio, tablaParcelas.getSelectedRow(), 1);
				((MiModeloTablaParcelas) j).setValueAt(temporada, tablaParcelas.getSelectedRow(), 2);
				((MiModeloTablaParcelas) j).setValueAt(tamano, tablaParcelas.getSelectedRow(), 3);
				((MiModeloTablaParcelas) j).setValueAt(ubicacion, tablaParcelas.getSelectedRow(), 4);
				((MiModeloTablaParcelas) j).setValueAt(caracteristicas, tablaParcelas.getSelectedRow(), 5);
				tablaParcelas.clearSelection();
				JOptionPane.showMessageDialog(null, "La parcela se ha modificado perfectamente");
				//frame.setVisible(false);
				panelGestionReservas.getBtnAnadir().setEnabled(true);
				panelGestionReservas.getBtnEliminar().setEnabled(true);
				panelGestionReservas.getBtnModificar().setEnabled(true);
			}
		}
	}
	
	private class BtnModificarBungalowActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String tamano = comboBoxTamanoBungalow.getSelectedItem().toString();
			String capacidadText = textFieldCapacidad.getText();
			String precioT = textFieldPrecioBungalow.getText();
			String estanciaMin = textFieldEstancia.getText();
			String descripcion = textFieldDescripcion.getText();
			String equipamiento = comboBoxEquipamiento.getSelectedItem().toString();
			String disponibilidad = "disponible";

			if ((textFieldCapacidad.getText().equals("")) || (textFieldPrecioBungalow.getText().equals(""))
					|| (textFieldEstancia.getText().equals("")) || (textFieldDescripcion.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldPrecioBungalow.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldEstancia.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldDescripcion.getText().equals(""))
					|| (textFieldPrecioBungalow.getText().equals("") && textFieldEstancia.getText().equals(""))
					|| (textFieldPrecioBungalow.getText().equals("") && textFieldDescripcion.getText().equals(""))
					|| (textFieldEstancia.getText().equals("")) && (textFieldDescripcion.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldPrecioBungalow.getText().equals("")
							&& textFieldEstancia.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldPrecioBungalow.getText().equals("")
							&& textFieldDescripcion.getText().equals(""))
					|| (textFieldPrecioBungalow.getText().equals("") && textFieldEstancia.getText().equals("")
							&& textFieldDescripcion.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldEstancia.getText().equals("")
							&& textFieldDescripcion.getText().equals(""))
					|| (textFieldCapacidad.getText().equals("") && textFieldEstancia.getText().equals("")
							&& textFieldDescripcion.getText().equals("")
							&& textFieldPrecioBungalow.getText().equals(""))) {
				JOptionPane.showMessageDialog(null, "Debes de completar todos los campos para modificar un bungalow");

			}else {
				int capacidadMax = Integer.parseInt(capacidadText);
				int precio = Integer.parseInt(precioT);
				int estancia = Integer.parseInt(estanciaMin);
				JTable tablaBungalows = panelGestionPropiedades.getBungalows();
				Object [] fila = {tamano, capacidadMax,precio,estancia, equipamiento, disponibilidad};
				MiModeloTablaBungalows tb = new MiModeloTablaBungalows();
				AbstractTableModel j = (AbstractTableModel) tablaBungalows.getModel();
				((MiModeloTablaBungalows) j).setValueAt(tamano, tablaBungalows.getSelectedRow(), 0);
				((MiModeloTablaBungalows) j).setValueAt(capacidadMax, tablaBungalows.getSelectedRow(), 1);
				((MiModeloTablaBungalows) j).setValueAt(precio, tablaBungalows.getSelectedRow(), 2);
				((MiModeloTablaBungalows) j).setValueAt(estancia, tablaBungalows.getSelectedRow(), 3);
				((MiModeloTablaBungalows) j).setValueAt(equipamiento, tablaBungalows.getSelectedRow(), 4);
				tablaBungalows.clearSelection();
				JOptionPane.showMessageDialog(null, "El bungalow se ha modificado perfectamente");
				//frame.setVisible(false);
				panelGestionReservas.getBtnAnadir().setEnabled(true);
				panelGestionReservas.getBtnEliminar().setEnabled(true);
				panelGestionReservas.getBtnModificar().setEnabled(true);
			}
			
		}
	}
	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowClosed(WindowEvent e) {
			panelGestionPropiedades.getBtnAnadir().setEnabled(true);
			panelGestionPropiedades.getBtnEliminar().setEnabled(true);
			panelGestionPropiedades.getBtnModificar().setEnabled(true);
		}
	}
}
