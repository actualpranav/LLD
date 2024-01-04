package DesignPatterns.prototype;

//import DesignPatterns.prototype.IntelligentStudent;
//import DesignPatterns.prototype.Student;
//import DesignPatterns.prototype.StudentRegistry;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void fillRegistry(StudentRegistry studentRegistry){
        Student aprilBatch = new Student();
        aprilBatch.setBatch("April batch");
        aprilBatch.setBatchAvgPsp(82.0);

        studentRegistry.register("abs", aprilBatch);

        IntelligentStudent superAprilBatch = new IntelligentStudent();
        superAprilBatch.setIq(148);
        superAprilBatch.setBatch("super april batch");
        superAprilBatch.setBatchAvgPsp(100);

        studentRegistry.register("sabs", superAprilBatch);
    }

    public static void main(String[] args) {
        StudentRegistry studentRegistry = new StudentRegistry();
        fillRegistry(studentRegistry);

        List<Student> abs = getAprilBatchStudents(studentRegistry);
        List<IntelligentStudent> sabs = getAprilBatchIntelligentStudents(studentRegistry);

        System.out.println(abs.get(1).getName());
        System.out.println(abs.get(0).getName());
        System.out.println(abs.get(2).getName());
        System.out.println(sabs.get(1).getName());
        System.out.println(sabs.get(0).getName());
        System.out.println(sabs.get(2).getName());

    }

    private static List<Student> getAprilBatchStudents(StudentRegistry studentRegistry){
        Student sid = studentRegistry.get("abs").clone();
        sid.setName("Siddarth");
        sid.setAge(30);
        sid.setPsp(90);

        Student mohit = studentRegistry.get("abs").clone();
        mohit.setName("Mohit");
        mohit.setAge(28);
        mohit.setPsp(88);

        Student rahul = studentRegistry.get("abs").clone();
        rahul.setName("Rahul");
        rahul.setAge(25);
        rahul.setPsp(80);

        List<Student> students = new ArrayList<>();
        students.add(sid);
        students.add(mohit);
        students.add(rahul);

        return students;
    }

    private static List<IntelligentStudent> getAprilBatchIntelligentStudents(StudentRegistry studentRegistry){
        IntelligentStudent rajat = (IntelligentStudent) studentRegistry.get("sabs").clone();
        rajat.setName("Rajat");
        rajat.setAge(30);
        rajat.setPsp(98);

        IntelligentStudent vijay = (IntelligentStudent) studentRegistry.get("sabs").clone();
        vijay.setName("Vijay");
        vijay.setAge(28);
        vijay.setPsp(96);


        IntelligentStudent shiva = (IntelligentStudent) studentRegistry.get("sabs").clone();
        shiva.setName("Shiva");
        shiva.setAge(25);
        shiva.setPsp(99);
        shiva.setIq(210);

        List<IntelligentStudent> students = new ArrayList<>();
        students.add(rajat);
        students.add(vijay);
        students.add(shiva);

        return students;
    }

}
