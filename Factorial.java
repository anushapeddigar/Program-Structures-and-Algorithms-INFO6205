/*
 * Anusha Peddigari
 * 001023769
 */
package Test;

/**
 *
 * @author 16175
 */

public class Factorial {
	
	public static int getFactorial(int n) 
	{
		return ( n==0 || n==2 || n==1) ?  n :  n * getFactorial(n - 1);
	}

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Factorial of "+n+" is :" + getFactorial(n));

	}

}
