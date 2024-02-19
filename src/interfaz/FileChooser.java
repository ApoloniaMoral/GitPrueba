package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FileChooser {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooser window = new FileChooser();
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
	public FileChooser() {
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
		
		JTextArea Texto1 = new JTextArea();
		Texto1.setBounds(78, 25, 290, 134);
		frame.getContentPane().add(Texto1);
		
		JButton BotonEscribir = new JButton("Escribir");
		BotonEscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				FileNameExtensionFilter filtroExtensionFilter = new FileNameExtensionFilter("Text file", "txt");
				
				//aplicar el filtro
				fc.addChoosableFileFilter(filtroExtensionFilter);
				
				//Dejarlo con solo la opcion del filtro
				fc.setAcceptAllFileFilterUsed(false);
				
				//Abrir el buscador de documentos
				//int result = fc.showSaveDialog(null);
				JFileChooser fc1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Test Files", "txt");

				fc1.setAcceptAllFileFilterUsed(false);

				fc1.addChoosableFileFilter(filter);

				int result1 = fc1.showSaveDialog(null);

				if (result1 == JFileChooser.APPROVE_OPTION) {

					File file = fc1.getSelectedFile();

					String content = Texto1.getText();

					try {

						FileWriter fw = new FileWriter(file, true/*No te lo sobreescribe... si esta false si*/);// si existe el fichero te lo añade en ese fichero sino te lo crea.

						fw.write(content);

						fw.close();

					} catch (FileNotFoundException ex) {

						System.out.print("File does not exist.");

					} catch (IOException ex) {

						System.out.print("Unable to access the file.");

					}

				}
			}
		});
		BotonEscribir.setBounds(44, 187, 121, 44);
		frame.getContentPane().add(BotonEscribir);
		
		JButton BotonLeer = new JButton("Leer");
		BotonLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						//JFileChooser fc = new JFileChooser(); //Si dejamos vacío abre documentos
						
						JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
						FileNameExtensionFilter filtroExtensionFilter = new FileNameExtensionFilter("Text file", "txt");
						
						//aplicar el filtro
						fc.addChoosableFileFilter(filtroExtensionFilter);
						
						//Dejarlo con solo la opcion del filtro
						fc.setAcceptAllFileFilterUsed(false);
						
						//Abrir el buscador de documentos
						int result = fc.showOpenDialog(null);
						
						if(result == JFileChooser.APPROVE_OPTION) {
							BufferedReader buffer =null;
							try {
								//Lee el archivo seleccionado.
								File file = fc.getSelectedFile();
								
								//Inicializar el Buffer
								buffer = new BufferedReader(new FileReader(file));
								
								//Declarando variables para trabajar el fichero.
								
								String line;
								String texto = "";
								
								//Leer el file
								while ((line = buffer.readLine()) != null) {
									texto+= line + "\n";
									}
								
								Texto1.setText(texto);
								
							} catch (FileNotFoundException ex) {
								System.out.println ("file not exist.");
							} catch (IOException e1) {
								System.out.println ("Unable to access the file.");
							}
							
							
						}
					
						
					}
				
			
		});
		
		BotonLeer.setBounds(277, 187, 121, 50);
		frame.getContentPane().add(BotonLeer);
		
		
	}
}
