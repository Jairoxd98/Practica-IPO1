package presentacion;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dominio.Bungalow;
import dominio.Parcela;
import dominio.Reserva;

import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Cursor;

public class panelGestionPropiedades extends JPanel {

	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JSeparator separator;
	private JPanel panel;
	private JToolBar toolBar;
	private JScrollPane scrollPaneParcela;
	private JLabel lblBungalow;
	private JScrollPane scrollPaneBungalow;
	private static JTable tablaParcelas;
	private JTable tablaBungalows;
	
	
	private ArrayList<Parcela> listaParcelas = new ArrayList<Parcela>();
	private ArrayList<Bungalow> listaBungalows = new ArrayList<Bungalow>();

	

	/**
	 * Create the panel.
	 */
	public panelGestionPropiedades() {
		setLayout(new BorderLayout(0, 0));
		{
			toolBar = new JToolBar();
			toolBar.setBorder(new LineBorder(new Color(0, 0, 0)));
			add(toolBar, BorderLayout.NORTH);
			{
				btnAnadir = new JButton("Añadir");
				btnAnadir.setToolTipText("Añadir Propiedad nueva");
				btnAnadir.addActionListener(new BtnAnadirActionListener());
				btnAnadir.setIcon(
						new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/anadir2.png")));
				toolBar.add(btnAnadir);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setToolTipText("Modificar Empleado seleccionado");
				btnModificar.addActionListener(new BtnModificarActionListener());
				btnModificar.setIcon(
						new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/editar2.png")));
				toolBar.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setToolTipText("Eliminar Empleado seleccionado");
				btnEliminar.addActionListener(new BtnEliminarActionListener());
				btnEliminar.setIcon(
						new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/borrar.png")));
				toolBar.add(btnEliminar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				btnGuardar.setToolTipText("Guardar Modificaciones");
				btnGuardar.setVisible(false);
				btnGuardar.setIcon(
						new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/guardar.png")));
				toolBar.add(btnGuardar);
			}

			{
				separator = new JSeparator();
				toolBar.add(separator);
			}
		}
		{
			panel = new JPanel();
			add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				scrollPaneParcela = new JScrollPane();
				scrollPaneParcela.setBounds(10, 53, 628, 120);
				scrollPaneParcela.setPreferredSize(new Dimension(50, 120));
				panel.add(scrollPaneParcela);
				
				{
					tablaParcelas = new JTable();
					tablaParcelas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					MiModeloTablaParcelas modeloTablaParcelas = new MiModeloTablaParcelas();
					tablaParcelas.setModel(modeloTablaParcelas);
					
					listaParcelas = cargarParcelas();
					
					for(int i = 0; i<listaParcelas.size();i++) {
						Object [] fila = {listaParcelas.get(i).getTipo(), new Integer(listaParcelas.get(i).getPrecio()), listaParcelas.get(i).getTemporada(),
								listaParcelas.get(i).getTamano(), listaParcelas.get(i).getUbicacion(), listaParcelas.get(i).getCaracteristicas(),
								listaParcelas.get(i).getDisponibilidad()
								};
						modeloTablaParcelas.aniadeFila(fila);
					}
					
									
					tablaParcelas.getColumnModel().getColumn(1).setPreferredWidth(88);
					tablaParcelas.getColumnModel().getColumn(2).setPreferredWidth(83);
					scrollPaneParcela.setViewportView(tablaParcelas);
					
				}
				
				
			}
			
			JLabel lblParcela = new JLabel("Parcelas");
			lblParcela.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			lblParcela.setBounds(262, 11, 88, 31);
			panel.add(lblParcela);
			
			lblBungalow = new JLabel("Bungalows");
			lblBungalow.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			lblBungalow.setBounds(252, 170, 133, 31);
			panel.add(lblBungalow);
			{
				scrollPaneBungalow = new JScrollPane();
				scrollPaneBungalow.setBounds(10, 201, 628, 120);
				panel.add(scrollPaneBungalow);
			}
			{
				tablaBungalows = new JTable();
				tablaBungalows.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				MiModeloTablaBungalows modeloTabla = new MiModeloTablaBungalows();
				tablaBungalows.setModel(modeloTabla);
				
				listaBungalows = cargarBungalows();
				
				for(int i = 0; i<listaBungalows.size();i++) {
					Object [] fila = {listaBungalows.get(i).getTamano(), new Integer(listaBungalows.get(i).getCapacidadMax()), 
							new Integer(listaBungalows.get(i).getPrecio()), new Integer(listaBungalows.get(i).getEstanciaMin()),
							listaBungalows.get(i).getEquipamiento(), listaBungalows.get(i).getDisponibilidad()};
					modeloTabla.aniadeFila(fila);
					
				}
				
				tablaBungalows.getColumnModel().getColumn(1).setPreferredWidth(88);
				tablaBungalows.getColumnModel().getColumn(2).setPreferredWidth(83);
				scrollPaneBungalow.setViewportView(tablaBungalows);
			}
			
		}

	}
	
	public static JTable getpanel() {
		return tablaParcelas;
	}
	
	private static ArrayList<Parcela> cargarParcelas() {

		Parcela parcela = new Parcela();
		boolean correcto = false;

		correcto = parcela.readAll();

		if (correcto) {
			return (parcela.getParcelaDAO().getListaParcelas());
		} else {
			return null;
		}
	}
	
	private static ArrayList<Bungalow> cargarBungalows() {

		Bungalow bungalow = new Bungalow();
		boolean correcto = false;

		correcto = bungalow.readAll();

		if (correcto) {
			return (bungalow.getBungalowDAO().getListaBungalows());
		} else {
			return null;
		}
	}
	final panelDatosPropiedades ventanaDatos = new panelDatosPropiedades();
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			ventanaDatos.setVisible(true);
		}
	}

	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}

	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar la propiedad seleccionada?", "Cuidado",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				
			} else {

			}
		}
	}

	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

		}
	}
}
