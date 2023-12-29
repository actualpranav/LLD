package Collections;

import java.util.Comparator;

public class StudentSalaryComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2){
        if(s1.salary == s2.salary)return 0;
        else if(s1.salary < s2.salary) return -1;
        else  return 1;
    }
}
