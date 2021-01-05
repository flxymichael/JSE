import java.util.ArrayList;
/**
 * 泛型
 * 在编译之后程序会采取去泛型化的措施。
 * 也就是说Java中的泛型，只在编译阶段有效。
 * 在编译过程中，正确检验泛型结果后，会将泛型的相关信息擦出，并且在对象进入和离开方法的边界处添加类型检查和类型转换的方法。
 * 也就是说，泛型信息不会进入到运行时阶段。
 *
 *
 * 常见泛型使用：
 * 泛型类，如map、set等
 * 泛型接口
 * 泛型方法
 *
 */
public class GenericsDemo {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();

        Class aClass = strings.getClass();
        Class aClass1 = strings1.getClass();

        // * 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
        if (aClass.equals(aClass1)){//==比较地址，equal比较对象各个属性
            System.out.println(("equal"));
        }

    }
}
