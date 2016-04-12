package algebra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
	public static void main(String [] args) throws Exception 
	{
		//Scanner data = new Scanner(new FileInputStream("D:\\data1.txt"));
		BufferedReader in = new BufferedReader(new FileReader("D:\\data1.txt"));
		String Line;
		
	
		while((Line= in.readLine()) != null)
		{
			String pattern1 = "([-+]*[0-9xy]+\\^*[2-9]*)([-+*/]+)([0-9xy]+\\^*[2-9]*)";
			Pattern r1 = Pattern.compile(pattern1);
			Matcher m1 = r1.matcher(Line);
			if(m1.find())
			{
				System.out.println(m1.group(1));
				System.out.println(m1.group(2));
				System.out.println(m1.group(3));
			}
			String pattern2 ="(inte)\\s*(-*[0-9]*\\.*[0-9]*pi)\\s*(-*[0-9]*\\.*[0-9]*pi)\\s*(sinx)";
			Pattern r2 = Pattern.compile(pattern2);
			Matcher m2 = r2.matcher(Line);
			if(m2.find())
			{
				System.out.println(m2.group(1));
				System.out.println(m2.group(2));
				System.out.println(m2.group(3));
				System.out.println(m2.group(4));
			}
			String pattern3 ="(inte)\\s*(-*[0-9]*\\.*[0-9]*pi)\\s*(-*[0-9]*\\.*[0-9]*pi)\\s*(cosx)";
			Pattern r3 = Pattern.compile(pattern3);
			Matcher m3 = r3.matcher(Line);
			if(m3.find())
			{
				System.out.println(m3.group(1));
				System.out.println(m3.group(2));
				System.out.println(m3.group(3));
				System.out.println(m3.group(4));
			}
			
		}
	}
}
