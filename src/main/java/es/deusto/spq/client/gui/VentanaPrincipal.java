package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import es.deusto.spq.client.ExampleClient;
import es.deusto.spq.pojo.Libro;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {

	String usuario, contraseña;
	JPanel contentPane, panel, panel_1;
	JLabel lblLogo;
	JLabel lblTablaLibros = new JLabel("TABLA LIBROS");
	DefaultTableModel modelo = new DefaultTableModel(new Object[] { "Nombre", "Descripcion", "Precio" }, 0);
	JTable tabla = new JTable(modelo);
	JButton btnNewButton;
	private JPanel panel_2;
	private JButton btnAlquilar;
	private JButton btnSalir;

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
		lblLogo.setOpaque(true);
		lblLogo.setBackground(new Color(236, 250, 244));

		// Cargar la imagen en un ImageIcon
		ImageIcon imagenIcono = new ImageIcon("src/main/java/es/deusto/spq/client/utils/LudoFun.png");

		// Obtener la imagen del ImageIcon
		Image imagenOriginal = imagenIcono.getImage();

		// Obtener el tamaño del JLabel
		int anchoLabel = (int) 600;
		int altoLabel = (int) 600;

		// Crear una nueva imagen escalada que cubra todo el espacio del JLabel
		Image imagenEscalada = imagenOriginal.getScaledInstance(anchoLabel, altoLabel, Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon a partir de la imagen escalada
		ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);

		// Establecer el ImageIcon en el JLabel
		lblLogo.setIcon(imagenEscaladaIcono);

		panel.add(lblLogo, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(187, 197, 193));
		panel.add(panel_2, BorderLayout.SOUTH);
		
		btnSalir = new JButton("Salir");

		panel_2.add(btnSalir);
		
		btnAlquilar = new JButton("Alquilar");
		btnAlquilar.setEnabled(false);

		panel_2.add(btnAlquilar);
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		lblTablaLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablaLibros.setBackground(new Color(244, 164, 96));
		lblTablaLibros.setFont(new Font("Montserrat", Font.BOLD, 24));
		lblTablaLibros.setOpaque(true);
		panel_1.add(lblTablaLibros, BorderLayout.NORTH);
		panel_1.add(new JScrollPane(tabla), BorderLayout.CENTER);
		cargarDatos();
		
		
		
		//FUNCIONALIDAD
		
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SI TIENES ALGUN LIBRO SELECCIONADO DE LA TABLA UN IF LO COMPRUEBA Y PONE EL BOTON ENABLE Y ALQUILA EL LIBRO 
				//DAR FUNCIONALIDAD DE ALQUILAR
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		

	}

	private void cargarDatos() {
		// TODO Auto-generated method stub
		ExampleClient eC = new ExampleClient("localhost", "8080");
		List<Libro> books = eC.getBooks();
		for (Libro libro : books) {
			String[] fila = { libro.getNombre(), libro.getDescripccion(), String.valueOf(libro.getPrecio()) };
			modelo.addRow(fila);
			System.out.println(libro.toString());
		}

	}
}