package interfaz;

import java.awt.EventQueue;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VariasOpcionesMensaje {

	private JFrame frame;
	String imagePath = "C:\\Users\\ALUMNOS_FP\\Desktop\\ICONOS\\seta.png";
    ImageIcon icon = new ImageIcon(imagePath);
// 
//// definir las nuevas dimesiones deseadas
//	
//	int nuevAnchura = 50;
//	int nuevAltura = 40;
//	
//	
//	//redimension de la imagen
//	
//	Image imagenRedimensionada = imagePath.getScale(nuevAnchura, nuevAltura, Image.SCALE_DEFAULT);
//	
//	//Crea un nuevo imagen Icon con la imagen redimencion 
//	
//	imagenIcon  nuevoicon  = new imagenIcon (imagenRedimensionada);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VariasOpcionesMensaje window = new VariasOpcionesMensaje();
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
	public VariasOpcionesMensaje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Object[] optiones = {"Si ho", "Calla ho"};
		
		//JOption dialogo con opciones personalizadas.
		
		@SuppressWarnings("unused")
		int opcion = JOptionPane.showOptionDialog(null, 
				"Mensaje", 
				"Titulo de la pregunta", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				icon, //para poner imagen.
				optiones, 
				optiones[1]); //seleccion de opcion por defecto en este caso la segunda 
	}

}
