package Search.BDFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BreadthFirstSearch {

    private final static Logger LOGGER = LoggerFactory.getLogger(BreadthFirstSearch.class);
    public static <T>Optional<Tree<T>> search(T value, Tree<T> root){
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        Tree<T> child;
        while(!queue.isEmpty()){
            child = queue.remove();
            LOGGER.debug("Visited trees: {}", child.getValue());

            if (child.getValue().equals(value)) return Optional.of(child);
            else {
                queue.addAll(child.getChildren());
            }
        }
        return Optional.empty();
    }

    public static <T>Optional<Node<T>> search(T value, Node<T> start){
        Queue<Node<T>> queue = new ArrayDeque<>();
        Set<Node<T>> visited = new HashSet<>();
        queue.add(start);

        Node<T> currentNode;
        while(!queue.isEmpty()){
            currentNode = queue.remove();
            LOGGER.debug("Visited neighbors: {}", currentNode.getValue());

            if (currentNode.getValue().equals(value)) return Optional.of(currentNode);
            else {
                visited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(visited);
            }
        }
        return Optional.empty();
    }
}
