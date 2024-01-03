package pl.userPanals;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import org.jcp.xml.dsig.internal.MacOutputStream;

import bll.Interfaces.IBLLFacade;
import transerferObjects.ProductTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class orderDetails extends JFrame {

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
//					orderDetails frame = new orderDetails();
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
	public orderDetails(IBLLFacade ibllFacade, int id) {
		this.bllFacade = ibllFacade ;
		
		System.out.println("-----" + id);
		List<Map<String, Object>> products = bllFacade.getProductsForOrderDetail(id);

		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 496, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Details");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 5, 202, 36);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 68, 405, 505);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
//		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		panel.setLayout(new GridLayout(0, 1, 20, 20));

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
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Products");
		lblNewLabel_1.setBounds(38, 43, 61, 16);
		contentPane.add(lblNewLabel_1);
	}
}
