package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射基操
 */
public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //获取class类
        Class userClass =Class.forName("reflection.User");
        //获取无参构造器
        userClass.getDeclaredConstructors();
        //获取带参构造器
        Constructor userConstructor =  userClass.getDeclaredConstructor(String.class,int.class,int.class);
        //利用构造器获取对象
        User instance = (User) userConstructor.newInstance("喜洋洋", 18, 20);
        System.out.println(instance.toString());
        System.out.println(instance);

        //获取普通方法
        Method setName = userClass.getDeclaredMethod("setName", String.class);
        //invoke，激活,通过反射操作方法
        setName.invoke(instance,"懒羊羊");
        System.out.println(instance);

        Field name = userClass.getDeclaredField("name");
        //反射不能直接操作私有方法，需要关闭程序的安全检测，，通过下面这行代码
        name.setAccessible(true);//关闭检测可以提升效率，详情看demo03
        name.set(instance,"沸羊羊");
        System.out.println(instance);


    }
}
