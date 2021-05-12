/*
 * Anusha Peddigari
 * 001023769
 */

package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 16175
 */
public class MinPQ {
     private Comparable[] pq;    
    private int N; 
    ArrayList<Integer> list;

    
    public MinPQ(int capacity) {
        this.pq = new Comparable[capacity + 1];
        this.N = 0;
        this.pq[0] = Integer.MIN_VALUE;
        list = new ArrayList<Integer>();
        
    }

    
    public MinPQ() { this(0); }

    public boolean isEmpty() { return N == 0; } 
    public int size()        { return N;      }  
    public Comparable min()  { return pq[1];  }  

    
    private void resize() {
        Comparable[] temp = new Comparable[2*pq.length];
        for (int i = 0; i <= N; i++) temp[i] = pq[i];
        pq = temp;
    }

    
    public void insert(Comparable x) {

        
        if (N >= pq.length - 1) resize();
 pq[++N] = x;
        swim(N);
    }

    
    public Comparable delMax() {
        if (N == 0) throw new RuntimeException("Priority queue underflow");
        swap(1, N);
        Comparable max = pq[N--];
        sink(1);
        pq[N + 1] = null;        
        return max;
    }

    
     public void print() 
    { 
        for (int i = 1; i <= N / 2; i++) { 
            System.out.print(" PARENT : " + pq[i] + " LEFT CHILD : " + 
                      pq[2 * i] + " RIGHT CHILD :" + pq[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    private int parent(int pos) 
    { 
        return pos / 2; 
    } 
  
    private int leftChild(int pos) 
    { 
        return (2 * pos); 
    } 
    private int rightChild(int pos) 
    { 
        return (2 * pos) + 1; 
    } 
  
    
    private boolean isLeaf(int pos) 
    { 
        if (pos >= (N / 2) && pos <= N) { 
            return true; 
        } 
        return false; 
    } 
   
    private void swim(int k) {
        while (k >1 && more(parent(k), k)) {
            swap(k, k/2);
            k = parent(k);
        }
    }

    private void sink(int pos) { 
        
        while (2*pos <= N) { //while position is not any of the leaf nodes
            int j = 2*pos;
            if (j < N && more(j, j+1)) j++;
            if (!more(pos, j)) break;
            swap(pos, j);
            pos = j;
        }
    }
 private boolean more(int i, int j) {
        return pq[i].compareTo(pq[j]) >0;
    }

    private void swap(int i, int j) {
        Comparable swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

 
    public void readFile() {
        Scanner s;
        try {
            s = new Scanner(new File("C:\\Users\\16175\\Downloads\\input.txt"));

            while (s.hasNextLine()) {
                list.add(Integer.parseInt(s.next()));
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }}
    public static void main(String[] args) {
        MinPQ pq = new MinPQ(15);
        pq.readFile();
        System.out.println("Priority Queue is Empty: " + pq.isEmpty());
        System.out.println();
        System.out.println("\nInserting all elements into Min Priority queue");
        
        
        for (int i = 0; i < pq.list.size(); i++) {
            pq.insert(pq.list.get(i));
        }
        
        pq.print();
        System.out.println("Priority Queue is Empty: " + pq.isEmpty());
        System.out.println();
        System.out.println("\nDeleting all elements from Min Priority queue");
        
     
       while (!pq.isEmpty())
            System.out.println(pq.delMax());
    
    
     System.out.println("Priority Queue is Empty: " + pq.isEmpty());
        System.out.println();
        System.out.println("\nInserting all elements into Min Priority queue");
        
        
        for (int i = 0; i < pq.list.size(); i++) {
            pq.insert(pq.list.get(i));
        }
    
        
        System.out.println("Priority Queue is Empty: " + pq.isEmpty());
        System.out.println();
        
        pq.print();
         System.out.println("\nSize of Priority Queue " + pq.size());
        System.out.println();
         System.out.println("\nMin element of Priority Queue " + pq.min());
        System.out.println();
        
    

    }
}
