package io;

import java.io.*;

/**
 * IO流标准步骤 字节输入流
 * 1.创建源
 * 2.选择流（字节？字符？）
 * 3.操作
 * 4.关闭资源
 */
public class StandardStepsIn {
    public static void main(String[] args) throws IOException {
        //1创建源 ,file 指的是某文件或者路径的逻辑名称
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "io" + File.separator;
        File file = new File(path + "asd.txt");//相对路径，其父路径是工程路径

        //2选择流
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            //3操作
//            int tmp;
//            while ((tmp=is.read())!=-1){
//                System.out.println((char) tmp);
//            }

            //分段读取
            int len = -1;//读取长度
            byte[] flush = new byte[1024];//缓冲容器
            while ((len = is.read(flush)) != -1) {
                StringBuffer sb = new StringBuffer(new String(flush, 0, len));
                System.out.println(sb);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭资源，一般放在finally里
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
