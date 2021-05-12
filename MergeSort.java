/*
 * Anusha Peddigari
 * 001023769
 */
package Test;
public class MergeSort {
	
	public static int[] merge(int arr[], int l, int m, int r) 
    { 
        
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        
        return arr;
    } 
	
	public static int[] Sort(int[] arr,int low,int high) {
		if(low<high) {
			int mid = (high+low) / 2;
			Sort(arr,low,mid);
			Sort(arr,mid+1,high);
		    arr = merge(arr,low,mid,high);
			return arr;
			
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {11, 27, 43, 38, 3, 9, 82, 10, 21, 8, 34, 19, 6};
		System.out.println("Before Merge Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		arr = Sort(arr,0,arr.length-1);
		
		System.out.println("Afer Merge Sort");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
