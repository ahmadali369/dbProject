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

public class UserLandingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserLandingPage frame = new UserLandingPage();
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
	public UserLandingPage() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 943, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(32, 26, 101, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reload");
		btnNewButton.setBounds(606, 26, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.setBounds(348, 26, 117, 29);
		contentPane.add(btnAddToCart);
		
		JLabel lblNewLabel_1 = new JLabel("Cart: ");
		lblNewLabel_1.setBounds(291, 31, 34, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		lblNewLabel_2.setBounds(328, 31, 32, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBounds(477, 26, 117, 29);
		contentPane.add(btnPlaceOrder);
		
		JPanel productWidget = new JPanel();
		productWidget.setBackground(Color.LIGHT_GRAY);
		productWidget.setForeground(new Color(246, 255, 236));
		productWidget.setLayout(null);
		productWidget.setBounds(32, 101, 340, 141);
		contentPane.add(productWidget);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBackground(Color.PINK);
		imgPanel.setBounds(19, 19, 107, 101);
		productWidget.add(imgPanel);
		
		JLabel productNameLable = new JLabel("IPhone 12 Pro Max");
		productNameLable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		productNameLable.setBounds(138, 19, 152, 16);
		productWidget.add(productNameLable);
		
		JTextPane productDiscription = new JTextPane();
		productDiscription.setBackground(new Color(255, 255, 255));
		productDiscription.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		productDiscription.setText("asdfaslkjfhlsajhdf asjhflkajshfdl kajshdfljka sfljashf lkjahsdfl ");
		productDiscription.setBounds(138, 47, 184, 52);
		productWidget.add(productDiscription);
		
		JLabel lblNewLabel_4 = new JLabel("Price: ");
		lblNewLabel_4.setBounds(139, 112, 38, 16);
		productWidget.add(lblNewLabel_4);
		
		JLabel priceLable = new JLabel("1000");
		priceLable.setBounds(176, 112, 68, 16);
		productWidget.add(priceLable);
		
		JCheckBox productCheckBox = new JCheckBox("Select");
		productCheckBox.setBounds(256, 107, 81, 23);
		productWidget.add(productCheckBox);
	}
}






