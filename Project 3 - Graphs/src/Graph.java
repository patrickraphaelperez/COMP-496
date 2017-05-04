import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Graph {
	
	private ArrayList<EdgeNode> [] adjList;
	private int nVertices;
	private int nEdges;
	
	public Graph(String inputFileName){
		//creates Graph from data in file
	}
	
	public Graph(int n){
		//Creates a Graph with n vertices and 0 edges
	}
	
	public void printGraph(){
		//prints nVertices, nEdges, and adjacency lists and total edge weight
	}
	
	public Graph dfsTraversal(int start){
		/*
		 * Use recursion by calling a recursive dfs method. Visit all nodes. 
		 * If graph is not connected you will need to call dfs more than once to visit all nodes.
		 * Print the following information gleaned from the dfs traversal
			-	Print nodes in order visited
			-	Connected?    ____
			-	NumberOfComponents?   _____
			-	Has a cycle?   _______
		 * If the graph is connected, return the spanning tree from the dfs traversal.
		 * Otherwise, return null. 
		 */
	}
	
	public void dijsktraShortestPaths(int start){
		/* Implement Dijkstra algorithm from text or class;
		 * Use the Java PriorityQueue<PQNode>   class. 
		 * Use PQNode class below. The Java PriorityQueue class has no updateKey method.
		 * For our problem, just add a new updated  node to the priority queue. 
		 * This will work for Dijkstra’s algorithm since the new node has a smaller priority than the node you want to update.
		 * See Problem C-14.3 in text.  An alternative is to remove the old node and add a new node. 
		 * Print shortest paths from vertex start to all other vertices reachable from start. Use format from class.
		 */
	}
	
	public Graph kruskalMST(){
		/* Implement Kruskal algorithm from text or class.
		 * You may assume that the graph is connected.
		 * You may sort the edges or use a priority queue.
		 * Use clusters. 
		 * Print the edges of the MST found and its total weight
		 * Return the minimum spanning tree as a Graph  
		 */
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class EdgeNode implements Comparable<EdgeNode>{
	int vertex1;
	int vertex2;
	int weight;
	
	public EdgeNode(int v1, int v2, int w){
		vertex1 = 1;
		vertex2 = 2;
		weight = w;
	}
	
	public int compareTo(EdgeNode node){
		return weight - node.weight;
	}
	
	public String toString(){
		String s = "(";
		s = s + vertex1 + "," + vertex2 + "," + weight + ")";
		return s;
	}	
}

class PONode implements Comparable<PONode>{
	int vertex;
	int distance;
	
	public PONode(int v, int z){
		vertex = v;
		distance = z;
	}
	
	public int compareTo(PONode node){
		return (distance - node.distance);
	}
	
	public String toString(){
		return "(" + vertex + "," + distance;
	}
}