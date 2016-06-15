/*
* Date: October 2016
* Author: Jasmien Cels
* Purpose: UCL COMPGC01 Java Tutorial
*/

package CreditCard;

public class CreditTestDriver {
	

	public static void main(String[] args) {
		
		creditCard validcc1 = new creditCard(10, 2014, "Jasmien", "Cels" ,"1234567891234567");
		creditCard invalidcc2 = new creditCard(01, 2016, "Blaine", "Muse", "9876543210123456");
	
		System.out.println(validcc1);
		System.out.println(invalidcc2);
	
	
	}
}