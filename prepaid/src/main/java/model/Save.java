package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

public class Save {

	private File file;
	private PrePaidCardList cardList;

	public Save(File file, PrePaidCardList cardList) {

		this.file = file;
		this.cardList = cardList;		
	}

	public void save() { 
		
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(this.file))){
			
			
			writer.writeObject(this.cardList);
			writer.close();

		} catch (Exception e) { Logger.getLogger(e.getMessage()); }
		


	}

}
