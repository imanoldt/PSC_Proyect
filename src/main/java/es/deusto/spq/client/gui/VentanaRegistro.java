package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import es.deusto.spq.pojo.*;
import es.deusto.spq.server.jdo.User;
import es.deusto.spq.client.*;
import java.awt.Cursor;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblRegistro;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JButton btnRegistrarse;
	private JLabel lblContrasenya;
	private JTextField textFieldContrasenia;
	private JButton btnNewButton;

	public VentanaRegistro() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 239, 213));
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[191.00][grow][][grow][grow][grow][grow][grow][grow][][grow][][][]",
				"[][][40.00][][][53.00][][grow][][][][][][][][][][][][][][][][]"));

		lblRegistro = new JLabel("Registrate");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Montserrat", Font.BOLD, 25));
		panel_1.add(lblRegistro, "cell 0 0 13 3,alignx center,aligny center");

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Montserrat", Font.PLAIN, 20));
		panel_1.add(lblNombre, "flowx,cell 0 3 1 4,alignx center,growy");

		textFieldNombre = new JTextField();
		panel_1.add(textFieldNombre, "cell 2 5 11 1,grow");
		textFieldNombre.setColumns(10);

		lblContrasenya = new JLabel("Contraseña:");
		lblContrasenya.setFont(new Font("Montserrat", Font.PLAIN, 20));
		panel_1.add(lblContrasenya, "flowx,cell 0 7,alignx center,growy");

		textFieldContrasenia = new JTextField();
		panel_1.add(textFieldContrasenia, "cell 2 7 11 1,grow");
		textFieldContrasenia.setColumns(10);

		btnRegistrarse = new JButton("Registrarme");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setOpaque(true);
		btnRegistrarse.setBackground(Color.DARK_GRAY);
		btnRegistrarse.setFont(new Font("Montserrat", Font.BOLD, 18));

		panel_1.add(btnRegistrarse, "cell 0 14 4 5,grow");

		btnNewButton = new JButton("Exit");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_1.add(btnNewButton, "cell 4 15 9 4,grow");

		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNombre.getText().equals("") && textFieldContrasenia.getText().equals("")) {
					
					     JOptionPane.showMessageDialog(null, "Complete todos los campos",
				      "ERROR!", JOptionPane.ERROR_MESSAGE);


				} else {
//					btnRegistrarse.setEnabled(true);

					User us = new User(textFieldNombre.getText(), textFieldContrasenia.getText());
//				Usuario u = new Usuario(textFieldNombre.getText(), textFieldContrasenia.getText());
					ExampleClient eC = new ExampleClient("localhost", "8080");
					eC.registerUser(us.getLogin(), us.getPassword());
					dispose();
					VentanaLoginN vL = new VentanaLoginN();
				}
			}
		});

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				"/Users/imanoldt/Documents/GitHub/PSC_Proyect/src/main/resources/es/deusto/images/barro.jpg"));
		panel.add(lblNewLabel);
		setVisible(true);
	}
}
