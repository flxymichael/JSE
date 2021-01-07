package io;

import java.io.*;

/**
 * 工具类
 * 1.封装拷贝
 * 2.封装释放资源
 */
public class FileUtils {
    static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "io" + File.separator;

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path + "dst.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(path + "cnm.txt");
        copy(fileInputStream, fileOutputStream);
    }

    public static void copy(InputStream is, OutputStream os) {
        int len = -1;
        byte[] buffer = new byte[1024];
        try {
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 所有能关闭的IO都实现了Closeable接口
     * @param ios
     */
    public static void freeSource(Closeable... ios) {
        for (Closeable io : ios) {

            try {
                if (io != null) {
                    io.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
