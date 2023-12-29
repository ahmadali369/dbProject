package pl.adminPanals;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import bll.IBLLFacade;
import pl.login.UserSignUp;

public class userPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private IBLLFacade bllFacade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					userActivityPage frame = new userActivityPage();
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
	public userPage(IBLLFacade ibllFacade) {
		bllFacade = ibllFacade; 
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 720, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Users");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 20, 112, 33);
		contentPane.add(lblNewLabel);
		
		JButton reloadButton = new JButton("Reload");
		reloadButton.setBounds(584, 24, 117, 29);
		contentPane.add(reloadButton);
		
		JButton addNewUserButton = new JButton("Add New User");
		addNewUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserSignUp frame = new UserSignUp(bllFacade);
				frame.setVisible(true);
			}
		});
		addNewUserButton.setBounds(326, 24, 117, 29);
		contentPane.add(addNewUserButton);
		
		JButton userAcitvityButton = new JButton("User Acitvity");
		userAcitvityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userActivityPage frame = new userActivityPage(bllFacade);
				frame.setVisible(true);
			}
		});
		userAcitvityButton.setBounds(194, 24, 117, 29);
		contentPane.add(userAcitvityButton);
		
		JLabel lblNewLabel_1 = new JLabel("Total:");
		lblNewLabel_1.setBounds(32, 79, 38, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel countLabel = new JLabel("0");
		countLabel.setBounds(71, 79, 61, 16);
		contentPane.add(countLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 107, 661, 379);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton deleteUserButton = new JButton("Delete User");
		deleteUserButton.setBounds(455, 24, 117, 29);
		contentPane.add(deleteUserButton);
	}
}
