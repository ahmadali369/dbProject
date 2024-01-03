package pl.adminPanals;

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
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class manageOrders extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IBLLFacade bllFacade;
	private int id;
	private int id2;
	private int id3;
	private int id4;

	private int tableRow = -1;
	private int table2Row = -1;
	private int table3Row = -1;
	private int table4Row = -1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					manageOrders frame = new manageOrders();
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
	public manageOrders(IBLLFacade blIbllFacade) {
		bllFacade = blIbllFacade; 
		List<Map<String, Object>> order1 = bllFacade.getOrdersBySatus("pending");
		List<Map<String, Object>> order2 = bllFacade.getOrdersBySatus("processing");
		List<Map<String, Object>> order3 = bllFacade.getOrdersBySatus("shipped");
		List<Map<String, Object>> order4 = bllFacade.getOrdersBySatus("delivered");
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 770, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Orders");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(26, 18, 99, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pending Orders");
		lblNewLabel_1.setBounds(26, 55, 99, 16);
		contentPane.add(lblNewLabel_1);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(26, 83, 332, 178);
//		contentPane.add(scrollPane);
		
		
		

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
								order.get("status") });
				idmodel.addRow(new Object[] { order.get("orderId"), });

			}

			JTable table = new JTable(model);
			JTable idtable = new JTable(idmodel);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(26, 83, 332, 178);
			
			

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
		
		
		
		
		
		
		JButton openPendingButton = new JButton("Open Details");
		openPendingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openPendingButton.setBounds(26, 268, 117, 29);
		contentPane.add(openPendingButton);
		
		JButton markAsProcessingButton = new JButton("Mark as Processing");
		markAsProcessingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				changeOrderStatus(); 
				
				bllFacade.changeOrderStatus(id, "processing");
				
			}
		});
		markAsProcessingButton.setBounds(146, 268, 175, 29);
		contentPane.add(markAsProcessingButton);
		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(408, 83, 332, 178);
//		
//		contentPane.add(scrollPane_1);
		
		
		
		

		if (order2.isEmpty()) {

		} else {
//			listPanel.removeAll();
			DefaultTableModel model = new DefaultTableModel();
			DefaultTableModel idmodel = new DefaultTableModel();

			model.addColumn("order id");
			model.addColumn("Address");
			model.addColumn("date");
			model.addColumn("satus");
			
			idmodel.addColumn("userid");

			for (Map<String, Object> order : order2) {
				model.addRow(
						new Object[] { order.get("orderId"), order.get("address"), order.get("date"),
								order.get("status"), order.get("totalPoems"), });
				idmodel.addRow(new Object[] { order.get("orderId"), });

			}

			JTable table = new JTable(model);
			JTable idtable = new JTable(idmodel);
//			JScrollPane scrollPane = new JScrollPane(table);
			JScrollPane scrollPane_1 = new JScrollPane(table);
			scrollPane_1.setBounds(408, 83, 332, 178);
			
			

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						int selectedRow = table.getSelectedRow();

						if (selectedRow != -1) {
							table2Row = selectedRow;

							id2 = (int) idtable.getValueAt(table2Row, 0);
							System.out.println("selected row" + table2Row);
						}
					}
				}

			});

			contentPane.add(scrollPane_1);
			
