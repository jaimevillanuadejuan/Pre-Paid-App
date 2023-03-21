package model;


public class ChangePin implements ChangePinInterface {

	@Override
	public void changePin(PrePaidCardList cardList, String cardNumber, String oldPin, String newPin) throws CardNotRegisteredException, IncorrectPinException, InputNotValidException {
		
		if(cardNumber.isEmpty() || oldPin.isEmpty() || newPin.isEmpty())
			throw new InputNotValidException("Fields can not be blank!");
		
		if (!new PinRegex(newPin).pinRegex())
			throw new IncorrectPinException("Error with Pin!");
		
		Verifications verifications = new Verifications(cardList, cardNumber);
		
		verifications.verification_1(oldPin);
		
		cardList.get(cardList.findCard(cardNumber)).setPin(new Sha256().sha256(newPin));	
	}
}
