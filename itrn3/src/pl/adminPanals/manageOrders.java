package pl.adminPanals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.IBLLFacade;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageOrders extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IBLLFacade bllFacade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					manageOrders frame = new manageOrders();
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
	public manageOrders(IBLLFacade blIbllFacade) {
		bllFacade = blIbllFacade; 
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 770, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Orders");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 18, 99, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pending Orders");
		lblNewLabel_1.setBounds(26, 55, 99, 16);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 83, 332, 178);
		contentPane.add(scrollPane);
		
		JButton openPendingButton = new JButton("Open Details");
		openPendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openPendingButton.setBounds(26, 268, 117, 29);
		contentPane.add(openPendingButton);
		
		JButton markAsProcessingButton = new JButton("Mark as Processing");
		markAsProcessingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		markAsProcessingButton.setBounds(146, 268, 175, 29);
		contentPane.add(markAsProcessingButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(408, 83, 332, 178);
		contentPane.add(scrollPane_1);
		
		JButton markAsShippButton = new JButton("Mark As Shipped");
		markAsShippButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		markAsShippButton.setBounds(528, 268, 133, 29);
		contentPane.add(markAsShippButton);
		
		JButton openProcessingButton = new JButton("Open Details");
		openProcessingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openProcessingButton.setBounds(408, 268, 117, 29);
		contentPane.add(openProcessingButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Processing Orders");
		lblNewLabel_1_1.setBounds(408, 55, 133, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(26, 358, 332, 178);
		contentPane.add(scrollPane_2);
		
		JButton markAsDeliverdButton = new JButton("Mark as Delivered");
		markAsDeliverdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		markAsDeliverdButton.setBounds(146, 543, 156, 29);
		contentPane.add(markAsDeliverdButton);
		
		JButton openShippedButton = new JButton("Open Details");
		openShippedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openShippedButton.setBounds(26, 543, 117, 29);
		contentPane.add(openShippedButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Shipped Orders");
		lblNewLabel_1_2.setBounds(26, 330, 99, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(408, 358, 332, 178);
		contentPane.add(scrollPane_3);
		
		JButton openDeliveredButton = new JButton("Open Details");
		openDeliveredButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openDeliveredButton.setBounds(408, 543, 117, 29);
		contentPane.add(openDeliveredButton);
		
		JLabel lblNewLabel_1_3 = new JLabel("Delivered Orders");
		lblNewLabel_1_3.setBounds(408, 330, 117, 16);
		contentPane.add(lblNewLabel_1_3);
	}
}
