package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class XBOX {

	private JFrame frame;
	//private final ButtonGroup buttonGroup = new ButtonGroup();//Lo que hace los botones de circulo estén agrupados.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XBOX window = new XBOX();
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
	public XBOX() {
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
		
				
		JLabel lblNewLabel = new JLabel("Tortilla");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(215, 59, 189, 30);
		frame.getContentPane().add(lblNewLabel);
		
					
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Con cebolla");
		//buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(215, 105, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.isSelected();
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Sin cebolla");
		//buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(215, 128, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.isSelected();
		
		ButtonGroup bp= new ButtonGroup();
		bp.add(rdbtnNewRadioButton);
		bp.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Selecciona");
		btnNewButton.setBounds(216, 173, 118, 30);
		frame.getContentPane().add(btnNewButton);
		
		
		JCheckBox CheckBoxMuyHecha = new JCheckBox("Mal hecha");
		CheckBoxMuyHecha.setBounds(39, 128, 93, 21);
		frame.getContentPane().add(CheckBoxMuyHecha);
		
		JLabel LabelPreparacion = new JLabel("Preparacion");
		LabelPreparacion.setBounds(43, 59, 124, 30);
		frame.getContentPane().add(LabelPreparacion);
		
		
		//rdbtnNewRadioButton.setActionCommand(""); //llamada a la acción para el get seletion
		btnNewButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				//lblNewLabel.setText("Tortilla " + bp.getSelection().getActionCommand()); Opcion 1 o 2 
				
				String tortilla1 = "Tortilla con cebolla";
				String tortilla2 = "Tortilla sin cebolla";
				
				if (rdbtnNewRadioButton.isSelected()) { //true si está seleccionado.
					lblNewLabel.setText (tortilla1);
					System.out.println(tortilla1);
				}
				else if (rdbtnNewRadioButton_1.isSelected()) {
					lblNewLabel.setText (tortilla2);
					System.out.println(tortilla2);
					
				} else {
					lblNewLabel.setText ("No has seleccionado nada");
					System.out.println("No has seleccionado nada");
				}
				
									
			
				}
		});
		JCheckBox CheckBoxPocoHecha = new JCheckBox("Poco hecha");
		CheckBoxPocoHecha.setSelected(true);
		LabelPreparacion.setText("Poco hecha");
		CheckBoxPocoHecha.setBounds(39, 105, 93, 21);
		frame.getContentPane().add(CheckBoxPocoHecha);
		
		
		ActionListener actionCheckBox = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (CheckBoxPocoHecha.isSelected()&& CheckBoxMuyHecha.isSelected() ) {
					LabelPreparacion.setText("Poco hecha y  mal hecha");
			//		JOptionPane.showMessageDialog(null, "Poco hecha y mal hecha");
					}
					  else if (CheckBoxPocoHecha.isSelected()&& !CheckBoxMuyHecha.isSelected() ) { //Distinto de la opcion 2 !
						LabelPreparacion.setText("Poco hecha");
				//		JOptionPane.showMessageDialog(null, "Poco hecha");
						
					} else if (!CheckBoxPocoHecha.isSelected()&& CheckBoxMuyHecha.isSelected() ) { //Distinto de la op1 
						LabelPreparacion.setText("Mal hecha");
				//		JOptionPane.showMessageDialog(null, "Mal hecha");
						
					} else {
						LabelPreparacion.setText ("No has seleccionado nada");

					}

					
				}
		};
		CheckBoxPocoHecha.addActionListener(actionCheckBox);
		CheckBoxMuyHecha.addActionListener(actionCheckBox);
		
		CheckBoxPocoHecha.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox c =(JCheckBox) e.getSource();
				System.out.println (e.getStateChange()+ " " + c.getText());
				
				
			}
		});
	}
	
}
