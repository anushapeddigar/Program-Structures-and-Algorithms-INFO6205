/*
 * Anusha Peddigari
 * 001023769
 */
package Test;
/**
 *
 * @author 16175
 */
public class HashCode {
    public static int getHashCode(String input){
		return input.hashCode();
	}
	
    public static  double getHashCodeWithImplementation(String input){
    	double result = 0;
    	for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			int ascii = (int)ch;
			double power = (double) Math.pow(31, input.length()-i-1);
			result += (double)ascii*power;
			
		}
    	return result;
	}

	public static void main(String[] args) {
		String input = "Welcome Students to Class";
		System.out.println("Hashcode using BuiltIn method: " + getHashCode(input));
		System.out.println("Hashcode built with logic: " + getHashCodeWithImplementation(input));
		
	}
}
