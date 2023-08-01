package Sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickTest {

    @Test
    void sort() {
        int[] array = {1,5,6,-3,10,0,15};

        int[] expected = {-3,0,1,5,6,10,15};

        Quick quick = new Quick();
        quick.sort(array);
        int[] actual = array;

        assertArrayEquals(expected,actual);
    }
}