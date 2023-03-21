package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovementList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3687803764795899830L;
	private List<Movement> movementList;
	
	public MovementList() {
		this.movementList = new ArrayList<>();
	}
	
	public void add(Movement movement) {
		
		this.movementList.add(0, movement);	
	}
	
	public List<Movement> getMovementList(){
		
		return this.movementList;
	}
}
