package Sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Bubble {
    public void bubbleSort(Integer[] arr){
        int n = arr.length-1;
        IntStream.range(0, n-1)
                .flatMap(i -> IntStream.range(1, n-i))
                .forEach(j -> {
                    if (arr[j-1] > arr[j]){
                        int temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    }
                });
    }

    public void optimizeBubbleSort(Integer[] arr){
        int n = arr.length-1, i = 0;
        boolean swapNeeded = true;
        while (i < n-1 && swapNeeded){
            swapNeeded = false;
            for (int j = 1; j < n-i; j++) {
                if (arr[j-1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapNeeded = true;
                }
            }
            if (!swapNeeded) break;
            i++;
        }
    }
}
