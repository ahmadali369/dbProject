package pl.adminPanals.productCRUD;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addProductPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField producttextField;
	private JTextField pricetextField;
	private JTextField quantitytextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					addProductPage frame = new addProductPage();
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
	public addProductPage() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 722, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Product");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 25, 164, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(300, 77, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		producttextField = new JTextField();
		producttextField.setBounds(390, 72, 250, 26);
		contentPane.add(producttextField);
		producttextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Discription");
		lblNewLabel_1_1.setBounds(300, 131, 70, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JTextPane discriptiontextPane = new JTextPane();
		discriptiontextPane.setBounds(390, 131, 250, 101);
		contentPane.add(discriptiontextPane);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setBounds(301, 267, 61, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Quantity");
		lblNewLabel_1_3.setBounds(503, 267, 61, 16);
		contentPane.add(lblNewLabel_1_3);
		
		pricetextField = new JTextField();
		pricetextField.setBounds(391, 262, 70, 26);
		contentPane.add(pricetextField);
		pricetextField.setColumns(10);
		
		quantitytextField = new JTextField();
		quantitytextField.setColumns(10);
		quantitytextField.setBounds(569, 262, 71, 26);
		contentPane.add(quantitytextField);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		panel.setBounds(33, 75, 225, 211);
		contentPane.add(panel);
		
		JButton selectImgButton = new JButton("Select Image");
		selectImgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		selectImgButton.setBounds(33, 310, 117, 29);
		contentPane.add(selectImgButton);
		
		JComboBox catagoryComboBox = new JComboBox();
		catagoryComboBox.setBounds(390, 311, 91, 27);
		contentPane.add(catagoryComboBox);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Catagory");
		lblNewLabel_1_2_1.setBounds(300, 315, 61, 16);
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton addProductButton = new JButton("Add Product");
		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addProductButton.setBounds(311, 410, 117, 29);
		contentPane.add(addProductButton);
		
		JButton addCatagoryButton = new JButton("Add New Catagory");
		addCatagoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addCatagoryButton.setBounds(503, 310, 148, 29);
		contentPane.add(addCatagoryButton);
	}
}
