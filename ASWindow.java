package Algebra;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ASWindow extends JFrame{
	JFrame frame = new JFrame("Algebra Solver");
	JPanel allp = new JPanel();
	// two son panel
	Algebra.Arith Arith = new Algebra.Arith();
	Algebra.Vari Vari = new Algebra.Vari();	
	CardLayout cl = new CardLayout();
	
	public ASWindow()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		this.setContentPane(allp);
		
		allp.setBorder(new EmptyBorder(5, 5, 5, 5));
		allp.setLayout(cl);
		allp.add(Arith);
		allp.add(Vari);
		
		// add mode buttons
		Font f = new Font("Helvetica", Font.PLAIN, 12);
		JButton btn1 = new JButton("Arithmetics Mode");
		btn1.setFont(f);
		btn1.setBounds(56, 87, 136, 86);
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e1)
			{
				cl.show(allp, "to ari");
			}
		});
		
		JButton btn2 = new JButton("Variable Mode");
		btn2.setFont(f);
		btn2.setBounds(238, 87, 136, 86);
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e2)
			{
				cl.show(allp, "to vari");
			}
		});
		
		allp.add(btn1);
		allp.add(btn2);
		this.add(allp);
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new ASWindow();
			}
		});
	}
}
