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
Description: Main window
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame implements ActionListener
{
	JButton[] bmode = new JButton[2];
	public MainFrame()
	{
		super("Mode Select");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		Container c = getContentPane();
		
		// two mode selection button
		JPanel p = new JPanel();
//		p.setLayout(new GridLayout());
		String[] mode = {"Arithmetics Mode", "Variable Mode"};
		for (int i = 0; i < mode.length; i++)
		{
			bmode[i] = new JButton(mode[i]);
			bmode[i].addActionListener(this);
			p.add(bmode[i]);
		}
		c.add(BorderLayout.CENTER, p);
		this.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == bmode[0])
			new ArithFrame();
		else if (e.getSource() == bmode[1])
			new VariFrame();
	}
}

