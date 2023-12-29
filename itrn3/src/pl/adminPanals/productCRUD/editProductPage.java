package pl.adminPanals.productCRUD;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import bll.IBLLFacade;
import transerferObjects.ProductTO;

public class editProductPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField producttextField;
	private JTextField pricetextField;
	private JTextField quantitytextField;
	private IBLLFacade bllFacade;

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
	public editProductPage(ProductTO productTO, IBLLFacade bIbllFacade) {
		bllFacade = bIbllFacade; 
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
		
		JButton changeImgButton = new JButton("Change Image");
		changeImgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		changeImgButton.setBounds(33, 310, 117, 29);
		contentPane.add(changeImgButton);
		
		JComboBox catagoryComboBox = new JComboBox();
		catagoryComboBox.setBounds(390, 311, 91, 27);
		contentPane.add(catagoryComboBox);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Catagory");
		lblNewLabel_1_2_1.setBounds(300, 315, 61, 16);
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton editProductButton = new JButton("Edit Product");
		editProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		editProductButton.setBounds(311, 410, 117, 29);
		contentPane.add(editProductButton);
		
		JButton addNewCatagoryButton = new JButton("Add New Catagory");
		addNewCatagoryButton.setBounds(493, 310, 147, 29);
		contentPane.add(addNewCatagoryButton);
	}

}
