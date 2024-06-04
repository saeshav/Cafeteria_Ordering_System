


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;



public class Billing extends Person {
   public static	File f;
	DefaultTableModel model;
	public JFrame frame;
	private JTable table;
	 java.sql.Connection con;
	    java.sql.Statement st;
	    public static String item_na;
	    public static int index;
	    private JLabel lblNewLabel;
	    private JButton btnNewButton;
	    private JLabel lblQuantity;
	    private JTextField qty;
	    private JButton btnAddToCart;
	    private JButton btnCart;
	    public String item_name,item_size,item_price,item_stock;
	    boolean check=false;
		public static ArrayList<String> arr_name=new ArrayList();
		public static ArrayList<String>  arr_size=new ArrayList();
		public static ArrayList<String>  arr_price=new ArrayList();
		public static ArrayList<String>  arr_qty=new ArrayList();
		private JLabel lblBasketItems;
		private JLabel basketitems;
		private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Billing window = new Billing();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public Billing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 493);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  
			}
		});
		scrollPane.setBounds(29, 88, 659, 280);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selected_row=table.getSelectedRow(); ;
		        item_name= (String) table.getValueAt(selected_row, 0);
		        item_size=(String) table.getValueAt(selected_row, 1);
		        item_price=(String) table.getValueAt(selected_row, 2);
		        item_stock=(String) table.getValueAt(selected_row, 3);
		        check=true;
				
			}
		});
		
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item_Name", "Size", "Price", "Stock"
			}
		));
		
		lblNewLabel = new JLabel("Item Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 39, 104, 20);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(29, 396, 96, 20);
		frame.getContentPane().add(lblQuantity);
		
		qty = new JTextField();
		qty.setColumns(10);
		qty.setBounds(123, 396, 96, 25);
		frame.getContentPane().add(qty);
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (qty.getText().isEmpty())
			        {
			            JOptionPane.showMessageDialog(null,"Quantity must be filled");
			            qty.requestFocusInWindow();
			        }
				 else if(check==true)
				 {
				
					 if(Integer.parseInt(qty.getText().toString())<=Integer.parseInt(item_stock))
					 {
						 arr_name.add(item_name);
						 arr_size.add(item_size);
						 arr_price.add(item_price);
						 arr_qty.add(qty.getText());
						basketitems.setText(Integer.toString(arr_name.size()));
						 updatebasket();
						 check=false; 
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null,"Your Entered Quantity is More then Stock"); 
					 }
					
					
					 
				 }
				 else
					 JOptionPane.showMessageDialog(null,"Select an item First");
				
				
			}
		});
		btnAddToCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddToCart.setBounds(229, 394, 142, 25);
		frame.getContentPane().add(btnAddToCart);
		
		btnCart = new JButton("View Basket");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ViewBasket us=new ViewBasket();
		           	us.frame.setVisible(true);
//		           	frame.setVisible(false); 
				
				
				
			}
		});
		btnCart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCart.setBounds(566, 394, 122, 25);
		frame.getContentPane().add(btnCart);
		
		lblBasketItems = new JLabel("Basket Items");
		lblBasketItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblBasketItems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBasketItems.setBounds(372, 396, 114, 20);
		frame.getContentPane().add(lblBasketItems);
		
		basketitems = new JLabel("0");
		basketitems.setFont(new Font("Tahoma", Font.PLAIN, 16));
		basketitems.setBounds(489, 396, 70, 20);
		frame.getContentPane().add(basketitems);
		
		btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arr_name.clear();
				arr_size.clear();
				arr_price.clear();
				arr_qty.clear();
				
				 Billing us=new Billing();
		           	us.frame.setVisible(true);
		           	frame.setVisible(false); 
				
			}
		});
		btnNewButton_1.setBounds(614, 38, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		
		
		
		 model = (DefaultTableModel) table.getModel();
		 
		
		name.clear();
		size.clear();
		price.clear();
		stock.clear();
		sold.clear();
		load();
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 41, 152, 21);
		frame.getContentPane().add(comboBox);
		btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (comboBox.getSelectedItem().equals(""))
			        {
			            JOptionPane.showMessageDialog(null,"Select soemthing to Search");
//			            search_name.requestFocusInWindow();
			        }
				 else
				 {
					if(name.contains(comboBox.getSelectedItem().toString()))
					{
						System.out.print("found");
						index=name.indexOf(comboBox.getSelectedItem().toString());
						
								
								
						model.setRowCount(0);
						model.addRow(new Object[]{name.get(index), size.get(index),price.get(index),
			                       stock.get(index),sold.get(index)});
						
					}
					else
						System.out.print("not found");
						
				 }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(342, 41, 104, 25);
		frame.getContentPane().add(btnNewButton);
		for(int i=0;i<name.size();i++)
		{
			comboBox.addItem(name.get(i));
		}
         try{
             
              
        	
        	 model.setRowCount(0);
              for(int i=0;i<name.size();i++) {
                    
                   
              
                    model.addRow(new Object[]{name.get(i), size.get(i),price.get(i),
                       stock.get(i)});
                    
                }
              
           //jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           
          
          
          
//           JOptionPane.showInputDialog(null, new JScrollPane(table));
         }
         catch(Exception e)
        {}
		
	}
	public static void updatebasket()
	{
	
		System.out.print(arr_name.get(0)+ arr_name.size() );
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
	          for(int i=0;i<name.size();i++)
	          {
	        	  if(i==index)
	        	  {
	        		  System.out.print(item_na);
	        		 System.out.print("found");        			
	        	  }
	        	  else {
	        	
	          bw.write(name.get(i)+"-"+ size.get(i)+"-"+price.get(i)+"-"+stock.get(i)+"-0");
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
