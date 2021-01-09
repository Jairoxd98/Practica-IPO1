package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
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
import java.awt.event.ActionEvent;

public class panelDatosPropiedades extends JFrame implements ActionListener {

	private JPanel contentPane;
	private ButtonGroup botones = new ButtonGroup();
	private JTextField textFieldPrecio;
	private JTextField textFieldCaracteristicas;
	private JPanel panelParcela;
	private JPanel panelBungalow;
	private JTextField textFieldCapacidad;
	private JTextField textFieldEstancia;
	private JTextField textFieldDescripcion;
	private JRadioButton rdbtnParcela;
	private JRadioButton rdbtnBungalow;


	/**
	 * Create the frame.
	 */
	public panelDatosPropiedades() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 443);
		contentPane = new JPanel();
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
		panelParcela.setBorder(new TitledBorder(null, "Datos Parcela", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParcela.setBounds(30, 75, 474, 306);
		panelParcela.setLayout(null);
		panelParcela.setVisible(true);
		
		panelBungalow = new JPanel();
		panelBungalow.setBorder(new TitledBorder(null, "Datos Bungalow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		JLabel lblCapacidad = new JLabel("Capacidad maxima pers.:");
		lblCapacidad.setBounds(38, 91, 47, 14);
		panelBungalow.add(lblCapacidad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(38, 129, 72, 14);
		panelBungalow.add(lblPrecio);
		
		JLabel lblestancia= new JLabel("Estancia min:");
		lblestancia.setBounds(38, 174, 47, 14);
		panelBungalow.add(lblestancia);
		
		JLabel lblEquipamiento = new JLabel("Equipamiento:");
		lblEquipamiento.setBounds(267, 174, 65, 14);
		panelBungalow.add(lblEquipamiento);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(267, 55, 105, 14);
		panelBungalow.add(lblDescripcion);
		
		JComboBox comboBoxTamano = new JComboBox();
		comboBoxTamano.setModel(new DefaultComboBoxModel(new String[] {"Pequeña", "Mediana", "Grande"}));
		comboBoxTamano.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxTamano.setBounds(102, 50, 97, 14);
		panelBungalow.add(comboBoxTamano);
		
		textFieldCapacidad = new JTextField();
		textFieldCapacidad.setRequestFocusEnabled(true);
		textFieldCapacidad.setBounds(102, 88, 96, 20);
		panelBungalow.add(textFieldCapacidad);
		textFieldCapacidad.setColumns(10);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setRequestFocusEnabled(true);
		textFieldPrecio.setBounds(102, 125, 97, 22);
		panelBungalow.add(textFieldPrecio);
		
		textFieldEstancia = new JTextField();
		textFieldEstancia.setRequestFocusEnabled(true);
		textFieldEstancia.setBounds(102, 170, 97, 22);
		panelBungalow.add(textFieldEstancia);
		
		JComboBox comboBoxEquipamiento = new JComboBox();
		comboBoxEquipamiento.setModel(new DefaultComboBoxModel(new String[] {"Menaje", "Microondas", "Pijama", "Toallas", "Wifi", "Todo"}));
		comboBoxEquipamiento.setBounds(328, 170, 123, 22);
		panelBungalow.add(comboBoxEquipamiento);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(267, 88, 184, 71);
		panelBungalow.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JButton btnAnadir = new JButton("Añadir");
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
		
		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Pequeña", "Mediana", "Deluxe", "Autocaravana"}));
		comboBoxTipo.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxTipo.setBounds(111, 45, 97, 23);
		panelParcela.add(comboBoxTipo);
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.setRequestFocusEnabled(true);
		textFieldPrecio.setBounds(111, 87, 96, 20);
		panelParcela.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);
		
		JComboBox comboBoxTemporada = new JComboBox();
		comboBoxTemporada.setModel(new DefaultComboBoxModel(new String[] {"Baja", "Media", "Alta"}));
		comboBoxTemporada.setBounds(111, 124, 97, 22);
		panelParcela.add(comboBoxTemporada);
		
		JComboBox comboBoxTamano = new JComboBox();
		comboBoxTamano.setModel(new DefaultComboBoxModel(new String[] {"Pequeña", "Mediana", "Grande"}));
		comboBoxTamano.setBounds(111, 169, 97, 22);
		panelParcela.add(comboBoxTamano);
		
		textFieldCaracteristicas = new JTextField();
		textFieldCaracteristicas.setBounds(259, 80, 192, 79);
		panelParcela.add(textFieldCaracteristicas);
		textFieldCaracteristicas.setColumns(10);
		
		JComboBox comboBoxUbicacion = new JComboBox();
		comboBoxUbicacion.setModel(new DefaultComboBoxModel(new String[] {"Aseos", "Fregaderos", "Piscina", "Bar", "Restaurante", "Playa"}));
		comboBoxUbicacion.setBounds(328, 170, 123, 22);
		panelParcela.add(comboBoxUbicacion);
		
		JButton btnAnadir = new JButton("Añadir");
		btnAnadir.addActionListener(new BtnAnadirActionListener());
		btnAnadir.setIcon(new ImageIcon(panelDatosPropiedades.class.getResource("/presentacion/Icon/anadir2.png")));
		btnAnadir.setToolTipText("Añadir Propiedad nueva");
		btnAnadir.setBounds(192, 237, 115, 31);
		panelParcela.add(btnAnadir);

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == rdbtnParcela ) {
			panelParcela.setVisible(true);
			panelBungalow.setVisible(false);
		}
		
		if(e.getSource() == rdbtnBungalow ) {
			panelParcela.setVisible(false);
			panelBungalow.setVisible(true);
		}
		
	}
	
	private class BtnAnadirActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	}
	
	
	
	
}
