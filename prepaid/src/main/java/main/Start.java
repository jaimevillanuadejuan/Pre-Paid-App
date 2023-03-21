package main;

import java.awt.EventQueue;

import controller.PrePaidController;


public class Start {
	public static void main(String [] args) {
		EventQueue.invokeLater(() -> {
					
			//PrePaidCardList cardList=new PrePaidCardList();
			//PrePaidModelInterface model = new PrePaidModel(cardList);
			
				 new PrePaidController();
			
			//PrePaidView view = new PrePaidView(controller,cardList);
			//controller.setView(view);
			
	});
	}

}
