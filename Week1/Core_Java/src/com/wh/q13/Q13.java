package com.wh.q13;

public class Q13 {
	public static void main(String[] args) {
		String str = "";
		int i = 0;
		int j = 0;
		boolean right = true;
		while(i < 4){
			if(right){
				str += j + " ";
				j++;
				right = false;
			}else{
				if(j >= 2){
					j = 0;
				}
				str = j+ " " + str;
				right = true;
			}
			System.out.println(str);
			i++;
		}
	}
}
