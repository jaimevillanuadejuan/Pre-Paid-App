package model;


public class PrePaidModel implements PrePaidModelInterface {

	private PrePaidCardList cardList;
	
	public PrePaidModel( PrePaidCardList cardList) {
			
		this.cardList = cardList;		
	}
	
	@Override
	public String buyCardModel(String name, String surname,String pin, String confirmPin, double amount) throws IncorrectPinException, InputNotValidException {
		
		BuyCardInterface buyCardInterface = new BuyCard();
		CardInterface cardInterface = buyCardInterface.buyCard(this.cardList, name.trim(), surname.trim(), pin, confirmPin, amount);
		
		TicketInterface ticketInterface = new Ticket(cardInterface);
		
		return ticketInterface.getTicket_1();
	}

	@Override
	public String payModel(String cardNumber, double amount, String pin) throws CardNotRegisteredException, IncorrectPinException, NoMoneyException, ExpiredException, InputNotValidException {
		
		PayInterface payInterface = new Pay();
		
		cardNumber = cardNumber.trim();
		
		payInterface.pay(this.cardList, cardNumber, amount, pin);
		
		TicketInterface ticketInterface = new Ticket(cardList.get(cardList.findCard(cardNumber)));
		
		return ticketInterface.getTicket_2();
	}

	@Override
	public String chargeMoneyModel(String cardNumber, double amount, String pin) throws CardNotRegisteredException, IncorrectPinException, ExpiredException, InputNotValidException {
		
		ChargeMoneyInterface chargeMoneyInterface = new ChargeMoney();

		cardNumber = cardNumber.trim();
		
		chargeMoneyInterface.chargeMoney(this.cardList, cardNumber, amount, pin);
		
		TicketInterface ticketInterface = new Ticket(cardList.get(cardList.findCard(cardNumber)));
		
		return ticketInterface.getTicket_2();
	}

	@Override
	public String changePinModel(String cardNumber, String oldPin, String newPin) throws CardNotRegisteredException, IncorrectPinException, InputNotValidException {
		
		ChangePinInterface changePinInterface = new ChangePin();
		
		cardNumber = cardNumber.trim();
		
		changePinInterface.changePin(this.cardList, cardNumber, oldPin, newPin);
		
		TicketInterface ticketInterface = new Ticket(cardList.get(cardList.findCard(cardNumber)));
		
		return ticketInterface.getTicket_3();		
	}

	@Override
	public String consultBalanceModel(String cardNumber, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException {
			
		ConsultBalanceInterface consultBalanceInterface = new ConsultBalance();
		
		cardNumber = cardNumber.trim();
		
		consultBalanceInterface.consultBalance(this.cardList, cardNumber, pin);
		
		TicketInterface ticketInterface = new Ticket(cardList.get(cardList.findCard(cardNumber)));
		
		return ticketInterface.getTicket_4();	
	}

	@Override
	public String consultMovementsModel(String cardNumber, String pin) throws InputNotValidException, CardNotRegisteredException, IncorrectPinException {
		
		ConsultMovementsInterface consultMovementsInterface = new ConsultMovements();
		
		cardNumber = cardNumber.trim();
		
		consultMovementsInterface.consultMovements(this.cardList, cardNumber, pin);
		
		TicketInterface ticketInterface = new Ticket(cardList.get(cardList.findCard(cardNumber)));
		
		return ticketInterface.getTicket_5();
	}
	
}
