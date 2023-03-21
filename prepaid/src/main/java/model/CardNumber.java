package model;

import java.util.Random;

public class CardNumber {
	
	public String generateCardNumber() {
		String num="";
		
		for(int i=0;i<2;i++) 
			num+=new Random().nextInt(899999)+100000;
		System.out.println(new Long(num).toString());
		return new Long(num).toString();	
	}
}
