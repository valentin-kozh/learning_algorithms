package Sort;

import java.util.Arrays;

public class Select {
    public static void main(String[] args) {
        Integer[] array = new Integer[33];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*50);
        }
        System.out.println(Arrays.toString(array));
        selectedSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void selectedSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
