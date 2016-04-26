import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Diff extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Diff() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the expression below.");
		springLayout.putConstraint(SpringLayout.WEST, lblPleaseEnterThe, 22, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPleaseEnterThe, -243, SpringLayout.SOUTH, this);
		lblPleaseEnterThe.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblPleaseEnterThe);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 27, SpringLayout.SOUTH, lblPleaseEnterThe);
		springLayout.putConstraint(SpringLayout.WEST, textField, 22, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 64, SpringLayout.SOUTH, lblPleaseEnterThe);
		springLayout.putConstraint(SpringLayout.EAST, textField, 382, SpringLayout.WEST, this);
		add(textField);
		textField.setColumns(10);
		
		JButton btnDiff = new JButton("Differential!");
		btnDiff.setFont(new Font("Helvetica", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.NORTH, btnDiff, 30, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, btnDiff, 155, SpringLayout.WEST, this);
		add(btnDiff);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 15, SpringLayout.SOUTH, btnDiff);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 22, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, 52, SpringLayout.SOUTH, btnDiff);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, -118, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -24, SpringLayout.EAST, this);
		add(btnNewButton);

	}
}
