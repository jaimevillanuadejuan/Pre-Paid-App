package model;

import java.util.regex.Pattern;

public class PinRegex {
	
	private String pin;
	
	public PinRegex(String pin) {
		this.pin = pin;
	}

	public boolean pinRegex() 
	{
		return Pattern.compile("^[0-9]{4}$").matcher(this.pin).find();
	}
}
