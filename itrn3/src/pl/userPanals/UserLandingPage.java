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

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import bll.Interfaces.IBLLFacade;
import transerferObjects.ProductTO;

public class UserLandingPage extends JFrame {

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
//					UserLandingPage frame = new UserLandingPage(bllFacade);
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
	public UserLandingPage(IBLLFacade ibllFacade) {
		bllFacade = ibllFacade;
		List<Map<String, Object>> products = bllFacade.getAllProdcuts();

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

		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PlaceOrder frame = new PlaceOrder(bllFacade);
				frame.setVisible(true);

			}
		});
		btnPlaceOrder.setBounds(677, 26, 117, 29);
		contentPane.add(btnPlaceOrder);

		JButton orderHIstoryButton = new JButton("Order History");
		orderHIstoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				orderHistory frame = new orderHistory(bllFacade);
				frame.setVisible(true);
			}
		});
		orderHIstoryButton.setBounds(806, 26, 117, 29);
		contentPane.add(orderHIstoryButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 63, 931, 515);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 2, 20, 20));

		if (!products.isEmpty()) {

			for (Map<String, Object> product : products) {

				ProductTO productTO = new ProductTO();

				productTO.setName((String) product.get("name"));
				productTO.setProductid((int) product.get("productId"));

				productTO.setImgPathString((String) product.get("imagePath"));

				BigDecimal bigDecimalValue = new BigDecimal(product.get("price").toString());
				Double price = bigDecimalValue.doubleValue();
				productTO.setPriceDouble(price);

				productTO.setDiscription((String) product.get("description"));
				productTO.setImgBytes((byte[]) product.get("imgBytes"));
				productTO.setQuantity((int) product.get("quantity"));

				productTO.setImgKey((int) product.get("imageId"));

				BigDecimal bigDecimalValue2 = new BigDecimal(product.get("cost").toString());
				Double cost = bigDecimalValue2.doubleValue();
				productTO.setCost(cost);

				panel.add(new ProductWidget(productTO, bllFacade, false));

				panel.revalidate();
				panel.repaint();

			}

		} else {
			System.out.println("no products found");
		}

	}
}
