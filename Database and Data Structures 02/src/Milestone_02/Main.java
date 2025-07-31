package Milestone_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");
        graph.addNode("H");
        graph.addNode("I");
        graph.addNode("J");

        // Add edges with weights
        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 5);
        graph.addEdge("B", "C", 6);
        graph.addEdge("B", "D", 8);
        graph.addEdge("C", "D", 7);
        graph.addEdge("C", "E", 2);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "F", 9);
        graph.addEdge("E", "F", 1);
        graph.addEdge("E", "G", 11);
        graph.addEdge("F", "G", 10);
        graph.addEdge("F", "H", 6);
        graph.addEdge("G", "H", 5);
        graph.addEdge("G", "I", 3);
        graph.addEdge("H", "I", 2);
        graph.addEdge("H", "J", 4);
        graph.addEdge("I", "J", 7);

        // Prompt the user for input
        Scanner scanner = new Scanner(System.in);
        boolean calculateAnotherPath = true;

        while (calculateAnotherPath) {
            String startNode = "";
            String endNode = "";

            // Handle input for the starting node
            while (true) {
                System.out.print("Enter the starting location: ");
                startNode = scanner.nextLine();
                if (graph.isValidNode(startNode)) {
                    break;
                } else {
                    System.out.println("Invalid starting location. Please try again.");
                }
            }

            // Handle input for the ending node
            while (true) {
                System.out.print("Enter the ending location: ");
                endNode = scanner.nextLine();
                if (graph.isValidNode(endNode)) {
                    break;
                } else {
                    System.out.println("Invalid ending location. Please try again.");
                }
            }

            List<String> shortestPath = graph.findShortPath(startNode, endNode);

            if (shortestPath.isEmpty()) {
                System.out.println("No path found.");
            } else {
                System.out.println("Shortest Path: " + shortestPath);
            }

            // Ask the user if they want to calculate another path
            while (true) {
                System.out.print("Calculate another path? (yes/no): ");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("yes")) {
                    break;
                } else if (response.equals("no")) {
                    calculateAnotherPath = false;
                    break;
                } else {
                    System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                }
            }
        }

        System.out.println("Program exited.");
    }
}