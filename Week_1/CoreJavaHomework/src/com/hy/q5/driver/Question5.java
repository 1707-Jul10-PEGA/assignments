package com.hy.q5.driver;

public class Question5 {
	//substring String str between 0 and idx
	public String substring(String str, int idx)
	{
		StringBuffer bu = new StringBuffer(str);
		bu.setLength(idx);
		return bu.toString();
	}
	
	public static final void main(String[] arg){
		System.out.println(new Question5().substring("AbCdEfGhIjKlMnOpQrStUvWxYz",9));
	}
}
