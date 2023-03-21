package model;

import java.time.LocalDate;

public class ChargeMoney implements ChargeMoneyInterface {

	@Override
	public void chargeMoney(PrePaidCardList cardList, String cardNumber, double amount, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException, ExpiredException  {

		if(cardNumber.isEmpty() || pin.isEmpty())
			throw new InputNotValidException("Fields can not be blank!");
		
		Verifications verifications = new Verifications(cardList, cardNumber);
		
		verifications.verification_1(pin);
		verifications.verification_3();
			
		CardInterface cardInterface = cardList.get(cardList.findCard(cardNumber));
		cardInterface.setBalance(amount);
		cardInterface.getMovementList().add(new Movement(LocalDate.now(),amount));
	}

}
