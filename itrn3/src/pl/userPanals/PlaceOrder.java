package pl.userPanals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.Interfaces.IBLLFacade;
import transerferObjects.ProductTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class PlaceOrder extends JFrame {

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
//					PlaceOrder frame = new PlaceOrder();
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
	public PlaceOrder(IBLLFacade ibllFacade) {
		bllFacade = ibllFacade;
		List<ProductTO> cart = bllFacade.getCartProducts();

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 741, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Your Order");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(28, 6, 163, 32);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 84, 370, 495);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 1, 20, 20));

		if (!cart.isEmpty()) {

			for (ProductTO product : cart) {

				ProductWidget productWidget = new ProductWidget(product, ibllFacade, true);
				productWidget.setSelected(true);

				panel.add(productWidget);

				panel.revalidate();
				panel.repaint();

			}

		} else {
			System.out.println("no products found in cart");
		}

		JLabel lblNewLabel_1 = new JLabel("Order Details");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(443, 84, 163, 39);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Total Items:");
		lblNewLabel_2.setBounds(443, 135, 84, 16);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Shipping Address:");
		lblNewLabel_2_1.setBounds(443, 242, 125, 16);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Order Amount:");
		lblNewLabel_2_2.setBounds(443, 163, 99, 16);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_2_1 = new JLabel("Delivery Charges:");
		lblNewLabel_2_2_1.setBounds(443, 191, 115, 16);
		contentPane.add(lblNewLabel_2_2_1);

		JLabel lblNewLabel_3 = new JLabel("Total Bill: ");
		lblNewLabel_3.setBounds(443, 411, 71, 16);
		contentPane.add(lblNewLabel_3);

		JTextPane shippingAddressPane = new JTextPane();
		shippingAddressPane.setBounds(443, 270, 250, 79);
		contentPane.add(shippingAddressPane);

		JButton placeOrderButton = new JButton("Place Order");
		placeOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		placeOrderButton.setBounds(443, 439, 250, 55);
		contentPane.add(placeOrderButton);

		JLabel lblNewLabel_4 = new JLabel("Cart");
		lblNewLabel_4.setBounds(28, 56, 61, 16);
		contentPane.add(lblNewLabel_4);

		JLabel totalItemLable = new JLabel("10");
		totalItemLable.setBounds(523, 135, 61, 16);
		contentPane.add(totalItemLable);

		JLabel orderAmountLable = new JLabel("10");
		orderAmountLable.setBounds(545, 163, 61, 16);
		contentPane.add(orderAmountLable);

		JLabel deliveryChargesLable = new JLabel("10");
		deliveryChargesLable.setBounds(555, 191, 61, 16);
		contentPane.add(deliveryChargesLable);

		JLabel totalBillLable = new JLabel("10");
		totalBillLable.setBounds(507, 411, 61, 16);
		contentPane.add(totalBillLable);
	}

}
