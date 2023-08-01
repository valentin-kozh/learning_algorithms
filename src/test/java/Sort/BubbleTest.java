package Sort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleTest {

    private Integer[] array;
    private Bubble bubble;
    @BeforeEach
    public void init(){
        bubble = new Bubble();
        array = new Integer[]{1,5,6,-3,10,0,15};
    }
    @Test
    void bubbleSort() {
        Integer[] expected = {-3,0,1,5,6,10,15};
        bubble.bubbleSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void optimizeBubbleSort() {
        Integer[] expected = {-3,0,1,5,6,10,15};
        bubble.optimizeBubbleSort(array);
        assertArrayEquals(expected, array);
    }
}