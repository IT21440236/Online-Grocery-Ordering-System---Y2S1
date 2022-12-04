package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDBUtil {
	
	/*public static boolean validate1(String email, String password)
	{
		boolean isSuccess = false;
		String url = "jdbc:mysql://localhost:3306/onestopgrocery";
		String user = "root";
		String pass = "root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select*from customer where email = '"+email+"' and password = '"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next())
			{
				isSuccess = true;
			}
			else
			{
				isSuccess = false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public List<Customer> getCustomer(String Email)
	{
		ArrayList<Customer> customer = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/onestopgrocery";
		String user = "root";
		String pass = "root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select*from customer where email = '"+Email+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String password = rs.getString(5);
				
				Customer cus = new Customer(id,name,email,phone,password);
				customer.add(cus);
			}
		}
		catch(Exception e)
		{
			
		}
		return customer;
	}*/

	
	
	public static List<Customer> validate(String Email, String Password) {
	
	ArrayList<Customer> cus = new ArrayList<>();

	String url = "jdbc:mysql://localhost:3306/hotel";
	String user = "root";
	String pass = "5544";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select *from customer where email='"+Email+"' and password='"+Password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String passU = rs.getString(5);
				
				Customer c = new Customer(id, name, email, phone, passU );
				cus.add(c);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return cus; 
	}  
	
	/*	public static boolean validate(String Email, String Password) {
		
		boolean isSuccess = false;

		String url = "jdbc:mysql://localhost:3306/onestopgrocery";
		String user = "root";
		String pass = "root";
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pass);
				Statement stmt = con.createStatement();
				String sql = "select *from customer where email='"+Email+"' and password='"+Password+"'";
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					isSuccess = true;
				}
				else
				{
					isSuccess = false;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
	} 
	public List<Customer> getCustomer(String Email)
	{
		ArrayList<Customer> customer = new ArrayList<>();
		
		String url = "jdbc:mysql://localhost:3306/onestopgrocery";
		String user = "root";
		String pass = "root";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select*from customer where password = '"+Email+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String password = rs.getString(5);
				
				Customer cus = new Customer(id,name, email, phone, password);
				customer.add(cus);
			}
		}
		catch(Exception e)
		{
			
		}
		return customer;
	} */
	
	
	
	public static boolean insertcustomer(String name, String email, String phone, String password)
	{
		boolean isSuccess = false;
		
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
	
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "insert into customer values(0,'"+name+"','"+email+"','"+phone+"','"+password+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0)
			{
				isSuccess = true;
			}
			else
			{
				isSuccess = false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean updatecustomer(String id, String name, String email, String phone, String password)
	{
		boolean isSuccess = false; 
		
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "update customer set name = '"+name+"' ,email = '"+email+"', phone = '"+phone+"', password='"+password+"' "
					+ "where id = '"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs >0)
			{
				isSuccess = true;
			}
			else
			{
				isSuccess = false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccess;
	}
	public static List<Customer> getCustomerDetails(String Id)
	{
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		int convertedID = Integer.parseInt(Id);
		ArrayList<Customer> cus = new ArrayList<>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select*from customer where id ='"+convertedID+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String password = rs.getString(5);
				
				Customer c = new Customer(id, name, email, phone, password);
				cus.add(c);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return cus;
	}
	public static boolean deletecCustomer(String id)
	{
		boolean isSuccess = false;
		
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		int convId = Integer.parseInt(id);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "delete from customer where id ='"+convId+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r > 0)
			{
				isSuccess = true;
			}
			else
			{
				isSuccess = false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccess;
	}
}

