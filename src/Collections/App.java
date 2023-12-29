package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args){
//        ArrayList<Student> students = new ArrayList<>();
//
//        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
//
//        priorityQueue.add(new Student("pranav", 76, 23));
//        priorityQueue.add(new Student("kaden", 88, 43));
//        priorityQueue.add(new Student("guyro", 95, 65));
//
//        while (!priorityQueue.isEmpty()){
//            System.out.println(priorityQueue.poll().name);
//        }

        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(20);
        integerArrayList.add(10);
        integerArrayList.add(40);
        integerArrayList.add(90);
        integerArrayList.add(40);
        integerArrayList.add(20);

        Collections.sort(integerArrayList);
        for(Integer k : integerArrayList){
            System.out.println(k);
        }

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("a", 19, 4));
        studentArrayList.add(new Student("zdd", 72, 12));
        studentArrayList.add(new Student("cd", 7, 81));

        StudentNameComparator snc = new StudentNameComparator();
        // uses length of 'name' attribute
        studentArrayList.sort(snc);
        StudentSalaryComparator ssc = new StudentSalaryComparator();
        studentArrayList.sort(ssc);
//            Collections.sort(studentArrayList, new StudentNameComparator());
        for( Student s : studentArrayList){
            System.out.println(s.name);
            System.out.println(s.salary);
        }



    }
}
