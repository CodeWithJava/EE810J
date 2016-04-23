package Algebra;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.*;

public class Vari extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Vari() {

		JLabel lblNewLabel = new JLabel("Please enter expression below.");
		lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 12));
		
		JLabel lblTipAllTrigonometric = new JLabel("Tip: All trigonometric function work in radians.");
		lblTipAllTrigonometric.setFont(new Font("Helvetica", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblValueOfX = new JLabel("Value of x:");
		lblValueOfX.setFont(new Font("Helvetica", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button = new JButton("=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton = new JButton("e^x");
		
		JButton btnSin = new JButton("sin");
		btnSin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnCos = new JButton("cos");
		
		JButton btnTam = new JButton("tan");
		
		JButton btnReturn = new JButton("Return");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTipAllTrigonometric)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblValueOfX)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textField, Alignment.LEADING)
									.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnNewButton)
								.addGap(27)
								.addComponent(btnSin, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(btnCos, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(28)
								.addComponent(btnTam, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(359, Short.MAX_VALUE)
					.addComponent(btnReturn)
					.addContainerGap())
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
					.addGap(7))
		);
		setLayout(groupLayout);

	}
}
