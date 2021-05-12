/*
 * Anusha Peddigari
 * 001023769
 */

package Test;

import java.util.Arrays;

/**
 *
 * @author 16175
 */
public class QuickSort {
     int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = low; 
        for (int j=low; j<high; j++) 
        { 
            
            if (arr[j] < pivot) 
            { 
               
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
                 i++; 
            } 
        } 
  
        
        int temp = arr[i]; 
        arr[i] = arr[high]; 
        arr[high] = temp; 
  
        return i; 
    } 
  
    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
  
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
  
    
    static void printArray(int arr[]) 
    { 
            System.out.print(Arrays.toString(arr)); 
        System.out.println(); 
    } 
    
     public static void main(String args[]) 
    { 
        int arr[] = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6}; 
        int n = arr.length; 
  
        System.out.println("Before sorting"); 
        printArray(arr);
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
    } 
  
}
