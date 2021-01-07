package io;

import java.io.*;

/**
 * 从文件中读取图片
 * 重新写回文件
 */
//ByteArrayOutPutStream和In是java虚拟机内存中的资源，不需要手动释放
public class ByteArrayTest {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "io" + File.separator;
        String fileName = "123.png";
        byte[] fileToByteArray = fileToByteArray(path + fileName);
        System.out.println(fileToByteArray.length);
        String newFileName = "cnm.png";
        byteArrayToFile(fileToByteArray,path+newFileName);
    }

    //1。图片读取到字节数组
    //图片到程序FileInputStream
    //程序到字节数组ByteArrayOutPutStream
    public static byte[] fileToByteArray(String filePath) {
        //1.创建源与目的地
        File file = new File(filePath);
        byte[] dst = null;

        //2.选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            is = new FileInputStream(file);
            baos = new ByteArrayOutputStream();

            //3.操作（分段读取）
            byte[] buff = new byte[1024 * 10];//缓冲区，每次读的大小
            int len = -1;//读取长度
            while ((len = is.read(buff)) != -1) {
                baos.write(buff, 0, len);
            }
            baos.flush();
            dst = baos.toByteArray();
            return dst;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //4.关闭资源
                is.close();//文件流相当用占用native的资源，一定要释放
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                baos.close();//字节数组流是java内存中的资源，gc会回收，不必手动释放（释放了也无所谓）
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //2。字节数组写出到文件
    //字节数组到程序 ByteArrayInputStream
    //程序到文件 FileOutputStream
    public static void byteArrayToFile(byte[] data, String dst) {
        //1.创建源与目的地,data已有
        File file = new File(dst);

        //2.选择源
        OutputStream os = null;
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(data);
            os = new FileOutputStream(dst);
            //3.操作
            byte[] buff = new byte[1024 * 10];
            int len = -1;
            while ((len = is.read(buff)) != -1) {
                os.write(buff,0,len);
            }
            os.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("output complete");
    }
}
