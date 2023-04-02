package es.deusto.spq.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.pojo.UserData;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
	String usuario, contraseña;
	JPanel contentPane;
	JPanel topLeftPanel,topRightPanel, leftPanel, rightPanel;


	public VentanaPrincipal(String usuario, String contraseña) {
		setResizable(false);
		setTitle("LudoFun");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1160, 761);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2,2));
		setContentPane(contentPane);
		
		topLeftPanel = new JPanel();
		topLeftPanel.setBackground(Color.cyan);
		contentPane.add(topLeftPanel);
		
		topRightPanel = new JPanel();
		topRightPanel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(topRightPanel);
		
		leftPanel = new JPanel();
		leftPanel.setBackground(Color.PINK);
		contentPane.add(leftPanel);
		
		rightPanel = new JPanel();
		rightPanel.setBackground(Color.YELLOW);
		contentPane.add(rightPanel);
	
	}
}
