import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Own_Order_Details extends Person {
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
					Own_Order_Details window = new Own_Order_Details();
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
	public Own_Order_Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		order_num.clear();
		 order_by.clear();
		order_contact.clear();
		 order_time.clear();
		 order_feedback.clear();
		loadorder();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 522, 202);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected_row=table.getSelectedRow(); 
		       String or_num= (String) table.getValueAt(selected_row, 0);
		       
		       int index=order_num.indexOf(or_num);
		      if (order_feedback.get(index).equals("Nil"))
		      {
		       String feedback=JOptionPane.showInputDialog("Write down your feedback of this order");
		       order_feedback.set(index, feedback);
		       updateorders();
		       frame.setVisible(false);
		      }
		      else
		    	  JOptionPane.showMessageDialog(null, "FeedBack Already Submitted");
			}
		});
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
	              
	              
	              if(order_by.get(i).equals(Login.loginname) && order_contact.get(i).equals(Login.logincontact))
	             {
	              model.addRow(new Object[]{order_num.get(i),order_by.get(i), order_contact.get(i),order_time.get(i),order_feedback.get(i),
	                });
	              }
	              System.out.print(Login.loginname+"\n"+Login.logincontact);
	          }
		
		
		
		
		System.out.print(order_no);
		JLabel lblNewLabel = new JLabel("Click On Order to Give FeedBack");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 256, 28);
		frame.getContentPane().add(lblNewLabel);
			
          
			
	}
	public static void updateorders()
	{
		 
		 try{
	            //Create a File
	              f=new File("orders.txt");
	              //Check if the file already exists
	             if (!f.exists()) {
	                 f.createNewFile();

	      } else {
	       
	      }
	          FileWriter fw = new FileWriter(f.getAbsoluteFile(),false);
	          BufferedWriter bw = new BufferedWriter(fw);
	       //   bw.write("Date: "+date.getText()+"     Time:"+ time.getText());
	         // bw.write(13);
 	        //  bw.write(10);
	          for(int i=0;i<order_by.size();i++)
	          {
 	          bw.write(order_num.get(i)+"-"+order_by.get(i)+"-"+order_contact.get(i)+"-"+order_time.get(i)+"-"+order_feedback.get(i));
	          bw.write(13);
	          bw.write(10);
	          }
 	        
	          bw.close();
	      
	          
	         
	                    
	    }
	        catch(Exception e)
	               {
	                   e.printStackTrace();
	               }  
	}
}
