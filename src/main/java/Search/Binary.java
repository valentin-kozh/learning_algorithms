package Search;

public class Binary {
    public int binarySearch(int[] array, int item) {
        if (array == null) throw new IllegalArgumentException("Can't be null");
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];
            if (guess == item) return mid;
            else if (guess < item) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public int recursiveBinarySearch(int[] arr, int item){
        int low = 0;
        int high = arr.length-1;
        return search(arr,low,high,item);
    }
    private int search(int[] arr, int low, int high, int item){
        if (low <= high) {
            int mid = (low + high) / 2;
            int guess = arr[mid];
            if (item == guess) return mid;
            else if (guess < item) return search(arr, mid + 1, high, item);
            else return search(arr, low, mid - 1, guess);
        }
        return -1;
    }

}
