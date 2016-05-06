
import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.*;

public class Vari extends JPanel {
	JTextField textField;
	JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Vari() {

		JLabel lblNewLabel = new JLabel("Please enter expression below.");
		lblNewLabel.setBounds(32, 120, 313, 13);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		JLabel lblTipAllTrigonometric = new JLabel("Tip: All trigonometric function work in radians.");
		lblTipAllTrigonometric.setBounds(32, 261, 265, 13);
		lblTipAllTrigonometric.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setBounds(32, 145, 343, 36);
		textField.setColumns(10);
		
		JLabel lblValueOfX = new JLabel("Value of x:");
		lblValueOfX.setBounds(32, 45, 63, 13);
		lblValueOfX.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		textField_1 = new JTextField();
		textField_1.setBounds(32, 70, 343, 38);
		textField_1.setColumns(10);
		
		JButton button = new JButton("=");
		button.setBounds(387, 150, 46, 31);
		button.setFont(new Font("Helvetica", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String postfix = new ConvertRPN().inToPost(textField.getText());
				double p = Double.valueOf(textField_1.getText());
				double result = new ReversePolishNotation().RPN(postfix,p);
				textField.setText(String.valueOf(result));
			}
		});
		
		JButton btnNewButton = new JButton("e^");
		btnNewButton.setBounds(32, 208, 75, 29);
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("e()"));
			}
		});
		JButton btnSin = new JButton("sin");
		btnSin.setBounds(133, 208, 75, 29);
		btnSin.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnSin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("s()"));
			}
		});
		JButton btnCos = new JButton("cos");
		btnCos.setBounds(234, 208, 75, 29);
		btnCos.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnCos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("c()"));
			}
		});
		JButton btnTam = new JButton("tan");
		btnTam.setBounds(338, 208, 75, 29);
		btnTam.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnTam.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("t()"));
			}
		});
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(338, 290, 95, 29);
		btnReturn.setFont(new Font("Helvetica", Font.PLAIN, 13));
		setLayout(null);
		add(lblTipAllTrigonometric);
		add(lblNewLabel);
		add(lblValueOfX);
		add(btnNewButton);
		add(btnSin);
		add(btnCos);
		add(btnTam);
		add(btnReturn);
		add(textField);
		add(textField_1);
		add(button);
	}
}
