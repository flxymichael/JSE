package reflection;

/**
 * 关于Class
 */
public class Demo01 {
    public static void main(String[] args) {


        //class可以理解为创建某种类的模版
        //只要类型一样，就是同一个class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass());
        System.out.println(b.getClass());

        Class c = void.class;
        Class d = Class.class;
        Class e = String.class;

        System.out.println(c);
        System.out.println(d);
        System.out.println(e);



    }
}
