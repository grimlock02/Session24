import java.util.*;

public class GraphTraversal {
    private int V; // Jumlah vertex
    private LinkedList<Integer>[] adj; // Adjacency List

    @SuppressWarnings("unchecked")
    public GraphTraversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Menambahkan edge ke graph (Undirected Graph)
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // Implementasi BFS
    public void BFS(int startNode) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        System.out.print("Hasil BFS (mulai dari node " + startNode + "): ");

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Implementasi DFS (Helper Rekursif)
    private void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // Fungsi Utama DFS
    public void DFS(int startNode) {
        boolean[] visited = new boolean[V];
        System.out.print("Hasil DFS (mulai dari node " + startNode + "): ");
        DFSUtil(startNode, visited);
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal(5);

        // Menambahkan hubungan antar vertex
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);

        // Jalankan Traversal
        graph.BFS(0);
        graph.DFS(0);
    }
}