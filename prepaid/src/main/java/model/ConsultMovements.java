package model;


public class ConsultMovements implements ConsultMovementsInterface {

	@Override
	public void consultMovements(PrePaidCardList cardList, String cardNumber, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException {
		
		if(cardNumber.isEmpty() || pin.isEmpty())
			throw new InputNotValidException("Fields can not be blank!");
		
		Verifications verifications = new Verifications(cardList, cardNumber);
		
		verifications.verification_1(pin);
		
	}

}
