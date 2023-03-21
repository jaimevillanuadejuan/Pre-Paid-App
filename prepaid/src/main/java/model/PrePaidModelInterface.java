package model;


public interface PrePaidModelInterface {

	public String buyCardModel(String name, String surname,String pin, String confirmPin, double amount) throws IncorrectPinException, InputNotValidException;
	public String payModel(String cardNumber,double amount,String pin) throws CardNotRegisteredException, IncorrectPinException, NoMoneyException, ExpiredException, InputNotValidException;
	public String chargeMoneyModel(String cardNumber,double amount,String pin) throws CardNotRegisteredException, IncorrectPinException, ExpiredException, InputNotValidException;
	public String changePinModel(String cardNumber,String oldPin,String newPin) throws CardNotRegisteredException, IncorrectPinException, InputNotValidException;
	public String consultBalanceModel(String cardNumber,String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException;
	public String consultMovementsModel(String cardNumber, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException;
}
