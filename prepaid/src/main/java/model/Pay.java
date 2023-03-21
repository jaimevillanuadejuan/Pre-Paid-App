package model;

import java.time.LocalDate;

public class Pay implements PayInterface{

	@Override
	public void pay(PrePaidCardList cardList, String cardNumber,double amount, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException, NoMoneyException, ExpiredException {
		
		if(cardNumber.isEmpty() || pin.isEmpty())
			throw new InputNotValidException("Fields can not be blank!");
		
		Verifications verifications = new Verifications(cardList, cardNumber);
		
		verifications.verification_1(pin);
		verifications.verification_2(amount);
		verifications.verification_3();
		
		CardInterface cardInterface = cardList.get(cardList.findCard(cardNumber));
		cardInterface.setBalance(-amount);
		
		cardInterface.getMovementList().add(new Movement(LocalDate.now(),-amount));		
	}

}
