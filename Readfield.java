//package algebra;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Readfield {
	public static void main(String [] args) throws Exception
	{
		System.out.println("Welcome to work with Polynimal System");
		System.out.println("Please select the mode by code");
		System.out.println("1.evaluate 2.compose 3.differentiate 4.integration");
		Scanner in = new Scanner(System.in);
		int select = in.nextInt();
		if(select == 1)
		{
			System.out.println("Please input the polynomial ");
			System.out.println("must: 1x^2+5x^5-5x^0");
			String eq = in.next();
			String a = "([-+]*[0-9]+)x\\^*([-+]*[0-9]+)";
			Pattern p1 = Pattern.compile(a);
			Matcher m1 = p1.matcher(eq);
			Polynomial ep =new Polynomial(0,0);	

			while(m1.find())
			{
				double coef = Double.parseDouble(m1.group(1));
				int exp = Integer.parseInt(m1.group(2));
				Polynomial ep1 =new Polynomial(coef,exp);
				ep = ep.plus(ep1);
			}
			System.out.println(ep);
			System.out.println("Please input the value");
			double val = in.nextDouble();
			System.out.println(ep.evaluate(val));
			
		}
		if(select == 2)
		{
			System.out.println("Please input the polynomial g(f(x)) ");
			System.out.println("must: 1x^2+5x^5-5x^0+0x^0");
			System.out.println("Please input f(x)");
			String eq = in.next();
			String a = "([-+]*[1-9]*)x\\^*([-+]*[2-9]+)";
			Pattern p1 = Pattern.compile(a);
			Matcher m1 = p1.matcher(eq);
			Polynomial fx =new Polynomial(0,0);
			Polynomial gx =new Polynomial(0,0);

			while(m1.find())
			{
				double coef = Double.parseDouble(m1.group(1));
				int exp = Integer.parseInt(m1.group(2));
				Polynomial ep1 =new Polynomial(coef,exp);
				fx = fx.plus(ep1);
			}
			System.out.println(fx);
			System.out.println("Please input g(x)");
			while(m1.find())
			{
				double coef = Double.parseDouble(m1.group(1));
				int exp = Integer.parseInt(m1.group(2));
				Polynomial ep1 =new Polynomial(coef,exp);
				gx = gx.plus(ep1);
			}
			System.out.println(gx);
			System.out.println(gx.compose(fx));
		}
		if(select == 3)
		{
			System.out.println("Please input the polynomial ");
			System.out.println("must: 1x^2+5x^5-5x^0");
			String a = "([-+]*[0-9]+)x\\^*([-+]*[0-9]+)";
			String eq = in.next();
			Pattern p1 = Pattern.compile(a);
			Matcher m1 = p1.matcher(eq);
			Polynomial ep =new Polynomial(0,0);	

			while(m1.find())
			{
				double coef = Double.parseDouble(m1.group(1));
				int exp = Integer.parseInt(m1.group(2));
				Polynomial ep1 =new Polynomial(coef,exp);
				ep = ep.plus(ep1);
			}
			System.out.println(ep);
			System.out.println(ep.differentiate());
			

		}
		if(select == 4)
		{
			System.out.println("Please input the polynomial ");
			System.out.println("must: 1x^2+5x^5-5x^0");
			String eq = in.next();
			String a = "([-+]*[0-9]+)x\\^*([-+]*[0-9]+)";
			Pattern p1 = Pattern.compile(a);
			Matcher m1 = p1.matcher(eq);
			Polynomial ep =new Polynomial(0,0);	

			while(m1.find())
			{
				double coef = Double.parseDouble(m1.group(1));
				int exp = Integer.parseInt(m1.group(2));
				Polynomial ep1 =new Polynomial(coef,exp);
				ep = ep.plus(ep1);
			}
			System.out.println(ep);
			System.out.println(ep.integration());
			System.out.println("Please input the lower limit of integral");
			double vallower = in.nextDouble();
			System.out.println("Please input the upper limit of integral");
			double valupper = in.nextDouble();
			System.out.println(ep.integration(vallower, valupper));
			
		}

		/*String eq = in.next();
		String a = "([-+]*[1-9]*)x\\^*([-+]*[2-9]+)";
		Pattern p1 = Pattern.compile(a);
		Matcher m1 = p1.matcher(eq);
		Polynomial ep =new Polynomial(0,0);	

		while(m1.find())
		{
			System.out.println(m1.group(1));
			System.out.println(m1.group(2));
			double coef = Double.parseDouble(m1.group(1));
			int exp = Integer.parseInt(m1.group(2));
			Polynomial ep1 =new Polynomial(coef,exp);
			ep = ep.plus(ep1);
		}
		System.out.println(ep);*/
		in.close();
	}
}
