package MainClass;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Constructor;

import javax.swing.JLabel;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private static Constructor cc;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String usuario = cc.getNombre();
					String contraseña = cc.getContraseña();
					Inicio frame = new Inicio(usuario, contraseña);
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
	public Inicio(String user, String passwd) {
		String usuario = user;
		String pass = passwd;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a la página de inicio");
		lblNewLabel.setBounds(127, 105, 191, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lbl_username = new JLabel("");
		lbl_username.setText(usuario);
		lbl_username.setBounds(177, 173, 46, 14);
		getContentPane().add(lbl_username);
	}

}
