package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射性能测试
 */
public class Demo03 {
    //普通调用
    public static void test01() {
        long startTime = System.currentTimeMillis();
        User user = new User();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通调用：" + (endTime - startTime) + "ms");
    }

    //反射调用
    @SuppressWarnings(value = "all")
    public static void test02() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        long startTime = System.currentTimeMillis();
        Class aClass = Class.forName("reflection.User");
        Constructor constructor = aClass.getDeclaredConstructor();
        User user = (User) constructor.newInstance();
        Method getName = aClass.getDeclaredMethod("getName", null);
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user, null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射调用：" + (endTime - startTime) + "ms");
    }

    //反射调用（关闭安全性检测）
    @SuppressWarnings(value = "all")
    public static void test03() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        long startTime = System.currentTimeMillis();

        Class aClass = Class.forName("reflection.User");
        Constructor constructor = aClass.getDeclaredConstructor();
        User user = (User) constructor.newInstance();
        Method getName = aClass.getDeclaredMethod("getName", null);
        getName.setAccessible(true);//在反射调用中，某属性/方法被大量调用时应关闭安全检测，有利于提升性能
        for (int i = 0; i < 1000000000; i++) {
        getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射调用(关闭检测)：" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        test01();
        test02();
        test03();
    }
}
