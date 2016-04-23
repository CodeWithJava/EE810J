
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
	Vari Vari = new Vari();	
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
				cl.show(allp, "ari");
			}
		});	
		JButton btn2 = (JButton) Mode.getComponent(1);
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e2)
			{
				cl.show(allp, "vari");
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
		
		JButton btn4 = (JButton) Vari.getComponent(7);
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e4)
			{
				cl.show(allp, "mode");
			}
		});
		
		
		allp.add(Mode, "mode");
		allp.add(Arith, "ari");
		allp.add(Vari, "vari");
		
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
