package Sort;

import java.util.Random;

public class Quick {
    public void sort(int[] array){
        int begin = 0;
        int end = array.length-1;
        quickSort(array,begin,end);
    }
    private void quickSort(int[] array, int begin, int end){
        if (begin < end){
            int partitionIndex = getPartition(array, begin, end);

            quickSort(array, begin, partitionIndex-1);
            quickSort(array, partitionIndex+1, end);
        }
    }
    private int getPartition(int[] array,int begin, int end){
        int index = getRandom(begin,end);
        swap(array,index,end);
        int pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot){
                i++;
                swap(array,i,j);
            }
        }
        swap(array,i+1, end);
        return i+1;
    }

    private int getRandom(int begin, int end){
        Random random = new Random();
        return random.nextInt(end-begin)+begin;
    }
    private void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
