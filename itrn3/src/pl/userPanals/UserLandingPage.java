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
		
		JPanel productWidget = new JPanel();
		productWidget.setBackground(Color.LIGHT_GRAY);
		productWidget.setForeground(new Color(246, 255, 236));
		productWidget.setBounds(47, 131, 340, 141);
		contentPane.add(productWidget);
		productWidget.setLayout(null);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(19, 19, 107, 101);
		imgPanel.setBackground(Color.PINK);
		productWidget.add(imgPanel);
		
		JLabel productNameLable = new JLabel("IPhone 12 Pro Max");
		productNameLable.setBounds(138, 19, 152, 16);
		productNameLable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		productWidget.add(productNameLable);
		
		JTextPane productDiscription = new JTextPane();
		productDiscription.setBounds(138, 47, 184, 52);
		productDiscription.setBackground(new Color(255, 255, 255));
		productDiscription.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		productDiscription.setText("asdfaslkjfhlsajhdf asjhflkajshfdl kajshdfljka sfljashf lkjahsdfl ");
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
		
		JButton orderHIstoryButton = new JButton("Order History");
		orderHIstoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				orderHistory frame = new orderHistory();
				frame.setVisible(true);
			}
		});
		orderHIstoryButton.setBounds(606, 26, 117, 29);
		contentPane.add(orderHIstoryButton);
		
		JPanel productWidget_1 = new JPanel();
		productWidget_1.setLayout(null);
		productWidget_1.setForeground(new Color(246, 255, 236));
		productWidget_1.setBackground(Color.LIGHT_GRAY);
		productWidget_1.setBounds(434, 131, 340, 141);
		contentPane.add(productWidget_1);
		
		JPanel imgPanel_1 = new JPanel();
		imgPanel_1.setBackground(Color.PINK);
		imgPanel_1.setBounds(19, 19, 107, 101);
		productWidget_1.add(imgPanel_1);
		
		JLabel productNameLable_1 = new JLabel("IPhone 12 Pro Max");
		productNameLable_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		productNameLable_1.setBounds(138, 19, 152, 16);
		productWidget_1.add(productNameLable_1);
		
		JTextPane productDiscription_1 = new JTextPane();
		productDiscription_1.setText("asdfaslkjfhlsajhdf asjhflkajshfdl kajshdfljka sfljashf lkjahsdfl ");
		productDiscription_1.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		productDiscription_1.setBackground(Color.WHITE);
		productDiscription_1.setBounds(138, 47, 184, 52);
		productWidget_1.add(productDiscription_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Price: ");
		lblNewLabel_4_1.setBounds(139, 112, 38, 16);
		productWidget_1.add(lblNewLabel_4_1);
		
		JLabel priceLable_1 = new JLabel("1000");
		priceLable_1.setBounds(176, 112, 68, 16);
		productWidget_1.add(priceLable_1);
		
		JCheckBox productCheckBox_1 = new JCheckBox("Select");
		productCheckBox_1.setBounds(256, 107, 81, 23);
		productWidget_1.add(productCheckBox_1);
		
		JPanel ProductPanal = new JPanel();
		ProductPanal.setBounds(43, 302, 866, 242);
		contentPane.add(ProductPanal);
		ProductPanal.setLayout(new GridLayout(1, 2, 0, 0));
	}
}






