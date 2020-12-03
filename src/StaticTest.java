/**
 * static方法就是没有this的方法。
 * 在static方法内部不能调用非静态方法，反过来是可以的。
 * 在没有创建任何对象的前提下，仅仅通过类本身来调用static方法。这实际上正是static方法的主要用途。
 */


public class StaticTest {
}

//被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，就可以通过类名去进行访问。
class A{
    //静态方法不依赖具体的对象，非静态方法依赖具体的对象
    //因此，静态方法不可以访问静态对象，因为此时可能类被加载，却没有生成对象，反之是可以的
    private static String str1 = "Fku";
    private String str2 = "fkutoo";

    public void say(){
        System.out.println(str1);
        System.out.println(str2);
    }
    public static void say1(){
        System.out.println(str1);
        //这里会报错
//        System.out.println(str2);
    }
}

class B {
    //static变量也称作静态变量，静态变量和非静态变量的区别是：
    // 静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。
    // 而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。
    //　static成员变量的初始化顺序按照定义的顺序进行初始化。
    private static String str1 = "fku";
}


//static代码块
//
//　  static关键字还有一个比较关键的作用就是 用来形成静态代码块以优化程序性能。
//    static块可以置于类中的任何地方，类中可以有多个static块。
//    在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次。
//    只会在类加载的时候执行一次,很多时候会将一些只需要进行一次的初始化操作都放在static代码块中进行。
