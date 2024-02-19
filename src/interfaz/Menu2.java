package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Menu2 {

	private JFrame frame;
	private JMenu File;
	private JMenu Edit;
	private JMenu Help;
	private JMenuBar menuBar;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu2 window = new Menu2();
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
	public Menu2() {
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
		
		
		JMenuItem abrirarchivo, copiar, cortar, pegar, seleccionartodo;
		
		
		textArea = new JTextArea();
		textArea.setBounds(0, 0, 260, 231);
		frame.getContentPane().add(textArea);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		File = new JMenu("File");
		menuBar.add(File);
		
		Edit = new JMenu("Edit");
		menuBar.add(Edit);
		
		Help = new JMenu("Help");
		menuBar.add(Help);
		
		
		// ITEMS FILE
		abrirarchivo = new JMenuItem("Abrir Archivo");
		
		//ITEMS DE EDIT
		copiar = new JMenuItem("copiar");
		cortar = new JMenuItem("cortar");
		pegar= new JMenuItem("pegar");
		seleccionartodo= new JMenuItem("Seleccionar todo");
		
		//Añadidos
		//ADD menu File
		File.add(abrirarchivo);
		
		//ADD de Menu Edit
		Edit.add(copiar);
		Edit.add(cortar);
		Edit.add(pegar);
		Edit.add(seleccionartodo);
		
		ActionListener abrirarch = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
						
						textArea.setText(texto);
						
					} catch (FileNotFoundException ex) {
						System.out.println ("file not exist.");
					} catch (IOException e1) {
						System.out.println ("Unable to access the file.");
					}
					
					
				}
				
			}
		};
		abrirarchivo.addActionListener(abrirarch);
		
		//Accion Lissenner para todos los botones de EDIT
		ActionListener ediActionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JMenuItem item = (JMenuItem)e.getSource(); // nos devuelve el JMenuItem que ha generado el evento
				if(item.getText().equals("copiar")) 
					textArea.copy();
				if (item.getText().equals("cortar"))
					textArea.cut();
				if (item.getText().equals("pegar"))
					textArea.paste();
				if (item.getText().equals("Seleccionar todo"))
					textArea.selectAll();
				
			}
		};
		copiar.addActionListener(ediActionListener);
		cortar.addActionListener(ediActionListener);
		pegar.addActionListener(ediActionListener);
		seleccionartodo.addActionListener(ediActionListener);
		
	}
	
}
