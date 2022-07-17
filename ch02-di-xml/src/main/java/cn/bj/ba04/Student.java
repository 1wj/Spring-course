package cn.bj.ba04;

public class Student {
    private String name;
    private int age;
    //声明一个引用类型
    School school;

    public Student() {
        System.out.println("先调用的无参数构造方法");
    }

    /**
     * 创建一个有参构造
     * @param myName
     * @param myAge
     * @param mySchool
     */
    public Student(String myName, int myAge, School mySchool){
        System.out.println("====调用了有参数构造方法====");
        this.name=myName;
        this.age=myAge;
        this.school=mySchool;
    }

    public Student(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
