package annotation;

import java.lang.annotation.*;

public class Demo01 {
}

//自定义注解，下面四个是元注解，用来描述其他注解
@Retention(value = RetentionPolicy.RUNTIME)//注解生存周期，一般都是runtime
@Target(value = {ElementType.METHOD,ElementType.TYPE})//注解作用目标
@Documented//是否生成子javaDoc中
@Inherited//子类是否可以继承父类
@interface MyAnnotation{

}