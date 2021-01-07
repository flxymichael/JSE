package io;

import java.io.*;

/**
 * IO流标准步骤 字节输出流
 * 1.创建目的地
 * 2.选择流（字节？字符？）
 * 3.操作
 * 4.关闭资源
 */
public class StandardStepsOut {
    public static void main(String[] args) {
        // 1.创建目的地
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "io" + File.separator + "dst.txt");

        //2.选择流
        OutputStream os = null;
        try {
            os= new FileOutputStream(file,true);
            //3.操作
            String msg = "fuck you go fuck yourself\r\n";
            byte[] data = msg.getBytes();//字符串->字符数组;
            os.write(data,0,data.length);
            os.flush();//刷新，避免数据驻留在内存中
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (os!=null){
                try {
                    //4.关闭资源
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
