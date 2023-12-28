package pl.adminPanals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLandingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminLandingPage frame = new AdminLandingPage();
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
	public AdminLandingPage() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 567, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Home");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 27, 134, 29);
		contentPane.add(lblNewLabel);
		
		JButton managePButton = new JButton("Manage Products");
		managePButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageProductPage frame = new manageProductPage();
				frame.setVisible(true);
			}
		});
		managePButton.setBounds(32, 78, 134, 29);
		contentPane.add(managePButton);
		
		JButton manageUsersButton = new JButton("Manage Users");
		manageUsersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userPage frame = new userPage();
				frame.setVisible(true);
			}
		});
		manageUsersButton.setBounds(297, 78, 117, 29);
		contentPane.add(manageUsersButton);
		
		JButton salesReportButton = new JButton("Sales Report");
		salesReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesReportPage frame = new salesReportPage();
				frame.setVisible(true);
			
			}
			
			
		});
		salesReportButton.setBounds(415, 78, 117, 29);
		contentPane.add(salesReportButton);
		
		JButton manageOrdersButton = new JButton("Manage Orders");
		manageOrdersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				manageOrders frame = new manageOrders();
				frame.setVisible(true);
			}
		});
		manageOrdersButton.setBounds(166, 78, 126, 29);
		contentPane.add(manageOrdersButton);
	}

}
