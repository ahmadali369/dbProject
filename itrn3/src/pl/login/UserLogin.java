package pl.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.Interfaces.IBLLFacade;
import pl.userPanals.UserLandingPage;
import transerferObjects.UserTO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userNametextField;
	private JTextField userPasswordtextField;
	private IBLLFacade bllFacade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserLogin frame = new UserLogin();
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
	public UserLogin(IBLLFacade bIbllFacade) {
		bllFacade = bIbllFacade; 
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userNametextField = new JTextField();
		userNametextField.setBounds(135, 65, 191, 26);
		contentPane.add(userNametextField);
		userNametextField.setColumns(10);
		
		userPasswordtextField = new JTextField();
		userPasswordtextField.setBounds(135, 103, 191, 26);
		contentPane.add(userPasswordtextField);
		userPasswordtextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(41, 70, 74, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(41, 108, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton userLoginButton = new JButton("Login");
		userLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				UserTO userTO = new UserTO(); 
				userTO.setEmail(userNametextField.getText());
				userTO.setPassword(userPasswordtextField.getText());
				
				bllFacade.loginUser(userTO); 
				
				
				UserLandingPage frame = new UserLandingPage(bllFacade);
				frame.setVisible(true);
			}
		});
		userLoginButton.setBounds(164, 155, 117, 29);
		contentPane.add(userLoginButton);
		
		JButton userSignupButton = new JButton("SignUp");
		userSignupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				UserSignUp frame = new UserSignUp(bllFacade);
				frame.setVisible(true);
			}
		});
		userSignupButton.setBounds(164, 229, 117, 29);
		contentPane.add(userSignupButton);
		
		JLabel lblNewLabel_2 = new JLabel("User Login");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(40, 19, 154, 16);
		contentPane.add(lblNewLabel_2);
	}

}
