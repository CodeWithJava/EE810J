/**
CopyRight:
Project:Algebra Solver
Comment:Teamwork
Course: EE 810 J Engineering Programming in Java
Title: Convert normal expression or infix expression into postfix expression which called reverse polish notation(RPN)
JDK Version: 1.8.0_77
Author: (Alphabeta Order) Songnian Yin, Yabin Han, Ying Cui
Create Date: March 26th 2016
Finish Date: Until Now
Description: A program which can solve algebra
*/

import java.util.Stack;

public class ConvertRPN
{
	//Convert infix expression to postfix expression which called reverse polish notation(RPN)
	public String inToPost (String infix)
	{
		if(infix == null || infix.length() == 0)
			return null;

		char [] x = infix.toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder postfix = new StringBuilder();

		for(int i = 0;i < x.length;i++)
		{
			switch(x[i])
			{
				case '+':
				case '-':
					while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/'))
						postfix.append(' ').append(stack.pop());
				case '*':
				case '/':
				case '%':
					while(!stack.isEmpty() && stack.peek() == '^')
						postfix.append(' ').append(stack.pop());
				case '^':
					while(!stack.isEmpty() && (stack.peek() == '!' || stack.peek() == 'e' || stack.peek() == 's' || stack.peek() == 'c' || stack.peek() == 't'))
							postfix.append(' ').append(stack.pop());
				case '!':
				case 'e':
				case 's':
				case 'c':
				case 't':
					postfix.append(' ');
				case '(':
					stack.push(x[i]);
				case ' ':
					break;
				case ')':
					while(!stack.isEmpty() && stack.peek() != '(')
						postfix.append(' ').append(stack.pop());
					if(!stack.isEmpty())
						stack.pop();
					break;
				default:
					postfix.append(x[i]);
					break;
			}

		}
		while(!stack.isEmpty())
		{
			if(stack.peek() == '!')
				postfix.append(stack.pop());
			else
				postfix.append(' ').append(stack.pop());
		}
		return postfix.toString();
	}
}
