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
public class TimSort {
     static class TimSort32 {

        static int RUN = 32;

        public static void insertionSort(int[] arr, int left, int right) {
            for (int i = left + 1; i <= right; i++) {
                int temp = arr[i];
                int j = i - 1;
                while (j >= left && arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = temp;
            }
        }

        
        public static void merge(int[] arr, int l,
                int m, int r) {
            int len1 = m - l + 1, len2 = r - m;
            int[] left = new int[len1];
            int[] right = new int[len2];
            for (int x = 0; x < len1; x++) {
                left[x] = arr[l + x];
            }
            for (int x = 0; x < len2; x++) {
                right[x] = arr[m + 1 + x];
            }

            int i = 0;
            int j = 0;
            int k = l;

            while (i < len1 && j < len2) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }

            
            while (i < len1) {
                arr[k] = left[i];
                k++;
                i++;
            }

             
            while (j < len2) {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
  
        public static void timSort(int[] arr, int n) {

            
            for (int i = 0; i < n; i += RUN) {
                insertionSort(arr, i, Math.min((i + 31), (n - 1)));
            }
 
            for (int size = RUN; size < n; size = 2 * size) {

                for (int left = 0; left < n; left += 2 * size) {

                    int right = Math.min((left + 2 * size - 1), (n - 1));
                    int mid = (left + right) / 2;

                    merge(arr, left, mid, right);
                }
            }
        }
    
    static void printArray(int arr[]) 
    { 
            System.out.print(Arrays.toString(arr)); 
        System.out.println(); 
    } 
    }

        static class TimSort64 {

            static int RUN = 64;

            public static void insertionSort(int[] arr, int left, int right) {
                for (int i = left + 1; i <= right; i++) {
                    int temp = arr[i];
                    int j = i - 1;
                    while (j >= left && arr[j] > temp) {
                        arr[j + 1] = arr[j];
                        j--;
                    }
                    arr[j + 1] = temp;
                }
            }

            
            public static void merge(int[] arr, int l,
                    int m, int r) {
                int len1 = m - l + 1, len2 = r - m;
                int[] left = new int[len1];
                int[] right = new int[len2];
                for (int x = 0; x < len1; x++) {
                    left[x] = arr[l + x];
                }
                for (int x = 0; x < len2; x++) {
                    right[x] = arr[m + 1 + x];
                }

                int i = 0;
                int j = 0;
                int k = l;

                while (i < len1 && j < len2) {
                    if (left[i] <= right[j]) {
                        arr[k] = left[i];
                        i++;
                    } else {
                        arr[k] = right[j];
                        j++;
                    }
                    k++;
                }

                
                while (i < len1) {
                    arr[k] = left[i];
                    k++;
                    i++;
                }

                
                while (j < len2) {
                    arr[k] = right[j];
                    k++;
                    j++;
                }
            }
 
            public static void timSort(int[] arr, int n) {

                
                for (int i = 0; i < n; i += RUN) {
                    insertionSort(arr, i, Math.min((i + 63), (n - 1)));
                }
  
                for (int size = RUN; size < n; size = 2 * size) {
 
                    for (int left = 0; left < n; left += 2 * size) {

                        int right = Math.min((left + 2 * size - 1), (n - 1));
                        int mid = (left + right)/2;
                        merge(arr, left, mid, right);
                    }
                }
            }
           static void printArray(int arr[]) 
    { 
            System.out.print(Arrays.toString(arr)); 
        System.out.println(); 
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
        
        
        TimSort32 ob = new TimSort32(); 
        ob.timSort(arr, n); 
  
        System.out.println("sorted array --using Run - 32"); 
        ob.printArray(arr); 
        
        int arr1[] = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6}; 
         TimSort64 ob1 = new TimSort64(); 
        ob1.timSort(arr1, n); 
  
        System.out.println("sorted array --using Run - 64"); 
        ob1.printArray(arr1); 
    } 
}
