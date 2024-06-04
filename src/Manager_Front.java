import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Manager_Front {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_Front window = new Manager_Front();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manager_Front() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Register Customer");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Register us=new Register();
		           	us.frame.setVisible(true);
//		           	frame.setVisible(false); 
			}
		});
		btnNewButton.setBounds(115, 57, 195, 53);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnManageInventory = new JButton("Manage Inventory");
		btnManageInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Manage_Inventory us=new Manage_Inventory();
		           	us.frame.setVisible(true);
			}
		});
		btnManageInventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnManageInventory.setBounds(115, 122, 195, 53);
		frame.getContentPane().add(btnManageInventory);
		
		
		
		
		
		JButton btnNewButton_1_1 = new JButton("View Order Details");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Order_Details us=new Order_Details();
		           	us.frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(115, 185, 195, 53);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Login us=new Login();
		           	us.frame.setVisible(true);
		           	frame.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(322, 24, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
	}
}
