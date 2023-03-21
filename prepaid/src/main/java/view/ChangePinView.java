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

public class ChangePinView extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6010427632545863957L;
	private PrePaidController controller;
	private JTextField cardNumberField;
	private JPasswordField oldPinField;
	private JPasswordField newPinField;
	
	public ChangePinView(PrePaidController controller) {
		
		this.controller = controller;
		
		setModal(true);
		setTitle("Change PIN");
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
		
		JLabel oldPin = new JLabel("Old PIN:");
		panel.add(oldPin);
		
		this.oldPinField = new JPasswordField(4);
		panel.add(this.oldPinField);
		
		JLabel newPin = new JLabel("New PIN:");
		panel.add(newPin);
		
		this.newPinField = new JPasswordField(4);
		panel.add(this.newPinField);
		
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
		confirm.addActionListener(event -> this.controller.changePin());
		
		panel.add(confirm);
		add(panel,BorderLayout.SOUTH);		
	}
	
	public String getCardNumber() {
		return this.cardNumberField.getText();
	}
	
	public 	String getOldPin() {
		return pinToString(this.oldPinField.getPassword());
	}
	
	public 	String getNewPin() {
		return pinToString(this.newPinField.getPassword());
	}
		
	private String pinToString(char[] pin) {
		String aux = "";
		for(int i=0; i<pin.length;i++)
			aux += pin[i];		
		return aux;		
	}
}
