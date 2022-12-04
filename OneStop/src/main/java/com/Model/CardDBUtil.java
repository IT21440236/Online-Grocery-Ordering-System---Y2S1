package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CardDBUtil {
	
	//VALIDATION USING JS CODE STARTS HERE
	public static boolean validate(String cardNumber, String password) {
	
		/*since this validate method should return a boolean value
		 we should declare a boolean variable and return it 
		 */
		boolean isSuccess = false;
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		try {
			
			/*Registering the driver using java's Class.forName method
			 to dynamically load the driver's class file into memory, which automatically
			registers it. */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*After the driver is loaded to the memory a connection to the database could be
			established using the DriverManager.getConnection() method.
			▪ There are three parameters to the method which are URL of the database, user
			name and the password*/
			Connection con = DriverManager.getConnection(url, user, pass);
			
			//provide methods to execute queries with the DB 
			Statement stmt = con.createStatement();
			String sql = "select * from card where cardnumber='"+cardNumber+"'and password='"+password+"'";
			
			/*ResultSet is a set of results returned by the database in response to a SQL query.*/ 
			ResultSet rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
			
			//The Exception class can tackle all the types of errors we might encounter.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	
	//////////////////////////////////////////
	public static List<Card> getCard(String password) {
		
		ArrayList<Card> card = new ArrayList<>();
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
				
				
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select * from card where password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String cardNum = rs.getString(1);
				String expirydate = rs.getString(2);
				String cvv = rs.getString(3);
				String name = rs.getString(4);
				String passU = rs.getString(5);
				
				//passing the values we obtained from the DB to the constructor of Card
				Card c = new Card(cardNum, expirydate, cvv, name, passU);
				
				//passing a card obj to the arraylist object we created
				card.add(c);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//returning the customer arrayList
		return card;
	}
	
	
	// VALIDATION USING JS CODE ENDS HERE
	
	
	
	//FOR INSERTING OF CARD DETAILS INTO THE DB - INSERT OPTION OF CRUD
	public static boolean insertCARD(String cardNum,String expirydate,String cvv,String name,String password) {
		
		boolean isSuccess = false;
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "insert into card values ('"+cardNum+"','"+expirydate+"','"+cvv+"','"+name+"','"+password+"')";
			int rs = stmt.executeUpdate(sql);
			
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
					
		}
		catch (Exception e) {
			e.printStackTrace(); //Number format exception
		}
		
		return isSuccess;
	}
	
	
	//FOR UPDATING OF CARD DETAILS  - UPDATE OPTION OF CRUD
	public static boolean updatecard(String cardNumber, String expiryDate, String cvv, String name, String Password) {
		
		
		boolean isSuccess = false;
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "update card set cardnumber='"+cardNumber+"' ,expirydate='"+expiryDate+"', cvv='"+cvv+"' ,name='"+name+"'"
					+ "where password='"+Password+"'";
			int rs = stmt.executeUpdate(sql);
			
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	
	
	//FOR RETRIEVING OF CARD DETAILS FROM THE CARD DETAILS TABLE - SELECT/RETRIEVE OPTION OF CRUD
	public static List<Card> getCardDetails(String password)  {
		
		ArrayList<Card> card = new ArrayList<>();
		
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "select * from card where password='"+password+"'";
			ResultSet rs = stmt.executeQuery(sql); //only for select we use executeQuery
			
			while(rs.next()) {
				String cardNum = rs.getString(1);
				String expirydate = rs.getString(2);
				String cvv = rs.getString(3);
				String name = rs.getString(4);
				String passU = rs.getString(5);
				
				
				Card c = new Card(cardNum, expirydate, cvv, name, passU);
				card.add(c);
			}	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return card;
	}
	
	
	//FOR DELETING OF CARD DETAILS FROM THE DB - DELETE OPTION OF CRUD
	public static boolean deleteCard(String password) {
		
		boolean isSuccess = false;
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "delete from card where password='"+password+"'";
			int rs = stmt.executeUpdate(sql);
			
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	

}//end of CardDBUtil