package DesignPatterns.builder;

public class Client {
    public static void main(String[] args) {
                Student st1 = Student.getBuilder()
                        .setId(1)
                        .setName("Pranav")
                        .setGraduationYear(2023)
                        .setAge(26)
                        .setPsp(99)
                        .build();
        System.out.println(st1.age);
    }
}
