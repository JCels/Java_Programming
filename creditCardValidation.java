/*
* Date: October 2016
* Author: Jasmien Cels
* Purpose: UCL COMPGC01 Java Tutorial
*/

package CreditCard;

import java.util.Calendar;
import java.util.Arrays;

public class creditCard {

	//data fields as private instance variables
	private int expiryMonth; 
	private int expiryYear; 
	private String firstName; 
	private String lastName;
	private String ccNumber;
	
	//defualt constructor 
	public  creditCard(){
		
	}
	
	//5-argument constructor 
	public creditCard(int expiryMonth, int expiryYear, String firstName, String lastName, String ccNumber){
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ccNumber = ccNumber; 
	}
	
	// Method to format the Expiry Date
	 public String formatExpiryDate() {
		 String[] arrYear = Integer.toString(expiryYear).split(""); //turn int into string array and split by element
		  String ex = new String(expiryMonth + "/" + arrYear[2] + arrYear[3]);
		  return ex;
	 }
	 
	 public String formatFullName() {
		 return firstName + " " + lastName;
	 }
	
	public String formatCCNumber() {
		String[] CCArray = ccNumber.split("");
		
		String ccNum = new String( CCArray[0] + CCArray[1] + CCArray[2] +CCArray[3] + " "+ 
				CCArray[4] + CCArray[5] + CCArray[6] + CCArray[7] + " " +
				CCArray[8] + CCArray[9] + CCArray[10] +CCArray[11] + " "  + 
				CCArray[12] + CCArray[13] + CCArray[14] +CCArray[15] );

		return ccNum;
	}
	
	public boolean isValid() {
		
		boolean validation = false;
		
		Calendar time = Calendar.getInstance();
		if (expiryYear > time.get(Calendar.YEAR)){ 
			validation = true;
			if (expiryMonth > time.get(Calendar.MONTH)){
					validation = true;
		}
		}
		else validation = false;
		
		return validation;
	}
	
	public String toString() {
		String s = new String ();
		s += ("Number: " + ccNumber + " "); 
		s += ("\n" + "Expiry Date: " + formatExpiryDate() + " ");
		s += ("\n" + "Account Holder: " + firstName + " " + lastName + " ");
		s += ("\n" + "Is valid: " + isValid() + "\n"); 
		return s;
	}

}