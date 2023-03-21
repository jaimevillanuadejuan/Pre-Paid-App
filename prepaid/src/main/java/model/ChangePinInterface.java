package model;


public interface ChangePinInterface {
	
	public void changePin(PrePaidCardList cardList, String cardNumber,String oldPin,String newPin) throws CardNotRegisteredException, IncorrectPinException, InputNotValidException;

}
