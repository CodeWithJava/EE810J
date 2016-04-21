package Algebra;

/**
CopyRight:
Project:Algebra Solver
Comment:Teamwork
Course: EE 810 J Engineering Programming in Java
Title: AlgebraSolver Main Method
JDK Version: 1.8.0_77
Author: (Alphabeta Order) Songnian Yin, Yabin Han, Ying Cui
Create Date: March 26th 2016
Finish Date: Until Now
Description: Window for Arithmetics Mode
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArithFrame extends JFrame implements ActionListener
{
	JButton[] bcal = new JButton[4];
	JTextField display = new JTextField();
	public ArithFrame()
	{
		super("Arithmetics Mode");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		Container c = getContentPane();
		
		String[] cal = {"Expon", "sin", "cos", "tan"};
		for (int i = 0; i < cal.length; i++)
		{
			bcal[i] = new JButton(cal[i]);
			bcal[i].addActionListener(this);
			c.add(bcal[i]);
		}
		// TextField frame
		c.add(BorderLayout.CENTER, display = new JTextField(""));
		Font f = new Font("Times", Font.PLAIN, 70);
		display.setFont(f);
		display.setEditable(true);
		
		// equal button
		JButton beql = new JButton("=");
		beql.addActionListener(new Solver());
		c.add(beql);
		
		// return button: return to main frame
		JButton rb = new JButton("Return");
		rb.addActionListener(new MainFrame());
		c.add(rb);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e1)
	{
		display.setText(display.getText().concat(((JButton)e1.getSource()).getText()));
	}
	class Solver
	{
		public void actionPerformed(ActionEvent e2)
		{
			String postfix = new ConvertRPN().inToPost(display.getText());
			double result = new ReversePolishNotation().RPN(postfix);
		}
	}
}
