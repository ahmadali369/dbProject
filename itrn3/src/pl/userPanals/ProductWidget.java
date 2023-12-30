package pl.userPanals;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import bll.Interfaces.IBLLFacade;
import net.miginfocom.swing.MigLayout;
import transerferObjects.ProductTO;

public class ProductWidget extends JPanel {

	private static final long serialVersionUID = 1L;
//	private IBLLFacade bllFacade;
	private ProductTO productTO; 
	private boolean isSelected; 

	/**
	 * Create the panel.
	 */
	public ProductWidget(ProductTO productTO) {
		this.productTO = productTO;
		this.isSelected = false; 
		setBorder(null);
		
//		JPanel productWidget = new JPanel();
		setBackground(new Color(223, 223, 223));
		setForeground(new Color(246, 255, 236));
		setLayout(null);
		setBounds(32, 101, 318, 125);
		setLayout(new MigLayout("", "[107px][106px][12px][81px]", "[16px][12px][52px][8px][23px]"));

		
		JPanel imgPanel = new JPanel();
		imgPanel.setBackground(Color.WHITE);
		add(imgPanel, "cell 0 0 1 5,grow");
		
//        String imagePath = "/img1.jpg";
        
        try {

        	
        	
            ImageIcon originalIcon = new ImageIcon(productTO.getImgBytes());

            Image originalImage = originalIcon.getImage();


            int newWidth = 100; // Set your desired width
            int newHeight = 100; // Set your desired height
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            ImageIcon resizedIcon = new ImageIcon(resizedImage);


            JLabel label = new JLabel(resizedIcon);
        	
            
            imgPanel.add(label); 
        	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("img not loaded");
//			e.printStackTrace();
		}

		
		
		JLabel productNameLable = new JLabel(productTO.getName());
		productNameLable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		add(productNameLable, "cell 1 0 3 1,alignx left,aligny center");
		
		JTextPane productDiscription = new JTextPane();
		productDiscription.setEditable(false);
		productDiscription.setBackground(new Color(255, 255, 255));
		productDiscription.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		productDiscription.setText(productTO.getDiscription());
		add(productDiscription, "cell 1 2 3 1,grow");
		
		JLabel lblNewLabel_4 = new JLabel("Price: ");
		add(lblNewLabel_4, "cell 1 4,alignx left,aligny center");
		
		JLabel priceLable = new JLabel(productTO.getPriceDouble().toString());
		add(priceLable, "cell 1 4,alignx right,aligny center");
		
		JCheckBox productCheckBox = new JCheckBox("Select");
		add(productCheckBox, "cell 3 4,growx,aligny top");
		
		productCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isSelected = productCheckBox.isSelected(); 
				
			}
		});
	}

	public ProductTO getProductTO() {
		return productTO;
	}

	public void setProductTO(ProductTO productTO) {
		this.productTO = productTO;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	
	

}
