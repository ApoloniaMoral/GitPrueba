package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class tabla {

	private JFrame frame;
	@SuppressWarnings("unused")
	private JTable table11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabla window = new tabla();
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
	public tabla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String datos [][]=  {{ "Ensalada" , "15€"},
							{  "Hamburguesa" ,"20€"},
							{  "Patatas" ,"7€"},
							{  "Agua " ,"2€"},
							};
				String columnas []= {"Carta"," Precio"};
				JTable table = new JTable(datos, columnas);
				table.setBounds(44, 58, 126, 136);
				frame.getContentPane().add(table);
				
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(36, 37, 426, 114);
		frame.getContentPane().add(scrollPane);
				
				
		//escuchador
				
				table.setCellSelectionEnabled(true); //para que las celdas sean seleccionables
				table.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
				ListSelectionModel selection = table.getSelectionModel();
				
				selection.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting()) {
								int row = table.getSelectedRow();
								int column = table.getSelectedColumn();
								String valor = (String) table.getValueAt(row, column);
								System.out.println("El valor es " + valor);
						
						}
					}
				});
				
				
	}
}
