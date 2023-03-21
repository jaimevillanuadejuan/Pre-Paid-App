package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrePaidCardList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5561530408023158966L;
	private List <CardInterface> cardList;
	
	public PrePaidCardList() {
		this.cardList= new ArrayList<>();
	}
	

	public void add(CardInterface cardInterface) {
		cardList.add(cardInterface);
	}
	
	public List<CardInterface> getCardList(){
		return this.cardList;
	}
	
	public CardInterface get(int i) {
		return cardList.get(i);
	}
	
	public int size() {
		return cardList.size();
	}
	
	public int findCard(String cardNumber)
	{
		if(this.cardList.isEmpty())
			return -1;

		boolean finded=false;
		int i=0;

		while(!finded && i<this.cardList.size())
		{
			finded=cardNumber.equals(this.cardList.get(i).getCardNumber());
			if(!finded)i++;
		}

		return finded?i:-1;
	}


}
