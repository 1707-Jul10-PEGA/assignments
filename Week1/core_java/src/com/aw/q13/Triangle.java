package com.aw.q13;

public class Triangle {
	public static void main(String[]args){
        for (int i = 1; i < 5; i++) { //determines the number of rows there are
            for (int j = 1; j <= i; j++) { //determines the number of numbers in the particular row
                if ((i + j) % 2 == 0) {  //the sum of the numbers will 
                	if ((i <3)){
                		System.out.print("0 ");
                	} else {
                		System.out.print("1 ");
                	}
                    
                } else {
                    
                	if ((i<3)){
                	System.out.print("1 ");
                	}else{
                		System.out.print("0 ");
                	}
                }
            }
            System.out.println();
        }
    }
}
// i starts at 1
//