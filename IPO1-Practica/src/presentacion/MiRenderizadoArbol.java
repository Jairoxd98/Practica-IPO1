package presentacion;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

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
		Font negrita = new Font("Calibri", Font.BOLD, 14);
		setFont(negrita);
		String c = (String) (nodo.getUserObject());
		switch (c) {
		case "Gestion":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("/presentacion/Icon/Gestion.png")));
			break;
		case "Reservas":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Propiedades":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Parcela":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("/presentacion/Icon/parcela2.png")));
			break;
		case "Bungalow":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("/presentacion/Icon/bungalow2.png")));
			break;
		case "Empleados":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Actividades":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Rutas":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("")));
			break;
		case "Diseño rutas":
			setIcon(new ImageIcon(MiRenderizadoArbol.class.getResource("/presentacion/Icon/chozaPequeña2.png")));
			break;
		}
		return this;
	}
}
