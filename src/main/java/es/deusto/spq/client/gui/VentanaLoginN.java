package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import remote.ServiceLocator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import controllers.LoginController;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class VentanaLoginN extends JFrame {
	private LoginController controller;

	private JPanel contentPane, pnlPrincipal, pnlIzquierda, pnlDerechaa;

	private JLabel lblIniciarSesion, lblUsuario, lblIconoUsu, lblContraseya;

	private JTextField txtUsuario;
	private JPasswordField passContraseya;
	private JButton btnIniciarSession, btnRegistrarse, btnSalir;
	private JLabel lblRegistrate;
	private JLabel lblNewLabel_3;
	private JLabel lblStravaCopyright;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public VentanaLoginN(ServiceLocator service) {
		controller = new LoginController(service);
		setResizable(false);
		setTitle("LogIn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnlPrincipal = new JPanel();
		contentPane.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(new GridLayout(0, 2, 0, 0));

		pnlIzquierda = new JPanel();
		pnlIzquierda.setBackground(new Color(255, 140, 0));
		pnlPrincipal.add(pnlIzquierda);
		pnlIzquierda.setLayout(new MigLayout("", "[grow]",
				"[59.00][][46.00][36.00,top][][3.00][41.00][][fill][46.00][47.00,grow][][][][][][][][][][][][]"));

		lblIniciarSesion = new JLabel("Bienvenido de nuevo");
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setBorder(null);
		lblIniciarSesion.setFont(new Font("Montserrat", Font.BOLD, 30));
		pnlIzquierda.add(lblIniciarSesion, "cell 0 0,alignx left,aligny center");

		lblIconoUsu = new JLabel("");
		lblIconoUsu.setIcon(new ImageIcon("img/basketc.png"));
		pnlIzquierda.add(lblIconoUsu, "cell 0 2,alignx center,aligny center");

		lblUsuario = new JLabel("Correo:");
		lblUsuario.setFont(new Font("Montserrat", Font.PLAIN, 16));
		pnlIzquierda.add(lblUsuario, "cell 0 3,alignx left,aligny center");

		txtUsuario = new JTextField();
		pnlIzquierda.add(txtUsuario, "cell 0 4,growx,aligny center");
		txtUsuario.setColumns(10);

		lblContraseya = new JLabel("Contraseña:");
		lblContraseya.setFont(new Font("Montserrat", Font.PLAIN, 16));
		pnlIzquierda.add(lblContraseya, "cell 0 6,alignx left,aligny center");

		passContraseya = new JPasswordField();
		pnlIzquierda.add(passContraseya, "cell 0 7,growx");

		pnlDerechaa = new JPanel();
		pnlDerechaa.setBorder(new MatteBorder(0, 3, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDerechaa.setBackground(UIManager.getColor("Button.background"));
		pnlPrincipal.add(pnlDerechaa);
		pnlDerechaa.setLayout(new BorderLayout(0, 0));

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("img/Disenyo_sin_titulo.png"));
		pnlDerechaa.add(lblNewLabel_3, BorderLayout.CENTER);

		lblStravaCopyright = new JLabel("STRAVA 2022 CopyRight © Todos los derechos reservados a LosMinitos");
		lblStravaCopyright.setBackground(Color.WHITE);
		lblStravaCopyright.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDerechaa.add(lblStravaCopyright, BorderLayout.SOUTH);

		// Imagenes
		// Imagen Salir boton login

		ImageIcon imgIcon = new ImageIcon("img/xApagada.png");
		Image imgEscalada = imgIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		ImageIcon imgIconEnc = new ImageIcon("img/xEncendida.png");
		Image imgEscaladaEnc = imgIconEnc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		btnSalir = new JButton();
		btnSalir.setOpaque(false);
		btnIniciarSession = new JButton("Iniciar Sesion");
		btnIniciarSession.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(controller.login(txtUsuario.getText(), passContraseya.getText())) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								VentanaMain frame = new VentanaMain(controller);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					System.out.println("# Error during login!");
				}
			}
		});
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaRegistro frame = new VentanaRegistro(controller);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnRegistrarse.setFont(new Font("Montserrat", Font.PLAIN, 16));
		btnRegistrarse.setPreferredSize(new Dimension(120, 50));
		pnlIzquierda.add(btnRegistrarse, "flowx,cell 0 14,alignx center,aligny center");
		btnIniciarSession.setFont(new Font("Montserrat", Font.PLAIN, 16));
		btnIniciarSession.setPreferredSize(new Dimension(5000, 50));
		pnlIzquierda.add(btnIniciarSession, "cell 0 14,alignx center,aligny center");
		btnSalir.setText(" Salir");
		btnSalir.setRolloverIcon(new ImageIcon("img/xEncendida.png"));
		btnSalir.setFont(new Font("Montserrat", Font.PLAIN, 16));
		btnSalir.setPreferredSize(new Dimension(5000, 20));
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		pnlIzquierda.add(btnSalir, "cell 0 15,alignx center,aligny center");
		btnSalir.setIcon(new ImageIcon(imgEscalada));
		btnSalir.setRolloverIcon(new ImageIcon(imgEscaladaEnc));

		lblRegistrate = new JLabel("¡¡ Registrate !!");
		lblRegistrate.setFont(new Font("Montserrat", Font.PLAIN, 20));
		pnlIzquierda.add(lblRegistrate, "cell 0 16,alignx center,aligny center");

		btnSalir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnSalir.setBackground(new Color(0, 0, 0));
			}
		});

		// Hilos
		Runnable r1 = new Runnable() {

			@Override
			public void run() {
				while (true) {
					lblRegistrate.setForeground(new Color(249, 194, 4));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lblRegistrate.setForeground(Color.BLACK);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		
		addWindowListener(new WindowAdapter() {
	
			@Override
			public void windowClosed(WindowEvent e) {
				t1.stop();
			}
	
		});
	}
}
