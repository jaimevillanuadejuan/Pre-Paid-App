package model;

import java.time.LocalDate;

public class Verifications {
	private PrePaidCardList cardList;
	private int pos;
	
	public Verifications(PrePaidCardList cardList, String cardNumber) {
		
		this.cardList = cardList;
		this.pos = cardList.findCard(cardNumber);	
	}
	
	public void verification_1(String pin) throws CardNotRegisteredException, IncorrectPinException 
	{
		
		if(this.pos==-1)
			throw new CardNotRegisteredException("The card is not registered in the system!");		
		
		if(!new Sha256().sha256(pin).equals(cardList.get(this.pos).getPin()))
			throw new IncorrectPinException("The Pin is incorrect!");
	}
	
	
	
	public void verification_2(double amount) throws NoMoneyException
	{
		
		if(cardList.get(this.pos).getBalance()==0 || amount > cardList.get(this.pos).getBalance())
			throw new NoMoneyException("The card does not have enough money!");		
	}
	
	
	
	public void verification_3() throws ExpiredException
	{
		
		if(cardList.get(this.pos).getExpiratonDate().isEqual(LocalDate.now()))
			throw new ExpiredException("The card has expired!");
	}

}
