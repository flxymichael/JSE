package io;

import java.io.*;

/**
 * BufferedInputStream和BufferedInputStream可以用来装饰FileInputStream和ByteArrayInputStream
 * 通过加入缓冲流的方式减少IO从而提升性能
 */
public class BufferedIOStream {

    //重写FileUtils.copy(is,os)
    public static void copy(String srcPath, String dstPath) {
        File src = new File(srcPath);
        File dst = new File(dstPath);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dst))){
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
