package presentacion;

import java.awt.Color;
import java.awt.Component;
import javax.swing.tree.TreeCellRenderer;
import java.awt.Component;
import javax.swing.*;
import javax.swing.tree.*;

class MiRenderizadoArbol extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) value;
		
		setBackground(new Color(0, 128, 0));
		setOpaque(true);
		setForeground(Color.BLACK);
		
		String c = (String) (nodo.getUserObject());
		switch (c) {
		case "Gestion":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("/presentacion/Icon/Gestion.png")));
			break;
		case "Propiedades":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Personal":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Actividades":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Rutas":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Añadir":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("/presentacion/Icon/anadir.png")));
			break;
		case "Modificar":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("/presentacion/Icon/editar.png")));
			break;
		}
		return this;
	}
}
