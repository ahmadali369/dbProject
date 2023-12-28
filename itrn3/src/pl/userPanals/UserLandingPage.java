package pl.userPanals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;

public class UserLandingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLandingPage frame = new UserLandingPage();
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
	public UserLandingPage() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 987, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 26, 101, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reload");
		btnNewButton.setBounds(735, 26, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddToCart.setBounds(348, 26, 117, 29);
		contentPane.add(btnAddToCart);
		
		JLabel lblNewLabel_1 = new JLabel("Cart: ");
		lblNewLabel_1.setBounds(875, 30, 34, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setBounds(912, 30, 32, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaceOrder frame = new PlaceOrder();
				frame.setVisible(true);
				
			}
		});
		btnPlaceOrder.setBounds(477, 26, 117, 29);
		contentPane.add(btnPlaceOrder);
		
		JButton orderHIstoryButton = new JButton("Order History");
		orderHIstoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				orderHistory frame = new orderHistory();
				frame.setVisible(true);
			}
		});
		orderHIstoryButton.setBounds(606, 26, 117, 29);
		contentPane.add(orderHIstoryButton);


	}
}






