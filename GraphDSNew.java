// https://excalidraw.com/#json=6heSKrIKOLhF_GxTVV5OU,igyGv1nuPm8_hvsQyZ5LIw

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphDS {
    private static void unweightedGraph() {
        int nodes, edges;
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();

        // adjacency matrix
        int[][] adjMat = new int[nodes][nodes];
        for(int i = 0; i < nodes; i++) {
            for(int j = 0; j < nodes; j++) {
                adjMat[i][j] = 0;
            }
        }
        // adjacency list
        int[] arr = new int[nodes];
        ArrayList<Integer>[] adjList = new ArrayList[nodes];

        // in each edges line, we get source and destination of edge for non weighted graph
        for(int i = 0; i < edges; i++) {
            int source, destination;
            source = sc.nextInt();
            destination = sc.nextInt();

            // adjacency matrix.
            adjMat[source][destination] = 1; // this is an edge from source to destination

            // adjacency list
            // put destination in the list of adjList[source]
            if (adjList[source] == null) {
                adjList[source] = new ArrayList<>();
            }
            adjList[source].add(destination);
        }
    }
    public static void main(String[] args) {
        unweightedGraph();
        weightedGraph();
        bfs();
        dfs();
    }

    private static void dfs() { // O(nodes + edges)
        int nodes, edges;
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();

        int[] arr = new int[nodes];
        ArrayList<Integer>[] adjList = new ArrayList[nodes];

        // in each edges line, we get source and destination of edge for non weighted graph
        for(int i = 0; i < edges; i++) {
            int source, destination;
            source = sc.nextInt();
            destination = sc.nextInt();

            // adjacency list
            // put destination in the list of adjList[source]
            if (adjList[source] == null) {
                adjList[source] = new ArrayList<>();
            }
            adjList[source].add(destination);
        }

        int starting;
        starting = sc.nextInt();
        Stack<Integer> q = new Stack<>();
        boolean[] visited = new boolean[nodes];
        for(int i = 0; i < nodes; i++) {
            visited[i] = false; // initially no one is visited
        }

        // start bfs now
        List<Integer> output = new ArrayList<>();
        q.add(starting);
        while(!q.isEmpty()) {
            int front = q.pop(); // extract front node from queue
            output.add(front);

            // iterate over list - adjList[front]
            if (adjList[front] == null) {
                continue;
            }
            for(int i = 0; i < adjList[front].size(); i++) {
                int nextNode = adjList[front].get(i);
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
        // print the output list
        for(int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }

    private static void bfs() { // breadth first search, O(nodes + edges)
        int nodes, edges;
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();

        int[] arr = new int[nodes];
        ArrayList<Integer>[] adjList = new ArrayList[nodes];

        // in each edges line, we get source and destination of edge for non weighted graph
        for(int i = 0; i < edges; i++) {
            int source, destination;
            source = sc.nextInt();
            destination = sc.nextInt();

            // adjacency list
            // put destination in the list of adjList[source]
            if (adjList[source] == null) {
                adjList[source] = new ArrayList<>();
            }
            adjList[source].add(destination);
        }

        int starting;
        starting = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[nodes];
        for(int i = 0; i < nodes; i++) {
            visited[i] = false; // initially no one is visited
        }

        // start bfs now
        List<Integer> output = new ArrayList<>();
        q.add(starting);
        while(!q.isEmpty()) {
            int front = q.poll(); // extract front node from queue
            output.add(front);

            // iterate over list - adjList[front]
            if (adjList[front] == null) {
                continue;
            }
            for(int i = 0; i < adjList[front].size(); i++) {
                int nextNode = adjList[front].get(i);
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
        // print the output list
        for(int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i) + " ");
        }
    }

    private static class Pair {
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static void weightedGraph() {
        int nodes, edges;
        Scanner sc = new Scanner(System.in);
        nodes = sc.nextInt();
        edges = sc.nextInt();

        // adjacency list
        int[][] adjMat = new int[nodes][nodes];
        for(int i = 0; i < nodes; i++) {
            for(int j = 0; j < nodes; j++) {
                adjMat[i][j] = -1;
            }
        }

        // adjacency list
        int[] arr = new int[nodes];
        ArrayList<Pair>[] adjList = new ArrayList[nodes];

        // in each edges line, we get source, destination and weight of edge for non weighted graph
        for(int i = 0; i < edges; i++) {
            int source, destination, weightOfEdge;
            source = sc.nextInt();
            destination = sc.nextInt();
            weightOfEdge = sc.nextInt();

            // adjacency matrix.
            adjMat[source][destination] = weightOfEdge; // this is an edge from source to destination with weight=weightOfEdge

            // adjacency list
            // put destination in the list of adjList[source]
            if (adjList[source] == null) {
                adjList[source] = new ArrayList<>();
            }
            Pair pp = new Pair(destination, weightOfEdge);
            adjList[source].add(pp);
        }
    }
}
