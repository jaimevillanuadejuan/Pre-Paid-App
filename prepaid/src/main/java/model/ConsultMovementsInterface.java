package model;


public interface ConsultMovementsInterface {
	
	public void consultMovements(PrePaidCardList cardList, String cardNumber, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException;

}
