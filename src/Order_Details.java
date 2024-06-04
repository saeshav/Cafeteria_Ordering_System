import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Order_Details extends Person {
	 public static	File f;
		DefaultTableModel model;
	public JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order_Details window = new Order_Details();
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
	public Order_Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 416, 225);
		frame.getContentPane().add(scrollPane);
		order_num.clear();
		 order_by.clear();
		order_contact.clear();
		 order_time.clear();
		 order_feedback.clear();
		loadorder();
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order#","Order_BY", "Phone#","Time", "Feedback", 
			}
		));
		 model = (DefaultTableModel) table.getModel();
		  for(int i=0;i<order_by.size();i++) {
              
              
              
              model.addRow(new Object[]{order_num.get(i),order_by.get(i), order_contact.get(i),order_time.get(i),order_feedback.get(i),
                });
              
          }
	}

}
