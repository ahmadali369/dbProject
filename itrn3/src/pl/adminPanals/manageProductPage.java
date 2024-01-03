package pl.adminPanals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bll.CartBLO;
import bll.Interfaces.IBLLFacade;
import pl.adminPanals.productCRUD.addProductPage;
import pl.adminPanals.productCRUD.editProductPage;
import pl.userPanals.ProductWidget;
import transerferObjects.ProductTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;

public class manageProductPage extends JFrame {

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
//					manageProductPage frame = new manageProductPage();
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
	public manageProductPage(IBLLFacade bIbllFacade) {
		bllFacade = bIbllFacade;

		List<Map<String, Object>> products = bllFacade.getAllProdcuts();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 726, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Product Management");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(31, 27, 188, 27);
		contentPane.add(lblNewLabel);

		JButton addProductButton = new JButton("Add");
		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addProductPage frame = new addProductPage(bllFacade);
				frame.setVisible(true);
			}
		});
		addProductButton.setBounds(328, 28, 117, 29);
		contentPane.add(addProductButton);

		JButton editProductButton = new JButton("Edit");
		editProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<ProductTO> cart = bllFacade.getCartProducts();

				if (cart.size() != 1) {
					System.out.println("------ Select one product");

				} else {

					editProductPage frame = new editProductPage(bllFacade);
					frame.setVisible(true);

				}

			}
		});
		editProductButton.setBounds(456, 28, 117, 29);
		contentPane.add(editProductButton);

		JButton deleteProductButton = new JButton("Delete");
		deleteProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteProductButton.setBounds(585, 28, 117, 29);
		contentPane.add(deleteProductButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 66, 671, 439);
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
