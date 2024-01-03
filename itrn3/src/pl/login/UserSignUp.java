package pl.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.Interfaces.IBLLFacade;
import pl.userPanals.UserLandingPage;
import transerferObjects.ActivityTO;
import transerferObjects.UserTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserSignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNametextField;
	private JTextField emailtextField;
	private JTextField lastNametextField;
	private JTextField addresstextField;
	private JTextField passwordtextField;
	private JTextField rePasswordtextField;
	private IBLLFacade bllFacade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserSignUp frame = new UserSignUp();
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
	public UserSignUp(IBLLFacade bIbllFacade) {
		bllFacade = bIbllFacade; 
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 622, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User SignUp");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 24, 117, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(33, 84, 77, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(33, 126, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		firstNametextField = new JTextField();
		firstNametextField.setBounds(122, 79, 163, 26);
		contentPane.add(firstNametextField);
		firstNametextField.setColumns(10);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(120, 121, 165, 26);
		contentPane.add(emailtextField);
		emailtextField.setColumns(10);
		
		lastNametextField = new JTextField();
		lastNametextField.setColumns(10);
		lastNametextField.setBounds(423, 79, 163, 26);
		contentPane.add(lastNametextField);
		
		addresstextField = new JTextField();
		addresstextField.setColumns(10);
		addresstextField.setBounds(423, 121, 163, 26);
		contentPane.add(addresstextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setBounds(319, 84, 73, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Home Address");
		lblNewLabel_2_1.setBounds(319, 126, 92, 16);
		contentPane.add(lblNewLabel_2_1);
		
		passwordtextField = new JTextField();
		passwordtextField.setColumns(10);
		passwordtextField.setBounds(120, 166, 165, 26);
		contentPane.add(passwordtextField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Password");
		lblNewLabel_2_2.setBounds(33, 171, 61, 16);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("re-Password");
		lblNewLabel_2_1_1.setBounds(319, 171, 92, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		rePasswordtextField = new JTextField();
		rePasswordtextField.setColumns(10);
		rePasswordtextField.setBounds(423, 166, 163, 26);
		contentPane.add(rePasswordtextField);
		
		JButton adminSignupButton = new JButton("SignUp");
		adminSignupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//
//				ActivityTO activityTO = new ActivityTO(); 
//				activityTO.setUserid(bllFacade.getUserid());
//				activityTO.setActivityString("user signup"); 
//				bllFacade.storeUserActivity(activityTO);
				
				
				UserTO userTO = new UserTO(); 
				userTO.setFname(firstNametextField.getText());
				userTO.setLname(lastNametextField.getText());
				userTO.setPassword(passwordtextField.getText());
				userTO.setAddress(addresstextField.getText());
				userTO.setEmail(emailtextField.getText());
				
				bllFacade.addNewUser(userTO); 
				
				
				UserLandingPage frame = new UserLandingPage(bllFacade);
				frame.setVisible(true);
			}
		});
		adminSignupButton.setBounds(264, 239, 117, 29);
		contentPane.add(adminSignupButton);
	}

}
