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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;

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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
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
			lblSeleccionaElIdioma.setBounds(78, 58, 138, 14);
			add(lblSeleccionaElIdioma);
		}
		{
			lblSeleccionaElTipo = new JLabel("Selecciona el tipo de letra de la pagina:");
			lblSeleccionaElTipo.setBounds(78, 169, 230, 14);
			add(lblSeleccionaElTipo);
		}
		{
			lblCambiaElColor = new JLabel("Cambia el color del fondo de la pagina:");
			lblCambiaElColor.setBounds(78, 246, 230, 14);
			add(lblCambiaElColor);
		}
		{
			lbldeseaQueAprezca = new JLabel("¿Desea que aprezca la fecha de ultima acceso?");
			lbldeseaQueAprezca.setBounds(78, 333, 277, 14);
			add(lbldeseaQueAprezca);
		}
		{
			rdbtnSi = new JRadioButton("Si");
			rdbtnSi.addActionListener(new RdbtnSiActionListener());
			buttonGroup.add(rdbtnSi);
			rdbtnSi.setSelected(true);
			rdbtnSi.setBounds(356, 329, 49, 23);
			add(rdbtnSi);
		}
		{
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.addActionListener(new RdbtnNoActionListener());
			buttonGroup.add(rdbtnNo);
			rdbtnNo.setBounds(425, 329, 53, 23);
			add(rdbtnNo);
		}
		{
			cmbColor = new JComboBox();
			cmbColor.setModel(new DefaultComboBoxModel(new String[] {"Verde", "Azul", "Amarillo"}));
			cmbColor.setBounds(356, 243, 122, 20);
			add(cmbColor);
		}
		{
			cmbTipoLetra = new JComboBox();
			cmbTipoLetra.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Times New Roman", "Arial"}));
			cmbTipoLetra.setBounds(356, 166, 122, 20);
			add(cmbTipoLetra);
		}
		{
			btnSpain = new JButton("");
			btnSpain.setIcon(new ImageIcon(panelPersonalizacion.class.getResource("/presentacion/Icon/espana.png")));
			btnSpain.setBounds(276, 50, 64, 43);
			add(btnSpain);
		}
		{
			btnEnglish = new JButton("");
			btnEnglish.setIcon(new ImageIcon(panelPersonalizacion.class.getResource("/presentacion/Icon/reino-unido.png")));
			btnEnglish.setBounds(385, 50, 64, 43);
			add(btnEnglish);
		}
		
	}

	private class RdbtnSiActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	private class RdbtnNoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*Usuario usuario = new Usuario();
			login log = new login();
			usuario=log.EsEsteUser();
			System.out.println(usuario);
			MenuInicio mInicio= new MenuInicio(usuario);
			mInicio.setVisibleHora(false);*/
		}
	}
}
