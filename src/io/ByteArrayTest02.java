package io;

import java.io.*;

/**
 * 代码经过优化后的ByteArrayTest
 */
public class ByteArrayTest02 {

    //1。图片读取到字节数组
    //图片到程序FileInputStream
    //程序到字节数组ByteArrayOutPutStream
    public static byte[] fileToByteArray(String filePath) {
        //1.创建源与目的地
        File file = new File(filePath);
        byte[] dst = null;

        //2.选择流
        /**
         * 将资源的申请放在try之后的括号里，资源会自动释放，不必手动了
         */
        try (InputStream is = new FileInputStream(file);
             ByteArrayOutputStream os = new ByteArrayOutputStream();) {
            /**
             * 3.操作，流的对接已经封装
             */
            FileUtils.copy(is, os);
            dst = os.toByteArray();
            return dst;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //2。字节数组写出到文件
    //字节数组到程序 ByteArrayInputStream
    //程序到文件 FileOutputStream
    public static void byteArrayToFile(byte[] data, String dst) {
        //1.创建源与目的地,已有

        //2.选择源
        try (OutputStream os = new FileOutputStream(dst);
             InputStream is = new ByteArrayInputStream(data);) {
            //3.操作
           FileUtils.copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output complete");
    }

    public static void main(String[] args) {
        byte[] data = fileToByteArray(FileUtils.path + "cnm.png");
        System.out.println(data.length);
        byteArrayToFile(data,FileUtils.path+"cnnn.png");
    }
}


