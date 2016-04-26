import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Int extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Int() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the expression below.");
		springLayout.putConstraint(SpringLayout.WEST, lblPleaseEnterThe, 23, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPleaseEnterThe, -248, SpringLayout.SOUTH, this);
		lblPleaseEnterThe.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblPleaseEnterThe);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblPleaseEnterThe);
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblPleaseEnterThe);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, -206, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, textField, 394, SpringLayout.WEST, this);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Lower bound");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 16, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblPleaseEnterThe);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Upper bound");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 157, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblPleaseEnterThe);
		lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 33, SpringLayout.EAST, lblNewLabel);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_1, -21, SpringLayout.NORTH, textField_2);
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, -107, SpringLayout.SOUTH, this);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Integral!");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 40, SpringLayout.SOUTH, textField);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 36, SpringLayout.EAST, textField_1);
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String a = "([-+]*[0-9]+)x\\^*([-+]*[0-9]+)";
				Pattern p1 = Pattern.compile(a);
				Matcher m1 = p1.matcher(textField.getText());
				Polynomial ep = new Polynomial(0,0);	
				while(m1.find())
				{
					double coef = Double.parseDouble(m1.group(1));
					int exp = Integer.parseInt(m1.group(2));
					Polynomial ep1 =new Polynomial(coef,exp);
					ep = ep.plus(ep1);
				}
				double vallower = Double.parseDouble(textField_1.getText());
				double valupper = Double.parseDouble(textField_2.getText());
				textField_3.setText(String.valueOf(ep.integration(vallower, valupper)));
			}
		});
		
		JButton btnNewButton_1 = new JButton("Return");
		btnNewButton_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -21, SpringLayout.EAST, this);
		add(btnNewButton_1);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, 13, SpringLayout.SOUTH, textField_2);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, lblPleaseEnterThe);
		springLayout.putConstraint(SpringLayout.SOUTH, textField_3, -19, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, textField_3, 0, SpringLayout.EAST, textField);
		add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);

	}
}
