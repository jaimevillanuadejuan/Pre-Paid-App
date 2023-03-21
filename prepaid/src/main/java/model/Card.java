package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Card implements CardInterface,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3695481056927391367L;
	private String cardNumber;
	private String name;
	private String surname;
	private String pin;
	private transient LocalDate expirationDate;
	private double amount;
	private double balance;
	private MovementList movementList;
	
	
	public Card(String cardNnumber, String pin, String name, String surname, LocalDate expirationDate,double amount,double balance) 
	{
		this.cardNumber=cardNnumber;
		this.pin=pin;
		this.name=name;
		this.surname=surname;
		this.expirationDate=expirationDate;
		this.amount=amount;
		this.balance=amount;
		this.movementList = new MovementList();
	}
	
	@Override
	public String getCardNumber()
	{
		return this.cardNumber;
	}
		
	@Override
	public String getPin() 
	{
		return this.pin;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getSurname() {
		return this.surname;
	}
	
	@Override
	public LocalDate getExpiratonDate()
	{
		return this.expirationDate;
	}
	
	@Override
	public double getAmount() {
		return this.amount;
	}
	
	@Override
	public double getBalance()
	{
		return this.balance;
	}
	
	@Override
	public MovementList getMovementList(){
		return this.movementList;
	}
	
	@Override
	public void setPin(String pin)
	{
		this.pin=pin;
	}
	
	@Override
	public void setBalance(double amount)
	{
		this.balance+=amount;
		this.amount=amount;
	}
}
