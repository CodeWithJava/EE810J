package algebra;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Readfield {
	public static void main(String [] args) throws Exception
	{
		System.out.println("输入多项式以及操作");
		Scanner in = new Scanner(System.in);
		String eq = in.next();
		String a = "([-+]*[2-9]*)x\\^*([-+]*[2-9]+)";
		//String b ="([-+]*[0-9]+)([-+*/])([0-9]+)";
		Pattern p1 = Pattern.compile(a);
		//Pattern p2 = Pattern.compile(b);
		Matcher m1 = p1.matcher(eq);
		//Matcher m2 = p2.matcher(eq);
		Polynomial ep =new Polynomial(0,0);	
		while(eq !=null)
		{
			/*if(m2.find())
			{
				System.out.println(m2.group(1));
				System.out.println(m2.group(2));
				System.out.println(m2.group(3));
			}*/
			if(m1.find())
			{
				System.out.println(m1.group(1));
				System.out.println(m1.group(2));
				double coef = Double.parseDouble(m1.group(1));
				int exp = Integer.parseInt(m1.group(2));
				Polynomial ep1 =new Polynomial(coef,exp);
				ep.plus(ep1);
			}
			System.out.println(ep);
		}
		in.close();
	}
	String x = "abcd";

	
}
