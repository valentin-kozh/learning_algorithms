package Search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTest {

    @Test
    void binarySearch() {
        int[] array = {0,1,4,6,8,10,12,14,16,18,20};
        Binary binary = new Binary();
        int expected = 9;
        int actual = binary.binarySearch(array,18);
        assertEquals(expected,actual);
    }

    @Test
    void recursiveBinarySearch() {
        int[] array = {0,1,4,6,8,10,12,14,16,18,20};
        Binary binary = new Binary();
        int expected = 9;
        int actual = binary.recursiveBinarySearch(array,18);
        assertEquals(expected,actual);
    }
}