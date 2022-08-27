import java.util.*;

class BfsAlgorithm {
    public static void main(String[] args) {
        int n = 15;
        List<Edge> nodes = Arrays.asList(new Edge(1, 2), new Edge(1, 3), new Edge(1, 4), new Edge(2, 5), new Edge(2, 6), new Edge(4, 7), new Edge(4, 8), new Edge(5, 9), new Edge(5, 10), new Edge(7, 12), new Edge(7, 12));
        Graph graph = new Graph(nodes, n);
        boolean[] visitors = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visitors[i]) {
                visitors[i] = true;
                q.add(i);
                bfsImplementation(graph, q, visitors);
            }
        }
    }

    private static void bfsImplementation(Graph graph, Queue<Integer> q, boolean[] visitors) {
        if (q.isEmpty()) return;
        int nodeIndex = q.poll();
        System.out.print(nodeIndex + " ");
        for (int node : graph.adjList.get(nodeIndex)) {
            if (!visitors[node]) {
                visitors[node] = true;
                q.add(node);
            }
        }
        bfsImplementation(graph, q, visitors);
    }
}

class Edge {
    int src, dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Graph {
    List<List<Integer>> adjList;

    public Graph(List<Edge> nodes, int n) {
        this.adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge node : nodes) {
            int src = node.src;
            int dest = node.dest;
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}