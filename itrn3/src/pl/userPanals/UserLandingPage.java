//
//
//package pl.userPanals;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class UserLandingPage extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//    private JPanel contentPane;
//
//    /**
//     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    UserLandingPage frame = new UserLandingPage();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    /**
//     * Create the frame.
//     */
//    public UserLandingPage() {
//        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        setBounds(100, 100, 987, 619);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(new BorderLayout());
//
//        JLabel lblNewLabel = new JLabel("Home Page");
//        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
//        contentPane.add(lblNewLabel, BorderLayout.NORTH);
//
//        JPanel buttonPanel = new JPanel();
//        contentPane.add(buttonPanel, BorderLayout.SOUTH);
//
//        JButton btnNewButton = new JButton("Reload");
//        buttonPanel.add(btnNewButton);
//
//        JButton btnAddToCart = new JButton("Add to Cart");
//        buttonPanel.add(btnAddToCart);
//
//        JButton btnPlaceOrder = new JButton("Place Order");
//        buttonPanel.add(btnPlaceOrder);
//
//        JButton orderHistoryButton = new JButton("Order History");
//        buttonPanel.add(orderHistoryButton);
//
//        JScrollPane scrollPane = new JScrollPane();
//        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//        contentPane.add(scrollPane, BorderLayout.CENTER);
//
//        JPanel panel = new JPanel(new GridLayout(0, 2, 1, 1));
//        scrollPane.setViewportView(panel);
//
//        // Add ProductWidget instances to the panel
//        for (int i = 0; i < 20; i++) {
//            panel.add(new ProductWidget());
//        }
//
//        // Action listeners for buttons
//        btnPlaceOrder.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                PlaceOrder frame = new PlaceOrder();
//                frame.setVisible(true);
//            }
//        });
//
//        orderHistoryButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                orderHistory frame = new orderHistory();
//                frame.setVisible(true);
//            }
//        });
//    }
//}






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
import javax.swing.ScrollPaneConstants;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 63, 931, 515);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 2, 20, 20));
		
		
		
		panel.add(new ProductWidget()); 
		panel.add(new ProductWidget()); 
		panel.add(new ProductWidget()); 
		panel.add(new ProductWidget()); 
		panel.add(new ProductWidget()); 


	}
}






