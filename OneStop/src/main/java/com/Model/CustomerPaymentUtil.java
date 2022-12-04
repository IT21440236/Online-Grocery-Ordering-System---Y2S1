package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerPaymentUtil {
	
	public static List<Payment> validate(String cardNumber,String cvv){
		
		ArrayList<Payment> pay = new ArrayList<>();
		
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		//validate
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con = DriverManager.getConnection(url, user, pass);
					Statement stmt = con.createStatement();
					String sql = "select * from payment where cardNumber='"+cardNumber+"'and cvv='"+cvv+"'";
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						String cardNum = rs.getString(1);
						String cardName = rs.getString(2);
						String cardType = rs.getString(3);
						String expiryDate = rs.getString(4);
						String cvvCus = rs.getString(5);
						String amount = rs.getString(6);
						
						//passing the above taken data to the p obj of the customer class
						Payment p = new Payment(cardNum, cardName, cardType, expiryDate, cvvCus, amount);
						
						//pass the p obj to the arraylist
					pay.add(p);
					}
						
				} 
				catch (Exception e) {
					e.printStackTrace();
				}	
		
		
		return pay;	
	}
	
public static boolean insertpayment(String cardNumber,String cardName,String cardType,String expiryDate,String cvv, String amount) {
		
		boolean isSuccess = false;
		
		//create database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "5544";
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "insert into payment values ('"+cardNumber+"','"+cardName+"','"+cardType+"','"+expiryDate+"','"+cvv+"','"+amount+"')";
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


}//end of CustomerPaymentUtil
