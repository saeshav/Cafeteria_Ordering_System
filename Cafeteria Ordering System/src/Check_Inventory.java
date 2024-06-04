


import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;



public class Check_Inventory {
	DefaultTableModel model;
	public static JFrame frame;
	private JTable table;
	 java.sql.Connection con;
	    java.sql.Statement st;
	    private JLabel lblNewLabel;
	    public static String item_na;
	    public static int index;
	    public static File f;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					Check_Inventory window = new Check_Inventory();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public Check_Inventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 380);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 566, 297);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item_Name", "Size", "Price", "Stock", "Sold"
			}
		));
		
		
		
		
		
		 model = (DefaultTableModel) table.getModel();
		 
		 table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
					 String[] options = new String[] {"Delete", "Cancel"};
					    int response = JOptionPane.showOptionDialog(null, "Choose Appropriate Option", "Actions",
					        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					        null, options, options[0]);
					if(response==0)
					{
						
					
					
				        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to cancel the insurance?","WARNING",JOptionPane.YES_NO_OPTION);
						
						if(dialogButton == JOptionPane.YES_OPTION) {
							int selected_row=table.getSelectedRow(); 
					        item_na= (String) table.getValueAt(selected_row, 0);
					        System.out.print(item_na);
							index=Manage_Inventory.name.indexOf(item_na);
//							name.set(index,"");
//						    size.set(index,"");
//						    price.set(index,"");
//						    stock.set(index,"");
//						    sold.set(index, "");
					         //Deleting row from sales_items
						    updatefile();
					         model.setRowCount(0);
					            Check_Inventory ad=new Check_Inventory();
								ad.frame.setVisible(true);
								frame.setVisible(false);
					          
					           }else {}
				    
				    
						
					}
					else if(response==1)
					{
						
						
					}
					else if(response==3)
					{
						
					}
					
					
					

				}
			});
		lblNewLabel = new JLabel("Note** : Click on Any Item to Delete");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 13, 290, 13);
		frame.getContentPane().add(lblNewLabel);
		Manage_Inventory.name.clear();
		Manage_Inventory.size.clear();
		Manage_Inventory.price.clear();
		Manage_Inventory.stock.clear();
		Manage_Inventory.sold.clear();
		Manage_Inventory.load();
         try{
             
              
        	
        	 model.setRowCount(0);
              for(int i=0;i<Manage_Inventory.name.size();i++) {
                    
                   
              
                    model.addRow(new Object[]{Manage_Inventory.name.get(i), Manage_Inventory.size.get(i),Manage_Inventory.price.get(i),
                    		Manage_Inventory.stock.get(i),Manage_Inventory.sold.get(i)});
                    
                }
              
           //jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           
          
          
          
//           JOptionPane.showInputDialog(null, new JScrollPane(table));
         }
         catch(Exception e)
        {}
		
	}
	public static void updatefile()
	{
		 try{
	            //Create a File
	              f=new File("inventory.txt");
	              //Check if the file already exists
	             if (!f.exists()) {
	                 f.createNewFile();

	      } else {
	       
	      }
	          FileWriter fw = new FileWriter(f.getAbsoluteFile(),false);
	          BufferedWriter bw = new BufferedWriter(fw);
	          for(int i=0;i<Manage_Inventory.name.size();i++)
	          {
	        	  if(i==index)
	        	  {
	        		  System.out.print(item_na);
	        		 System.out.print("found");        			
	        	  }
	        	  else {
	        	
	          bw.write(Manage_Inventory.name.get(i)+"-"+ Manage_Inventory.size.get(i)+"-"+Manage_Inventory.price.get(i)+"-"+Manage_Inventory.stock.get(i)+"-0");
	          bw.write(13);
	          bw.write(10);
	        	  }
	          }
	          bw.close();
	          JOptionPane.showMessageDialog(null,"Item Added Successfully");
//	          Login us=new Login();
//	           	us.frame.setVisible(true);
//	           	frame.setVisible(false); 
	         
	                    
	    }
	        catch(Exception e)
	               {
	                   e.printStackTrace();
	               }  
	}
}
