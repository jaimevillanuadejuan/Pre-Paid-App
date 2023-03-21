package model;


public class Ticket implements TicketInterface {


	private CardInterface cardInterface;
	private String dear;
	private String amount;
	private String cardNumber;
	private String balance;
	private String thank;
	
	public Ticket(CardInterface cardInterface) {
		this.cardInterface = cardInterface;
		this.dear =  "Dear " + cardInterface.getName() + " "+ cardInterface.getSurname() + " ,\n\n";
		this.amount = "Amount : " + cardInterface.getAmount() + "\n";
		this.cardNumber = cardInterface.getCardNumber();
		this.balance = "\nBalance : " + cardInterface.getBalance() + "\n\n";
		this.thank = "Thanks for using our system.\n";
		
	}
	
	
	@Override
	public String getTicket_1() {
		
		return this.dear + this.amount + "Card Number: " + this.cardNumber + this.balance + this.thank;
	}
	
	@Override
	public String getTicket_2() {
		
		return this.dear + this.amount + cardNumberFormat(this.cardNumber) + this.balance + this.thank;
	}
	
	@Override
	public String getTicket_3() {
		
		return this.dear + "Your Pin was changed correctly!\n\n" + this.thank;
	}
	
	@Override
	public String getTicket_4() {

		return this.dear + cardNumberFormat(this.cardNumber) + this.balance + this.thank;
	}
	
	private String cardNumberFormat(String cardNumber) {
		
		return "Card Number : XXXX XXXX "+ cardNumber.substring(8, 12);		
	}
	
	@Override
	public String getTicket_5() {
		
		String ticket = this.dear;
		
		for(Movement movement: this.cardInterface.getMovementList().getMovementList())
			
			ticket+= movement.getDate().getDayOfMonth() + "/" + movement.getDate().getMonthValue() + "/" + movement.getDate().getYear() + "    " +
					movement.getMovement() + "\n";
		
		return ticket+= "\nThanks for using our system\n";
	}

}
