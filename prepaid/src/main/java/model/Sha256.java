package model;

import java.security.MessageDigest;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

public class Sha256 {
	
	public String sha256(String pin)
	{
		String code = null;
		
		try {	
		
			MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
			byte [] hash=mDigest.digest(pin.getBytes("UTF-8"));		
			code = DatatypeConverter.printHexBinary(hash);	
			
		} catch (Exception e) { Logger.getLogger(e.getMessage()); }
		
		return code;
	}

}
