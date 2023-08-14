// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.

// Example 1:

// Input:
// Output: 1
// Explanation: 3 -> 3 is a cycle

// Example 2:

// Input:
// Output: 0
// Explanation: no cycle in the graph

// Your task:
// You dont need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list adj as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.
// In the adjacency list adj, element adj[i][j] represents an edge from i to j.


// Expected Time Complexity: O(V + E)
// Expected Auxiliary Space: O(V)


// Undirected Graph Cycle Detection:

// Algorithm Focus: The algorithm focuses on finding back edges while performing a Depth-First Search (DFS) traversal of the graph.

// Back Edge Handling: When exploring a vertex's neighbors, the algorithm checks if the neighbor has already been visited. If it has been visited and is not the immediate parent of the current vertex being explored, it implies the existence of a cycle.

// Parent Consideration: The algorithm keeps track of the parent vertex that led to the current vertex to avoid considering the parent as part of a cycle. This prevents false positives in cycle detection in undirected graphs.

// Directed Graph Cycle Detection:

// Algorithm Focus: The algorithm is designed to identify cycles in directed graphs using DFS.

// Recursion Stack: Unlike the undirected graph algorithm, a directed graph can have cycles that don't involve the immediate parent. To handle this, the algorithm maintains a "recursion stack" that tracks the vertices currently being explored within the DFS recursion.

// Back Edge Handling: The algorithm checks if a vertex being explored is already present in the recursion stack. If it is, that means there's a back edge pointing to a vertex currently in the recursion stack, indicating a cycle.

// Recursion Stack Cleanup: To ensure accurate cycle detection, the algorithm removes a vertex from the recursion stack when the DFS recursion for that vertex is complete. This cleanup step is crucial to distinguish between cycles and normal back edges in a directed graph.

// In a nutshell, the main technical difference between the two algorithms lies in how they handle cycles involving back edges. The undirected graph algorithm uses the concept of a parent vertex to avoid including the parent in cycle detection. On the other hand, the directed graph algorithm relies on a "recursion stack" to keep track of vertices in the current recursion, accurately identifying cycles even if the cycle does not involve the immediate parent.

package Day95;

//{ Driver Code Starts
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V]; // Array to track visited vertices
        boolean recStack[] = new boolean[V]; // Array to track vertices in recursion stack
        
        // Iterate through all vertices and start DFS from unvisited vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true; // If cycle is detected, return true
                }
            }
        }
        return false; // If no cycle is detected, return false
    }
    
    // Recursive DFS function to detect cycle
    private boolean dfs(int currV, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] recS) {
        vis[currV] = true; // Mark the current vertex as visited
        recS[currV] = true; // Mark the current vertex in the recursion stack
        
        for (Integer neighbour : adj.get(currV)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, adj, vis, recS)) {
                    return true; // Recursively check for cycle in the subgraph
                }
            } else if (recS[neighbour]) {
                return true; // If an already visited vertex is in recursion stack, a cycle is found
            }
        }
        
        recS[currV] = false; // Mark the current vertex as not in recursion stack
        return false; // No cycle found in this subgraph
    }
}

