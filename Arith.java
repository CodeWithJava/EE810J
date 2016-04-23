
import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.*;

public class Arith extends JPanel {

	/**
	 * Create the panel.
	 */
	JTextField textField;
	public Arith() {
		JLabel lblNewLabel = new JLabel("Please enter expression below.");
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 12));
		
		JLabel lblTipAllTrigonometric = new JLabel("Tip: All trigonometric function work in radians.");
		lblTipAllTrigonometric.setFont(new Font("Helvetica", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton button = new JButton("=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton = new JButton("e");
		JButton btnSin = new JButton("sin");
		
		JButton btnReturn = new JButton("Return");
		
		JButton btnCos = new JButton("cos");
		JButton btnTan = new JButton("tan");
		btnNewButton.addActionListener(new btnFunction());
		btnSin.addActionListener(new btnFunction());
		btnCos.addActionListener(new btnFunction());
		btnTan.addActionListener(new btnFunction());
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(lblTipAllTrigonometric)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(26)
							.addComponent(btnSin, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnCos, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnTan, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(338, Short.MAX_VALUE)
					.addComponent(btnReturn)
					.addGap(27))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(lblNewLabel)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnTan)
						.addComponent(btnCos)
						.addComponent(btnSin))
					.addGap(47)
					.addComponent(lblTipAllTrigonometric)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnReturn)
					.addGap(10))
		);
		setLayout(groupLayout);
	}
	
	class btnFunction implements ActionListener
	{
		public void actionPerformed(ActionEvent e1)
		{
			textField.setText(textField.getText().concat(((JButton)e1.getSource()).getText()));
		}
	}

}
