import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Int extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public Int() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the expression below.");
		springLayout.putConstraint(SpringLayout.WEST, lblPleaseEnterThe, 22, SpringLayout.WEST, this);
		lblPleaseEnterThe.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblPleaseEnterThe);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 76, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPleaseEnterThe, -19, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField, 22, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, 393, SpringLayout.WEST, this);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Lower bound");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 22, SpringLayout.WEST, this);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Upper bound");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 22, SpringLayout.WEST, this);
		lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -21, SpringLayout.NORTH, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 133, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 12, SpringLayout.NORTH, textField_1);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -24, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 192, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 34, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -72, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, textField_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 13, SpringLayout.NORTH, textField_2);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Integral!");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 51, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 40, SpringLayout.EAST, textField_1);
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -21, SpringLayout.EAST, this);
		add(btnNewButton_1);

	}
}
