package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Demo02 {
    @MyAnnotation2(name="👴",schools = {"哈尔滨佛教学院"})
    public void fk(){

    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE,ElementType.METHOD})
@interface MyAnnotation2{
    //格式：  参数类型 + 参数名 + （） 若只有一个参数，一般名称为value
    String name() default  "";
    int age() default 0;
    int id() default -1;//默认值-1 代表不存在
    String[] schools(); //无默认值的参数，使用时必须显示赋值
}
