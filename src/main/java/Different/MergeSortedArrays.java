package Different;

public class MergeSortedArrays {
    public int[] getMergeArray(int[] foo, int[] bar){
        int mergePosition = 0, fooPosition = 0, barPosition = 0;
        int fooLength = foo.length;
        int barLength = bar.length;
        int[] merge = new int[fooLength+barLength];
        while (fooPosition < fooLength && barPosition < barLength){
            if (foo[fooPosition] < bar[barPosition]){
                merge[mergePosition++] = foo[fooPosition++];
            }
            else {
                merge[mergePosition++] = bar[barPosition++];
            }
        }

        while (fooPosition < fooLength){
            merge[mergePosition++] = foo[fooPosition++];
        }
        while (barPosition < barLength){
            merge[mergePosition++] = bar[barPosition++];
        }
        return merge;
    }
}
