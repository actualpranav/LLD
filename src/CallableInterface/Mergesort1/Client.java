package CallableInterface.Mergesort1;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(java.time.LocalTime.now());
        Instant start = Instant.now();
        int cases = 10000;
//        int val = (int) (Math.log(cases)/Math.log(2)) * 2;
        List<Integer> array = testCaseGenerator(new ArrayList<>(), cases);

//        System.out.println("running Single threaded \n");
//        MergeSortSimple ob = new MergeSortSimple(array);
//        List<Integer> sortedArray = ob.sort();

        System.out.println("running Multi threaded with Fixed ThreadPool of size half the size of test case \n");
//        ExecutorService es  = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(cases/2);
        Sorter x = new Sorter(array, es);
        Future<List<Integer>> listFuture = es.submit(x);

        List<Integer> sortedArray = listFuture.get();
                es.shutdown();

        for(Integer n : sortedArray){
            System.out.print(n);
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        System.out.println("\n");
        System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        System.out.println(java.time.LocalTime.now());
    }

    public static List<Integer> testCaseGenerator(List<Integer> numbers, int cases){
        for (int i = 1; i <= cases; i++) {
            numbers.add(i);
        }

        // Shuffle the list
        Collections.shuffle(numbers, new Random());
        return numbers;
    }
}
