package com.cg.q8;

public class StoreStrings {
	private static String [] palidromes = new String[13];
	private static String [] nonpalidromes = new String[13];
	
	public static void checkStrings(String [] args){
		int counter = 0;
		
		for(String i:args){
			boolean flag = true;
			
			for(int j = 0,k = i.length()-1; j < i.length(); j++, k--){
						
						System.out.print(i.charAt(j));
						System.out.println(" " + i.charAt(k));
						if(i.charAt(j) != i.charAt(k)){
							flag = false;
							break;
						}
			}
				
			if(flag){
				palidromes[counter] = i;
			}else{
				nonpalidromes[counter] = i;
			}
			counter++;
		}
		System.out.println("Nonpalidromes");
		for(String i:nonpalidromes){
			System.out.print(i + ", ");
		}
		
		System.out.println();
		System.out.println("Palidromes");
		for(String i:palidromes){
			System.out.print(i + ", ");
		}
	}
	
	public static void main(String [] args){
		String [] words = {"karan","madam","tom","civic",
						   "radar","sexes","jimmy","kayak",
						   "john","refer","billy","did","noon"};
		
		checkStrings(words);
	}
}
