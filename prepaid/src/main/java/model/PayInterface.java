package model;


public interface PayInterface {
	
	public void pay(PrePaidCardList cardList, String cardNumber,double amount, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException, NoMoneyException, ExpiredException;

}
