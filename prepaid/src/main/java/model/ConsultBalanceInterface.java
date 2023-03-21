package model;


public interface ConsultBalanceInterface {
	
	public void consultBalance(PrePaidCardList cardList, String cardNumber, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException;

}
