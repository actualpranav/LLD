package Collections;

public class Student implements Comparable<Student>{
//    public class Student{
    String name;
    int psp;
    int salary;

    public Student(String name, int psp, int salary){
        this.name = name;
        this.psp = psp;
        this.salary = salary;
    }

    @Override
    public  int compareTo(Student other){
        // we compare this object with other object
        // if both are equal we return 0
        // if other is greater than this, return -1
        // if this is greater than other, return 1
//        return Integer.compare(this.psp, other.psp);
        if(this.psp == other.psp) return 0;
        else if(this.psp < other.psp) return -1;
        else return 1;
    }

}
