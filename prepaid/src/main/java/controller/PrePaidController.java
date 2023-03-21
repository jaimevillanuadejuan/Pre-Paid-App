package controller;

import java.io.File;
import java.util.logging.Logger;

import model.CardInterface;
import model.CardNotRegisteredException;
import model.ExpiredException;
import model.IncorrectPinException;
import model.InputNotValidException;
import model.Load;
import model.NoMoneyException;
import model.PrePaidCardList;
import model.PrePaidModel;
import model.PrePaidModelInterface;
import model.Save;
import view.PrePaidView;

public class PrePaidController {
	
	private PrePaidModelInterface model;
	private PrePaidView view;
	private PrePaidCardList cardList;
	
	public PrePaidController ()  {

		this.view = new PrePaidView(this);
		getMemory();
		this.model = new PrePaidModel(this.cardList);		
	}
	
	
	
	private void getMemory() 
	{
		//String url = "C:" + File.separator + "Users" + File.separator + System.getProperty("user.name") + File.separator+"data.txt";
		try {
			
			File file = new File("memory.txt");
				
			if(!file.exists())			
				File.createTempFile("memory", ".txt");
			
			this.cardList = new Load(file).load();
		
		}catch (Exception e) { Logger.getLogger(e.getMessage()); }
	}
	
	
	
	public void save() {
		
		for(CardInterface card: this.cardList.getCardList())
			card.getMovementList().getMovementList().clear();
	
		new Save(new File("memory.txt"),this.cardList).save();				
	}
	
	
	
	public void buyCard() {
		
		try {
			
			String name = view.getBuyCardView().getName();
			String surname = view.getBuyCardView().getSurname();
			String pin = view.getBuyCardView().getPin();
			String confirmPin = view.getBuyCardView().getPinConfirmation();
			double amount = Double.parseDouble(view.getBuyCardView().getAmount());
			String ticket = model.buyCardModel(name, surname, pin, confirmPin, amount);
			view.getBuyCardView().dispose();
			view.showTicket(ticket);
			
		}catch(InputNotValidException | NumberFormatException e) {
			
			view.showError("The input was not valid!");
			
		}catch(IncorrectPinException e) {
			
			view.showError("Incorrect Pin!");
		}
	}
	
	
	
	public void pay() {
		
		try {
			
			String cardNumber = view.getPayView().getCardNumber();
			String pin = view.getPayView().getPin();
			double amount = Double.parseDouble(view.getPayView().getAmount());
			String ticket = model.payModel(cardNumber, amount, pin);
			view.getPayView().dispose();
			view.showTicket(ticket);		
			
		}catch(InputNotValidException | NumberFormatException e) {
			
			view.showError("The input was not valid!");
			
		}catch(IncorrectPinException e) {
			
			view.showError("Incorrect Pin!");
			
		}catch(NoMoneyException e) {
			
			view.showError("The card does not have enough money!");
			
		}catch(ExpiredException e) {
			
			view.showError("Invalid Pre Paid Card!");
			
		}catch(CardNotRegisteredException e) {
			
			view.showError("Card not Registered!");
		}		
	}
	
	
	
	public void chargeMoney() {
		
		try {
			
			String cardNumber = view.getChargeMoneyView().getCardNumber();
			String pin = view.getChargeMoneyView().getPin();
			double amount = Double.parseDouble(view.getChargeMoneyView().getAmount());
			String ticket = model.chargeMoneyModel(cardNumber, amount, pin);
			view.getChargeMoneyView().dispose();
			view.showTicket(ticket);	
			
		}catch(InputNotValidException | NumberFormatException e) {
			
			view.showError("The input was not valid!");
			
		}catch(IncorrectPinException e) {
			
			view.showError("Incorrect Pin!");
			
		}catch(ExpiredException e) {
			
			view.showError("Invalid Pre Paid Card!");
			
		}catch(CardNotRegisteredException e) {
			
			view.showError("Card not Registered!");
		}
	}
	
	
	
	public void changePin() {

		try {
			
			String cardNumber = view.getChangePinView().getCardNumber();
			String oldPin = view.getChangePinView().getOldPin();
			String newPin = view.getChangePinView().getNewPin();
			String ticket = model.changePinModel(cardNumber, oldPin, newPin);		
			view.getChangePinView().dispose();
			view.showTicket(ticket);
		
		}catch (InputNotValidException e) {
			
			view.showError("The input was not valid!");
		
		}catch (CardNotRegisteredException e) {
			
			view.showError("Card not Registered!");
			
		}catch(IncorrectPinException e) {
			
			view.showError("Incorrect Pin!");
		} 
	}
	
	
	
	public void consultBalance() {
		
		try {
			
			String cardNumber = view.getConsultBalanceView().getCardNumber();
			String pin = view.getConsultBalanceView().getPin();
			String ticket = model.consultBalanceModel(cardNumber, pin);
			view.getConsultBalanceView().dispose();
			view.showTicket(ticket);
		
		}catch (InputNotValidException e) {
			
			view.showError("The input was not valid!");
			
		} catch (CardNotRegisteredException e) {

			view.showError("Card not Registered!");
			
		} catch (IncorrectPinException e) {

			view.showError("Incorrect Pin!");
		}				
	}
	
	
	
	public void consultMovements() {
		
		try {
			
			String cardNumber = view.getConsultMovementsView().getCardNumber();
			String pin = view.getConsultMovementsView().getPin();
			String ticket = model.consultMovementsModel(cardNumber, pin);
			view.getConsultMovementsView().dispose();
			view.showTicket(ticket);
					
		}catch (InputNotValidException e) {
			
			view.showError("The input was not valid!");
			
		} catch (CardNotRegisteredException e) {

			view.showError("Card not Registered!");
			
		} catch (IncorrectPinException e) {

			view.showError("Incorrect Pin!");
		}		
	}
}