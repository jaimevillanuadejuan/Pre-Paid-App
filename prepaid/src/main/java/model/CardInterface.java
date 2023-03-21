package model;

import java.time.LocalDate;

public interface CardInterface {

	public String getCardNumber();

	public String getPin();

	public String getName();

	public String getSurname();
	
	public LocalDate getExpiratonDate();

	public double getAmount();

	public double getBalance();
	
	public MovementList getMovementList();

	public void setPin(String pin);

	public void setBalance(double amount);

}
