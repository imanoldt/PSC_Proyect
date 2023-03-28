package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.LoginController;

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
import datechooser.beans.DateChooserPanel;
import domain.TipoProvedor;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaRegistro extends JFrame {

	private LoginController controller;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblRegistro;
	private JLabel lblNombre;
	private JLabel lblEmail;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblFecha;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JTextField textField_2;
	private JTextField textField_3;
	private DateChooserPanel dateChooserPanel;
	private JButton btnRegistrarse;
	private JLabel lblFcardiacaMax;
	private JTextField txtFcardiacaMax;
	private JComboBox comboBox;
	private JLabel lblProvedor;
	private JTextField textField_4;
	private JLabel lblNewLabel_1;
	private JLabel lblContrasenya;
	private JTextField textField_5;


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
	public VentanaRegistro(LoginController cont) {
		controller = cont;
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
		panel_1.setLayout(new MigLayout("", "[191.00][grow][][][grow][grow][grow][grow][grow][grow][][grow][][][][][][grow][][][]", "[][][][][][][grow][][][][][][][][][][][][][][][][]"));
		
		lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Montserrat", Font.BOLD, 25));
		panel_1.add(lblRegistro, "cell 0 0 16 1,alignx center,aligny center");
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblNombre, "flowx,cell 0 2,grow");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "cell 9 2 11 1,grow");
		textField_5.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblEmail, "cell 0 4,growx,aligny center");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 10 4 10 1,growx");
		textField_1.setColumns(10);
		
		lblFecha = new JLabel("Fecha de Nacimiento:\n");
		lblFecha.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblFecha, "cell 0 6");
		
		dateChooserPanel = new DateChooserPanel();
		panel_1.add(dateChooserPanel, "cell 6 6 14 1,grow");
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblPeso, "cell 0 8,grow");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 10 8 10 1,grow");
		textField_2.setColumns(10);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblAltura, "cell 0 10,grow");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 10 10 10 1,growx");
		textField_3.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Frecuencia Cardiaca Reps.");
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1, "cell 0 11");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "cell 10 11 10 1,grow");
		textField_4.setColumns(10);
		
		lblFcardiacaMax = new JLabel("Frecuencia Cardiaca Max.");
		lblFcardiacaMax.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblFcardiacaMax, "cell 0 12");
		
		txtFcardiacaMax = new JTextField();
		panel_1.add(txtFcardiacaMax, "cell 10 12 10 1,growx,aligny center");
		txtFcardiacaMax.setColumns(10);
		
		lblProvedor = new JLabel("Proveedor:");
		lblProvedor.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblProvedor, "cell 0 14");
		
		comboBox = new JComboBox();
		String[] s = new String[TipoProvedor.values().length];
		int i = 0;
		for(TipoProvedor t: TipoProvedor.values()) {
			s[i++] = t.toString();
		}
		comboBox.setModel(new DefaultComboBoxModel(s));
		panel_1.add(comboBox, "cell 9 14 11 1,grow");
		
		btnRegistrarse = new JButton("Registrarme");
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setOpaque(true);
		btnRegistrarse.setBackground(new Color(0, 0, 0));
		btnRegistrarse.setFont(new Font("Montserrat", Font.BOLD, 18));

		panel_1.add(btnRegistrarse, "cell 0 18 20 4,grow");
		
		textField = new JTextField();
		panel_1.add(textField, "flowx,cell 0 2 8 1,growx");
		textField.setColumns(10);
		
		lblContrasenya = new JLabel("Contraseña:");
		lblContrasenya.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblContrasenya, "cell 7 2");
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img/Disenyo_sin_titulo.png"));
		panel.add(lblNewLabel);
		
		
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.regist(textField.getText(), textField_5.getText(), textField_1.getText(), 
						dateChooserPanel.getSelectedDate().getTime(), 
						textField_2.getText(), textField_3.getText(), txtFcardiacaMax.getText(), 
						textField_4.getText(), comboBox.getSelectedIndex());
				dispose();
			}
		});

	}

}
