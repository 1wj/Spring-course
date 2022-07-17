package nj.nxd.ba07;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 注解+属性配置文件properties +${}
 */

@Component("myStudent")
public class Student {

    @Value("${myname}")
 private String name;
    @Value(value="${myage}")
 private Integer age;

   // @Autowired  byType
   // @Qualifier("mySchool") byName
    // @Resource(name="mySchool") byName
    @Resource  //默认byName不行自动byType
 private School school;


public Student() {
    System.out.println("使用了无参数构造");
}

public void setName(String name) {
    this.name = name;
}

public void setAge(Integer age) {
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
