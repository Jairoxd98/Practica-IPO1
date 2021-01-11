package presentacion;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;

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
	private static JTable miTabla;
	private JTextArea taFilaSeleccionada;
	private static ArrayList<Reserva> list = cargarReserva();
	private static int ROW;
	private ImageIcon imagen;
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
								String contenido="";
										
										try {
											contenido+=
													"ID Reserva: "+list.get(n).getId()+"\n"+
													"Nombre: "+ list.get(n).getNombre()+"\n"+
													"Fecha entrada: "+ list.get(n).getFechaEntrada()+"\n"+
													"Fecha salida: "+ list.get(n).getFechaSalida()+"\n"+
													"Tipo: "+ list.get(n).getTipo()+"\n"+		
													"Telefono: "+list.get(n).getTelefono()+"\n"+
													"Email: "+list.get(n).getEmail()+"\n"+
													"Ocupantes: "+ list.get(n).getOcupantes()+"\n"+
													"Solicitud: "+list.get(n).getSolicitud()+"\n"+
													"Hora entrega: "+list.get(n).getHoraEntrada()+"\n"+
													"Hora salida: "+list.get(n).getHoraSalida()+"\n";
										}catch(NullPointerException ne) {
											contenido+=
													"ID Reserva: \n"+
													"Nombre: \n"+
													"Fecha entrada: \n"+
													"Fecha salida: \n"+
													"Tipo: \n"+		
													"Telefono: \n"+
													"Email: \n"+
													"Ocupantes: \n"+
													"Solicitud: \n"+
													"Hora entrega: \n"+
													"Hora salida: \n";
										}
										
								taFilaSeleccionada.setText(contenido);
								
								ImageIcon miniatura = null;
								try {
									miniatura = new ImageIcon(getClass().getClassLoader().getResource("presentacion/Icon/"+list.get(n).getTipo()+".png"));
								} catch (Exception ei) {
									miniatura = new ImageIcon(getClass().getClassLoader().getResource("presentacion/Icon/choza.png"));
								} finally {
									Image image = miniatura.getImage();
									imagen = new ImageIcon(image);
								}
								lblFoto.setIcon(imagen);
								lblFoto.setToolTipText("Foto "+list.get(n).getTipo());
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
				PanelDatosReservas panel = new PanelDatosReservas(0);
				panel.setVisible(true);
				JOptionPane.showMessageDialog(null,"Para guardar una ruta rellena todos los campos y pulsa Guardar");
		}
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			MiModeloTablaReservas modeloTablaReservas = (MiModeloTablaReservas) miTabla.getModel();
			int n= miTabla.getSelectedRow();
			ROW=n;
			if (n != -1) {
				PanelDatosReservas panel = new PanelDatosReservas(0);
				panel.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null,"Debes seleccionar una reserva para eliminarla");
			}
		}
	}
	
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar la reserva seleccionada?", "Cuidado",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				MiModeloTablaReservas modeloTablaReservas = (MiModeloTablaReservas) miTabla.getModel();
				int n= miTabla.getSelectedRow();
				if (n != -1) {
					modeloTablaReservas.eliminaFila(miTabla.getSelectedRow());
					modeloTablaReservas.fireTableDataChanged();
					list.remove(n);
				}else {
					JOptionPane.showMessageDialog(null,"Debes seleccionar una reserva para eliminarla");
				}
				lblFoto.setIcon(null);
				taFilaSeleccionada.setText("");
			} else {

			}
			
		}
	}
	
	public static ArrayList<Reserva> getListReserva(){
		return list;
	}
	public static JTable getpanel() {
		return miTabla;
	}
	public static int getRow() {
		return ROW;
	}
	
}