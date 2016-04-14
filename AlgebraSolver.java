import java.util.Stack;
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
			String postfix = new AlgebraSolver().inToPost(x);
			double result = new AlgebraSolver().RPN(postfix);
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
			String postfix = new AlgebraSolver().inToPost(x);
			System.out.println("Please input the value of variable x");
			double p = Double.valueOf(n.next());
			double result = new AlgebraSolver().RPN(postfix,p);
			System.out.println("Result:" + result);
			n.close();
		}
		else
			System.out.println("Please input right code");
		scanner.close();
	}

	private double RPN(String postfix)
	{
		if(postfix == null || postfix.length() == 0)
			throw new IllegalArgumentException("Input is invalid");
		
		if(postfix.charAt(0) == ' ')
			postfix = postfix.substring(1);
		
		String [] p = postfix.split(" ");
		return RPN(p);
	}
	
	private double RPN(String postfix,double x)
	{
		if(postfix == null || postfix.length() == 0)
			throw new IllegalArgumentException("Input is invalid");
		
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

	private String inToPost (String infix)
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