package Different;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedArraysTest {
    @Test
    void getMergeArray(){
        MergeSortedArrays merge = new MergeSortedArrays();
            int[] foo = {1,3,8,9};
            int[] bar = {1, 2,4,7,10};
            int[] expected = {1,1, 2,3,4,7,8,9,10};
            int[] actual = merge.getMergeArray(foo,bar);
            assertArrayEquals(expected,actual);
    }
}