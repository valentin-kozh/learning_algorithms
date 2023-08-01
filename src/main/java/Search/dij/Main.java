package Search.dij;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Node nodeA = new Node("A");
//        Node nodeB = new Node("B");
//        Node nodeC = new Node("C");
//        Node nodeD = new Node("D");
//        Node nodeE = new Node("E");
//        Node nodeF = new Node("F");
//
//        nodeA.addDestination(nodeB, 5);
//        nodeA.addDestination(nodeF,2);
//
//        nodeB.addDestination(nodeC,4);
//        nodeB.addDestination(nodeE, 2);
//
//        nodeF.addDestination(nodeB, 8);
//        nodeF.addDestination(nodeE, 7);
//
//        nodeC.addDestination(nodeD, 3);
//        nodeC.addDestination(nodeE, 6);
//
//        nodeE.addDestination(nodeD,1);
//
//        Graph graph = new Graph();
//
//        graph.addNodes(nodeA);
//        graph.addNodes(nodeB);
//        graph.addNodes(nodeC);
//        graph.addNodes(nodeD);
//        graph.addNodes(nodeE);
//        graph.addNodes(nodeF);

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addDestination(nodeB, 10);
        nodeB.addDestination(nodeC, 20);
        nodeC.addDestination(nodeD, 30);
        nodeC.addDestination(nodeE,1);
        nodeE.addDestination(nodeB,1);

        Graph graph = new Graph();

        graph.addNodes(nodeA);
        graph.addNodes(nodeB);
        graph.addNodes(nodeC);
        graph.addNodes(nodeD);
        graph.addNodes(nodeE);


        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

        int shortestPathWeigh = 0;
        List<Node> shortestPath = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (Node node : graph.getNodes()){
            if (node.getName().equals("D")){
                shortestPathWeigh = node.getDistance();
                shortestPath = node.getShortestPath();
            }
        }

        for (Node node : shortestPath){
            sb.append(node.getName()).append(" --> ");
        }
        if (shortestPathWeigh < Integer.MAX_VALUE){
            sb.append("D");
            System.out.printf("Кратчайший путь: %s. Расстояние: %d", sb, shortestPathWeigh);
        }
        else System.out.println("Пути до указанной точки не существует!");
    }
}
