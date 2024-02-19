package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pasword {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pasword window = new Pasword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pasword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 436, 2);
		frame.getContentPane().add(scrollPane);
		
		JLabel LabelUsuario = new JLabel("Usuario");
		LabelUsuario.setBounds(104, 84, 79, 13);
		frame.getContentPane().add(LabelUsuario);
		
		textField = new JTextField();
		textField.setBounds(220, 81, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(220, 119, 96, 19);
		frame.getContentPane().add(passwordField);
		
		JButton btnCancelar = new JButton("Cancelar"); //Salir del programa.
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(199, 177, 85, 21);
		frame.getContentPane().add(btnCancelar);
		
		JLabel LabelPass = new JLabel("Contraseña");
		LabelPass.setBounds(104, 122, 79, 13);
		frame.getContentPane().add(LabelPass);
		
		JLabel lblinformation = new JLabel("");
		lblinformation.setBounds(104, 220, 275, 21);
		frame.getContentPane().add(lblinformation);
		
		JButton btnClear = new JButton("Limpiar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnClear.setBounds(294, 177, 85, 21);
		frame.getContentPane().add(btnClear);
		
	
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				
				String usuario = textField.getText();
				String password = new String(passwordField.getPassword());
				
				String data = "Usuario " + usuario;
				data += ", Password: " + password;
				lblinformation.setText(data);
				if (usuario.equals("admin") && password.equals("1234")) {
					JOptionPane.showMessageDialog(null, "Authenticated");
					System.out.println("Puedes pasar");
					}
				
				else {
						System.out.println("¡NO Puedes pasar!");
					}
			}
		});
		btnLogin.setBounds(104, 177, 85, 21);
		frame.getContentPane().add(btnLogin);
	}
}
