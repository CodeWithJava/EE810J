import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		setLayout(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the expression below.");
		lblPleaseEnterThe.setBounds(22, 65, 203, 13);
		lblPleaseEnterThe.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(lblPleaseEnterThe);
		
		textField = new JTextField();
		textField.setBounds(41, 111, 360, 37);
		add(textField);
		textField.setColumns(10);
		
		JButton btnDiff = new JButton("Differential!");
		btnDiff.setBounds(165, 178, 110, 29);
		btnDiff.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(btnDiff);
		btnDiff.addActionListener(new ActionListener()
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
				textField_1.setText(String.valueOf(ep.differentiate()));
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setBounds(41, 228, 360, 37);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.setBounds(340, 298, 94, 29);
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		add(btnNewButton);

	}
}
