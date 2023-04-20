package es.deusto.spq.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

public class VentanaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenu frame = new VentanaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMenu() {
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
		lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 23));
		panelNorte.add(lblTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panelNorte.add(lblNewLabel_1);
		
		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		panelCentral.setBackground(new Color(224, 255, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		
		JButton btnCompra = new JButton();
		btnCompra.setBorder(null);
		btnCompra.setBackground(new Color(224, 255, 255));
		btnCompra.setBounds(258, 33, 89, 75);
		
		ImageIcon icon1=new ImageIcon(VentanaMenu.class.getResource("/es/deusto/spq/client/utils/compra.png"));
		int anchoc=btnCompra.getWidth();
		int altoc=btnCompra.getHeight();
		ImageIcon icono1=new ImageIcon(icon1.getImage().getScaledInstance(anchoc, altoc, Image.SCALE_DEFAULT));
		
		btnCompra.setIcon(icono1);
		panelCentral.add(btnCompra);
		
		JButton btnAlquilar = new JButton();
		btnAlquilar.setBorder(null);
		btnAlquilar.setBackground(new Color(224, 255, 255));
		btnAlquilar.setBounds(88, 33, 89, 75);
		ImageIcon icon=new ImageIcon(VentanaMenu.class.getResource("/es/deusto/spq/client/utils/rent.png"));
		int ancho=btnAlquilar.getWidth();
		int alto=btnAlquilar.getHeight();
		ImageIcon icono=new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		btnAlquilar.setIcon(icono);
		btnAlquilar.repaint();
		
		panelCentral.add(btnAlquilar);
		
		JButton btnDevolver = new JButton();
		btnDevolver.setBorder(null);
		btnDevolver.setBackground(new Color(224, 255, 255));
		btnDevolver.setBounds(436, 33, 89, 75);
		
		ImageIcon icon3=new ImageIcon(VentanaMenu.class.getResource("/es/deusto/spq/client/utils/devolver.png"));
		int anchod=btnCompra.getWidth();
		int altod=btnCompra.getHeight();
		ImageIcon icono3=new ImageIcon(icon3.getImage().getScaledInstance(anchod, altod, Image.SCALE_DEFAULT));
		
		btnDevolver.setIcon(icono3);
		panelCentral.add(btnDevolver);
		
		JLabel lblNewLabel = new JLabel("ALQUILAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(98, 129, 74, 14);
		panelCentral.add(lblNewLabel);
		
		JLabel lblComprar = new JLabel("COMPRAR");
		lblComprar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComprar.setBounds(258, 130, 74, 14);
		panelCentral.add(lblComprar);
		
		JLabel lblDevolver = new JLabel("DEVOLVER");
		lblDevolver.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDevolver.setBounds(436, 130, 74, 14);
		panelCentral.add(lblDevolver);
	}
}
