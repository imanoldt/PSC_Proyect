package es.deusto.spq.client.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.client.ClientController;
import es.deusto.spq.client.ExampleClient;
import es.deusto.spq.pojo.LibroDTO;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Color;

import java.awt.Image;

import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JTextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridLayout;

public class VentanaMenuN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txInfo;
	List<LibroDTO> books;
	protected static final Logger logger = LogManager.getLogger();
	DefaultTableModel modelAlquiler = new DefaultTableModel(new Object[] { /* "Id", */ "Nombre", "Descripcion", "Precio" }, 0) {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	JTable tablaAlquiler = new JTable(modelAlquiler);
	DefaultTableModel modelComprar = new DefaultTableModel(
			new Object[] { /* "Id", */ "Nombre", "Descripcion", "Precio" }, 0) {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	JTable tablaCompra = new JTable(modelComprar);

	public VentanaMenuN(String usuario, String contraseña) {

		setBounds(100, 100, 969, 416);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// IMAGENES
		ImageIcon imagenIcono = new ImageIcon("src/main/java/es/deusto/spq/client/utils/rent.png");
		ImageIcon imagenIconoAmp = new ImageIcon("src/main/java/es/deusto/spq/client/utils/rent.png");
		ImageIcon imagenIcono2 = new ImageIcon("src/main/java/es/deusto/spq/client/utils/compra.png");
		ImageIcon imagenIcono3 = new ImageIcon("src/main/java/es/deusto/spq/client/utils/devolver.png");

		// Obtener la imagen del ImageIcon
		Image imagenOriginal = imagenIcono.getImage();
		Image imagenOriginalAmp = imagenIconoAmp.getImage();
		Image imagenOriginal2 = imagenIcono2.getImage();
		Image imagenOriginal3 = imagenIcono3.getImage();

		// Obtener el tamaño del JLabel
		int anchoLabel = (int) 100;
		int anchoLabelMax = (int) 150;
		int altoLabel = (int) 100;
		int altoLabelMax = (int) 150;

		// Crear una nueva imagen escalada que cubra todo el espacio del JLabel
		Image imagenEscalada = imagenOriginal.getScaledInstance(anchoLabel, altoLabel, Image.SCALE_SMOOTH);
		Image imagenEscaladaMax = imagenOriginalAmp.getScaledInstance(anchoLabelMax, altoLabelMax, Image.SCALE_SMOOTH);
		Image imagenEscalada2 = imagenOriginal2.getScaledInstance(anchoLabel, altoLabel, Image.SCALE_SMOOTH);
		Image imagenEscalada3 = imagenOriginal3.getScaledInstance(anchoLabel, altoLabel, Image.SCALE_SMOOTH);

		// Crear un nuevo ImageIcon a partir de la imagen escalada
		ImageIcon imagenEscaladaIcono = new ImageIcon(imagenEscalada);
		ImageIcon imagenEscaladaIconoMax = new ImageIcon(imagenEscaladaMax);
		ImageIcon imagenEscaladaIcono2 = new ImageIcon(imagenEscalada2);
		ImageIcon imagenEscaladaIcono3 = new ImageIcon(imagenEscalada3);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Administrador");
		menuBar.add(mnMenu);

		JMenuItem mnItemAnyadir = new JMenuItem("Añadir libro nuevo");
		mnMenu.add(mnItemAnyadir);

		JMenuItem mnItemEliminar = new JMenuItem("Eliminar libro");
		mnMenu.add(mnItemEliminar);
		
		JMenu mnMenuTicket = new JMenu("Ticket");
		menuBar.add(mnMenuTicket);
		
		JMenuItem mntmItemGenerarT = new JMenuItem("Generar ticket");
		
		mnMenuTicket.add(mntmItemGenerarT);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel pnlPrincipal = new JPanel();
		contentPane.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("- Menu -");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pnlPrincipal.add(lblNewLabel, BorderLayout.NORTH);

		JPanel pnlSur = new JPanel();
		pnlSur.setBackground(new Color(224, 255, 255));
		pnlPrincipal.add(pnlSur, BorderLayout.CENTER);
		pnlSur.setLayout(
				new MigLayout("", "[][][][][][][][][][][][][][][][][][][grow]", "[][][grow][34.00][29.00][][]"));

		JLabel lblIconAlquiler = new JLabel();

		lblIconAlquiler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblIconCompra = new JLabel();
		lblIconCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JLabel lblIconDevolver = new JLabel();
		lblIconDevolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblIconAlquiler.setIcon(imagenEscaladaIcono);
		lblIconCompra.setIcon(imagenEscaladaIcono2);
		lblIconDevolver.setIcon(imagenEscaladaIcono3);
		pnlSur.add(lblIconAlquiler, "cell 3 2 1 3,alignx center,growy");
		pnlSur.add(lblIconCompra, "cell 9 2 1 3,alignx center,growy");
		pnlSur.add(lblIconDevolver, "cell 15 2 1 3,alignx center,growy");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		pnlSur.add(panel, "cell 18 0 1 7,grow");
		panel.setLayout(new BorderLayout(0, 0));

		txInfo = new JTextField();
		txInfo.setHorizontalAlignment(SwingConstants.CENTER);
		txInfo.setOpaque(true);
		txInfo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txInfo.setEditable(false);
		txInfo.setFont(new Font("Montserrat", Font.PLAIN, 14));
		txInfo.setText("Bienvenid@ de nuevo, " + usuario);
		panel.add(txInfo, BorderLayout.NORTH);
		txInfo.setColumns(10);

		JPanel pnlPanelSur = new JPanel();
		panel.add(pnlPanelSur, BorderLayout.CENTER);
		pnlPanelSur.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel lblAlquiler = new JLabel("Alquiler");
		lblAlquiler.setFont(new Font("Montserrat", Font.PLAIN, 20));

		pnlSur.add(lblAlquiler, "cell 3 6,alignx center,growy");

		JLabel lblCompra = new JLabel("Compra");
		lblCompra.setFont(new Font("Montserrat", Font.PLAIN, 20));

		pnlSur.add(lblCompra, "cell 9 6,alignx center,growy");

		JLabel lblDevolver = new JLabel("Devolver");
		lblDevolver.setFont(new Font("Montserrat", Font.PLAIN, 20));

		pnlSur.add(lblDevolver, "cell 15 6,alignx center,growy");

		pnlPanelSur.add(new JScrollPane(tablaAlquiler));
		pnlPanelSur.add(new JScrollPane(tablaCompra));
		tablaAlquiler.getTableHeader().setResizingAllowed(false);

		lblIconAlquiler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(usuario, contraseña, "alquiler");
				dispose();
			}
		});

		lblIconCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(usuario, contraseña, "compra");
				dispose();

			}
		});
		
		lblIconDevolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ExampleClient eC = new ExampleClient("localhost", "8080");
				LibroDTO result = null;
				
				int[] libros = tablaAlquiler.getSelectedRows();
				
				if(libros.length!=0) {
					for (int i = 0; i < libros.length; i++) {
						result = books.get(i);
						
						eC.DevolverLibro(books.get(libros[i]).getNombre(),usuario);
						//eC.actualizarLibroCommprado(books.get(libros[i]).getId(), books.get(libros[i]).getNombre(), books.get(libros[i]).getDescripccion(), result.getPrecio(),books.get(libros[i]).getTipo(), usuario);
						eC.actualizarLibroDevueto(books.get(libros[i]).getId());

					}	
					for (int i = libros.length-1; i>=0 ; i--) {
						modelAlquiler.removeRow(libros[i]);
					}
								
					JOptionPane.showMessageDialog(null, "Libro devuelto con exito ", "Devolución realizada", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione un libro para devolver ", "Devolución Erronea", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});
		
		
		mnItemAnyadir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String title = "";
				while (title == null || title.isEmpty()) {
					title = JOptionPane.showInputDialog(null, "Introduce el título del libro:");
					if (title == null || title.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debes introducir un título válido", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				String descripcion = "";
				while (descripcion == null || descripcion.isEmpty()) {
					descripcion = JOptionPane.showInputDialog(null, "Introduce la descripción del libro:");
					if (descripcion == null || descripcion.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debes introducir una descripción válida", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					}
				}

				Float precio = null;
				while (precio == null) {
					String precioString = JOptionPane.showInputDialog(null, "Introduce el precio del libro:");
					if (precioString == null || precioString.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Debes introducir un precio válido", "Advertencia",
								JOptionPane.WARNING_MESSAGE);
					} else {
						try {
							precio = Float.parseFloat(precioString);
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Debes introducir un precio válido", "Advertencia",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}

				String[] opciones = { "Alquilar", "Comprar" };

				while (true) {
					int opcion = JOptionPane.showOptionDialog(null, "¿Desea alquilarlo o comprarlo?", "Opciones",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
							new String[] { "Alquilar", "Comprar" }, null);

					if (opcion == JOptionPane.YES_OPTION) {
						System.out.println("Alquilando");
						System.out.println(opcion);
						LibroDTO nuevoLibro = new LibroDTO(title, descripcion, precio, "alquiler");
						ClientController.getInstance().adminSaveBook(nuevoLibro);
						logger.info("LIBRO: " + nuevoLibro + "ALQUILADO");

						break;
					} else if (opcion == JOptionPane.NO_OPTION) {
						System.out.println("Comprando");
						System.out.println(opcion);
						LibroDTO nuevoLibro = new LibroDTO(title, descripcion, precio, "compra");
						System.out.println(nuevoLibro);
						ClientController.getInstance().adminSaveBook(nuevoLibro);
						logger.info("LIBRO: " + nuevoLibro + " COMPRADO");

						break;
					} else if (opcion == JOptionPane.CLOSED_OPTION) {
						System.out.println(opcion);
						JOptionPane.showMessageDialog(null, "Debe seleccionar una opción.");
						logger.warn("OPCION SELECIONADA NO VALIDA");
					}

				}

			}
		});

		mnItemEliminar.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {

			        SwingUtilities.invokeLater(new Runnable() {
			            public void run() {
			                BookSelectionDialog dialog = new BookSelectionDialog(null);
			                dialog.setVisible(true);

			                String selectedBook = dialog.getSelectedBook();
			                if (selectedBook != null) {
			                    // Realizar la eliminación del libro aquí
			                    System.out.println("Libro seleccionado: " + selectedBook);
			                } else {
			                    System.out.println("No se seleccionó ningún libro.");
			                }
			            }
			        });
			    }
		});
		
		mntmItemGenerarT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					generarTicket(tablaCompra);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		cargarDatosCompra(usuario);
		cargarDatosAlquilar(usuario);
		
		
	}
	
	
	

	private void cargarDatosAlquilar(String usuario) {
		// TODO Auto-generated method stub
		ExampleClient eC = new ExampleClient("localhost", "8080");
		books = eC.getBooksUsuarioUsuario(usuario);
		if (books != null) {
			for (LibroDTO libro : books) {
				String[] fila = { /* String.valueOf(libro.getId()), */ libro.getNombre(), libro.getDescripccion(),
						String.valueOf(libro.getPrecio()) };
				modelAlquiler.addRow(fila);
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("VACIO");
		}
	}


	private void cargarDatosCompra(String usuario) {
		// TODO Auto-generated method stub
		ExampleClient eC = new ExampleClient("localhost", "8080");
		books = eC.getBooksCompraUsuario(usuario);
		if (books != null) {
			for (LibroDTO libro : books) {
				String[] fila = { /* String.valueOf(libro.getId()), */ libro.getNombre(), libro.getDescripccion(),
						String.valueOf(libro.getPrecio()) };
				modelComprar.addRow(fila);
				System.out.println(libro.toString());
			}
		} else {
			System.out.println("VACIO");
		}

	}
	
	public void generarTicket(JTable tabla) throws IOException {
	    FileWriter fw = new FileWriter("ticket.txt");
	    PrintWriter pw = new PrintWriter(fw);

	
	    pw.println("------------- LUDOFUN -------------");
	    pw.println("\nFecha impresion del ticket: " + LocalDate.now());
	    pw.println("Hora impresion del ticket: " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	    pw.println("---------------------------------------");
	    pw.println("Nombre \t\t           \t\tPrecio");

	 
	    for (int i = 0; i < tabla.getRowCount(); i++) {
	        String nombre = tabla.getValueAt(i, 0).toString();
	        String precio = tabla.getValueAt(i, 2).toString();

	        pw.printf("%-20s .......... %10s%n", nombre, precio);
	    }

	    
	
	    //calcular total de dinero gastado
	  
	    pw.println("--------------------------------\n");
	    pw.println("TOTAL: " + calcularTotal(tabla) + "€\n");
	    pw.printf("Gracias por su visita!\n");

	   
	    pw.close();
	    fw.close();
	    JOptionPane.showMessageDialog(null, "Ticket generado", "Ticket", JOptionPane.INFORMATION_MESSAGE);

		
	}

	private double calcularTotal(JTable tabla) {
	    double total = 0;
	    for (int i = 0; i < tabla.getRowCount(); i++) {
	        double precio = Double.parseDouble(tabla.getValueAt(i, 2).toString());
	        total += precio;
	    }
	    return total;
	}

}
