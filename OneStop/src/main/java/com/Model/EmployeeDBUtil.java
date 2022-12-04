package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDBUtil {
	
	public static List<Employee> validate(String Username, String Password) {
		
		ArrayList<Employee> emp = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pass);
				Statement stmt = con.createStatement();
				String sql = "select *from employee where username='"+Username+"' and password='"+Password+"'";
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					int eid = rs.getInt(1);
					String username = rs.getString(2);
					String email = rs.getString(3);
					String phone = rs.getString(4);
					String passU = rs.getString(5);
					
					Employee e = new Employee(eid, username, email, phone, passU );
					emp.add(e);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return emp;
		} 
	
	public static boolean insertemployee(String username, String email, String phone, String password)
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
			String sql = "insert into employee values(0,'"+username+"','"+email+"','"+phone+"','"+password+"')";
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
	
	public static boolean updateemployee(String eid, String username, String email, String phone, String password)
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
			String sql = "update employee set username = '"+username+"' ,email = '"+email+"', phone = '"+phone+"', password='"+password+"' "
					+ "where eid = '"+eid+"'";
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
	public static List<Employee> getEmployeeDetails(String Eid)
	{
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		int convertedEID = Integer.parseInt(Eid);
		ArrayList<Employee> emp = new ArrayList<>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select*from employee where eid ='"+convertedEID+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int eid = rs.getInt(1);
				String username = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String password = rs.getString(5);
				
				Employee e = new Employee(eid, username, email, phone, password);
				emp.add(e);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return emp;
	}
	
	public static boolean deleteEmployee(String eid)
	{
		boolean isSuccess = false;
		
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		int convEid = Integer.parseInt(eid);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "delete from employee where eid ='"+convEid+"'";
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
