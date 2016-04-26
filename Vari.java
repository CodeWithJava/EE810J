
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
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		JLabel lblTipAllTrigonometric = new JLabel("Tip: All trigonometric function work in radians.");
		lblTipAllTrigonometric.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblValueOfX = new JLabel("Value of x:");
		lblValueOfX.setFont(new Font("Helvetica", Font.PLAIN, 13));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button = new JButton("=");
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
		btnNewButton.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("e()"));
			}
		});
		JButton btnSin = new JButton("sin");
		btnSin.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnSin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("s()"));
			}
		});
		JButton btnCos = new JButton("cos");
		btnCos.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnCos.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("c()"));
			}
		});
		JButton btnTam = new JButton("tan");
		btnTam.setFont(new Font("Helvetica", Font.PLAIN, 13));
		btnTam.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(textField.getText().concat("t()"));
			}
		});
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Helvetica", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTipAllTrigonometric)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValueOfX)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(27)
							.addComponent(btnSin, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnCos, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnTam, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnReturn)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField, Alignment.LEADING)
									.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblValueOfX)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnCos)
						.addComponent(btnSin)
						.addComponent(btnTam))
					.addGap(18)
					.addComponent(lblTipAllTrigonometric)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReturn)
					.addGap(10))
		);
		setLayout(groupLayout);
	}
}
