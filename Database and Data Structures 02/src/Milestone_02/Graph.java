package Milestone_02;

import java.util.*;

public class Graph {
    private Map<String, Node> nodes;
    private List<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    public void addNode(String name) {
        Node node = new Node(name);
        nodes.put(name, node);
    }

    public void addEdge(String source, String destination, int weight) {
        Node sourceNode = nodes.get(source);
        Node destinationNode = nodes.get(destination);
        Edge edge = new Edge(sourceNode, destinationNode, weight);
        edges.add(edge);
    }

    public List<String> findShortPath(String start, String end) {
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previousNodes = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> distances.getOrDefault(a, Integer.MAX_VALUE)
                - distances.getOrDefault(b, Integer.MAX_VALUE));

        Node startNode = nodes.get(start);
        pq.offer(startNode);
        distances.put(startNode, 0);

        boolean foundPath = false;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            visited.add(current);

            for (Edge edge : edges) {
                Node neighbor = edge.getDestination();

                if (edge.getSource().equals(current) && !visited.contains(neighbor)) {
                    int newDistance = distances.get(current) + edge.getWeight();

                    if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        distances.put(neighbor, newDistance);
                        previousNodes.put(neighbor, current);
                        pq.offer(neighbor);

                    }
                }
            }
        }

        List<String> shortestPath = new ArrayList<>();
        Node temp = nodes.get(end);

        if (temp == null || !distances.containsKey(temp)) {
            // If there is no path to the specified ending node
            return shortestPath;
        }

        while (temp != null) {
            shortestPath.add(0, temp.getName());
            temp = previousNodes.get(temp);
        }

        return shortestPath;
    }

    public boolean isValidNode(String nodeName) {
        return nodes.containsKey(nodeName);
    }

}