//			listPanel.add(scrollPane);
//			listPanel.revalidate();
//			listPanel.repaint();

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		JButton markAsShippButton = new JButton("Mark As Shipped");
		markAsShippButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bllFacade.changeOrderStatus(id2, "shipped");
				
			}
		});
		markAsShippButton.setBounds(528, 268, 133, 29);
		contentPane.add(markAsShippButton);
		
		JButton openProcessingButton = new JButton("Open Details");
		openProcessingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openProcessingButton.setBounds(408, 268, 117, 29);
		contentPane.add(openProcessingButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("Processing Orders");
		lblNewLabel_1_1.setBounds(408, 55, 133, 16);
		contentPane.add(lblNewLabel_1_1);
		
//		JScrollPane scrollPane_2 = new JScrollPane();
//		scrollPane_2.setBounds(26, 358, 332, 178);
//		contentPane.add(scrollPane_2);
		
		
		
		if (order3.isEmpty()) {

		} else {
//			listPanel.removeAll();
			DefaultTableModel model = new DefaultTableModel();
			DefaultTableModel idmodel = new DefaultTableModel();

			model.addColumn("order id");
			model.addColumn("Address");
			model.addColumn("date");
			model.addColumn("satus");
			
			idmodel.addColumn("userid");

			for (Map<String, Object> order : order3) {
				model.addRow(
						new Object[] { order.get("orderId"), order.get("address"), order.get("date"),
								order.get("status"), order.get("totalPoems"), });
				idmodel.addRow(new Object[] { order.get("orderId"), });

			}

			JTable table = new JTable(model);
			JTable idtable = new JTable(idmodel);
			JScrollPane scrollPane_2 = new JScrollPane(table);
			scrollPane_2.setBounds(26, 358, 332, 178);
			
			

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						int selectedRow = table.getSelectedRow();

						if (selectedRow != -1) {
							table3Row = selectedRow;

							id3 = (int) idtable.getValueAt(table3Row, 0);
							System.out.println("selected row" + table3Row);
						}
					}
				}

			});

			contentPane.add(scrollPane_2);
			
//			listPanel.add(scrollPane);
//			listPanel.revalidate();
//			listPanel.repaint();

		}
		
		
		
		
		
		JButton markAsDeliverdButton = new JButton("Mark as Delivered");
		markAsDeliverdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bllFacade.changeOrderStatus(id3, "delivered");
				
				
				
			}
		});
		markAsDeliverdButton.setBounds(146, 543, 156, 29);
		contentPane.add(markAsDeliverdButton);
		
		JButton openShippedButton = new JButton("Open Details");
		openShippedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openShippedButton.setBounds(26, 543, 117, 29);
		contentPane.add(openShippedButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Shipped Orders");
		lblNewLabel_1_2.setBounds(26, 330, 99, 16);
		contentPane.add(lblNewLabel_1_2);
		
//		JScrollPane scrollPane_3 = new JScrollPane();
//		scrollPane_3.setBounds(408, 358, 332, 178);
//		contentPane.add(scrollPane_3);
		
		
		if (order4.isEmpty()) {

		} else {
//			listPanel.removeAll();
			DefaultTableModel model = new DefaultTableModel();
			DefaultTableModel idmodel = new DefaultTableModel();

			model.addColumn("order id");
			model.addColumn("Address");
			model.addColumn("date");
			model.addColumn("satus");
			
			idmodel.addColumn("userid");

			for (Map<String, Object> order : order4) {
				model.addRow(
						new Object[] { order.get("orderId"), order.get("address"), order.get("date"),
								order.get("status"), order.get("totalPoems"), });
				idmodel.addRow(new Object[] { order.get("orderId"), });

			}

			JTable table = new JTable(model);
			JTable idtable = new JTable(idmodel);
			JScrollPane scrollPane_3 = new JScrollPane(table);
			scrollPane_3.setBounds(408, 358, 332, 178);
			
			

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						int selectedRow = table.getSelectedRow();

						if (selectedRow != -1) {
							table4Row = selectedRow;

							id4 = (int) idtable.getValueAt(table4Row, 0);
							System.out.println("selected row" + table4Row);
						}
					}
				}

			});

			contentPane.add(scrollPane_3);


		}

		
		
		JButton openDeliveredButton = new JButton("Open Details");
		openDeliveredButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		openDeliveredButton.setBounds(408, 543, 117, 29);
		contentPane.add(openDeliveredButton);
		
		JLabel lblNewLabel_1_3 = new JLabel("Delivered Orders");
		lblNewLabel_1_3.setBounds(408, 330, 117, 16);
		contentPane.add(lblNewLabel_1_3);
	}
}
