package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
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


	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
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
		panel_1.setLayout(new MigLayout("", "[191.00][grow][][][grow][grow][grow][grow][grow][grow][][grow][][][][][][grow][][][]", "[][][][][][][][grow][][][][][][][][][][][][][][][][]"));
		
		lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Montserrat", Font.BOLD, 25));
		panel_1.add(lblRegistro, "cell 0 0 16 1,alignx center,aligny center");
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblNombre, "flowx,cell 0 2,grow");
		
		lblContrasenya = new JLabel("Contraseña:");
		lblContrasenya.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblContrasenya, "flowx,cell 0 5");
		
		btnRegistrarse = new JButton("Registrarme");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setOpaque(true);
		btnRegistrarse.setBackground(new Color(0, 0, 0));
		btnRegistrarse.setFont(new Font("Montserrat", Font.BOLD, 18));

		panel_1.add(btnRegistrarse, "cell 0 19 20 4,grow");
		
		textFieldNombre = new JTextField();
		panel_1.add(textFieldNombre, "cell 0 2,growx");
		textFieldNombre.setColumns(10);
		
		textFieldContrasenia = new JTextField();
		panel_1.add(textFieldContrasenia, "cell 0 5,grow");
		textFieldContrasenia.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/Disenyo_sin_titulo.png"));
		panel.add(lblNewLabel);
		
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User us = new User(textFieldNombre.getText(), textFieldContrasenia.getText());
//				Usuario u = new Usuario(textFieldNombre.getText(), textFieldContrasenia.getText());
				ExampleClient eC = new ExampleClient("localhost", "8080");
				eC.registerUser(us.getLogin(), us.getPassword());
				dispose();
				VentanaLoginN vL = new VentanaLoginN();
			}
		});
		setVisible(true);
	}
}
