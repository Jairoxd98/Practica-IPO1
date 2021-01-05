package presentacion;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class panelDiseñoRutas extends JPanel {
	private JToolBar tbBarraDibujo;
	private JButton btnDibujar;
	private JButton btnBorrar;
	private JButton btnCasa;
	private JButton btnAnotacion;
	private JButton btnMeta;
	private JButton btnCargarMapa;
	private JButton btnEliminar;
	private JSplitPane splitPane;
	private JScrollPane scrollPaneMapa;
	private JScrollPane scrollPaneTabla;
	//Area de dibujo personalizada (creada extendiendo de JLabel)
	private MiAreaDibujo miAreaDibujo;
	//Imagen en la que se cargará el fichero seleccionado por el usuario
	private ImageIcon imagen;
	private JLabel lblNewLabel;
	
	int modo = -1;
	private final int DIBUJAR = 1;
	private final int BORRAR = 2;
	private final int CHOZA = 3;
	private final int ANOTACION = 4;
	private final int META = 5;
	
	//Cursores e imagenes
	private Toolkit toolkit;
	private Image imagChoza;
	private Image imagAnotacion;
	private Image imagMeta;
	private Image imagCursorDibujar;
	private Image imagCursorBorrar;
	private Cursor cursorDibujar;
	private Cursor cursorBorrar;
	private Cursor cursorChoza;
	private Cursor cursorAnotacion;
	private Cursor cursorMeta;
	private int x, y;
	//Componente de entrada de texto que permitirá añadir anotaciones (dibujar texto) sobre la imagen
	private JTextField txtTexto = new JTextField();
	private JButton btnBorrarTodo;
	private JTable miTabla;
	private JList lstRutas;
	/**
	 * Create the panel.
	 */
	public panelDiseñoRutas() {
		setLayout(new BorderLayout(0, 0));
		{
			tbBarraDibujo = new JToolBar();
			add(tbBarraDibujo, BorderLayout.NORTH);
			{
				btnDibujar = new JButton("");
				btnDibujar.addActionListener(new BtnDibujarActionListener());
				btnDibujar.setToolTipText("Dibujar linea");
				btnDibujar.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Icon/lapiz.png")));
				tbBarraDibujo.add(btnDibujar);
			}
			{
				btnBorrar = new JButton("");
				btnBorrar.addActionListener(new BtnBorrarActionListener());
				btnBorrar.setToolTipText("Goma de borrar");
				btnBorrar.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Icon/goma-de-borrar.png")));
				tbBarraDibujo.add(btnBorrar);
			}
			{
				btnCasa = new JButton("");
				btnCasa.addActionListener(new BtnCasaActionListener());
				btnCasa.setToolTipText("Inicio ruta");
				btnCasa.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Icon/chozaPequeña.png")));
				tbBarraDibujo.add(btnCasa);
			}
			{
				btnAnotacion = new JButton("");
				btnAnotacion.addActionListener(new BtnAnotacionActionListener());
				btnAnotacion.setToolTipText("Dibujar anotacion");
				btnAnotacion.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Icon/anotacion.png")));
				tbBarraDibujo.add(btnAnotacion);
			}
			{
				btnMeta = new JButton("");
				btnMeta.addActionListener(new BtnMetaActionListener());
				btnMeta.setToolTipText("Final ruta");
				btnMeta.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Icon/meta.png")));
				tbBarraDibujo.add(btnMeta);
			}
			{
				btnCargarMapa = new JButton("");
				btnCargarMapa.setToolTipText("Cargar mapa");
				btnCargarMapa.addActionListener(new BtnCargarMapaActionListener());
				{
					btnBorrarTodo = new JButton("");
					btnBorrarTodo.addActionListener(new BtnBorrarTodoActionListener());
					btnBorrarTodo.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Icon/borrar.png")));
					tbBarraDibujo.add(btnBorrarTodo);
				}
				btnCargarMapa.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Icon/cargarMapa.png")));
				tbBarraDibujo.add(btnCargarMapa);
			}
			{
				btnEliminar = new JButton("");
				btnEliminar.addActionListener(new BtnEliminarActionListener());
				btnEliminar.setToolTipText("Eliminar mapa");
				btnEliminar.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Icon/quitarMapa.png")));
				tbBarraDibujo.add(btnEliminar);
			}
		}
		{
			splitPane = new JSplitPane();
			add(splitPane, BorderLayout.CENTER);
			{
				scrollPaneMapa = new JScrollPane();
				splitPane.setRightComponent(scrollPaneMapa);
				{
					//Creación del área de dibujo personalizada
					miAreaDibujo = new MiAreaDibujo();
					miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
					miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
					miAreaDibujo.setIcon(null);
					scrollPaneMapa.setViewportView(miAreaDibujo);
					
					//Creación de imágenes y cursores
					toolkit = Toolkit.getDefaultToolkit();
					imagChoza =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/Icon/chozaPequeña.png"));
					imagAnotacion =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/Icon/anotacion.png"));
					imagMeta =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/Icon/meta.png"));
					imagCursorDibujar =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/Icon/lapiz.png"));
					imagCursorBorrar =
					toolkit.getImage(getClass().getClassLoader().getResource("presentacion/Icon/goma-de-borrar.png"));
					//Creación de los cursores
					cursorDibujar = toolkit.createCustomCursor(imagCursorDibujar,new Point(0,0),"CURSOR_DIBUJAR");
					cursorBorrar= toolkit.createCustomCursor(imagCursorBorrar,new Point(0,0),"CURSOR_BORRAR");
					cursorChoza = toolkit.createCustomCursor(imagChoza,new Point(0,0),"CURSOR_CHOZA");
					cursorAnotacion = toolkit.createCustomCursor(imagAnotacion,new Point(0,0),"CURSOR_ANOTACION");
					cursorMeta = toolkit.createCustomCursor(imagMeta,new Point(0,0),"CURSOR_META");
					
					//Se suscriben el oyente de eventos de ratón
					miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
					miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
				}
			}
			{
				scrollPaneTabla = new JScrollPane();
				scrollPaneTabla.setMaximumSize(new Dimension(25, 25));
				scrollPaneTabla.setMinimumSize(new Dimension(20, 20));
				splitPane.setLeftComponent(scrollPaneTabla);
				{
					lstRutas = new JList();
					lstRutas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					lstRutas.addListSelectionListener(new LstRutasListSelectionListener());
					lstRutas.setModel(new AbstractListModel() {
						String[] values = new String[] {"Ruta 1-Bosque", "Ruta 2-Monte"};
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
					scrollPaneTabla.setViewportView(lstRutas);
				}
			}
		}

	}

	private class BtnCargarMapaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser fcAbrir = new JFileChooser();
			fcAbrir.setFileFilter(new ImageFilter());
			int valorDevuelto = fcAbrir.showOpenDialog(btnCargarMapa);
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
			imagen = new ImageIcon(file.getAbsolutePath());
			miAreaDibujo.setIcon(imagen);
			}
		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas eliminar todo?", "Cuidado",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				miAreaDibujo.removeAll();
				miAreaDibujo.repaint();
				miAreaDibujo.setIcon(null);
				miAreaDibujo.revalidate();
			} else {

			}
		}
	}
	private class BtnDibujarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = DIBUJAR;
			scrollPaneMapa.setCursor(cursorDibujar);
		}
	}
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = BORRAR;
			scrollPaneMapa.setCursor(cursorBorrar);
		}
	}
	private class BtnCasaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = CHOZA;
			scrollPaneMapa.setCursor(cursorChoza);
		}
	}
	private class BtnAnotacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = ANOTACION;
			scrollPaneMapa.setCursor(cursorAnotacion);
		}
	}
	private class BtnMetaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = META;
			scrollPaneMapa.setCursor(cursorMeta);
		}
	}
	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			if (imagen != null)
			{
				switch (modo)
				{
					case CHOZA:
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagChoza));
						miAreaDibujo.repaint();
						break;
					case ANOTACION:
						txtTexto.setBounds(x, y, 200,30);
						txtTexto.setVisible(true);
						txtTexto.requestFocus();
						txtTexto.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg) {
								if(!txtTexto.getText().equals(""))
								miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(),Color.BLUE));
								txtTexto.setText("");
								txtTexto.setVisible(false);
								miAreaDibujo.repaint();
							}
						});
						miAreaDibujo.add(txtTexto);
						break;
					case META:
						miAreaDibujo.addObjetoGrafico(new ImagenGrafico(x,y,imagMeta));
						miAreaDibujo.repaint();
						break;
					case DIBUJAR:
						miAreaDibujo.addObjetoGrafico(new LineaGrafica(x,y,x,y,Color.RED));
						break;
					case BORRAR:
						miAreaDibujo.removeObjetoGrafico(x, y);
						miAreaDibujo.repaint();
						break;
				}
			}
		}
	}
	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == DIBUJAR && imagen!=null) {
				((LineaGrafica)miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((LineaGrafica)miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
				}
		}
	}
	private class BtnBorrarTodoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (JOptionPane.showConfirmDialog(null, "¿Estas seguro de que deseas borrar todo lo que has dibujado?", "Cuidado",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				miAreaDibujo.removeAll();
				miAreaDibujo.repaint();
			} else {

			}
		}
	}
	private class LstRutasListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			if(lstRutas.getSelectedValue()== "Ruta 1-Bosque") {
				miAreaDibujo.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Imagenes/mapa1.png")));
				scrollPaneMapa.setViewportView(miAreaDibujo);
			}else if(lstRutas.getSelectedValue()== "Ruta 2-Monte"){
				miAreaDibujo.setIcon(new ImageIcon(panelDiseñoRutas.class.getResource("/presentacion/Imagenes/mapa2.png")));
				scrollPaneMapa.setViewportView(miAreaDibujo);
			}
		}
	}
}
