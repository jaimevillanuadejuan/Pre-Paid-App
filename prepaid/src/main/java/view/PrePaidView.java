package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controller.PrePaidController;


public class PrePaidView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1250632379668040771L;
	private PrePaidController controller;
	private BuyCardView buyCardView;
	private PayView payView;
	private ChargeMoneyView chargeMoneyView;
	private ChangePinView changePinView;
	private ConsultBalanceView consultBalanceView;
	private ConsultMovementsView consultMovementsView;
	
	public PrePaidView(PrePaidController controller) {
		
		this.controller = controller;

		setTitle("Pre-Paid App");
		setSize(320,300);
		setLocationRelativeTo(null);
		createMenuOptionsPanel();
		createButtonsPanel();
		this.setVisible(true);
	}
	
	private void createMenuOptionsPanel() {
		
		JMenuBar menu = new JMenuBar();
		JMenu options = new JMenu("Menu");
		JMenuItem exit = new JMenuItem("Save and Exit");
		

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			    controller.save();
			    System.exit(0);
			}
		});
		
		exit.addActionListener(event -> { controller.save(); System.exit(0);	});
		
		options.add(exit);
		menu.add(options);
		setJMenuBar(menu);		
	}
	
	
	private void createButtonsPanel() {
		
		JPanel panel = new JPanel();
		
		JButton buyCard = new JButton ("Buy Card");
 
		buyCard.addActionListener(event -> newBuyCardView().setVisible(true));
		panel.add(buyCard);
		
		JButton pay = new JButton ("Pay");
		pay.addActionListener(event -> newPayView().setVisible(true));
		panel.add(pay);
		
		JButton chargeMoney = new JButton ("Charge Money");
		chargeMoney.addActionListener(event -> newChargeMoneyView().setVisible(true));
		panel.add(chargeMoney);
		
		JButton changePin = new JButton ("Change Pin");
		changePin.addActionListener(event -> newChangePinView().setVisible(true));
		panel.add(changePin);
		
		JButton consultBalance = new JButton ("Consult Balance");
		consultBalance.addActionListener(event -> newConsultBalanceView().setVisible(true));
		panel.add(consultBalance);
		
		JButton consultMovements = new JButton ("Consult Movements");
		consultMovements.addActionListener(event -> newConsultMovementsView().setVisible(true));
		panel.add(consultMovements);
		
		panel.setLayout(new GridLayout(3,2,6,6));
		add(panel,BorderLayout.CENTER);		
	}
	
	
	public void showTicket(String ticket) {
		JOptionPane.showMessageDialog(this, ticket, "Ticket", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void showError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}

	
	public BuyCardView newBuyCardView() {
		return this.buyCardView = new BuyCardView(this.controller);
	}
	
	public PayView newPayView() {
		return this.payView = new PayView(this.controller);
	}
	
	public ChargeMoneyView newChargeMoneyView() {
		return this.chargeMoneyView = new ChargeMoneyView(this.controller);
	}
	
	public ChangePinView newChangePinView() {
		return this.changePinView = new ChangePinView(this.controller);
	}
	
	public ConsultBalanceView newConsultBalanceView() {
		return this.consultBalanceView = new ConsultBalanceView(this.controller);
	}
	
	public ConsultMovementsView newConsultMovementsView() {
		return this.consultMovementsView = new ConsultMovementsView(this.controller);
	}
	
	public BuyCardView getBuyCardView() {
		return this.buyCardView;
	}
	
	public PayView getPayView() {
		return this.payView;
	}
	
	public ChargeMoneyView getChargeMoneyView() {
		return this.chargeMoneyView;
	}
	
	public ChangePinView getChangePinView() {
		return this.changePinView;
	}
	
	public ConsultBalanceView getConsultBalanceView() {
		return this.consultBalanceView;
	}
	
	public ConsultMovementsView getConsultMovementsView() {
		return this.consultMovementsView;
	}
}
