package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;

public class ComboBoX{

	private JFrame frame;
	private ComboBoxModel<?> datosCombobox;
	JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboBoX window = new ComboBoX();
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
	public ComboBoX() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	void iniciarComponentes() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] datosCombobox = {"hambuguesa", "kabak","pizza" , "ensalada","fruta", "patatas fritas"}; // Array con los datos a pasar.
		
		comboBox = new JComboBox<String>(datosCombobox); //el String se pone aqui para indicarle que es de tipo String 
		comboBox.setBounds(68, 35, 247, 39);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Cambiar comida");
		lblNewLabel.setBounds(93, 109, 196, 52);
		frame.getContentPane().add(lblNewLabel);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText((String)comboBox.getSelectedItem());
				
			}
		});
		
		JButton btnNewButton = new JButton("Mostrar selección");
		btnNewButton.setBounds(74, 196, 235, 31);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String messageString = " Se ha elegido " + comboBox.getSelectedItem();
				JOptionPane.showMessageDialog(null, messageString);
				
				
			}
		});
		
	}
	void showDialog() { 
		//Para ejecutar un texto por encima del que ya tenemos como en un POP-UP
//		
//		JOptionPane.showMessageDialog(null/*componente padre*/, "Texto"/*Mensaje a mostrar*/);//normal sin más añadidos
//		JOptionPane.showMessageDialog(null, "Texto", "Alert"/*nombre del mensaje*/, JOptionPane.WARNING_MESSAGE/*Tipo de mensaje, en este caso error*/);
//	
		//Show confirm dialog para que el dialogo nos confirme entre varias opciones
//		int respuesta = JOptionPane.showConfirmDialog(null/*componente padre*/, "¿No quieres fruta?");
//		if (respuesta == JOptionPane.YES_OPTION) {
//			System.out.println( "Opcion escojida es" + respuesta);
//			
//		}
//		System.out.println ("Ha seleccionado que " + respuesta);
		
		//Show input dialog
//		String respuesta = JOptionPane.showInputDialog("Introduce una opción ");
//		System.out.println ("Opcion introducida " + respuesta);
//	}
	
		//Añadir linea al comboBox
		int respuesta = JOptionPane.showConfirmDialog(null/*componente padre*/, "¿Quieres añadir un alimento?");
		if (respuesta == JOptionPane.YES_OPTION) {
			String alimento = JOptionPane.showInputDialog("Introduce alimento ");
			comboBox.addItem(alimento); //introduce el alimento a la lista al final
		}
			
		}
	private void initialize() {
		iniciarComponentes();
		showDialog();
	}

	public ComboBoxModel<?> getDatosCombobox() {
		return datosCombobox;
	}

	public void setDatosCombobox(ComboBoxModel<?> datosCombobox) {
		this.datosCombobox = datosCombobox;
	}
}
