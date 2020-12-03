import java.util.ArrayList;
import java.util.List;

public class FinalTest {
    public static void main(String[] args) {
        System.out.println("6");
    }
}

//1.final 修饰类时，该类不可被继承，即断子绝孙类
final class T1 {
    public void say() {

    }

}

//1.1无法继承final类
//class T2 extends  T1{
//
//}

class T3 {

    //2.final修饰方法时，该类可以被继承，但是该方法不可被重写
    public final void say() {

    }
}

class T4 extends T3 {
    //2.1会报错，方法不可被重写
//    public void say(){
//
//    }
}

//3.对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
class T5 {
    public void say() {
        final int i = 0;
        //不可被修改错误
        //i=3;
    }
}

// 4.如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
class T6 {
    void say() {
        final ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        //此时list1内部的object仍可修改
        //但list1不可再指向其他对象

         //此处报错 final 赋值错误
         //list1=list2;
    }
}

class T7{

    //5.final修饰类的成员变量，必须被显示赋值，或在构造函数中赋值
    final String fk;

    public T7(String fk) {
        this.fk = fk;
    }
}
