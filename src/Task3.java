import java.util.*;

public class Task3 {

    private Map<String, List<String>> graph = new HashMap<>();

    public Task3() {
        graph.put("A", Arrays.asList("C", "B", "D"));
        graph.put("B", Arrays.asList("A", "C", "E", "G"));
        graph.put("C", Arrays.asList("A", "B", "D"));
        graph.put("D", Arrays.asList("C", "A"));
        graph.put("E", Arrays.asList("G", "F", "B"));
        graph.put("F", Arrays.asList("G", "E"));
        graph.put("G", Arrays.asList("F", "B"));
    }

    // DFS Algorithm
    public void dfs(String start) {
        Set<String> visited = new HashSet<>();

        System.out.println("DFS Traversal:");
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(String node, Set<String> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (String neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    // BFS Algorithm
    public void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.println("BFS Traversal:");

        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node + " ");

            for (String neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Task3 g = new Task3();

        g.dfs("A");
        g.bfs("A");
    }
}