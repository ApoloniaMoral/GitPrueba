package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class VentanaPrincipal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue/*cola de eventos*/.invokeLater/*invoca más tarde*/(new Runnable() { //New Runnable -> crea un proceso.
			public void run() {/*lo que se va a ejecutar*/
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true); //ser visible la ventana
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100/*Posicion en X*/, 100/*posicion en Y*/, 725/*ancho*/, 471/*alto*/);//método que nos posiciona la ventana, se empieza a contar desde la esquina arriba a la izquierda que sería 0, 0 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("¿Quién eres?");
		lblNewLabel.setBounds(167, 171, 102, 21); //tamaño y disposición
		
		JLabel otraEtiqueta = new JLabel ();
		otraEtiqueta.setBounds(167, 190, 80, 60);
		otraEtiqueta.setText("Otra etiqueta");
		frame.getContentPane().add(otraEtiqueta);
		
		//BOTON ACEPTAR
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() { //escucha del botón para que ejecute un acción
			public void actionPerformed(ActionEvent e) {//Esto es el cuerpo del ActionListener, obligatorio porque es una interfaz 
			//todo lo que queremos que haga el programa se pondrá aquí
			}
		});
		btnNewButton.setBounds(460, 169, 85, 25);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(btnNewButton);
		
		//TEXTO
		
		JTextPane txtpnEscribe = new JTextPane();
		txtpnEscribe.setText("Escribe aquí tu nombre");
		txtpnEscribe.setToolTipText("");
		txtpnEscribe.setForeground(new Color(0, 0, 0));
		txtpnEscribe.setBounds(291, 173, 134, 21);
		frame.getContentPane().add(txtpnEscribe);
		
		// CHECK 
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Eres estudiante de DAM");
		chckbxNewCheckBox.setBounds(291, 264, 134, 21);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		//BOTON CAMBIO 
		
		JButton btnNewButton1 = new JButton("Cambio");
		
		btnNewButton1.setBounds(460, 199, 85, 25);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(btnNewButton1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(122, 58, 442, 82);
		frame.getContentPane().add(textArea);
		
		btnNewButton1.addActionListener(new ActionListener() { //escucha del botón para que ejecute un acción
			@Override
			public void actionPerformed(ActionEvent e) {//Esto es el cuerpo del ActionListener, obligatorio porque es una interfaz 
			//todo lo que queremos que haga el programa se pondrá aquí
				lblNewLabel.setText(otraEtiqueta.getText());
				otraEtiqueta.setText("Nuevo Texto");
				lblNewLabel.setText(txtpnEscribe.getText());
			}
		});
	}
}
