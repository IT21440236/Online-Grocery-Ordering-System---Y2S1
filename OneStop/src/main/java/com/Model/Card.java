package com.Model;

/*Encapsulation of all the variables and methods related to the 
Card Class*/

public class Card {
	
	private String cardnumber;
	private String expirydate;
	private String cvv;
	private String name;
	private String password;
	
	public Card(String cardnumber, String expirydate, String cvv, String name, String password) {
		super();
		this.cardnumber = cardnumber;
		this.expirydate = expirydate;
		this.cvv = cvv;
		this.name = name;
		this.password = password;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public String getExpirydate() {
		return expirydate;
	}

	public String getCvv() {
		return cvv;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
}//end of Card Class
