package pl.adminPanals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pl.adminPanals.productCRUD.addProductPage;
import pl.adminPanals.productCRUD.editProductPage;
import transerferObjects.ProductTO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class manageProductPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
	public manageProductPage() {
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
				
				addProductPage frame = new addProductPage();
				frame.setVisible(true);
			}
		});
		addProductButton.setBounds(328, 28, 117, 29);
		contentPane.add(addProductButton);
		
		JButton editProductButton = new JButton("Edit");
		editProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editProductPage frame = new editProductPage(new ProductTO());
				frame.setVisible(true);
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton reLoadButton = new JButton("Reload");
		reLoadButton.setBounds(209, 28, 117, 29);
		contentPane.add(reLoadButton);
	}
}
