package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class login {

	private JFrame frmLogin;
	private JPanel panel;
	private JTextField txtUser;
	private JLabel lblUserIcon;
	private JLabel lblPasswordIcon;
	private JCheckBox chckbxRecuerdame;
	private JButton btnEntrar;
	private JLabel lblUser;
	private JLabel lblPassword;
	
	private final String user = "Jairo";
	private final String password = "1234";
	private Color colorBlanco = new Color (255,255,255);
	private Color colorResaltado = new Color (255,255,210);
	private Border bordeRojo = BorderFactory.createLineBorder(Color.RED);
	private Border bordeVerde = BorderFactory.createLineBorder(Color.GREEN);
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.addWindowListener(new FrmInicioWindowListener());
		frmLogin.setTitle("INICIO SESIÓN");
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/presentacion/choza.png")));
		frmLogin.setBounds(100, 100, 500, 350);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		{
			panel = new JPanel();
			frmLogin.getContentPane().add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{62, 80, 55, 147, 82, 65, 0};
			gbl_panel.rowHeights = new int[]{21, 70, 21, 18, 0, 47, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				lblUserIcon = new JLabel("");
				lblUserIcon.setForeground(Color.BLACK);
				lblUserIcon.setIcon(new ImageIcon(login.class.getResource("/presentacion/user.png")));
				GridBagConstraints gbc_lblUserIcon = new GridBagConstraints();
				gbc_lblUserIcon.insets = new Insets(0, 0, 5, 5);
				gbc_lblUserIcon.gridx = 1;
				gbc_lblUserIcon.gridy = 1;
				panel.add(lblUserIcon, gbc_lblUserIcon);
			}
			{
				lblUser = new JLabel("Usuario:");
				GridBagConstraints gbc_lblUser = new GridBagConstraints();
				gbc_lblUser.insets = new Insets(0, 0, 5, 5);
				gbc_lblUser.gridx = 2;
				gbc_lblUser.gridy = 1;
				panel.add(lblUser, gbc_lblUser);
			}
			{
				txtUser = new JTextField();
				txtUser.addKeyListener(new TxtUserKeyListener());
				txtUser.addActionListener(new TxtUserActionListener());
				txtUser.addFocusListener(new MiFocusListener());
				GridBagConstraints gbc_txtUser = new GridBagConstraints();
				gbc_txtUser.gridwidth = 2;
				gbc_txtUser.insets = new Insets(0, 0, 5, 5);
				gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtUser.gridx = 3;
				gbc_txtUser.gridy = 1;
				panel.add(txtUser, gbc_txtUser);
				txtUser.setColumns(10);
			}
			{
				lblPasswordIcon = new JLabel("");
				lblPasswordIcon.setIcon(new ImageIcon(login.class.getResource("/presentacion/candado.png")));
				GridBagConstraints gbc_lblPasswordIcon = new GridBagConstraints();
				gbc_lblPasswordIcon.anchor = GridBagConstraints.EAST;
				gbc_lblPasswordIcon.insets = new Insets(0, 0, 5, 5);
				gbc_lblPasswordIcon.gridx = 1;
				gbc_lblPasswordIcon.gridy = 3;
				panel.add(lblPasswordIcon, gbc_lblPasswordIcon);
			}
			{
				lblPassword = new JLabel("Contraseña:");
				lblPassword.setEnabled(false);
				GridBagConstraints gbc_lblPassword = new GridBagConstraints();
				gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
				gbc_lblPassword.anchor = GridBagConstraints.EAST;
				gbc_lblPassword.gridx = 2;
				gbc_lblPassword.gridy = 3;
				panel.add(lblPassword, gbc_lblPassword);
			}
			{
				txtPassword = new JTextField();
				txtPassword.setEnabled(false);
				txtPassword.addKeyListener(new TxtPasswordKeyListener());
				txtPassword.addFocusListener(new MiFocusListener());
				GridBagConstraints gbc_txtPassword = new GridBagConstraints();
				gbc_txtPassword.gridwidth = 2;
				gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
				gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPassword.gridx = 3;
				gbc_txtPassword.gridy = 3;
				panel.add(txtPassword, gbc_txtPassword);
				txtPassword.setColumns(10);
			}
			{
				chckbxRecuerdame = new JCheckBox("Recuerdame");
				GridBagConstraints gbc_chckbxRecuerdame = new GridBagConstraints();
				gbc_chckbxRecuerdame.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxRecuerdame.gridx = 2;
				gbc_chckbxRecuerdame.gridy = 5;
				panel.add(chckbxRecuerdame, gbc_chckbxRecuerdame);
			}
			{
				btnEntrar = new JButton("Entrar");
				btnEntrar.addActionListener(new BtnEntrarActionListener());
				btnEntrar.setEnabled(false);
				btnEntrar.setIcon(new ImageIcon(login.class.getResource("/presentacion/login.png")));
				GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
				gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
				gbc_btnEntrar.gridx = 4;
				gbc_btnEntrar.gridy = 5;
				panel.add(btnEntrar, gbc_btnEntrar);
			}
		}
	}

	private class TxtUserActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			//Activamos la contraseña
			lblPassword.setEnabled(true);
			txtPassword.setEnabled(true);
			//Pasamos el cursor al campo de la contraseña
			txtPassword.requestFocus();
		}
	}
	
	private class MiFocusListener extends FocusAdapter {//Metodo global para los JTextField a la hora de rellenar un campo
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(colorResaltado);
		}
		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(colorBlanco);
		}
	}
	private class TxtPasswordKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (txtPassword.getText().equals(password) && txtUser.getText().equals(user))
			{
				txtPassword.setBorder(bordeVerde);
				btnEntrar.setEnabled(true);
			} else
			{
				txtPassword.setBorder(bordeRojo);
				btnEntrar.setEnabled(false);
			}
		}
	}
	private class TxtUserKeyListener extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			if (txtPassword.getText().equals(password) && txtUser.getText().equals(user))
			{
				btnEntrar.setEnabled(true);
			} else
			{
				btnEntrar.setEnabled(false);
			}
		}
	}
	private class BtnEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Se crea una instancia de la segunda ventana (JFrame)
			GestionPropiedades otraVentana = new GestionPropiedades();
			//se hace visible
			otraVentana.setVisible(true);
			//se destruye la ventana actual (atributo a nivel de clase)
			frmLogin.setVisible(false);
		}
	}
	private class FrmInicioWindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent arg0) {
			JOptionPane.showMessageDialog(frmLogin, "Gracias por utilizar nuestra aplicación", "Cerrar la aplicación",JOptionPane.PLAIN_MESSAGE);
		}
	}
	public void setVisible(boolean b) {
		frmLogin.setVisible(b);
	}
}
