package DataStructure.graph;

import java.util.*;

public class GraphTraversal {
    static Set<String> depthFirstTraversal(Graph graph, String root){
        Stack<String> stack = new Stack<>();
        Set<String> visited = new LinkedHashSet<>();
        stack.push(root);
        while (!stack.isEmpty()){
            String vertex = stack.pop();
            if (!visited.contains(vertex)){
                visited.add(vertex);
                for(Graph.Vertex v : graph.getAdjVertices(vertex)){
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }
    static Set<String> breadthFirstTraversal(Graph graph, String root){
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()){
            String vertex = queue.poll();
            for (Graph.Vertex v : graph.getAdjVertices(vertex)){
                if (!visited.contains(v.label)){
                    queue.add(v.label);
                    visited.add(v.label);
                }
            }
        }
        return visited;
    }
}
