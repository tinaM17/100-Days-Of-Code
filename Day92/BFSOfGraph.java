// Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
// Note: One can move from node u to node v only if there's an edge from u to v. Find the BFS traversal of the graph starting from the 0th vertex, from left to right according to the input graph. Also, you should only take nodes directly or indirectly connected from Node 0 in consideration.


// Example 1:

// Input:

// Output: 0 1 2 3 4
// Explanation: 
// 0 is connected to 1 , 2 , 3.
// 2 is connected to 4.
// so starting from 0, it will go to 1 then 2
// then 3. After this 2 to 4, thus bfs will be
// 0 1 2 3 4.
// Example 2:

// Input:

// Output: 0 1 2
// Explanation:
// 0 is connected to 1 , 2.
// so starting from 0, it will go to 1 then 2,
// thus bfs will be 0 1 2. 

// Your task:
// You dont need to read input or print anything. Your task is to complete the function bfsOfGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns  a list containing the BFS traversal of the graph starting from the 0th vertex from left to right.


// Expected Time Complexity: O(V + E)
// Expected Auxiliary Space: O(V)

// Graph: A graph is a mathematical representation of a set of objects where some pairs of the objects are connected by links. These objects are often called "vertices" or "nodes," and the links are called "edges." Graphs are used to model various real-world scenarios and relationships.

// Directed Graph (Digraph): In a directed graph, edges have a direction, meaning they go from one vertex to another. It represents relationships where a particular order matters.

// Undirected Graph: In an undirected graph, edges do not have a direction. The relationship between vertices is symmetric, and edges represent mutual connections.

// Sparse Graph: A sparse graph is a graph in which the number of edges is much smaller than the maximum possible edges.

// Dense Graph: A dense graph is a graph in which the number of edges is close to the maximum possible edges.

// Adjacency Matrix: An adjacency matrix is a two-dimensional array that represents the connections between vertices in a graph. If there is an edge between vertices i and j, then matrix[i][j] is 1; otherwise, it's 0. For weighted graphs, the matrix stores the weights instead of 1s and 0s.

// Adjacency List: An adjacency list is a collection of lists, where each list represents the set of vertices adjacent to a particular vertex. It's a more memory-efficient way to represent sparse graphs.

// Weighted Graph: A weighted graph is a graph in which a weight or cost is assigned to each edge. These weights can represent distances, costs, or any other relevant metric.

// Vertices: Vertices (or nodes) are the fundamental units in a graph that represent the objects or entities being modeled.

// Edges: Edges are the connections between vertices in a graph, representing relationships or interactions between the corresponding objects.

// Breadth-First Search (BFS) Algorithm: BFS is a graph traversal algorithm that starts from a specified vertex and explores its neighbors level by level. It visits all the vertices at the same level before moving on to the next level. BFS is implemented using a queue data structure and is often used to find the shortest path in unweighted graphs.

package Day92;

//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                // adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return Breadth First Traversal of given graph.
   public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    Queue<Integer> q = new ArrayDeque<>(); // Queue for BFS traversal
    int visited[] = new int[V]; // Array to track visited nodes
    ArrayList<Integer> nodes = new ArrayList<Integer>(); // List to store BFS result
    
    // Initializing the visited array with zeros
    for (int i = 0; i < V; i++) {
        visited[i] = 0;
    }
    
    q.add(0); // Adding the starting node (0) to the queue
    nodes.add(0); // Adding the starting node (0) to the result list
    visited[0] = 1; // Marking the starting node as visited
    
    // BFS traversal loop
    while (!q.isEmpty()) {
        int curr = q.remove(); // Removing the front element from the queue
        
        // Iterating through neighbors of the current node
        for (int i = 0; i < adj.get(curr).size(); i++) {
            int neighbor = adj.get(curr).get(i); // Get the current neighbor
            
            // Checking if the neighbor is not visited
            if (visited[neighbor] == 0) {
                visited[neighbor] = 1; // Marking the neighbor as visited
                q.add(neighbor); // Adding the neighbor to the queue
                nodes.add(neighbor); // Adding the neighbor to the result list
            }
        }
    }
    
    return nodes; // Returning the BFS result
}

}
