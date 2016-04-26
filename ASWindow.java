
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ASWindow extends JFrame
{
	JPanel allp = new JPanel();
	// Mode panel
	Mode Mode = new Mode();
	// two son panel
	Arith Arith = new Arith();
	SecondMode SecondMode = new SecondMode();
	Vari Vari = new Vari();	
	Diff Diff = new Diff();
	Int int1 = new Int();
	CardLayout cl = new CardLayout();
	
	public ASWindow()
	{
		super("Algebra Solver");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		allp.setLayout(cl);
		
		// add mode buttons
		JButton btn1 = (JButton) Mode.getComponent(0);
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e1)
			{
				cl.show(allp, "sm");
			}
		});	
		JButton btn2 = (JButton) Mode.getComponent(1);
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e2)
			{
				cl.show(allp, "ari");
			}
		});
		
		JButton btn3 = (JButton) Arith.getComponent(8);
		btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e3)
			{
				cl.show(allp, "mode");
			}
		});
		
		JButton btn4 = (JButton) SecondMode.getComponent(3);
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e4)
			{
				cl.show(allp, "mode");
			}
		});
		
		JButton btn5 = (JButton) SecondMode.getComponent(2);
		btn5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e5)
			{
				cl.show(allp, "vari");
			}
		});
		
		JButton btn6 = (JButton) Vari.getComponent(7);
		btn6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e6)
			{
				cl.show(allp, "sm");
			}
		});
		
		JButton btn7 = (JButton) SecondMode.getComponent(1);
		btn7.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e7)
			{
				cl.show(allp, "diff");
			}
		});
		
		JButton btn8 = (JButton) Diff.getComponent(4);
		btn8.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e8)
			{
				cl.show(allp, "sm");
			}
		});
		
		JButton btn9 = (JButton) int1.getComponent(7);
		btn9.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e9)
			{
				cl.show(allp, "sm");
			}
		});
		
		JButton btn10 = (JButton) SecondMode.getComponent(0);
		btn10.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e10)
			{
				cl.show(allp, "integral");
			}
		});
		
		
		allp.add(Mode, "mode");
		allp.add(Arith, "ari");
		allp.add(Vari, "vari");
		allp.add(SecondMode, "sm");
		allp.add(Diff, "diff");
		allp.add(int1, "integral");
		
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
				new ASWindow().setVisible(true);;
			}
		});
	}
}
