public class FinalTest{
    public static void main(String[] args) {
        System.out.println("6");
    }
}

//final 修饰类时，该类不可被继承，即断子绝孙类
final class T1{
    public void say(){

    }

}

//无法继承final类
//class T2 extends  T1{
//
//}