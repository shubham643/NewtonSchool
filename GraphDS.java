// 25th march- https://1drv.ms/u/s!ApNLaUHTgtzbkHna1aR740JYngeq?e=ypIbYi
// Graph
// vertex, edge
// connected/ disconnected
// Cyclic/non-cyclic (or acyclic)
// directed/undirected
// bfs/dfs
// tree is non-cyclic directed graph
// Representation - 1. adjacency matrix, 2. adjacency list

import java.util.*;

class GraphAdjacencyMatrix {
    int[][] graph;

    public GraphAdjacencyMatrix() { // constructor is creating graph
        Scanner sc = new Scanner(System.in);
        System.out.println("input number of nodes");
        int n = sc.nextInt();
        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0;j  < n; j++) {
                graph[i][j] = 0;
            }
        }
        int edges;
        System.out.println("input number of edges");
        edges = sc.nextInt();
        for(int i = 0; i < edges; i++) {
            System.out.println("input edge");
            int starting = sc.nextInt();
            int ending = sc.nextInt();
            graph[starting][ending] = 1;
        }
    }

    public void bfs() { // in adjacency matrix using stack. O(n*n)
        int n = graph.length;
        // print bfs of tree
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            visited[i] = false;
        }
        // we need to traverse whole graph.
        for(int start = 0; start < n; start++) {
            // start bfs considering start as source node
            q.add(start);
            if (!visited[start]) {
                visited[start] = true;
                bfs_util(q, visited, n);
            }
        }
    }

    private void bfs_util(Queue<Integer> q, boolean[] visited, int n) {
        while(!q.isEmpty()) {
            // pop first element
            int front = q.remove();
            // print element
            System.out.print(front);
            // push connected non-visited nodes in queue
            for(int i = 0; i < n; i++) {
                if (graph[front][i] == 1) {
                    // it means there is edge between front -> i
                    if (!visited[i]) {
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }
}

class GraphAdjacencyList {
    ArrayList<ArrayList<Integer> > graph;

    public GraphAdjacencyList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("input number of nodes");
        int n = sc.nextInt();
        graph = new ArrayList<>(n);
        int edges;
        System.out.println("input number of edges");
        edges = sc.nextInt();
        for(int i = 0; i < edges; i++) {
            System.out.println("input edge");
            int starting = sc.nextInt();
            int ending = sc.nextInt();
            graph.get(starting).add(ending);
        }
    }

    public void bfs() { // O(n+e)
        int n = graph.size();
        // print bfs of tree
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            visited[i] = false;
        }
        // we need to traverse whole graph.
        for(int start = 0; start < n; start++) { // to handle disconnected graphs
            // start bfs considering start as source node

            if (!visited[start]) {
                q.add(start);
                visited[start] = true;
                bfs_util(q, visited);
            }
        }
    }
    private void bfs_util(Queue<Integer> q, boolean[] visited) {
        while(!q.isEmpty()) {
            // pop first element
            int front = q.remove();
            // print element
            System.out.print(front);
            // push connected non-visited nodes in queue
            for(int i = 0; i < graph.get(front).size(); i++) {
                int element = graph.get(front).get(i);
                if (!visited[element]) {
                    q.add(element);
                    visited[element] = true;
                }
            }
        }
    }

    public void dfs() { // O(n+e)
        int n = graph.size();
        // print bfs of tree
        Stack<Integer> stk = new Stack<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            visited[i] = false;
        }
        // we need to traverse whole graph.
        for(int start = 0; start < n; start++) { // to handle disconnected graphs
            // start bfs considering start as source node
            if (!visited[start]) {
                stk.add(start);
                visited[start] = true;
                dfs_util(stk, visited);
            }
        }
    }
    private void dfs_util(Stack<Integer> stk, boolean[] visited) {
        while(!stk.isEmpty()) {
            // pop first element
            int front = stk.pop();
            // print element
            System.out.print(front);
            // push connected non-visited nodes in queue
            for(int i = 0; i < graph.get(front).size(); i++) {
                int element = graph.get(front).get(i);
                if (!visited[element]) {
                    stk.add(element);
                    visited[element] = true;
                }
            }
        }
    }

    public int distance(int source, int destination) {
        int n = graph.size();
        // print bfs of tree
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            visited[i] = false;
        }
        q.add(source);
        q.add(-1);
        visited[source] = true;
        int distance = 0;
        while(q.size() != 1) {
            int front = q.remove();
            // print element
            if (front == -1) {
                distance++;
                q.add(-1);
                continue;
            }
            for(int i = 0; i < graph.get(front).size(); i++) {
                int element = graph.get(front).get(i);
                if (element == destination) {
                    return distance;
                }
                if (!visited[element]) {
                    q.add(element);
                    visited[element] = true;
                }
            }
        }
        return -1;
    }
    
    class Pair {
        int x;
        int y;
        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }
    
    public boolean isConnected(int[][] mat) {
        int rows = 5;
        int columns = 10;
        Pair source = new Pair(0,0);
        Pair destination = new Pair(4,9);
        Queue<Pair> q = new LinkedList<>();
        q.add(source);
        while(!q.isEmpty()) {
            Pair node = q.remove();
            if (node.x == destination.x && node.y == destination.y) {
                return true;
            }
            Pair temp;
            // try right side
            if (node.y != 9) {
                // it is not the rightmost column
                temp = new Pair(node.x, node.y+1);
            }
            // try down side
            if (node.x != 4) {
                // it is not the downmost row
                temp = new Pair(node.x+1, node.y);
            }
            if (mat[temp.x][temp.y] == 0) {
                q.add(temp);
            }
        }
        return false;
    }
    
}

public class GraphDS {

    public static void main(String[] args) {
        // Question: Given n cities(numbered 0 to n-1) and road connection between them, tell whether we can reach from x to y?
        // inputformat:
        // n // first line
        // x y // second line
        // e // number of edges, then following e lines contains the edges with space separation
        // sample
        // 5
        // 2 0 // means can we reach 0 from 2
        // 5
        // 0 1
        // 2 3
        // 2 4
        // 4 0
        // 2 0
        //
        GraphAdjacencyMatrix matrix = new GraphAdjacencyMatrix();
    }
}
