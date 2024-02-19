package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {

	private JFrame frmMenubar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBar window = new MenuBar();
					window.frmMenubar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuBar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenubar = new JFrame();
		frmMenubar.setTitle("MenuBar");
		frmMenubar.setBounds(100, 100, 901, 300);
		frmMenubar.setLocationRelativeTo(null);
		frmMenubar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenubar.getContentPane().setLayout(null);
		
		JMenu menu, submenu;
		JMenuItem option1, option2, option3, rojo, verde;
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		frmMenubar.setJMenuBar(menuBar);
		
		// instanciamos los menus
		menu= new JMenu("Menu");
		submenu= new JMenu("Sub Menu");
		option1 = new JMenuItem("option1");
		option2 = new JMenuItem("option2");
		option3 = new JMenuItem("option3");
		rojo = new JMenuItem("Color Rojo");
		verde = new JMenuItem("Color Verde");
		
		//Añadirlo de los menu a los demás menus
		
		menu.add(option1);
		menu.add(option2);
		menu.add(option3);
		// va de mayor a menor
		submenu.add(rojo);
		submenu.add(verde);
		
		menu.add(submenu);
		menuBar.add(menu);
		
		//SETEAMOS EL MENU EN EL FRAME PARA QUE SE VEA SIN ESTO NO SE VE
		frmMenubar.setJMenuBar(menuBar); //sin esta linea no se ve el menú
		
		//creacion de listener
		//ACCION PARA CAMBIAR EL COLOR DEL FONDO
		ActionListener colorAction = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem item = (JMenuItem)e.getSource();
				if (item.getText().equals("Color Rojo")) {
					System.out.println(item.getText());
					frmMenubar.getContentPane().setBackground(new Color(255,0,0)); //Para que se tiña el frame de este color
				}
				
				if (item.getText().equals("Color Verde")) {
					System.out.println(item.getText());
					frmMenubar.getContentPane().setBackground(new Color(0,255,0));
				}
				
			}
		};
		
		rojo.addActionListener(colorAction);
		verde.addActionListener(colorAction);
	}
}
