/*
* Date: October 2016
* Author: Jasmien Cels
* Purpose: UCL COMPGC01 Java Tutorial
*/

package DNA;

public class DNAStrandTester {
	
	public static void summarise(DNAStrand dna){
		
		System.out.println("Original DNA Sequence: " + dna); 
		if (dna.isValidDNA()) {
			System.out.println("Is valid");
			System.out.println("Complement: " + dna.complementWC());
			System.out.println("WC Palindrome: " + dna.palindromeWC());
			
		}else {
			System.out.println("Not Valid DNA");
		}
	}


	public static void main(String[] args) {
	
		DNAStrand valid = new DNAStrand("ATGCAAATTTGCGCGTA");
		DNAStrand invalid = new DNAStrand("MMMMMMMM");
		DNAStrand nuller = new DNAStrand("");
	
	
		summarise(valid);
		System.out.println();
		summarise(invalid);
		System.out.println();
		summarise(nuller);

	}
}