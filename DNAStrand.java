/*
* Date: October 2016
* Author: Jasmien Cels
* Purpose: UCL COMPGC01 Java Tutorial
*/

package DNA;

import java.util.Arrays;

public class DNAStrand {
	
	//field
	public String dna; 
	
	//default constructor
	public DNAStrand() {
	}
	
	//1-argument constructor
	public DNAStrand(String dna) { //don't forget parameter for non-default constructor
		this.dna = dna;
	}

	public boolean isValidDNA() {
		
		boolean isValidDNA = false;
		
		if (dna.matches("[ATCG]*")) { //RE expression syntax
			isValidDNA = true;
		}
		return isValidDNA;
	}
	
	//Complement String Method
	public String complementWC() {
		
		//Form string array of each DNA letter 
		String[] complementWC = dna.split("");
		
		//Loop through each DNA letter and create compliment form
		for (int i=0; i < complementWC.length; i++ ){
			switch(complementWC[i]){
			case "A":
				complementWC[i] = "T";
				break;
			case "T":
				complementWC[i] = "A";
				break;	
			case "G":
				complementWC[i] = "C";
				break;
			case "C":
				complementWC[i] = "G";
				break;
			}
		}
		
		String complementString = "";
		
		for (int i =0; i < complementWC.length; i++) {
			complementString += complementWC[i];
		}
		
		return complementString ;
		
		}

	//Reverse DNA Sequence method 
	public String palindromeWC() {
		String reverse = new StringBuffer(dna).reverse().toString();
		return reverse;	
	}
	
	public boolean containsSequence(String seq) {
		boolean contains = false;
		
		if (dna.contains(seq)){
			contains = true;
		}
		return contains;
	}
	
	public String toString() {
		return dna + "\n" + complementWC();
		
	}
	
}
			
			
		
	

