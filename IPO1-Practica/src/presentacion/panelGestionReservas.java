package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import dominio.Reserva;
import javax.swing.JSeparator;

public class panelGestionReservas extends JPanel {
	private JToolBar toolBar;
	private JButton btnAnadir;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JLabel lblFoto;
	private JScrollPane scrollPane_1;
	private JTable miTabla;
	private JTextArea taFilaSeleccionada;
	
	private ArrayList<Reserva> list = new ArrayList<Reserva>();
	private JSeparator separator;
	private JButton btnGuardar;

	/**
	 * Create the panel.
	 */
	public panelGestionReservas() {
		setLayout(new BorderLayout(0, 0));
		{
			toolBar = new JToolBar();
			toolBar.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			add(toolBar, BorderLayout.NORTH);
			{
				btnAnadir = new JButton("Añadir");
				btnAnadir.setToolTipText("Añadir Empleado nuevo");
				btnAnadir.addActionListener(new BtnAnadirActionListener());
				btnAnadir.setIcon(new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/anadir2.png")));
				toolBar.add(btnAnadir);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setToolTipText("Modificar Empleado seleccionado");
				btnModificar.addActionListener(new BtnModificarActionListener());
				btnModificar.setIcon(new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/editar2.png")));
				toolBar.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setToolTipText("Eliminar Empleado seleccionado");
				btnEliminar.addActionListener(new BtnEliminarActionListener());
				btnEliminar.setIcon(new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/borrar.png")));
				toolBar.add(btnEliminar);
			}
			{
				btnGuardar = new JButton("Guardar");
				btnGuardar.addActionListener(new BtnGuardarActionListener());
				btnGuardar.setToolTipText("Guardar Modificaciones");
				btnGuardar.setVisible(false);
				btnGuardar.setIcon(new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/guardar.png")));
				toolBar.add(btnGuardar);
			}
			{
				separator = new JSeparator();
				toolBar.add(separator);
			}
		}
		{
			panel = new JPanel();
			add(panel, BorderLayout.SOUTH);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			{
				scrollPane = new JScrollPane();
				scrollPane.setPreferredSize(new Dimension(50, 120));
				panel.add(scrollPane);
				{
					lblFoto = new JLabel("");
					scrollPane.setViewportView(lblFoto);
				}
			}
			{
				taFilaSeleccionada = new JTextArea();
				taFilaSeleccionada.setEditable(false);
				panel.add(taFilaSeleccionada);
			}
		}
		{
			scrollPane_1 = new JScrollPane();
			add(scrollPane_1, BorderLayout.CENTER);
			{
				miTabla = new JTable();
				miTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				MiModeloTablaReservas modeloTabla = new MiModeloTablaReservas();
				miTabla.setModel(modeloTabla);
				
				
				list=cargarReserva();
				
				for(int i = 0; i<list.size();i++) {
					Object[] fila= {new Integer(list.get(i).getId()), list.get(i).getNombre(), list.get(i).getFechaEntrada(), list.get(i).getFechaSalida(), new Integer(list.get(i).getOcupantes()), list.get(i).getTipo()};
					modeloTabla.aniadeFila(fila);
				}
				
						

				miTabla.getColumnModel().getColumn(1).setPreferredWidth(88);
				miTabla.getColumnModel().getColumn(2).setPreferredWidth(83);
				scrollPane_1.setViewportView(miTabla);
				
				ListSelectionModel rowSM = miTabla.getSelectionModel();
				rowSM.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						ListSelectionModel lsm = (ListSelectionModel) e.getSource();
						if (!lsm.isSelectionEmpty()) {
							MiModeloTablaReservas modeloTablaReservas = (MiModeloTablaReservas) miTabla.getModel();
							int n= miTabla.getSelectedRow();
							if (n != -1)
							{
								String contenido = "ID Reserva: "+ modeloTablaReservas.getValueAt(n, 0)+"\n"+
										"Nombre: "+ modeloTablaReservas.getValueAt(n, 1)+"\n"+
										"Fecha entrada: "+ modeloTablaReservas.getValueAt(n, 2)+"\n"+
										"Fecha salida: "+ modeloTablaReservas.getValueAt(n, 3)+"\n"+
										"Ocupantes :"+ modeloTablaReservas.getValueAt(n, 4)+"\n"+
										"Tipo: "+ modeloTablaReservas.getValueAt(n, 5)+"\n";
										
										try {
											contenido+="Telefono: "+list.get(n).getTelefono()+"\n"+
													"Email: "+list.get(n).getEmail()+"\n"+
													"Solicitud: "+list.get(n).getSolicitud()+"\n"+
													"Hora entrega: "+list.get(n).getHoraEntrada()+"\n"+
													"Hora salida: "+list.get(n).getHoraSalida()+"\n";
										}catch(NullPointerException ne) {
											contenido+="Telefono: \n"+
													"Email: \n"+
													"Solicitud: \n"+
													"Hora entrega: \n"+
													"Hora salida: \n";
										}
										
								taFilaSeleccionada.setText(contenido);
								
								lblFoto.setIcon(new ImageIcon(panelGestionReservas.class.getResource("/presentacion/Icon/"+modeloTablaReservas.getValueAt(n, 5)+".png")));
								lblFoto.setToolTipText("Foto "+modeloTablaReservas.getValueAt(n, 5));
							}
						}
					}
				});
				
				TableColumn columnaTipos = miTabla.getColumnModel().getColumn(5);
				JComboBox comboBox = new JComboBox();
				comboBox.addItem("parcela");
				comboBox.addItem("bungalow");
				columnaTipos.setCellEditor(new DefaultCellEditor(comboBox));
			}
		}

	}
	
	private static ArrayList<Reserva> cargarReserva() {

		Reserva reserva = new Reserva();
		boolean correcto = false;

		correcto = reserva.readAll();

		if (correcto) {
			return (reserva.getReservaDAO().getListaReservas());
		} else {
			return null;
		}
	}
	
	
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			habilitarList(true);
			MiModeloTablaReservas modeloTablaReservas = (MiModeloTablaReservas) miTabla.getModel();
			Object[] nuevaFila = {"...", "...", "..." ,"...", "...", "..."};
			modeloTablaReservas.aniadeFila(nuevaFila);
			modeloTablaReservas.fireTableDataChanged();
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			habilitarList(true);
		}
	}
	public void habilitarList(boolean b) {
		taFilaSeleccionada.setEditable(b);
		btnGuardar.setVisible(b);
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			habilitarList(false);
		}
	}
	
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MiModeloTablaReservas modeloTablaReservas = (MiModeloTablaReservas) miTabla.getModel();
			int n= miTabla.getSelectedRow();
			if (n != -1) modeloTablaReservas.eliminaFila(miTabla.getSelectedRow());
			modeloTablaReservas.fireTableDataChanged();
			
			taFilaSeleccionada.setText("");
			lblFoto.setIcon(null);
			habilitarList(false);
		}
	}
	
}
