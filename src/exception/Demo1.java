package exception;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Throwable两个子类：Exception和Error,常用的方法printStackTrace、getMessage也是Throwable的方法
 * Exception:程序员可以处理的错误，如除零异常、空指针、读取文件不存在
 * Error：程序员无法处理的错误，如资源耗尽、JVM内部错误
 *
 * Exception分为两种：运行时异常和受检查异常
 * 受检查异常：如IOException、ParseException，编译时会进行检查，未捕获或抛出则编译不通过
 * 运行时异常：如数组越界等、编译时不会进行检查，多由于程序编写不规范造成
 *
 *
 * 资源回收的操作一般放在finally里面，确保其一定会被回收,使用了自动资源管理技术的场景除外
 * throws用于方法后声明抛出异常，
 * 而throw 关键字用来人工引发异常
 *
 */
//自定义异常需要两个这样的构造方法
class MyException extends Exception{
    public MyException() {
    }
    public MyException(String message) {
        super(message);
    }
}
public class Demo1 {
    public static void main(String[] args)throws Exception {

        //这就是自动资源管理技术:声明或初始化资源语句放到在try语句后面小括号中，语句之 间用分号“;”分隔
        // ，采用了自动资源管理后不再需要finally代码块，不需要自己close这些资源，释放过程交给了JVM。
        try(FileInputStream fs = new FileInputStream("fileName");
            InputStreamReader isr  = new InputStreamReader(fs);
            BufferedReader bf = new BufferedReader(isr);){
            while (bf.readLine()!=null){
                System.out.println(bf.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            throw new MyException("nmsl");
        }

    }
}

