

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ParameterObjects.BllPo;
import ParameterObjects.DalPO;
import bll.BllFacade;
import bll.Interfaces.IBLLFacade;
import dal.DalFacade;
import dal.Interfaces.IDalFacade;
import pl.login.AdminLogin;
import pl.login.UserLogin;

public class LandingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private IBLLFacade bllFacade; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DalPO dalPO = new DalPO(); 
					IDalFacade dalFacade = new DalFacade(dalPO); 
					
					BllPo bllPo = new BllPo(dalFacade); 
					
					IBLLFacade bllFacade = new BllFacade(bllPo); 
					
					LandingPage frame = new LandingPage(bllFacade);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LandingPage(IBLLFacade bllFacade) {
		this.bllFacade = bllFacade; 
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 890, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory Management System");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(298, 160, 321, 46);
		contentPane.add(lblNewLabel);
		
		JButton userButton = new JButton("User");
		userButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogin frame = new UserLogin(bllFacade);
				frame.setVisible(true);
				
			}
		});
		userButton.setBounds(332, 244, 117, 29);
		contentPane.add(userButton);
		
		JButton adminButton = new JButton("Admin");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin frame = new AdminLogin(bllFacade);
				frame.setVisible(true);
				
				
			}
		});
		adminButton.setBounds(456, 244, 117, 29);
		contentPane.add(adminButton);
	}
}
