package pl.userPanals;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import bll.Interfaces.IBLLFacade;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class orderHistory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private IBLLFacade bllFacade;
	private int id;
	private int tableRow = -1;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					orderHistory frame = new orderHistory();
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
	public orderHistory(IBLLFacade ibllFacade) {
		bllFacade = ibllFacade; 
		List<Map<String, Object>> order1 = bllFacade.getOrdersByStatusAndCustormerId("pending", bllFacade.getUserid());
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 738, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order History");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(31, 30, 127, 27);
		contentPane.add(lblNewLabel);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(31, 87, 687, 543);
		
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		
		
		
		

		if (order1.isEmpty()) {

		} else {
//			listPanel.removeAll();
			DefaultTableModel model = new DefaultTableModel();
			DefaultTableModel idmodel = new DefaultTableModel();

			model.addColumn("order id");
			model.addColumn("Address");
			model.addColumn("date");
			model.addColumn("satus");
			
			idmodel.addColumn("userid");

			for (Map<String, Object> order : order1) {
				model.addRow(
						new Object[] { order.get("orderId"), order.get("address"), order.get("date"),
								order.get("status"), order.get("totalPoems"), });
				idmodel.addRow(new Object[] { order.get("orderId"), });

			}

			JTable table = new JTable(model);
			JTable idtable = new JTable(idmodel);
//			JScrollPane scrollPane = new JScrollPane(table);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(31, 87, 687, 543);
			
			

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						int selectedRow = table.getSelectedRow();

						if (selectedRow != -1) {
							tableRow = selectedRow;

							id = (int) idtable.getValueAt(tableRow, 0);
							System.out.println("selected row" + tableRow);
						}
					}
				}

			});

			contentPane.add(scrollPane);
			
//			listPanel.add(scrollPane);
//			listPanel.revalidate();
//			listPanel.repaint();

		}
		
		
		

		
		
		
		
		
		
		
		
		JButton reloadButton = new JButton("reload");
		reloadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		reloadButton.setBounds(601, 31, 117, 29);
		contentPane.add(reloadButton);
		
		JButton openOrderDetailsButton = new JButton("Open Order Details");
		openOrderDetailsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openOrderDetailsButton.setBounds(439, 31, 150, 29);
		contentPane.add(openOrderDetailsButton);
	}
}
