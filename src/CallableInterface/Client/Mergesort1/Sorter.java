package CallableInterface.Client.Mergesort1;

//import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>>{
    List<Integer> arrayToSort;
    ExecutorService es;

    Sorter(List<Integer> givenArray, ExecutorService passedES){
        arrayToSort = givenArray;
        es = passedES;
    }



    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size() <= 1) return arrayToSort;

        int len = arrayToSort.size();
        int mid = len/2;
        List<Integer> left = new ArrayList<>();
        for(int i = 0; i < mid; i++){
            left.add(arrayToSort.get(i));
        }
        List<Integer> right = new ArrayList<>();
        for(int i = mid; i < len; i++){
            right.add(arrayToSort.get(i));
        }

        Sorter leftSorter = new Sorter(left, es);
        Sorter rightSorter = new Sorter(right, es);

        Future<List<Integer>> leftArrayFuture = es.submit(leftSorter);
        Future<List<Integer>> rightArrayFuture = es.submit(rightSorter);

        List<Integer> leftSortedArray = leftArrayFuture.get();
        List<Integer> rightSortedArray = rightArrayFuture.get();

        List<Integer> mergedSortedArray = getIntegers(leftSortedArray, rightSortedArray);
        return mergedSortedArray;
    }

    private List<Integer> getIntegers(List<Integer> leftSortedArray, List<Integer> rightSortedArray) {
        int i = 0;
        int j = 0;

        List<Integer> mergedSortedArray = new ArrayList<>();
        while(i < leftSortedArray.size() && j < rightSortedArray.size()){
            int leftVal = leftSortedArray.get(i);
            int rightVal = rightSortedArray.get(j);
            if(leftVal < rightVal){
                mergedSortedArray.add(leftVal);
                i++;
            }
            else{
                mergedSortedArray.add(rightVal);
                j++;
            }

        }
        while(i < leftSortedArray.size()){
            int leftVal = leftSortedArray.get(i);
            mergedSortedArray.add(leftVal);
            i++;
        }
        while(j < rightSortedArray.size()){
            int rightVal = rightSortedArray.get(j);
            mergedSortedArray.add(rightVal);
            j++;
        }
        return mergedSortedArray;
    }
}
