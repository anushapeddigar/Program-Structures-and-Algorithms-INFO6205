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


import java.util.LinkedList;

public class FordFulkerson {
	static final int noOfVertices = 6; 
	  
	   
    boolean bfs(int rGraph[][], int s, int t, int parent[]) 
    { 
        
        boolean visited[] = new boolean[noOfVertices]; 
        for(int i=0; i<noOfVertices; ++i) 
            visited[i]=false; 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        queue.add(s); 
        visited[s] = true; 
        parent[s]=-1; 
        while (queue.size()!=0) 
        { 
            int u = queue.poll(); 
  
            for (int v=0; v<noOfVertices; v++) 
            { 
                if (visited[v]==false && rGraph[u][v] > 0) 
                { 
                    queue.add(v); 
                    parent[v] = u; 
                    visited[v] = true; 
                } 
            } 
        } 
  
       
        return (visited[t] == true); 
    } 
  
    int fordFulkerson(int graph[][], int s, int t) 
    { 
        int u, v; 
        int rGraph[][] = new int[noOfVertices][noOfVertices]; 
  
        for (u = 0; u < noOfVertices; u++) 
            for (v = 0; v < noOfVertices; v++) 
                rGraph[u][v] = graph[u][v]; 
        int parent[] = new int[noOfVertices]; 
        int max_flow = 0;  // There is no flow initially 
        while (bfs(rGraph, s, t, parent)) 
        { 
            int path_flow = Integer.MAX_VALUE; 
            for (v=t; v!=s; v=parent[v]) 
            { 
                u = parent[v]; 
                path_flow = Math.min(path_flow, rGraph[u][v]); 
            } 
            for (v=t; v != s; v=parent[v]) 
            { 
                u = parent[v]; 
                rGraph[u][v] -= path_flow; 
                rGraph[v][u] += path_flow; 
            } 
  
            max_flow += path_flow; 
        } 
        return max_flow; 
    } 
  
    public static void main (String[] args) throws java.lang.Exception 
    { 
        
        int graph[][] =new int[][] {                                    {00, 00, 6, 00, 00, 10}, 
	        							{10, 00, 2, 00, 2, 00},
	           							{4, 00, 00, 00, 5, 0},
	           							{00, 4, 00, 00, 00, 6},
	           							{00, 6, 4, 6, 0, 0},
	           							{0, 0, 0, 4, 10, 0},
                                   }; 
                                   FordFulkerson m = new FordFulkerson(); 
  
        System.out.println("Maximum flow is " + 
                           m.fordFulkerson(graph, 0, 5)); 
  
    } 
}

