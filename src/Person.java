import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Person {
	public static ArrayList<String> name=new ArrayList();
	public static ArrayList<String> size=new ArrayList();
	public static ArrayList<String> price=new ArrayList();
	public static ArrayList<String> stock=new ArrayList();
	public static ArrayList<String> sold=new ArrayList();
	
	public static ArrayList<String> order_num=new ArrayList();
	public static ArrayList<String> order_by=new ArrayList();
	public static ArrayList<String> order_contact=new ArrayList();
	public static ArrayList<String> order_time=new ArrayList();
	public static ArrayList<String> order_feedback=new ArrayList();
	
	public static int order_no=0;
	 public static void load()
		{
			  String line = "";
		      String mydata = null;
		      ArrayList data=new ArrayList();
		        try
		        {
		            FileReader fileReader = new FileReader("inventory.txt");
		            
		            // always wrap the FileReader in BufferedReader
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		            
		            while((line = bufferedReader.readLine()) != null)
		            {
//		                System.out.println(line);
		                String[] parts = line.split("-");
		                name.add(parts[0].toLowerCase()) ; // 004
		                size.add(parts[1].toLowerCase());
		                price.add(parts[2].toLowerCase());
		                stock.add(parts[3].toLowerCase());
		                sold.add(parts[4].toLowerCase());
		                System.out.println(parts[0]);
		                System.out.println(parts[1]);
		                System.out.println(parts[2]);
		                System.out.println(parts[3]);
//		                String part2 = parts[1];
//		                data.add(line);
		            }
//		              System.out.println(String.join("\n", data));
		            
//		              mydata=String.join("\n", data);
		            // always close the file after its use
		            bufferedReader.close();
		        }
		        catch(IOException ex)
		        {
		            System.out.println("\nError occurred");
		            System.out.println("Exception Name: " +ex);
		        }
		       
		}	
	 public static void loadorder()
		{
			  String line = "";
		      String mydata = null;
		      ArrayList data=new ArrayList();
		        try
		        {
		            FileReader fileReader = new FileReader("orders.txt");
		            
		            // always wrap the FileReader in BufferedReader
		            BufferedReader bufferedReader = new BufferedReader(fileReader);
		            
		            while((line = bufferedReader.readLine()) != null)
		            {
//		                System.out.println(line);
		                String[] parts = line.split("-");
		                order_num.add(parts[0]) ;
		                order_by.add(parts[1]) ; // 004
		                order_contact.add(parts[2]);
		                order_time.add(parts[3]);
		                order_feedback.add(parts[4]);
		                System.out.println(parts[0]);
		                System.out.println(parts[1]);
		                System.out.println(parts[2]);
		                order_no++;
//		                String part2 = parts[1];
//		                data.add(line);
		            }
//		              System.out.println(String.join("\n", data));
		            
//		              mydata=String.join("\n", data);
		            // always close the file after its use
		            bufferedReader.close();
		        }
		        catch(IOException ex)
		        {
		            System.out.println("\nError occurred");
		            System.out.println("Exception Name: " +ex);
		        }
		       
		}	
		
	
	

}
