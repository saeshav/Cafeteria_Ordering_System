

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Manage_Inventory extends Person {

	public static JFrame frame;
	public static JTextField item_name;
	public static JTextField item_size;
	public static JTextField item_price;
	public static JTextField item_stock;
	public static File f;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					Manage_Inventory window = new Manage_Inventory();
					window.frame.setVisible(true);
				 
	}

	/**
	 * Create the application.
	 */
	public Manage_Inventory() {
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
		load();
		JLabel lblNewLabel_1 = new JLabel("Item Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(82, 49, 74, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		item_name = new JTextField();
		item_name.setColumns(10);
		item_name.setBounds(172, 46, 145, 28);
		frame.getContentPane().add(item_name);
		
		item_size = new JTextField();
		item_size.setColumns(10);
		item_size.setBounds(172, 84, 145, 28);
		frame.getContentPane().add(item_size);
		
		JLabel lblNewLabel_1_1 = new JLabel("Size");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(82, 89, 74, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Price");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(82, 124, 74, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		item_price = new JTextField();
		item_price.setColumns(10);
		item_price.setBounds(172, 119, 145, 28);
		frame.getContentPane().add(item_price);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Stock");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(82, 161, 74, 13);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		item_stock = new JTextField();
		item_stock.setColumns(10);
		item_stock.setBounds(172, 156, 145, 28);
		frame.getContentPane().add(item_stock);
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if (item_name.getText().equals(""))
			        {
			            JOptionPane.showMessageDialog(null,"item name must be filled");
			            item_name.requestFocusInWindow();
			        }
				 else  if (item_size.getText().equals(""))
			        {
			            JOptionPane.showMessageDialog(null,"Item size must be filled");
			            item_size.requestFocusInWindow();
			        }
				 else  if (item_price.getText().equals(""))
			        {
			            JOptionPane.showMessageDialog(null,"Item size must be filled");
			            item_price.requestFocusInWindow();
			        }
				 else  if (item_stock.getText().equals(""))
			        {
			            JOptionPane.showMessageDialog(null,"item stock must be filled");
			            item_stock.requestFocusInWindow();
			        }
				
				 else if(name.contains(item_name.getText().toLowerCase()) && size.contains(item_size.getText().toLowerCase()))
				{
					  JOptionPane.showMessageDialog(null,"Item Already Registered/ Use Update Button");
				}
				else
				{
				additem();
				name.clear();
				size.clear();
				price.clear();
				stock.clear();
				sold.clear();
				item_name.setText("");
				item_size.setText("");
				item_price.setText("");
				item_stock.setText("");
				load();
				// Manage_Inventory us=new Manage_Inventory();
		          // 	us.frame.setVisible(true);
		           //	frame.setVisible(false); 
				}
			}
		});
		btnAddNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddNew.setBounds(302, 214, 98, 28);
		frame.getContentPane().add(btnAddNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index;
				index=name.indexOf(item_name.getText().toString());
				price.set(index, item_price.getText());
				stock.set(index, item_stock.getText());
				updateinfile();
				name.clear();
				size.clear();
				price.clear();
				stock.clear();
				sold.clear();
				load();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(194, 214, 98, 28);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnNewButton_1_1 = new JButton("Check Inventory");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Check_Inventory us=new Check_Inventory();
		           	us.frame.setVisible(true);
		          // 	frame.setVisible(false); 
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(22, 214, 162, 28);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblInventoryMagment = new JLabel("Inventory Magment");
		lblInventoryMagment.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInventoryMagment.setBounds(116, 10, 201, 28);
		frame.getContentPane().add(lblInventoryMagment);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  Manage_Inventory us=new Manage_Inventory();
		           	us.frame.setVisible(true);
		           	frame.setVisible(false); 
				
				
			}
		});
		btnNewButton.setBounds(327, 17, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
	public static void updateinfile()
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
	          bw.write(name.get(i)+"-"+ size.get(i)+"-"+price.get(i)+"-"+stock.get(i)+"-0");
	          bw.write(13);
	          bw.write(10);
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
	
	public static void additem()
	{
		 
		 try{
	            //Create a File
	              f=new File("inventory.txt");
	              //Check if the file already exists
	             if (!f.exists()) {
	                 f.createNewFile();

	      } else {
	       
	      }
	          FileWriter fw = new FileWriter(f.getAbsoluteFile(),true);
	          BufferedWriter bw = new BufferedWriter(fw);
	          bw.write(item_name.getText()+"-"+ item_size.getText()+"-"+item_price.getText()+"-"+item_stock.getText()+"-0");
	          bw.write(13);
	          bw.write(10);
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
