package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import javax.swing.JLabel;

public class Spinner {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spinner window = new Spinner();
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
	public Spinner() {
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
		
		//para darle valores iniciales al Spinner
		SpinnerModel model = new SpinnerNumberModel(
				10, //Valor inicial
				0,//minimo
				20,//maximo
				1//saltos que va dando
				);
				
		JSpinner spinner = new JSpinner(model);
		spinner.setBounds(65, 73, 48, 46);
		frame.getContentPane().add(spinner);
		spinner.setEditor(new JSpinner.DefaultEditor(spinner)); //para que no se pueda escribir dentro del spinner.
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(140, 89, 45, 13);
		frame.getContentPane().add(lblNewLabel);
	}
}
