package es.deusto.spq.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	public VentanaMenu(String usuario, String contraseña) {

		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("LudoFun-Principal");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 648, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelNorte = new JPanel();
		panelNorte.setBorder(new EmptyBorder(1, 1, 1, 1));
		panelNorte.setBackground(new Color(255, 160, 122));
		contentPane.add(panelNorte, BorderLayout.NORTH);

		JLabel lblTitulo = new JLabel("LudoFun");
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		panelNorte.add(lblTitulo);

		JLabel lblNewLabel_1 = new JLabel();
		panelNorte.add(lblNewLabel_1);

		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		panelCentral.setBackground(new Color(224, 255, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JButton btnAlquilar = new JButton();

		btnAlquilar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlquilar.setText("PRUEBA");
		btnAlquilar.setBorder(null);
		btnAlquilar.setBackground(new Color(255, 32, 249));
		btnAlquilar.setBounds(88, 33, 89, 75);

		btnAlquilar.repaint();

		panelCentral.add(btnAlquilar);

		JButton btnCompra = new JButton();

		btnCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCompra.setText("Prueba");
		btnCompra.setBorder(null);
		btnCompra.setBackground(new Color(224, 255, 255));
		btnCompra.setBounds(258, 33, 89, 75);

		panelCentral.add(btnCompra);

		JButton btnDevolver = new JButton();
		btnDevolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDevolver.setText("Prueba");
		btnDevolver.setBorder(null);
		btnDevolver.setBackground(new Color(224, 255, 255));
		btnDevolver.setBounds(436, 33, 89, 75);

		panelCentral.add(btnDevolver);

		JLabel lblAlquiler = new JLabel("ALQUILAR");
		lblAlquiler.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlquiler.setBounds(98, 129, 74, 14);
		panelCentral.add(lblAlquiler);

		JLabel lblComprar = new JLabel("COMPRAR");
		lblComprar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComprar.setBounds(258, 130, 74, 14);
		panelCentral.add(lblComprar);

		JLabel lblDevolver = new JLabel("DEVOLVER");
		lblDevolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevolver.setBounds(436, 130, 74, 14);
		panelCentral.add(lblDevolver);

		// FUNCIONALIDAD DE LOS BOTONES

		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(usuario, contraseña);

			}
		});

		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(usuario, contraseña);
			}
		});

	}
}
