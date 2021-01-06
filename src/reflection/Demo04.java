package reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 */
public class Demo04 {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<Student> studentClass = Student.class;

        //通过反射获得注解
        Annotation[] annotations = studentClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }


        //获取注解的值
        ClassAno annotation = studentClass.getAnnotation(ClassAno.class);
        System.out.println(annotation.value());

        //获取某一个字段的注解的值
        Field name = studentClass.getDeclaredField("id");
        FieldAno fieldAno = name.getAnnotation(FieldAno.class);
        System.out.println(fieldAno);
        System.out.println(fieldAno.name());
        System.out.println(fieldAno.num());
        System.out.println(fieldAno.type());


    }
}

@ClassAno(value = "db_student")
class Student {
    @FieldAno(name = "name", type = "varChar", num = 1000)
    private String StudentName;
    @FieldAno(name = "id", type = "int", num = 10)
    private int id;
    @FieldAno(name = "age", type = "int", num = 1000)
    private int age;

    public Student(String StudentName, int id, int age) {
        this.StudentName = StudentName;
        this.id = id;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return StudentName;
    }

    public void setName(String StudentName) {
        this.StudentName = StudentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + StudentName + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@interface ClassAno {
    String value();
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
@interface FieldAno {
    String name();

    String type();

    int num();
}


