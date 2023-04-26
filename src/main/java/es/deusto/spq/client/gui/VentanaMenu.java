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
import net.miginfocom.swing.MigLayout;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	public VentanaMenu(String usuario, String contraseña) {

		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("LudoFun-Principal");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 862, 411);
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
		panelCentral.setLayout(new MigLayout("", "[100px][][89px][89px]", "[][216.00px][15px]"));

		JButton btnAlquilar = new JButton();
		btnAlquilar.setText("Boton alquilar");
		//btnAlquilar.setIcon(new ImageIcon(VentanaMenu.class.getResource("../utils/rent.png"))); // me
																													// da
																													// null
																													// pointer
																													// porque?

		btnAlquilar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlquilar.setBorder(null);
		btnAlquilar.setBackground(new Color(255, 32, 249));

		btnAlquilar.repaint();

		panelCentral.add(btnAlquilar, "cell 0 1,alignx center,aligny center");

		// FUNCIONALIDAD DE LOS BOTONES

		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(usuario, contraseña,"alquiler");

			}
		});

		JButton btnCompra = new JButton();
		//btnCompra.setIcon(new ImageIcon(VentanaMenu.class.getResource("../utils/compra.png")));

		btnCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCompra.setBorder(null);
		btnCompra.setBackground(new Color(224, 255, 255));

		panelCentral.add(btnCompra, "cell 2 1,grow");

		JButton btnDevolver = new JButton();
		//btnDevolver.setIcon(new ImageIcon(VentanaMenu.class.getResource("../utils/devolver.png")));
		btnDevolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDevolver.setBorder(null);
		btnDevolver.setBackground(new Color(224, 255, 255));
		btnDevolver.setText("Boton devolver");
		panelCentral.add(btnDevolver, "cell 3 1,growx,aligny top");

		JLabel lblAlquiler = new JLabel("ALQUILAR");
		lblAlquiler.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCentral.add(lblAlquiler, "cell 0 2,alignx center,growy");

		JLabel lblComprar = new JLabel("COMPRAR");
		lblComprar.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCentral.add(lblComprar, "cell 2 2,alignx left,growy");

		JLabel lblDevolver = new JLabel("DEVOLVER");
		lblDevolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelCentral.add(lblDevolver, "cell 3 2,alignx left,growy");

		btnCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(usuario, contraseña,"compra");
			}
		});

	}
}
