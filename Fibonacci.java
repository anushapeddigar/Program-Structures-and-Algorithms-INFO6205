/*
 * Anusha Peddigari
 * 001023769
 */
package Test;

/**
 *
 * @author 16175
 */
public class Fibonacci {
	
	public static  int getFibonacciRecursion(int n) 
	{
		return n==1 || n==2 ?  1 : getFibonacciRecursion(n-1) + getFibonacciRecursion(n-2);
	}

	public static  void getFibonacciIterative(int n) 
	{
		 int maxNumber = 5; 
		 int previousNumber = 1;
		 int nextNumber = 1;
		 for (int i = 1; i <= maxNumber; ++i)
	        {
	            System.out.print(previousNumber+" ");
	            int sum = previousNumber + nextNumber;
	            previousNumber = nextNumber;
	            nextNumber = sum;
	        }
	}

	public static void main(String[] args) {
		int n = 5;
		String series = "";
		for (int i = 1; i <= n; i++) {
			int val = getFibonacciRecursion(i);
			series += val;
			System .out.println("Fibonacci of "+ i +" using recursion is : " + val );
		}
		System .out.println("Fibonacci series of "+ n +"  using recursion is : " + series );
		System .out.println("Fibonacci of using Iteration is : " );
		 getFibonacciIterative(n);
	}

}
