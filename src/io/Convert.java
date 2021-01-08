package io;

import java.io.*;

/**
 * 字节流可以处理一切
 * 字符流处理文件好一点
 * InputStreamReader和OutputStreamWriter能提供字节流向字符流的转化
 */
public class Convert {
    public static void main(String[] args) {
        //isr提供字节到字符的转化，br提高性能
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            String contain = null;
            while (!(contain=br.readLine()).equals("exit")){
                bw.write(contain);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
