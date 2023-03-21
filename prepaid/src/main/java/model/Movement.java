package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Movement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2872569827363083873L;
	private transient LocalDate date;
	private Double movement;
	
	public Movement(LocalDate date, double movement) {
		this.date = date;
		this.movement = movement;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public double getMovement() {
		return this.movement;
	}

}
