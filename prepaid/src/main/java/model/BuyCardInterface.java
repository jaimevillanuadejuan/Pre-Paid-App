package model;


public interface BuyCardInterface {

	public Card buyCard(PrePaidCardList cardList, String name, String surname, String pin, String confirmPin, double amount) throws IncorrectPinException, InputNotValidException;
}
