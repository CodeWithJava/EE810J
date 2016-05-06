
import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.*;
import java.util.Scanner;

public class Arith extends JPanel {

	/**
	 * Create the panel.
	 */
	JTextField textField;
	public Arith() {
		JLabel lblNewLabel = new JLabel("Please enter expression below.");
		lblNewLabel.setBounds(26, 64, 427, 13);
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		JLabel lblTipAllTrigonometric = new JLabel("Tip: All trigonometric function work in radians.");
		lblTipAllTrigonometric.setBounds(26, 258, 265, 13);
		lblTipAllTrigonometric.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setBounds(26, 108, 317, 36);
		textField.setColumns(10);
		
		JButton button = new JButton("=");
		button.setBounds(360, 114, 42, 29);
		button.setFont(new Font("Helvetica", Font.PLAIN, 13));
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String postfix = new ConvertRPN().inToPost(textField.getText());
				textField.setText(String.valueOf(new ReversePolishNotation().RPN(postfix)));
			}
		});
		JButton btnNewButton = new JButton("e^");
		btnNewButton.setBounds(26, 185, 75, 29);
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("e()"));
			}
		});
		JButton btnSin = new JButton("sin");
		btnSin.setBounds(129, 185, 75, 29);
		btnSin.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnSin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("s()"));
			}
		});
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(350, 290, 82, 29);
		btnReturn.setFont(new Font("Helvetica", Font.PLAIN, 13));
		JButton btnCos = new JButton("cos");
		btnCos.setBounds(240, 185, 75, 29);
		btnCos.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnCos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("c()"));
			}
		});
		JButton btnTan = new JButton("tan");
		btnTan.setBounds(342, 185, 75, 29);
		btnTan.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnTan.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("t()"));
			}
		});
		setLayout(null);
		add(btnReturn);
		add(lblTipAllTrigonometric);
		add(textField);
		add(button);
		add(btnNewButton);
		add(btnSin);
		add(btnCos);
		add(btnTan);
		add(lblNewLabel);
	}

}
