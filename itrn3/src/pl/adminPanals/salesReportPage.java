//package pl.adminPanals;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import bll.Interfaces.IBLLFacade;
//
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.JButton;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//
//public class salesReportPage extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private JTable table;
//	private JTable table_1;
//	private IBLLFacade bllFacade;
//
//	/**
//	 * Launch the application.
//	 */
////	public static void main(String[] args) {
////		EventQueue.invokeLater(new Runnable() {
////			public void run() {
////				try {
////					salesReportPage frame = new salesReportPage();
////					frame.setVisible(true);
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
////			}
////		});
////	}
//
//	/**
//	 * Create the frame.
//	 */
//	public salesReportPage(IBLLFacade bIbllFacade) {
//		bllFacade = bIbllFacade; 
//		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//		setBounds(100, 100, 728, 688);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Sales Report");
//		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
//		lblNewLabel.setBounds(27, 23, 107, 26);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("Revenue Generated:");
//		lblNewLabel_1.setBounds(27, 80, 126, 16);
//		contentPane.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_1_1 = new JLabel("Total Profit:");
//		lblNewLabel_1_1.setBounds(260, 80, 78, 16);
//		contentPane.add(lblNewLabel_1_1);
//		
//		JLabel lblNewLabel_1_1_1 = new JLabel("Sold Products:");
//		lblNewLabel_1_1_1.setBounds(430, 80, 93, 16);
//		contentPane.add(lblNewLabel_1_1_1);
//		
//		JLabel lblNewLabel_1_1_2 = new JLabel("Total Orders:");
//		lblNewLabel_1_1_2.setBounds(607, 80, 87, 16);
//		contentPane.add(lblNewLabel_1_1_2);
//		
//		JButton relaodButton = new JButton("reload");
//		relaodButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		relaodButton.setBounds(577, 24, 117, 29);
//		contentPane.add(relaodButton);
//		
//		JLabel reveLable = new JLabel("23423");
//		reveLable.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
//		reveLable.setBounds(27, 96, 126, 43);
//		contentPane.add(reveLable);
//		
//		JLabel totalProfitLable = new JLabel("23423");
//		totalProfitLable.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
//		totalProfitLable.setBounds(260, 96, 126, 43);
//		contentPane.add(totalProfitLable);
//		
//		JLabel soldProductsLable = new JLabel("23423");
//		soldProductsLable.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
//		soldProductsLable.setBounds(430, 96, 126, 43);
//		contentPane.add(soldProductsLable);
//		
//		JLabel totalOrdersLable = new JLabel("23423");
//		totalOrdersLable.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
//		totalOrdersLable.setBounds(607, 96, 93, 43);
//		contentPane.add(totalOrdersLable);
//		
//		JButton pdfButton = new JButton("PDF");
//		pdfButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		pdfButton.setBounds(448, 24, 117, 29);
//		contentPane.add(pdfButton);
//		
//		JLabel lblNewLabel_2 = new JLabel("Order History");
//		lblNewLabel_2.setBounds(27, 186, 87, 16);
//		contentPane.add(lblNewLabel_2);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(27, 214, 678, 166);
//		contentPane.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBounds(30, 444, 675, 166);
//		contentPane.add(scrollPane_1);
//		
//		table_1 = new JTable();
//		scrollPane_1.setViewportView(table_1);
//		
//		JLabel lblNewLabel_2_1 = new JLabel("Sold Products");
//		lblNewLabel_2_1.setBounds(30, 416, 87, 16);
//		contentPane.add(lblNewLabel_2_1);
//	}
//
//}

package pl.adminPanals;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

// Add iText imports
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import bll.Interfaces.IBLLFacade;

public class salesReportPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private IBLLFacade bllFacade;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					salesReportPage frame = new salesReportPage();
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
	private JLabel reveLable; // Declare as a class field
    private JLabel totalProfitLable; // Declare as a class field
    private JLabel soldProductsLable; // Declare as a class field
    private JLabel totalOrdersLable; // Declare as a class field
 
	public salesReportPage(IBLLFacade bIbllFacade) {
		bllFacade = bIbllFacade; 
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 728, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sales Report");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(27, 23, 107, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Revenue Generated:");
		lblNewLabel_1.setBounds(27, 80, 126, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Profit:");
		lblNewLabel_1_1.setBounds(260, 80, 78, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Sold Products:");
		lblNewLabel_1_1_1.setBounds(430, 80, 93, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Total Orders:");
		lblNewLabel_1_1_2.setBounds(607, 80, 87, 16);
		contentPane.add(lblNewLabel_1_1_2);
		
		JButton relaodButton = new JButton("reload");
		relaodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		relaodButton.setBounds(577, 24, 117, 29);
		contentPane.add(relaodButton);
		
		reveLable = new JLabel("23423");
		reveLable.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		reveLable.setBounds(27, 96, 126, 43);
		contentPane.add(reveLable);
		
		totalProfitLable = new JLabel("23423");
		totalProfitLable.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		totalProfitLable.setBounds(260, 96, 126, 43);
		contentPane.add(totalProfitLable);
		
		soldProductsLable = new JLabel("23423");
		soldProductsLable.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		soldProductsLable.setBounds(430, 96, 126, 43);
		contentPane.add(soldProductsLable);
		
		totalOrdersLable = new JLabel("23423");
		totalOrdersLable.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		totalOrdersLable.setBounds(607, 96, 93, 43);
		contentPane.add(totalOrdersLable);
		
		JButton pdfButton = new JButton("PDF");
		pdfButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generatePDF();
			}
		});
		pdfButton.setBounds(448, 24, 117, 29);
		contentPane.add(pdfButton);
		
		JLabel lblNewLabel_2 = new JLabel("Order History");
		lblNewLabel_2.setBounds(27, 186, 87, 16);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 214, 678, 166);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 444, 675, 166);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sold Products");
		lblNewLabel_2_1.setBounds(30, 416, 87, 16);
		contentPane.add(lblNewLabel_2_1);
	}
	private void generatePDF() {
        try {
        	
        	
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("SalesReport.pdf"));
            document.open();

            // Add content to the PDF
            document.add(new Paragraph("Sales Report"));
            document.add(new Paragraph("Revenue Generated: " + reveLable.getText()));
            document.add(new Paragraph("Total Profit: " + totalProfitLable.getText()));
            document.add(new Paragraph("Sold Products: " + soldProductsLable.getText()));
            document.add(new Paragraph("Total Orders: " + totalOrdersLable.getText()));

            // Add additional content as needed

            document.close();

            // Inform the user that the PDF has been generated
            JOptionPane.showMessageDialog(this, "PDF generated successfully.");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	

}
