import java.util.*;

class Node implements Comparable<Node> {
    String city;
    int distance;

    public Node(String city, int distance) {
        this.city = city;
        this.distance = distance;
    }

@Override
public int compareTo(Node other) {
    return this.distance - other.distance;
}
}

public class Task5 {

    private Map<String, List<Node>> graph = new HashMap<>();

    public Task5() {
        graph.put("Edinburgh", Arrays.asList(
                new Node("Perth", 45),
                new Node("Glasgow", 50)
        ));

        graph.put("Perth", Arrays.asList(
                new Node("Dundee", 22)
        ));

        graph.put("Glasgow", Arrays.asList(
                new Node("Dundee", 80)
        ));

        graph.put("Dundee", new ArrayList<>());
    }

    public void dijkstra(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        for (String city : graph.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }

        distances.put(start, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            for (Node neighbor : graph.get(current.city)) {
                int newDistance = distances.get(current.city) + neighbor.distance;

                if (newDistance < distances.get(neighbor.city)) {
                    distances.put(neighbor.city, newDistance);
                    previous.put(neighbor.city, current.city);
                    pq.add(new Node(neighbor.city, newDistance));
                }
            }
        }

        System.out.println("Shortest distance: " + distances.get(end));

        List<String> path = new ArrayList<>();
        String current = end;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);

        System.out.println("Shortest path: " + String.join(" -> ", path));
    }

    public static void main(String[] args) {
        Task5 d = new Task5();
        d.dijkstra("Edinburgh", "Dundee");
    }
}