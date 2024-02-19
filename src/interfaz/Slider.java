package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Slider {

	private JFrame frame;
	private JLabel lblNumero;
	private JSlider slider;
	private JButton BotonMostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slider window = new Slider();
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
	public Slider() {
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
		
		slider = new JSlider(JSlider.HORIZONTAL, 0,50,25);
		slider.setBounds(31, 58, 233, 134);
		slider.setMinorTickSpacing(2); //separacion mínima entre rallitas
		slider.setMajorTickSpacing(10); // la separación de ralla grande,
		slider.setPaintTicks(true); //para que nos pinte las rallitas
		slider.setPaintLabels(true); //para mostrar los números
		frame.getContentPane().add(slider);
		
		frame.getContentPane().add(slider);
		
		slider.getValue();
		slider.setValue(0);
		
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int sliderValue = slider.getValue();
				lblNumero.setText(Integer.toString(sliderValue));
				
			}
			
		});
		
		
		
		lblNumero = new JLabel("");
		lblNumero.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(274, 83, 68, 59);
		frame.getContentPane().add(lblNumero);
		
		BotonMostrar = new JButton("Mostrar");
		BotonMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(BotonMostrar, slider.getValue());
			}
			
		});
		
		
		
		
		BotonMostrar.setBounds(105, 190, 113, 30);
		frame.getContentPane().add(BotonMostrar);
	}
}
