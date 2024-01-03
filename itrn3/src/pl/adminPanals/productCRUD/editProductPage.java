package pl.adminPanals.productCRUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import bll.Interfaces.IBLLFacade;
import transerferObjects.CatagoryTO;
import transerferObjects.ProductTO;

public class editProductPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField producttextField;
	private JTextField pricetextField;
	private JTextField quantitytextField;
	private JFrame frame;
	private IBLLFacade bllFacade;
	private String imgPathString;
	private JTextField costTextfiled;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					editProductPage frame = new editProductPage(new ProductTO());
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
	public editProductPage(IBLLFacade bIbllFacade) {
		bllFacade = bIbllFacade;
		List<ProductTO> cart = bllFacade.getCartProducts();
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 722, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Edit Product");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 25, 164, 30);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(300, 77, 61, 16);
		contentPane.add(lblNewLabel_1);

		producttextField = new JTextField();
		producttextField.setBounds(390, 72, 250, 26);
		
		producttextField.setText(cart.get(0).getName());
		contentPane.add(producttextField);
		producttextField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Discription");
		lblNewLabel_1_1.setBounds(300, 131, 70, 16);
		contentPane.add(lblNewLabel_1_1);

		JTextPane discriptiontextPane = new JTextPane();
		discriptiontextPane.setBounds(390, 131, 250, 101);
		discriptiontextPane.setText(cart.get(0).getDiscription());
		contentPane.add(discriptiontextPane);

		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setBounds(301, 267, 61, 16);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Quantity");
		lblNewLabel_1_3.setBounds(503, 267, 61, 16);
		contentPane.add(lblNewLabel_1_3);

		pricetextField = new JTextField();
		pricetextField.setBounds(391, 262, 70, 26);
		pricetextField.setText(cart.get(0).getPriceDouble().toString());
		contentPane.add(pricetextField);
		pricetextField.setColumns(10);

		quantitytextField = new JTextField();
		quantitytextField.setColumns(10);
		quantitytextField.setBounds(569, 262, 71, 26);
		quantitytextField.setText(cart.get(0).getQuantity()+ "");
		contentPane.add(quantitytextField);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(33, 75, 225, 211);
		contentPane.add(panel);
		
		try {

			ImageIcon originalIcon = new ImageIcon(cart.get(0).getImgBytes());

			Image originalImage = originalIcon.getImage();

			int newWidth = 250; // Set your desired width
			int newHeight = 250; // Set your desired height
			Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

			ImageIcon resizedIcon = new ImageIcon(resizedImage);

			JLabel label = new JLabel(resizedIcon);

			panel.add(label);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("img not loaded");
//			e.printStackTrace();
		}

		List<Map<String, Object>> catagoriesList = bllFacade.getAllCatagoriesList();
		JComboBox catagoryComboBox = new JComboBox();
		if (!catagoriesList.isEmpty()) {

			for (Map<String, Object> catagory : catagoriesList) {

				CatagoryTO catagoryTO = new CatagoryTO();


				catagoryComboBox.addItem((String) catagory.get("name"));

			}

		}
		
		
		catagoryComboBox.setBounds(390, 311, 91, 27);
		contentPane.add(catagoryComboBox);
		
		
		costTextfiled = new JTextField();
		costTextfiled.setText((String) null);
		costTextfiled.setColumns(10);
		costTextfiled.setBounds(390, 358, 70, 26);
		costTextfiled.setText(cart.get(0).getCost().toString());
		
		contentPane.add(costTextfiled);
		
		

		JLabel lblNewLabel_1_2_1 = new JLabel("Catagory");
		lblNewLabel_1_2_1.setBounds(300, 315, 61, 16);
		contentPane.add(lblNewLabel_1_2_1);

		JButton editProductButton = new JButton("Edit Product");
		editProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ProductTO productTO1 = new ProductTO();
				
				productTO1.setValuesFromProduct(cart.get(0));
				

				productTO1.setName(producttextField.getText());
				productTO1.setPriceDouble(Double.parseDouble(pricetextField.getText()));
				productTO1.setDiscription(discriptiontextPane.getText());
				productTO1.setCost(Double.parseDouble(costTextfiled.getText()));


				if(imgPathString == null) {
					
					productTO1.setImgPathString(cart.get(0).getImgPathString());
				}else {
					productTO1.setImgPathString(imgPathString);
				}
			
				productTO1.setQuantity(Integer.parseInt(quantitytextField.getText()));
				
                String selectedItem = (String) catagoryComboBox.getSelectedItem();
                
                productTO1.setCatagory(selectedItem);
                
				

				try {
					bllFacade.updateProdcut(productTO1);
//					
//					cart.get(0).printProductDetails(); 
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
				
				
			}
		});
		editProductButton.setBounds(311, 410, 117, 29);
		contentPane.add(editProductButton);

		JButton addNewCatagoryButton = new JButton("Add New Catagory");
		addNewCatagoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				addNewCatagory frame = new addNewCatagory(bllFacade);
				frame.setVisible(true);
				
			}
		});
		addNewCatagoryButton.setBounds(493, 310, 147, 29);
		contentPane.add(addNewCatagoryButton);
		

		
		JLabel lblNewLabel_1_2_2 = new JLabel("Cost");
		lblNewLabel_1_2_2.setBounds(300, 363, 61, 16);
		contentPane.add(lblNewLabel_1_2_2);
		
		JButton btnNewButton = new JButton("Del product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ProductTO productTO = new ProductTO(); 
				
				
				
				bllFacade.deleteProduct(cart.get(0));
				
				
				
			}
		});
		btnNewButton.setBounds(50, 410, 117, 29);
		contentPane.add(btnNewButton);
	}

}
