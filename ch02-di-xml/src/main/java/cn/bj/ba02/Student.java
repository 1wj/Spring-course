package cn.bj.ba02;

public class Student {
    private String name;
    private int age;
    //声明一个引用类型
    School school;

    public Student() {
        System.out.println("先调用的无参数构造方法");
    }

    public void setName(String name) {
        System.out.println("setname===="+name);
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("setage===="+age);
        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("setschool==="+school);
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
