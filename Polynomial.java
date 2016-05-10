package algebra;

import java.util.Random;

public class Polynomial {
	private double [] coef;//coefficients
	private int deg;
	
	//construct a*x^b
	public Polynomial(double a , int b)
	{
		coef  = new double [b+1];
		coef[ b ] = a;
		deg = degree();
	}
	
	// retrun the degree of this polynomial, index of the array is the degree
	public int degree()
	{
		int d = 0;
		for( int i = 0; i <coef.length ; i++)
			if( coef [i] != 0  )
				d = i;
		return d;
	}
	
	//plus:a*x^2 + b* x^3
	public Polynomial plus(Polynomial b)
	{
		Polynomial c = new Polynomial(0,Math.max(this.deg,b.deg));
		for( int i =0; i <= this.deg;i++)
			c.coef[i] += this.coef[i];
		for( int i = 0; i <= b.deg; i++)
			c.coef[i] += b.coef[i];
		c.deg = c.degree();
		return c;
	}
	
	//minus
	public Polynomial minus(Polynomial b)
	{
		Polynomial c = new Polynomial(0,Math.max(this.deg, b.deg));
		for(int i =0 ; i <= this.deg; i++)
			c.coef[ i ] += this.coef[ i ];
		for( int i = 0 ; i <= b.deg ; i++)
			c.coef[ i ] -= b.coef[ i ];
		c.deg = c.degree();
		return c;
	}
	
	//multiply
	public Polynomial time(Polynomial b)
	{
		Polynomial c = new Polynomial(0,this.deg+b.deg);
		for( int i = 0; i <= this.deg ; i++)
			for( int j = 0; j <= b.deg ; j++)
				c.coef[ i +j ] += this.coef[ i ] *b.coef[ j ];
		c.deg = c.degree();
		return c;
	}
	
	// return a(b(x)) because polynomial can write as :a0+x(a1+x(a2+x(a3+....x(an-1+an*x))))
	public Polynomial compose(Polynomial b)
	{
		Polynomial c = new Polynomial (0 , 0);
		for( int i = this.deg ; i >= 0; i-- )
			{
				Polynomial term = new Polynomial (this.coef[ i ], 0);
				c = term.plus(b.time(c));
			}
		return c;
	}
	
	//evaluate(value)
	public double evaluate (double x)
	{
		double p = 0;
		for( int i = this.deg ; i >=0 ; i--)
			p = coef[ i ] + (x *p);
		
		return p;
	}
	
	//differentiate this polynomial and return it
	public Polynomial differentiate()
	{
		if (this.deg == 0)
			return new Polynomial(0,0);
		Polynomial deriv = new Polynomial (0, this.deg -1);
		deriv.deg = this.deg -1;// all the deg =  deg -1 
		for( int i = 0 ; i < this.deg ; i++)
			deriv.coef [ i ] = (i+1) * coef[i +1];// new coef = coef * degree
		return deriv;
	}
	//integration with lower limite of integration and upper limite of integration
	public double integration(double a, double b)
	{
		Polynomial d =this.integration();
		return (d.evaluate(b)-d.evaluate(a));
	}
	
	public Polynomial integration()
	{
		Polynomial integral = new Polynomial(1,this.deg+1);// all degree +1
		for(int i = 0; i <= this.deg+1; i ++)
		{
			if( i == 0 )
			{
				integral.coef[ i ] = 0;
			}
			else
				integral.coef[ i ] = this.coef[i-1] / i;//new coef
		}
		return integral;
	}
	//print the polynomial
	public String toString()
	{
		if(deg ==0)
			return ""+coef[0];
		if(deg ==1)
			return coef[ 1 ]+"x +"+ coef[0];
		String s = coef[deg] +"x^"+deg;
		for( int  i = deg -1 ; i >= 0 ;i--)
		{
			if ( coef [ i ] ==0)
				continue;
			else if( coef[ i ] > 0)
				s = s+ "+" +coef[i];
			else if( coef[ i ] < 0)
				s = s+"-"+(-coef[i]);
			if ( i == 1)
				s = s + "x";
			else if(i > 1)
				s = s + "x^"+i;
		}
		return s;
	}
	//netown method:x(n) = x(n-1)-dx still work on this problem
	public double root()
	{
		//Random a = new Random();did not work well, can not promise find the right answers 
		//double x = 10*(a.nextDouble()-0.5);
		double x = 3.2;// can not promise find all  answers
		Polynomial da = this.differentiate();
		for(int i = 0 ; i < 1000000000 ; i++)
		{
			double dx = (this.evaluate(x))/da.evaluate(x);// dx = f(x(n-1))/df(x(n-1))
			if( dx<= 0.0000000000001)
			{
				return x;
			}
			else
			{
				x = x - dx;
			}
		}
		return -1;
		// still can not find the good balance of the dx and itertation times.
	}
	
	//test all the method:
	public static void main(String [] args)
	{
		/*Polynomial s1 = new Polynomial(3,3);
		Polynomial s2 = new Polynomial(2,2);
		Polynomial s3 = new Polynomial(1,1);
		Polynomial s4 = new Polynomial(1,0);
		Polynomial s5 = ((s1.plus(s2)).plus(s3)).plus(s4);
		Polynomial s6 = ((s1.minus(s2)).plus(s3)).minus(s4);
		Polynomial s7 = s1.time(s2);
		Polynomial s8 = s2.compose(s1);
		System.out.println(s5);
		System.out.println(s5.differentiate());
		System.out.println(s5.integration());
		System.out.println(s5.integration(-10,10));
		
		System.out.println(s6);
		System.out.println(s7);
		System.out.println(s8);
		System.out.println(s3);*/
		Polynomial s1 = new Polynomial(1,2);
		Polynomial s2 = new Polynomial(-4,0);
		s1=s1.plus(s2);
		System.out.println(s1);
		System.out.println(s1.root());
		Polynomial s3 = new Polynomial(3,3);
		s1 = s1.plus(s3);
		System.out.println(s1);
		System.out.println(s1.root());
		Polynomial s4 = new Polynomial(-3,5);
		s1 = s1.plus(s4);
		System.out.println(s1);
		System.out.println(s1.root());
		

		
	}
}
	

