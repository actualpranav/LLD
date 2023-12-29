package Collections;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2){
        if(o1.name.length() == o2.name.length()) return 0;
        else if(o1.name.length() < o2.name.length()) return -1;
        else return 1;
    }
}
