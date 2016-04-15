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
Description: A program which can solve algebra
*/

import java.util.Scanner;

public class AlgebraSolver
{
	public static void main(String [] args)
	{
		System.out.println("Welcome to work with Algebra Solver System");
		System.out.println("Please select the mode by code");
		System.out.println("1: Arithmetics Mode 2: Variable Mode");
		Scanner scanner = new Scanner(System.in);
		int select = scanner.nextInt();
		if(select == 1)
		{
			System.out.println("Please input the arithmetics expression");
			System.out.println("e: exp s: sin c: cos t: tan and trigonometric function works with radians");
			System.out.println("Example: s(2) + 1, 1 * 5 + 2");
			Scanner m = new Scanner(System.in);
			String x = m.nextLine();
			String postfix = new ConvertRPN().inToPost(x);
			double result = new ReversePolishNotation().RPN(postfix);
			System.out.println("Result:" + result);
			m.close();
		}
		else if(select == 2)
		{
			System.out.println("Please input the arithmetics expression with variable");
			System.out.println("e: exp s: sin c: cos t: tan and trigonometric function works with radians");
			System.out.println("Example: s(2*x) + 1, 1 * 5 + 2 and variable are x only");
			Scanner n = new Scanner(System.in);
			String x = n.nextLine();
			String postfix = new ConvertRPN().inToPost(x);
			System.out.println("Please input the value of variable x");
			double p = Double.valueOf(n.next());
			double result = new ReversePolishNotation().RPN(postfix,p);
			System.out.println("Result:" + result);
			n.close();
		}
		else
			System.out.println("Please input right code");
		scanner.close();
	}
}