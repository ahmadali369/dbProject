package pl.userPanals;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class ProductWidget extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProductWidget() {
		setLayout(null);
		
//		JPanel productWidget = new JPanel();
		setBackground(Color.LIGHT_GRAY);
		setForeground(new Color(246, 255, 236));
		setLayout(null);
		setBounds(32, 101, 340, 141);

		
		JPanel imgPanel = new JPanel();
		imgPanel.setBackground(Color.PINK);
		imgPanel.setBounds(19, 19, 107, 101);
		add(imgPanel);
		
		JLabel productNameLable = new JLabel("IPhone 12 Pro Max");
		productNameLable.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		productNameLable.setBounds(138, 19, 152, 16);
		add(productNameLable);
		
		JTextPane productDiscription = new JTextPane();
		productDiscription.setBackground(new Color(255, 255, 255));
		productDiscription.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		productDiscription.setText("asdfaslkjfhlsajhdf asjhflkajshfdl kajshdfljka sfljashf lkjahsdfl ");
		productDiscription.setBounds(138, 47, 184, 52);
		add(productDiscription);
		
		JLabel lblNewLabel_4 = new JLabel("Price: ");
		lblNewLabel_4.setBounds(139, 112, 38, 16);
		add(lblNewLabel_4);
		
		JLabel priceLable = new JLabel("1000");
		priceLable.setBounds(176, 112, 68, 16);
		add(priceLable);
		
		JCheckBox productCheckBox = new JCheckBox("Select");
		productCheckBox.setBounds(256, 107, 81, 23);
		add(productCheckBox);

	}

}
