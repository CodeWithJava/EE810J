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
		setLayout(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the expression below.");
		lblPleaseEnterThe.setBounds(23, 52, 203, 13);
		lblPleaseEnterThe.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblPleaseEnterThe);
		
		textField = new JTextField();
		textField.setBounds(23, 85, 371, 36);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Lower bound");
		lblNewLabel.setBounds(23, 154, 73, 13);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Upper bound");
		lblNewLabel_1.setBounds(23, 198, 73, 13);
		lblNewLabel_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 137, 130, 36);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(129, 185, 130, 36);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Integral!");
		btnNewButton.setBounds(295, 171, 91, 29);
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
		btnNewButton_1.setBounds(356, 298, 82, 29);
		btnNewButton_1.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(btnNewButton_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(23, 243, 371, 36);
		add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEditable(false);

	}
}
