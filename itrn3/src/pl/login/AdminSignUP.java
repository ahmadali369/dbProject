package pl.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.Interfaces.IBLLFacade;
import pl.adminPanals.AdminLandingPage;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSignUP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNametextField;
	private JTextField lastNametextField;
	private JTextField emailtextField;
	private JTextField adddresstextField;
	private JTextField passtextField;
	private JTextField rePasswordtextField;
	private IBLLFacade bllFacade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminSignUP frame = new AdminSignUP();
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
	public AdminSignUP(IBLLFacade bIbllFacade) {
		bllFacade = bIbllFacade; 
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 624, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin SignUp");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 26, 117, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(33, 78, 84, 16);
		contentPane.add(lblNewLabel_1);
		
		firstNametextField = new JTextField();
		firstNametextField.setBounds(122, 73, 156, 26);
		contentPane.add(firstNametextField);
		firstNametextField.setColumns(10);
		
		lastNametextField = new JTextField();
		lastNametextField.setColumns(10);
		lastNametextField.setBounds(423, 73, 156, 26);
		contentPane.add(lastNametextField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1.setBounds(334, 78, 77, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setBounds(33, 126, 61, 16);
		contentPane.add(lblNewLabel_1_2);
		
		emailtextField = new JTextField();
		emailtextField.setColumns(10);
		emailtextField.setBounds(122, 121, 156, 26);
		contentPane.add(emailtextField);
		
		adddresstextField = new JTextField();
		adddresstextField.setColumns(10);
		adddresstextField.setBounds(423, 121, 156, 26);
		contentPane.add(adddresstextField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setBounds(334, 126, 61, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Password");
		lblNewLabel_1_2_1.setBounds(33, 176, 61, 16);
		contentPane.add(lblNewLabel_1_2_1);
		
		passtextField = new JTextField();
		passtextField.setColumns(10);
		passtextField.setBounds(122, 171, 156, 26);
		contentPane.add(passtextField);
		
		rePasswordtextField = new JTextField();
		rePasswordtextField.setColumns(10);
		rePasswordtextField.setBounds(423, 171, 156, 26);
		contentPane.add(rePasswordtextField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("re-Password");
		lblNewLabel_1_1_1_1.setBounds(334, 176, 84, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton adminSignUpButton = new JButton("SignUP");
		adminSignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLandingPage frame = new AdminLandingPage(bllFacade);
				frame.setVisible(true);
			}
		});
		adminSignUpButton.setBounds(262, 253, 117, 29);
		contentPane.add(adminSignUpButton);
	}

}
