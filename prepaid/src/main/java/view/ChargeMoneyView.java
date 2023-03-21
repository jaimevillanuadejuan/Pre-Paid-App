package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.PrePaidController;

public class ChargeMoneyView extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -506457903842716696L;
	private PrePaidController controller;
	private JTextField cardNumberField;
	private JPasswordField pinField;
	private JTextField amountField;
	
	public ChargeMoneyView(PrePaidController controller) {
		
		this.controller = controller;
		
		setModal(true);
		setTitle("Charge Money");
		setSize(260, 140);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createFormPanel();
		createBtnPanel();
	}
	
	private void createFormPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));


		JLabel cardNumber = new JLabel("Card Number:");
		panel.add(cardNumber);
		
		this.cardNumberField = new JTextField(12);
		panel.add(this.cardNumberField);
		
		JLabel pin = new JLabel("PIN:");
		panel.add(pin);
		
		this.pinField = new JPasswordField(4);
		panel.add(this.pinField);
		
		JLabel amount = new JLabel("Amount:");
		panel.add(amount);
		
		this.amountField = new JTextField(4);
		panel.add(this.amountField);
		
		add(panel);	
	}
	
	private void createBtnPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton cancel = new JButton();
		cancel.setText("Cancel");
		panel.add(cancel);
		cancel.addActionListener(event -> dispose());
		
		JButton confirm = new JButton();
		confirm.setText("Confirm");
		confirm.addActionListener(event -> this.controller.chargeMoney());
		
		panel.add(confirm);
		add(panel,BorderLayout.SOUTH);
	}
	
	public String getCardNumber() {
		return this.cardNumberField.getText();
	}
	
	public 	String getPin() {
		return pinToString(this.pinField.getPassword());
	}
		
	public String getAmount() {
		return this.amountField.getText();
	}
	
	private String pinToString(char[] pin) {
		String aux = "";
		for(int i=0; i<pin.length;i++)
			aux += pin[i];		
		return aux;		
	}
}
