package Search.BDFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch {

    private final static Logger LOGGER = LoggerFactory.getLogger(DepthFirstSearch.class);

    public static <T>Optional<Tree<T>> search(T value, Tree<T> root){
        Stack<Tree<T>> stack = new Stack<>();
        stack.push(root);

        Tree<T> child;

        while(!stack.isEmpty()){
            child = stack.pop();
            LOGGER.debug("Visited trees: {}", child.getValue());

            if (child.getValue().equals(value)) return Optional.of(child);
            else {
                for (Tree<T> ch : child.getChildren()){
                    stack.push(ch);
                }
            }
        }
        return Optional.empty();
    }

    public static <T>Optional<Node<T>> search(T value, Node<T> start){
        Stack<Node<T>> stack = new Stack<>();
        Set<Node<T>> visited = new HashSet<>();
        stack.push(start);
        Node<T> currentNode;
        while (!stack.isEmpty()){
            currentNode = stack.pop();
            visited.add(currentNode);
            LOGGER.debug("Visited neighbors: {}", currentNode.getValue());
            if (currentNode.getValue().equals(value)) return Optional.of(currentNode);
            else {
                for (Node<T> node : currentNode.getNeighbors()){
                    if (!visited.contains(node)) {
                        stack.push(node);
                    }
                }
            }
        }
       return Optional.empty();
    }
}
