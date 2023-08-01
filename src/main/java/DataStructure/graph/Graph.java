package DataStructure.graph;

import java.util.*;

public class Graph {

    private Map<Vertex, List<Vertex>> adjVertices;
    public Graph(){
        this.adjVertices = new HashMap<>();
    }

    public void addVertex(String label){
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }
    public void removeVertex(String label){
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    public void addEdge(String label1, String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }
    public void removeEdge(String label1,String label2){
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null) eV1.remove(v2);
        if (eV2 != null) eV2.remove(v1);
    }
    public List<Vertex> getAdjVertices(String label){
        return adjVertices.get(new Vertex(label));
    }

    class Vertex {
        String label;
        public Vertex(String label){
            this.label = label;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = result*prime + getOuterGraph().hashCode();
            result = result*prime + (label != null ? label.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Vertex vertex = (Vertex) obj;
            if (!getOuterGraph().equals(vertex.getOuterGraph())) return false;
            return Objects.equals(label, vertex.label);
        }

        private Graph getOuterGraph(){
            return Graph.this;
        }
    }
}
