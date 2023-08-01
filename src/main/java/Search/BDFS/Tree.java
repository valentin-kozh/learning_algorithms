package Search.BDFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree<T> {
    private T value;
    private List<Tree<T>> children;
    public Tree(T value){
        this.value = value;
        this.children = new ArrayList<>();
    }
    public T getValue(){
        return value;
    }
    public List<Tree<T>> getChildren(){
        return Collections.unmodifiableList(children);
    }
    public static <T> Tree<T> of (T value){
        return new Tree<>(value);
    }
    public Tree<T> addChild(T value){
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }
}
