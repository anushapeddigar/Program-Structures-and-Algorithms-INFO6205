/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author 16175
 */
class CountBinary
{ 
    public static int countBinary (int n)
{
// break cases
if(n == 0) // 1 string of length 0
return 1;
if(n == 1) // 2 strings: 1 and 0
return 2;

// The number of such strings is the number of strings that start with a 0 plus the number of strings that start with 10.
return countBinary (n-1) + countBinary (n-2);
}
    public static void main (String args[]) 
    { 
          System.out.println(countBinary (3)); 
    } 
}