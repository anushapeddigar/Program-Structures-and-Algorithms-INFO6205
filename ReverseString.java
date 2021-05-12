/*
 * Anusha Peddigari
 * 001023769
 */

package Test;

/**
 *
 * @author 16175
 */
import java.util.Scanner;
 
public class ReverseString
{
 public static void main(String[] args)
 {

 String str = "BooksToRead";
 String reverse = "";
 
 StringBuilder rev = new StringBuilder();
 
 
 for(int i = str.length() - 1; i >= 0; i--)
 {
 reverse = reverse + str.charAt(i);
 }
 
 
 for(int i = str.length() - 1; i >= 0; i--)
 {
 rev = rev.append(str.charAt(i)) ;
 }
 
 System.out.println("Reversed string is:");
 System.out.println(reverse);
 
  System.out.println("Reversed string using StringBuilder is:");
 System.out.println(rev);
 }
}