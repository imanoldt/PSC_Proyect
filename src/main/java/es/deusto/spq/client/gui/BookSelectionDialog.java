package es.deusto.spq.client.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import es.deusto.spq.client.ExampleClient;
import es.deusto.spq.pojo.LibroDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BookSelectionDialog extends JDialog {
    private JTable table;
    private JButton bntAceptar;
	List<LibroDTO> books;
    private DefaultTableModel tableModel;

    private String selectedBook;

    public BookSelectionDialog(Frame parent) {
        super(parent, "Seleccionar libro", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(650, 490);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Seleccion de Libros");

        tableModel = new DefaultTableModel(new Object[] {"Nombre", "Descripcion", "Precio"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

      
        bntAceptar = new JButton("Aceptar");
        bntAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

				ExampleClient eC = new ExampleClient("localhost", "8080");
				LibroDTO result = null;
				
				int[] libros = table.getSelectedRows();
				
				for (int i = 0; i < libros.length; i++) {
					result = books.get(i);
					eC.borrarLibro(books.get(libros[i]).getId());
					
				}	
				for (int i = libros.length-1; i>=0 ; i--) {
					tableModel.removeRow(libros[i]);
				}
							
				JOptionPane.showMessageDialog(null, "Libro borrado con exito", "Borrado realizado", JOptionPane.INFORMATION_MESSAGE);

                //dispose();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(bntAceptar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        cargarDatos();
    }

    public String getSelectedBook() {
        return selectedBook;
    }
    
    private void cargarDatos() {
        ExampleClient eC = new ExampleClient("localhost", "8080");
        books = eC.getAllBooks();
        if (books != null) {
            for (LibroDTO libro : books) {
                String[] fila = { libro.getNombre(), libro.getDescripccion(), String.valueOf(libro.getPrecio()) };
                tableModel.addRow(fila);
                System.out.println(libro.toString());
            }
        } else {
            System.out.println("VACIO");
        }
    }
}
