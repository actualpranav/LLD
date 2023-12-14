package Concurrenty.CallableInterface.Mergesort1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestCaseGenerator {
    static ArrayList<Integer> testcases;
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1001; i++) {
            numbers.add(i);
        }

        // Shuffle the list
        Collections.shuffle(numbers, new Random());

        // Print the shuffled list
//        System.out.println("Shuffled list:");
//        for (Integer number : numbers) {
//            System.out.print(number + ", ");
//        }
//        System.out.println();

        // Store the shuffled numbers in a separate ArrayList
        List<Integer> testcases = new ArrayList<>(numbers);
    }
}
