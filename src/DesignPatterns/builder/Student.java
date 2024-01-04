package DesignPatterns.builder;

public class Student {
    int id;
    String name;
    int psp;
    int age;
    String universityName;
    int graduationYear;

    private Student(Builder builder){
        this.id = builder.getId();
        this.name = builder.getName();
        this.universityName = builder.getUniversityName();
        this.age = builder.getAge();
        this.graduationYear = builder.getGraduationYear();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    static class Builder{
        int id;
        String name;
        int psp;
        int age;
        String universityName;
        int graduationYear;
        public int getId() {
            return id;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getPsp() {
            return psp;
        }

        public Builder setPsp(int psp) {
            this.psp = psp;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getUniversityName() {
            return universityName;
        }

        public Builder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public int getGraduationYear() {
            return graduationYear;
        }

        public Builder setGraduationYear(int graduationYear) {
            this.graduationYear = graduationYear;
            return this;
        }



        public Student build(){
            if(age < 22){
                throw new IllegalArgumentException("Age cannot be less than 22");
            }
            if(name == null){
                throw new IllegalArgumentException("Name cannot be empty, please give a name");
            }
            return new Student(this);
        }


    }
}
