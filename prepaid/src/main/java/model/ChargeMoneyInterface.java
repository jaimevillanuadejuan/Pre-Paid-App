package model;


public interface ChargeMoneyInterface {
	
	public void chargeMoney(PrePaidCardList cardList, String cardNumber, double amount, String pin) throws CardNotRegisteredException, IncorrectPinException, ExpiredException, InputNotValidException;

}
