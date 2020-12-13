package presentacion;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;

import dominio.Usuario;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class panelDatosPersonales extends JPanel {
	private JLabel lblFoto;
	private JPanel pnlDatosUsuario;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JLabel lblDomicilio;
	private JLabel lblCorreo;
	private JLabel lblNacionalidad;
	private JLabel lblFechaNacimiento;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtDomicilio;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtFechaNacimiento;
	private JTextField txtNacionalidad;

	/**
	 * Create the panel.
	 */
	public panelDatosPersonales(Usuario usuario) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		{
			lblFoto = new JLabel("");
			lblFoto.setIcon(new ImageIcon(panelDatosPersonales.class.getResource("/presentacion/Imagenes/"+usuario.getNombre()+".png")));
			lblFoto.setBounds(10, 33, 68, 70);
			add(lblFoto);
		}
		{
			pnlDatosUsuario = new JPanel();
			pnlDatosUsuario.setName("");
			pnlDatosUsuario.setBorder(new TitledBorder(null, "Datos Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlDatosUsuario.setBackground(Color.WHITE);
			pnlDatosUsuario.setForeground(Color.WHITE);
			pnlDatosUsuario.setToolTipText("");
			pnlDatosUsuario.setBounds(100, 11, 390, 378);
			add(pnlDatosUsuario);
			pnlDatosUsuario.setLayout(null);
			{
				lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 48, 46, 14);
				pnlDatosUsuario.add(lblNombre);
			}
			{
				lblApellidos = new JLabel("Apellidos:");
				lblApellidos.setBounds(206, 51, 46, 14);
				pnlDatosUsuario.add(lblApellidos);
			}
			{
				lblTelefono = new JLabel("Telefono:");
				lblTelefono.setBounds(206, 221, 46, 14);
				pnlDatosUsuario.add(lblTelefono);
			}
			{
				lblDni = new JLabel("DNI:");
				lblDni.setBounds(10, 134, 22, 14);
				pnlDatosUsuario.add(lblDni);
			}
			{
				lblDomicilio = new JLabel("Domicilio:");
				lblDomicilio.setBounds(10, 218, 46, 14);
				pnlDatosUsuario.add(lblDomicilio);
			}
			{
				lblCorreo = new JLabel("Correo:");
				lblCorreo.setBounds(10, 303, 46, 14);
				pnlDatosUsuario.add(lblCorreo);
			}
			{
				lblNacionalidad = new JLabel("Nacionalidad:");
				lblNacionalidad.setBounds(206, 137, 69, 14);
				pnlDatosUsuario.add(lblNacionalidad);
			}
			{
				lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
				lblFechaNacimiento.setBounds(181, 303, 96, 14);
				pnlDatosUsuario.add(lblFechaNacimiento);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setText(usuario.getNombre());
				txtNombre.setBounds(55, 45, 96, 20);
				pnlDatosUsuario.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtApellidos = new JTextField();
				txtApellidos.setEditable(false);
				txtApellidos.setText(usuario.getApellidos());
				txtApellidos.setBounds(274, 45, 96, 20);
				pnlDatosUsuario.add(txtApellidos);
				txtApellidos.setColumns(10);
			}
			{
				txtDNI = new JTextField();
				txtDNI.setEditable(false);
				txtDNI.setText(usuario.getDNI());
				txtDNI.setColumns(10);
				txtDNI.setBounds(55, 131, 96, 20);
				pnlDatosUsuario.add(txtDNI);
			}
			{
				txtDomicilio = new JTextField();
				txtDomicilio.setEditable(false);
				txtDomicilio.setText(usuario.getDomicilio());
				txtDomicilio.setColumns(10);
				txtDomicilio.setBounds(55, 215, 96, 20);
				pnlDatosUsuario.add(txtDomicilio);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setEditable(false);
				txtTelefono.setText(usuario.getTelefono());
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(274, 218, 96, 20);
				pnlDatosUsuario.add(txtTelefono);
			}
			{
				txtCorreo = new JTextField();
				txtCorreo.setEditable(false);
				txtCorreo.setText(usuario.getCorreo());
				txtCorreo.setColumns(10);
				txtCorreo.setBounds(55, 300, 96, 20);
				pnlDatosUsuario.add(txtCorreo);
			}
			{
				txtFechaNacimiento = new JTextField();
				txtFechaNacimiento.setEditable(false);
				txtFechaNacimiento.setText(usuario.getFecha());
				txtFechaNacimiento.setColumns(10);
				txtFechaNacimiento.setBounds(274, 300, 96, 20);
				pnlDatosUsuario.add(txtFechaNacimiento);
			}
			{
				txtNacionalidad = new JTextField();
				txtNacionalidad.setEditable(false);
				txtNacionalidad.setText(usuario.getNacionalidad());
				txtNacionalidad.setColumns(10);
				txtNacionalidad.setBounds(274, 131, 96, 20);
				pnlDatosUsuario.add(txtNacionalidad);
			}
		}

	}
}
