package io;

import java.io.*;

/**
 * 打印流
 * PrintStream
 */
public class PrintIO {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        PrintStream ps = System.out;
        PrintStream sysout = System.out;
        ps.println("2222");
        ps.println("asdaa");
        FileUtils.freeSource(ps);

        //打印到文件
        ps=new PrintStream(new FileOutputStream(new File(FileUtils.path+"dst.txt"),true));
        ps.println("666");

        //重定向输出
        System.setOut(ps);
        System.out.println("777");
        FileUtils.freeSource(ps);

        //重定向回来
        FileOutputStream fos = new FileOutputStream(FileDescriptor.out);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ps = new PrintStream(bos,true);
        System.setOut(sysout);
        //todo 没定向回来？？？ 不管了
        System.out.println(888+"asdsadad");
        System.out.println("fafa");
    }

}
