/**
CopyRight:
Project:Algebra Solver
Comment:Teamwork
Course: EE 810 J Engineering Programming in Java
Title: Calculate the result according the RPN rule
JDK Version: 1.8.0_77
Author: (Alphabeta Order) Songnian Yin, Yabin Han, Ying Cui
Create Date: March 26th 2016
Finish Date: Until Now
Description: A program which can solve algebra
*/

import java.util.Stack;

public class ReversePolishNotation
{
	public double RPN(String postfix)
	{
		if(postfix == null || postfix.length() == 0)
			throw new IllegalArgumentException("Input is invalid");
		
		if(postfix.charAt(0) == ' ')
			postfix = postfix.substring(1);
		
		String [] p = postfix.split(" ");
		return RPN(p);
	}
	
	public double RPN(String postfix,double x)
	{
		if(postfix == null || postfix.length() == 0)
			throw new IllegalArgumentException("Input is invalid");
		
		if(postfix.charAt(0) == ' ')
			postfix = postfix.substring(1);
		
		String [] p = subsitution(postfix,x);
		return RPN(p);
		
	}

	private double RPN(String [] tokens)
	{
		Stack<String> stack = new Stack<>();
		String operators = "!esct+-*/%^";

		for(int i = 0;i < tokens.length;i++)
		{
			if(!operators.contains(tokens[i]))
				stack.push(tokens[i]);
			else if(tokens[i].equals(" "))
				continue;
			else
			{
				int index = operators.indexOf(tokens[i]);
				double a = 0;
				double b = 0;
				switch(index)
				{
					case 0:
						a = Double.valueOf(stack.pop());
						stack.push(String.valueOf(factorial((int)a)));
						break;
					case 1:
						a = Double.valueOf(stack.pop());
						stack.push(String.valueOf(Math.exp(a)));
						break;
					case 2:
						a = Double.valueOf(stack.pop());
						stack.push(String.valueOf(Math.sin(a)));
						break;
					case 3:
						a = Double.valueOf(stack.pop());
						stack.push(String.valueOf(Math.cos(a)));
						break;
					case 4:
						a = Double.valueOf(stack.pop());
						stack.push(String.valueOf(Math.tan(a)));
						break;
					case 5:
						a = Double.valueOf(stack.pop());
						b = Double.valueOf(stack.pop());
						stack.push(String.valueOf(b+a));
						break;
					case 6:
						a = Double.valueOf(stack.pop());
						b = Double.valueOf(stack.pop());
						stack.push(String.valueOf(b-a));
						break;
					case 7:
						a = Double.valueOf(stack.pop());
						b = Double.valueOf(stack.pop());
						stack.push(String.valueOf(b*a));
						break;
					case 8:
						a = Double.valueOf(stack.pop());
						b = Double.valueOf(stack.pop());
						stack.push(String.valueOf(b/a));
						break;
					case 9:
						a = Double.valueOf(stack.pop());
						b = Double.valueOf(stack.pop());
						stack.push(String.valueOf((int)b % (int) a));
						break;
					case 10:
						a = Double.valueOf(stack.pop());
						b = Double.valueOf(stack.pop());
						stack.push(String.valueOf(Math.pow(b,(int)a)));
						break;
				}
			}
		}

		return Double.valueOf(stack.pop());
	}

	private String [] subsitution(String postfix,double x)
	{
		String [] p = postfix.split(" ");
		for(int i = 0;i < p.length;i++)
			if(p[i].equals("x"))
				p[i] = String.valueOf(x);
		return p;
	}

	private static int factorial(int x)
	{
		if(x == 0)
				return 1;
		return x * factorial(x-1);
	}
}
