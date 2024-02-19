package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class VentanaNueva {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNueva window = new VentanaNueva();
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
	public VentanaNueva() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(154, 94, 514, 153);
		frame.getContentPane().add(textArea);
		
		JLabel labelLetras = new JLabel("Cuantas Letras");
		labelLetras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelLetras.setBounds(164, 257, 109, 41);
		frame.getContentPane().add(labelLetras);
		
		JLabel ResultadoLetras = new JLabel("NºLetras");
		ResultadoLetras.setBounds(268, 266, 69, 27);
		frame.getContentPane().add(ResultadoLetras);
		
		JLabel labelPalabras = new JLabel("Cuantas Palabras");
		labelPalabras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPalabras.setBounds(483, 257, 172, 41);
		frame.getContentPane().add(labelPalabras);
		
		JLabel ResultadoPalabras = new JLabel("NºPalabras");
		ResultadoPalabras.setBounds(599, 266, 69, 27);
		frame.getContentPane().add(ResultadoPalabras);
		
		JButton btnNewButton = new JButton("Contador");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto = textArea.getText();
				//int numCaracteres = texto.trim().length(); //Trim es para quitar los espacios de delante y detrás
				int numCaracteres = texto.replaceAll(" ", "").length(); //replace para quitar caracteres en general.
				ResultadoLetras.setText("" + numCaracteres); //metodo que nos devuelve los caracteres de una palabra
				
				String[] arrayPalabras/*Esta primera parte no es necesaria pero lo pongo para saber que devuelve una array de strings */ = texto.split("\\s");//metodo Split nos cuenta segun un parámetro ("//s" para poner espacios)
				int numPalabras = arrayPalabras.length;
				ResultadoPalabras.setText("" + numPalabras);
					
			}
		});
		btnNewButton.setBounds(298, 353, 263, 48);
		frame.getContentPane().add(btnNewButton);
		
	}
}
