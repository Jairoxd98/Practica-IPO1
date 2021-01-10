package presentacion;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class OtroListCellRenderer extends DefaultListCellRenderer {
	//Imagen en la que se cargará el fichero seleccionado por el usuario
	private ImageIcon imagen;
	
	protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean hasFocus) {
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected,
				hasFocus);
		
		ImageIcon miniatura = null;
		try {
			miniatura = new ImageIcon(getClass().getClassLoader().getResource("presentacion/Icon/"+renderer.getText()+".png"));

		} catch (Exception e) {
			miniatura = new ImageIcon(getClass().getClassLoader().getResource("presentacion/Icon/actividad.png"));
		} finally {
			Image image = miniatura.getImage();
			imagen = new ImageIcon(image);
		}
		renderer.setIcon(imagen);
		
		renderer.setBorder(LineBorder.createGrayLineBorder());
		renderer.setHorizontalAlignment(JLabel.CENTER);
		renderer.setBackground(new Color(250, 250, 200));
		renderer.setForeground(Color.BLUE);
		if (isSelected)
			renderer.setBackground(new Color(200, 250, 200));
		return renderer;
	}
	
}
