package com.taashee.training;
import java.util.*;
import com.taashee.training.dao.UserDAO;
public class App 
{
	static UserDAO userDAO = new UserDAO(); 
    public static void main( String[] args )
    {
        launchJDBCAppConsole();
    }
    private static void launchJDBCAppConsole()
    {
    	System.out.println("Welcome to JDBC ConsoleApp");
    	String input="-1";
    	while(input!= "0")
    	{
    		System.out.println("\nSelect the task you wish to perform");
    		System.out.println("1. Fetch all users");
    		System.out.println("2. Get User By Name");
    		System.out.println("3. Insert a new User");
    		System.out.println("4. Update User");
    		System.out.println("5. Delete User");
    		System.out.println("6. Search User");
    		System.out.println("7. Exit");
    		Scanner sc=new Scanner(System.in);
    		input=sc.nextLine();
    		String name="";
			String city="";
    		switch(input)
    		{	
    			case "1":
    				userDAO.getAllUsers();
    				break;
    			case "2":
    				System.out.println("Enter a name");
    				String namee=sc.nextLine();
    				userDAO.getUserByName(namee);
    				break;
    			case "3":
    				System.out.println("Enter a name");
    				name=sc.nextLine();
    				System.out.println("Enter city");
    				city=sc.nextLine();
    				userDAO.addUser(name, city);
    				break;
    			case "4":
    				System.out.println("Enter id");
    				int id=sc.nextInt();
    				System.out.println("Enter name");
    				name=sc.next();
    				System.out.println("Enter city");
    				city=sc.next();
    				userDAO.UpdateUser(id,name,city);
    				break;
    			case "5":
    				System.out.println("Enter a User to delete");
    				String user=sc.nextLine();
    				userDAO.deleteUser(user);
    				break;
    			case "6":
    				System.out.println("Enter name to search");
    				name=sc.next();
    				System.out.println("Enter city to search");
    				city=sc.next();
    				userDAO.SearchUser(name,city);
    			case "0":
    				break;
    		}
    		//sc.close();
    	}
    }
}
