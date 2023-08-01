package Search.BDFS;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    @Test
    void search() {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> fl1 = root.addChild(2);
        Tree<Integer> fl2 = root.addChild(4);
        Tree<Integer> sl1 = fl1.addChild(3);
        Tree<Integer> sl2 = fl2.addChild(5);

        Tree<Integer> expected = Tree.of(3);

        assertEquals(expected.getValue(), BreadthFirstSearch.search(3, root).get().getValue());
        assertEquals(Optional.empty(),BreadthFirstSearch.search(138, root) );
    }

    @Test
    void testSearch() {
        Node<Integer> node = new Node<>(10);
        Node<Integer> fN = new Node<>(2);
        node.connect(fN);
        Node<Integer> sN = new Node<>(4);
        node.connect(sN);
        Node<Integer> tN = new Node<>(3);
        node.connect(tN);
        fN.connect(tN);

        Node<Integer> expected = new Node<>(3);
        assertEquals(expected.getValue(), BreadthFirstSearch.search(3, node).get().getValue());
        assertEquals(Optional.empty(), BreadthFirstSearch.search(44,node));
    }
}