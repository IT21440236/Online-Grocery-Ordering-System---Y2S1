package com.Model;


public class Payment {
	private String cardNumber;
	private String cardName;
	private String cardType;
	private String expiryDate;//a problem might occur cuz of the Date data type
	private String cvv;
	private String amount;
	
	
	
	public Payment(String cardNumber, String cardName, String cardType, String expiryDate, String cvv,String amount) {
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cardType = cardType;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.amount = amount;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public String getCardName() {
		return cardName;
	}



	public String getCardType() {
		return cardType;
	}



	public String getExpiryDate() {
		return expiryDate;
	}
	
	public String getcvv() {
		return cvv;
	}



	public String getAmount() {
		return amount;
	}

}//end of Payment class
