package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	String usuario, contraseña;
	JPanel contentPane, panel, panel_1;
	JLabel lblLogo;

	public VentanaPrincipal(String usuario, String contraseña) {

		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("LudoFun");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		lblLogo = new JLabel();
		
		
		// Cargar la imagen en un ImageIcon
				ImageIcon imagenIcono = new ImageIcon("src/main/java/es/deusto/spq/client/utils/LudoFun.png");

				// Obtener la imagen del ImageIcon
				Image imagenOriginal = imagenIcono.getImage();

				// Obtener el tamaño del JLabel
				int anchoLabel = (int)600;
				int altoLabel = (int) 600;

				// Crear una nueva imagen escalada que cubra todo el espacio del JLabel
				Image imagenEscalada = imagenOriginal.getScaledInstance(anchoLabel, altoLabel, Image.SCALE_SMOOTH);

				// Crear un nuevo ImageIcon a partir de la imagen escalada
				ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);

				// Establecer el ImageIcon en el JLabel
				lblLogo.setIcon(imagenEscaladaIcono);
		
		//lblLogo.setIcon(new ImageIcon("src/main/java/es/deusto/spq/client/utils/LudoFun.png"));
		
		
		
		panel.add(lblLogo, BorderLayout.CENTER);
		panel_1 = new JPanel();
		contentPane.add(panel_1);

	}
}