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

public class BuyCardView extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6575220646309620106L;
	private PrePaidController controller;
	private JTextField nameField;
	private JTextField surnameField;
	private JPasswordField pinField;
	private JPasswordField pinConfirmationField;
	private JTextField amountField;
	
	public BuyCardView(PrePaidController controller) {
		
		this.controller=controller;
		
		setModal(true);
		setTitle("Buy Card");
		setSize(260, 230);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createFormPanel();
		createBtnPanel();
		
	}
	
	private void createFormPanel() {
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel name = new JLabel("Name:");
		panel.add(name);
		
		this.nameField = new JTextField(21);		
		panel.add(nameField);


		JLabel surname = new JLabel("Surname:");
		panel.add(surname);
		
		this.surnameField = new JTextField(21);
		panel.add(this.surnameField);
		
		JLabel pin = new JLabel("PIN:");
		panel.add(pin);
		
		this.pinField = new JPasswordField(4);
		panel.add(this.pinField);
		
		JLabel pinConfirmation = new JLabel("PIN Confirmation:");
		panel.add(pinConfirmation);
		
		this.pinConfirmationField = new JPasswordField(4);
		panel.add(this.pinConfirmationField);
		
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
		confirm.addActionListener(event -> controller.buyCard());
			
		
		panel.add(confirm);
		add(panel,BorderLayout.SOUTH);
	}
	
	public String getName() {
		return this.nameField.getText();
	}
	
	public String getSurname() {
		return this.surnameField.getText();
	}
	
	public 	String getPin() {
		return pinToString(this.pinField.getPassword());
	}
	
	public 	String getPinConfirmation() {
		return pinToString(this.pinConfirmationField.getPassword());
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
