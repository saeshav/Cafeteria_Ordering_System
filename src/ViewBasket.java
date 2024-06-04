


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;



public class ViewBasket extends Billing{
	DefaultTableModel model;
	public static JFrame frame;
	public static JTable table;
	 java.sql.Connection con;
	    java.sql.Statement st;
	    private static JLabel lblNewLabel;
	    public static String item_na;
	    public static int index;
	    public JButton btnNewButton;
	    public static JLabel lblNetTotal;
	    public static JLabel net_bill;
	    public static JLabel lblVat;
	    public static JLabel tax;
	    public static JLabel lblGrandTotal;
	    public static JLabel grand_tot;
	    public static JButton btnNewButton_1;
	    public static JLabel lblDate;
	    public static JLabel lblTime;
	    public static JLabel date;
	    public static JLabel time;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					ViewBasket window = new ViewBasket();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public ViewBasket() {
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
		order_num.clear();
		 order_by.clear();
		order_contact.clear();
		 order_time.clear();
		 order_feedback.clear();
		 order_no=0;
		loadorder();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 566, 216);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item_Name", "Size", "Price", "Quantiy"
			}
		));
		
		 model = (DefaultTableModel) table.getModel();
		 try{
             
             
	        	
        	 model.setRowCount(0);
              for(int i=0;i<name.size();i++) {
                    
                   
              
                    model.addRow(new Object[]{arr_name.get(i), arr_size.get(i),arr_price.get(i),
                    		arr_qty.get(i)});
                    
                }
              
           //jTable1.setModel(DbUtils.resultSetToTableModel(rs));
           
          
          
          
//           JOptionPane.showInputDialog(null, new JScrollPane(table));
         }
         catch(Exception e)
        {}
		
		
		
		
		

		lblNewLabel = new JLabel("Items in cart");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(10, 13, 290, 13);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Check Out and Pay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 generatebill();
				   
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(389, 278, 170, 41);
		frame.getContentPane().add(btnNewButton);
		
		lblNetTotal = new JLabel("Net Total");
		lblNetTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNetTotal.setBounds(206, 262, 101, 20);
		frame.getContentPane().add(lblNetTotal);
		
		net_bill = new JLabel("0");
		net_bill.setFont(new Font("Tahoma", Font.PLAIN, 16));
		net_bill.setBounds(322, 262, 57, 20);
		frame.getContentPane().add(net_bill);
		
		lblVat = new JLabel("VAT-10%");
		lblVat.setHorizontalAlignment(SwingConstants.CENTER);
		lblVat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblVat.setBounds(206, 285, 114, 20);
		frame.getContentPane().add(lblVat);
		
		tax = new JLabel("0");
		tax.setForeground(Color.RED);
		tax.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tax.setBounds(322, 285, 57, 20);
		frame.getContentPane().add(tax);
		
		lblGrandTotal = new JLabel("Grand Total");
		lblGrandTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrandTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrandTotal.setBounds(206, 311, 101, 20);
		frame.getContentPane().add(lblGrandTotal);
		
		grand_tot = new JLabel("0");
		grand_tot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		grand_tot.setBounds(322, 313, 57, 20);
		frame.getContentPane().add(grand_tot);
		
		btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ViewBasket us=new ViewBasket();
		           	us.frame.setVisible(true);
		           	frame.setVisible(false); 
			}
		});
		btnNewButton_1.setBounds(491, 5, 85, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(10, 274, 49, 20);
		frame.getContentPane().add(lblDate);
		
		lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTime.setBounds(10, 299, 49, 20);
		frame.getContentPane().add(lblTime);
		
		date = new JLabel("Net Total");
		date.setFont(new Font("Tahoma", Font.PLAIN, 13));
		date.setBounds(60, 274, 101, 20);
		frame.getContentPane().add(date);
		
		time = new JLabel("Net Total");
		time.setFont(new Font("Tahoma", Font.PLAIN, 13));
		time.setBounds(60, 299, 101, 20);
		frame.getContentPane().add(time);
		name.clear();
		size.clear();
		price.clear();
		stock.clear();
		sold.clear();
		load();
		float sales,total_sales = 0,grand_total = 0;
		  for(int i=0;i<table.getRowCount();i++)
	        {
	            sales=Float.parseFloat(table.getValueAt(i,2).toString());
	            total_sales=total_sales+sales*Float.parseFloat(table.getValueAt(i,3).toString());
	        
	           
	            net_bill.setText(Float.toString((int)Math.round(total_sales)));
	            tax.setText(Float.toString((float) (total_sales*(10.0/100.0))));
	            grand_total=(float) (total_sales-(total_sales*(10.0/100.0)));
	            grand_tot.setText(Float.toString(grand_total));
	        }
		  
		  
		  String pattern = "hh:mm a";

	        // Create an instance of SimpleDateFormat used for formatting
	        // the string representation of date according to the chosen pattern
	        DateFormat df = new SimpleDateFormat(pattern);

	        // Get the today date using Calendar object.
	        Date today = Calendar.getInstance().getTime();
	        // Using DateFormat format method we can create a string
	        // representation of a date with the defined format.
	        String todayAsString = df.format(today);

	        // Print it!
//	        time.setText(todayAsString);
	        LocalDate localDate = LocalDate.now();
	        String d=DateTimeFormatter.ofPattern("dd-MM-yyy").format(localDate);
	        date.setText(d);
	        time.setText(todayAsString);
	        
	        JSeparator separator = new JSeparator();
	        separator.setBounds(206, 303, 132, 2);
	        frame.getContentPane().add(separator);
		
	}
	public static void generateorderdetails()
	{
		 try{
	            //Create a File
	              f=new File(Login.loginname+"_"+Login.logincontact+".txt");
	              //Check if the file already exists
	             if (!f.exists()) {
	                 f.createNewFile();

	      } else {
	       
	      }
	          FileWriter fw = new FileWriter(f.getAbsoluteFile(),true);
	          BufferedWriter bw = new BufferedWriter(fw);
		  bw.write ("No. Item Name     Size   Qty  Price");
          bw.write(13);
          bw.write(10);
          bw.write("-------------------------------------");
          bw.write(13);
          bw.write(10);
          for(int i=0;i<table.getRowCount();i++){
        	  bw.write(i+1+"-"+table.getValueAt(i, 0)+"-"+ table.getValueAt(i, 1)+"-"+table.getValueAt(i, 3)+"-"+table.getValueAt(i, 2)+"-"+grand_tot.getText());
 	          bw.write(13);
 	          bw.write(10);
        	  
        	  
        	  
          }
     //     bw.write("Net Bil: "+ net_bill.getText());
      //    bw.write(13);
	  //        bw.write(10);
	  //       bw.write("Tax: "+ tax.getText());
      //    bw.write(13);
      //    bw.write(10);
       //   bw.write("Grand Total: "+ grand_tot.getText());
       //   bw.write(13);
	    //      bw.write(10);
	          bw.close();
	          JOptionPane.showMessageDialog(null,"Bill Created Successfully");
	          Billing us=new Billing();
	           frame.setVisible(false);
//	           	us.frame.setVisible(true);
	           	frame.setVisible(false); 
	            JOptionPane.showMessageDialog(null,"Refresh the panel before Shopping More");
		  }
	        catch(Exception e)
	               {
	                   e.printStackTrace();
	               }  
	}
	public static void generatebill()
	{
		 
		 try{
	            //Create a File
	              f=new File("orders.txt");
	              //Check if the file already exists
	             if (!f.exists()) {
	                 f.createNewFile();

	      } else {
	       
	      }
	          FileWriter fw = new FileWriter(f.getAbsoluteFile(),true);
	          BufferedWriter bw = new BufferedWriter(fw);
	       //   bw.write("Date: "+date.getText()+"     Time:"+ time.getText());
	         // bw.write(13);
 	        //  bw.write(10);
 	          bw.write(order_no+1+"-"+Login.loginname+"-"+Login.logincontact+"-"+time.getText()+"-"+"Nil");
	          bw.write(13);
	          bw.write(10);
	        generateorderdetails();
 	        
	          bw.close();
	      
	            updatestock();
	         
	                    
	    }
	        catch(Exception e)
	               {
	                   e.printStackTrace();
	               }  
	}
	public static void updatestock()
	{
		 for(int i=0;i<table.getRowCount();i++){
		index=name.indexOf(table.getValueAt(i, 0));
		int leftstock=Integer.parseInt(stock.get(index))-Integer.parseInt((String) table.getValueAt(i, 3));
		stock.set(index, Integer.toString(leftstock));
		int totalsold=Integer.parseInt(sold.get(index));
		totalsold=totalsold+Integer.parseInt((String) table.getValueAt(i, 3));
		sold.set(index, Integer.toString(totalsold));
		System.out.print(stock.get(index));
		updatefile();
		 }
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
	        	
	        	
	          bw.write(name.get(i)+"-"+ size.get(i)+"-"+price.get(i)+"-"+stock.get(i)+"-"+sold.get(i));
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
