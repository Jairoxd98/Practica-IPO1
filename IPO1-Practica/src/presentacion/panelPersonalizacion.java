package presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Graphics;

public class panelPersonalizacion extends JPanel {
	private JLabel lblSeleccionaElIdioma;
	private JLabel lblSeleccionaElTipo;
	private JLabel lblCambiaElColor;
	private JLabel lbldeseaQueAprezca;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private JComboBox cmbColor;
	private JComboBox cmbTipoLetra;
	private JButton btnSpain;
	private JButton btnEnglish;

	/**
	 * Create the panel.
	 */
	public panelPersonalizacion() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, "Personalizacion de la pagina", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		{
			lblSeleccionaElIdioma = new JLabel("Selecciona el idioma:");
			lblSeleccionaElIdioma.setBounds(20, 30, 103, 14);
			add(lblSeleccionaElIdioma);
		}
		{
			lblSeleccionaElTipo = new JLabel("Selecciona el tipo de letra de la pagina:");
			lblSeleccionaElTipo.setBounds(20, 115, 192, 14);
			add(lblSeleccionaElTipo);
		}
		{
			lblCambiaElColor = new JLabel("Cambia el color del fondo de la pagina:");
			lblCambiaElColor.setBounds(20, 182, 185, 14);
			add(lblCambiaElColor);
		}
		{
			lbldeseaQueAprezca = new JLabel("¿Desea que aprezca la fecha de ultima acceso?");
			lbldeseaQueAprezca.setBounds(20, 245, 230, 14);
			add(lbldeseaQueAprezca);
		}
		{
			rdbtnSi = new JRadioButton("Si");
			rdbtnSi.setBounds(275, 241, 39, 23);
			add(rdbtnSi);
		}
		{
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.setBounds(340, 241, 39, 23);
			add(rdbtnNo);
		}
		{
			cmbColor = new JComboBox();
			cmbColor.setBounds(257, 179, 122, 20);
			add(cmbColor);
		}
		{
			cmbTipoLetra = new JComboBox();
			cmbTipoLetra.setBounds(257, 112, 122, 20);
			add(cmbTipoLetra);
		}
		{
			btnSpain = new JButton("");
			btnSpain.setIcon(new ImageIcon(panelPersonalizacion.class.getResource("/presentacion/Icon/espana.png")));
			btnSpain.setBounds(168, 30, 64, 43);
			add(btnSpain);
		}
		{
			btnEnglish = new JButton("");
			btnEnglish.setIcon(new ImageIcon(panelPersonalizacion.class.getResource("/presentacion/Icon/reino-unido.png")));
			btnEnglish.setBounds(275, 30, 64, 43);
			add(btnEnglish);
		}
		
	}
}
