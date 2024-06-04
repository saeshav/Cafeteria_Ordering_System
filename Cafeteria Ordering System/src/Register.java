

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class Register {

	public static JFrame frame;
	private static JTextField name;
	private static JTextField pass;
	private static JTextField phone;
	 public static File f;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					Register window = new Register();
					window.frame.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public Register() {
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
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegister.setBounds(163, 21, 115, 28);
		frame.getContentPane().add(lblRegister);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(163, 71, 145, 28);
		frame.getContentPane().add(name);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(73, 74, 74, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(73, 114, 74, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(163, 109, 145, 28);
		frame.getContentPane().add(pass);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(163, 147, 145, 28);
		frame.getContentPane().add(phone);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phone No.");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(73, 152, 74, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (name.getText().isEmpty())
			        {
			            JOptionPane.showMessageDialog(null,"Name must be filled");
			            name.requestFocusInWindow();
			        }
				 else if (pass.getText().isEmpty())
			        {
			            JOptionPane.showMessageDialog(null,"Password must be filled");
			            pass.requestFocusInWindow();
			        }
				 else if (phone.getText().isEmpty())
			        {
			            JOptionPane.showMessageDialog(null,"Phone No. must be filled");
			            phone.requestFocusInWindow();
			        }
				 else
					 adduser();
				
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(146, 201, 138, 28);
		frame.getContentPane().add(btnRegister);
	}
	public static void adduser()
	{
		 
		 try{
	            //Create a File
	              f=new File("users.txt");
	              //Check if the file already exists
	             if (!f.exists()) {
	                 f.createNewFile();

	      } else {
	       
	      }
	          FileWriter fw = new FileWriter(f.getAbsoluteFile(),true);
	          BufferedWriter bw = new BufferedWriter(fw);
	          bw.write(name.getText()+"-"+ pass.getText()+"-"+phone.getText());
	          bw.write(13);
	          bw.write(10);
	          bw.close();
	          JOptionPane.showMessageDialog(null,"Registered Successfully");
	          Login us=new Login();
	           	us.frame.setVisible(true);
	           	frame.setVisible(false); 
	         
	                    
	    }
	        catch(Exception e)
	               {
	                   e.printStackTrace();
	               }  
	}
}
