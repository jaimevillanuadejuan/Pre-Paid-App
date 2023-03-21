package model;

import java.time.LocalDate;

public class BuyCard implements BuyCardInterface{

	@Override
	public Card buyCard(PrePaidCardList cardList, String name, String surname, String pin, String confirmPin, double amount) throws IncorrectPinException, InputNotValidException {
		
		if(name.isEmpty() || surname.isEmpty() || pin.isEmpty() || confirmPin.isEmpty())
			throw new InputNotValidException("Fields can not be blank!");
		
		if (!new PinRegex(pin).pinRegex() || !pin.equals(confirmPin))
			throw new IncorrectPinException("Error with Pin!");
			
		String number;
		while(cardList.findCard(number = new CardNumber().generateCardNumber())!=-1) {}
		
		Card card = new Card(number, new Sha256().sha256(pin), name, surname, LocalDate.now().plusYears(1), amount, amount);
		cardList.add((CardInterface)card);
		 
		return card; 
	}
	
}
