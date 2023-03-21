package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.logging.Logger;

public class Load {

	private File file;
	
	public Load(File file) {
		this.file = file;
	}
	
	public PrePaidCardList load() {
		
		PrePaidCardList cardList=new PrePaidCardList();
		
		if(file.length()!=0) 
		{	
			try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(this.file))){
				
				cardList = (PrePaidCardList) reader.readObject();
				reader.close();
				
			}catch (Exception e) { Logger.getLogger(e.getMessage()); }			
		}
		
		return cardList;		
	}
}
