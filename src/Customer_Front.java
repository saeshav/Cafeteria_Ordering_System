import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_Front {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_Front window = new Customer_Front();
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
	public Customer_Front() {
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
		
		JButton btnBilling = new JButton("Billing");
		btnBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Billing us=new Billing();
		           	us.frame.setVisible(true);
		          
			}
		});
		btnBilling.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBilling.setBounds(102, 77, 195, 53);
		frame.getContentPane().add(btnBilling);
		
		JButton btnViewOrdersfeedback = new JButton("View Orders/FeedBack");
		btnViewOrdersfeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Own_Order_Details us=new Own_Order_Details();
	           	us.frame.setVisible(true);
	           	
			}
		});
		btnViewOrdersfeedback.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewOrdersfeedback.setBounds(102, 142, 195, 53);
		frame.getContentPane().add(btnViewOrdersfeedback);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Login us=new Login();
		           	us.frame.setVisible(true);
		           	frame.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(309, 44, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
	}
}
