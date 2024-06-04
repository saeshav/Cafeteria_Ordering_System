


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login {
	public static ArrayList<String> names=new ArrayList();
	public static ArrayList<String> password=new ArrayList();
	public static ArrayList<String> contacts=new ArrayList();
	public static String loginname,logincontact;
//	public static String username;
	public static JFrame frame;
	private static JTextField name;
	private static JTextField pass;
	java.sql.Connection con;
    java.sql.Statement st;
   
 
    public void load()
	{
		  String line = "";
	      String mydata = null;
	      ArrayList data=new ArrayList();
	        try
	        {
	            FileReader fileReader = new FileReader("users.txt");
	            
	            // always wrap the FileReader in BufferedReader
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            
	            while((line = bufferedReader.readLine()) != null)
	            {
//	                System.out.println(line);
	                String[] parts = line.split("-");
	                names.add(parts[0]) ; // 004
	                password.add(parts[1]);
	                contacts.add(parts[2]);
	                System.out.println(parts[0]);
	                System.out.println(parts[1]);
	                System.out.println(parts[2]);
//	                String part2 = parts[1];
//	                data.add(line);
	            }
//	              System.out.println(String.join("\n", data));
	            
//	              mydata=String.join("\n", data);
	            // always close the file after its use
	            bufferedReader.close();
	        }
	        catch(IOException ex)
	        {
	            System.out.println("\nError occurred");
	            System.out.println("Exception Name: " +ex);
	        }
	       
	}	
	
    
    
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Login window = new Login();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public Login() {
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
	load();
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(152, 20, 115, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(55, 77, 74, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(55, 130, 74, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		name = new JTextField();
		name.setBounds(145, 74, 182, 28);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(145, 125, 182, 28);
		frame.getContentPane().add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index;
				boolean check=false;
		;
				 if(name.getText().toString().equals("admin") && pass.getText().toString().equals("admin"))
				    {
					 Manager_Front us=new Manager_Front();
			           	us.frame.setVisible(true);
			           	frame.setVisible(false); 
				    }
				    
				    
				 else if(names.contains(name.getText().toString()))
				    {
				    	index=names.indexOf(name.getText().toString());
				    	if(password.get(index).equals(pass.getText().toString()))
				    		{
				    		check=true;
				    		loginname=names.get(index);
				    		logincontact=contacts.get(index);
				    		}
				    	
				    }
				    if(check==true)
				    {
//				    	loginname=name.getText();
				    	 Customer_Front us=new Customer_Front();
				           	us.frame.setVisible(true);
				           	frame.setVisible(false); 
				    }
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(169, 176, 98, 28);
		frame.getContentPane().add(btnNewButton);
	}
}
