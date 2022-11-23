package MainClass;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.Conexion;
import Controlador.Constructor;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class JavaLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_usuario;
	private JTextField txt_user;
	private JPasswordField txt_pass;
	private JLabel lbl_mensajeError;
	private Constructor c;
	private String nameUser = null;
	private String passUser = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaLogin frame = new JavaLogin();
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
	public JavaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 311);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(193, 232, 255));
		contentPane.setForeground(new Color(193, 232, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setFont(new Font("Arial Black", Font.BOLD, 16));
		lbl_usuario.setForeground(new Color(0, 0, 0));
		lbl_usuario.setBounds(51, 63, 94, 34);
		contentPane.add(lbl_usuario);
		
		JLabel lbl_pass = new JLabel("Contraseña:");
		lbl_pass.setForeground(Color.BLACK);
		lbl_pass.setFont(new Font("Arial Black", Font.BOLD, 16));
		lbl_pass.setBounds(51, 108, 127, 34);
		contentPane.add(lbl_pass);
		
		txt_user = new JTextField();
		txt_user.setBounds(188, 66, 229, 34);
		contentPane.add(txt_user);
		txt_user.setColumns(10);
		
		/* Configuracion Login */
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulta();
				String nombre = txt_user.getText();
				String pass = txt_pass.getText();
				c = new Constructor(nombre,pass);
				
				if(nombre.isEmpty() || pass.isEmpty()) {
					
					lbl_mensajeError.setText("Debes introducir un usuario y una contraseña");
					lbl_mensajeError.enable();
				}else {
					if(nombre.equals(nameUser) && pass.equals(passUser)) {
						Inicio inicio = new Inicio(nombre,pass);
						inicio.setVisible(true);
						dispose();
					}else {
						lbl_mensajeError.setText("Usuario o contraseña incorrectos");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnNewButton.setBounds(218, 203, 113, 34);
		contentPane.add(btnNewButton);
		
		txt_pass = new JPasswordField();
		txt_pass.setBounds(188, 111, 229, 34);
		contentPane.add(txt_pass);
		
		lbl_mensajeError = new JLabel("");
		lbl_mensajeError.setForeground(new Color(220, 20, 60));
		lbl_mensajeError.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_mensajeError.setBounds(188, 156, 358, 23);
		contentPane.add(lbl_mensajeError);
	}
	
	public void consulta() {
		Connection connect = null;
		Conexion cn = new Conexion();
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			connect = cn.conectar();
			stm = connect.createStatement();
			rs = stm.executeQuery("SELECT * FROM logueo");
			
			while(rs.next()) {
				rs.getString(1);
				rs.getString(2);
				
				if(rs.getString(1).equals("test") && rs.getString(2).equals("test")){
					nameUser = rs.getString(1);
					passUser = rs.getString(2);
						}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
