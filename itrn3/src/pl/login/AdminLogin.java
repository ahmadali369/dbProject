package pl.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.Interfaces.IBLLFacade;
import pl.adminPanals.AdminLandingPage;
import transerferObjects.UserTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNametextField;
	private JTextField passwordtextField;
	private IBLLFacade bllFacade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminLogin frame = new AdminLogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AdminLogin(IBLLFacade ibllFacade) {
		bllFacade = ibllFacade; 
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(42, 25, 111, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(42, 77, 79, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(42, 115, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		userNametextField = new JTextField();
		userNametextField.setBounds(133, 72, 188, 26);
		contentPane.add(userNametextField);
		userNametextField.setColumns(10);
		
		passwordtextField = new JTextField();
		passwordtextField.setBounds(133, 110, 188, 26);
		contentPane.add(passwordtextField);
		passwordtextField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				UserTO userTO = new UserTO(); 
				userTO.setUserType(userNametextField.getText());
				userTO.setPassword(passwordtextField.getText());
				
				bllFacade.loginUser(userTO); 
				
				
				AdminLandingPage frame = new AdminLandingPage(bllFacade);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(167, 160, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminSignUP frame = new AdminSignUP(bllFacade);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(167, 229, 117, 29);
		contentPane.add(btnNewButton_1);
	}

}
