package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Registro;
import Modelo.ValidadorDNI;
import Modelo.ValidadorEmail;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class registro extends JFrame {

	private JPanel contentPane;
	private JTextField textDNI;
	private JTextField textNom;
	private JTextField textAP1;
	private JTextField textAP2;
	private JTextField textUser;
	private JTextField textpass;
	private JTextField textEM;
	private JTextField textTlf;
	private JTextField textTarjeta;
	private JLabel lblRegistro;
	private JLabel lblDNI;
	private JLabel labelNombre;
	private JLabel lblapellido;
	private JLabel lblapellido_1;
	private JLabel lblUsername;
	private JLabel lblContrasea;
	private JLabel lblEmail;
	private JLabel lblTelefono;
	private JLabel lblTarjeta;
	private JButton btnRegistrarse;
	private JButton btnRestablecer;
	private JButton btnVolver;
	private JLabel label;
	private JLabel label_6;



	/**
	 * Create the frame.
	 */
	public registro() {
		setTitle("LUDA2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblRegistro = new JLabel();
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 50));

		lblDNI = new JLabel();
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 20));

		labelNombre = new JLabel();
		labelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblapellido = new JLabel();
		lblapellido.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblapellido_1 = new JLabel();
		lblapellido_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblUsername = new JLabel();
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblContrasea = new JLabel();
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblEmail = new JLabel("E-Mail");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblTelefono = new JLabel();
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblTarjeta = new JLabel();
		lblTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		if(Login.idioma) {
			lblRegistro.setText("Sign up");
			labelNombre.setText("Name");
			lblDNI.setText("ID");
			lblapellido.setText("First Surname");
			lblapellido_1.setText("Second Surname");
			lblUsername.setText("UserName");
			lblContrasea.setText("Password");
			lblTelefono.setText("Phone");
			lblTarjeta.setText("Credit Card");

		}
		else {
			lblRegistro.setText("Registro");
			labelNombre.setText("Nombre");
			lblDNI.setText("DNI");
			lblapellido.setText("1� Apellido");
			lblapellido_1.setText("2� Apellido");
			lblUsername.setText("Usuario");
			lblContrasea.setText("Contrase�a");
			lblTelefono.setText("Tel�fono");
			lblTarjeta.setText("Tarjeta");

		}

		textDNI = new JTextField();
		textDNI.setColumns(10);

		textNom = new JTextField();
		textNom.setColumns(10);

		textAP1 = new JTextField();
		textAP1.setColumns(10);

		textAP2 = new JTextField();
		textAP2.setColumns(10);

		textUser = new JTextField();
		textUser.setColumns(10);

		textpass = new JTextField();
		textpass.setFont(new Font("Bookshelf Symbol 7", Font.PLAIN, 13));
		textpass.setColumns(10);

		textEM = new JTextField();
		textEM.setColumns(10);

		textTlf = new JTextField();
		textTlf.setColumns(10);

		btnRegistrarse = new JButton("Registrarse");
		if(Login.idioma) {
			btnRegistrarse.setText("Sign Up");
		}
		else {
			btnRegistrarse.setText("Registrarse");
		}
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidadorDNI vD=new ValidadorDNI(textDNI.getText());
				ValidadorEmail vE=new ValidadorEmail(textEM.getText());
				if(vD.validar()) {
					if(vE.Validar()) {
						Registro r=new Registro(textEM.getText().trim(),textDNI.getText().trim(),textNom.getText().trim(),textAP1.getText().trim(),textAP2.getText().trim(),textUser.getText().trim(),textpass.getText().trim(), Integer.parseInt(textTlf.getText().trim()), textTarjeta.getText().trim());
						r.insertarUsuario();
						Login L=new Login();
						L.setVisible(true);
						dispose();
					}
					else {
						Error err=new Error();
						err.setVisible(true);
						label.setVisible(false);
						label_6.setVisible(true);
					}
				}
				else {
					Error err=new Error();
					err.setVisible(true);
					label.setVisible(true);
					label_6.setVisible(false);
				}
			}
		});

		btnRestablecer = new JButton();
		if(Login.idioma) {
			btnRestablecer.setText("Restore");
		}
		else {
			btnRestablecer.setText("Restablecer");
		}
		btnRestablecer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNom.setText("");
				textAP1.setText("");
				textAP2.setText("");
				textDNI.setText("");
				textEM.setText("");
				textTlf.setText("");
				textUser.setText("");
				textpass.setText("");
			}
		});

		btnVolver = new JButton("Menu");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login L=new Login();
				L.setVisible(true);
				dispose();
			}
		});

		textTarjeta = new JTextField();
		textTarjeta.setColumns(10);

		label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setVisible(false);

		label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_6.setVisible(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(lblRegistro))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(labelNombre, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDNI)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblapellido)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUsername)
										.addComponent(lblapellido_1))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblContrasea)
										.addComponent(lblTelefono)
										.addComponent(lblTarjeta)
										.addComponent(btnRegistrarse)
										.addComponent(lblEmail, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textTarjeta, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
										.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textAP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textAP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textTlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(textpass, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(textEM, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(label))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(42)
									.addComponent(btnRestablecer)
									.addGap(46)
									.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegistro)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDNI)
						.addComponent(textDNI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblapellido, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAP1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblapellido_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAP2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textpass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textEM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textTlf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTarjeta)
						.addComponent(textTarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnRegistrarse)
						.addComponent(btnRestablecer)
						.addComponent(btnVolver))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
