package io;

import java.io.*;


public class BufferedReaderWriter {
    public static void main(String[] args) {
        writerTest();
        copy("asd.txt","asd_copy.txt");
    }

    public static void readerTest() {
        String filePath = FileUtils.path + "asd.txt";
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String contain = null;
            while ((contain = br.readLine()) != null) {
                System.out.println(contain);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writerTest() {
        String filePath = FileUtils.path + "asd.txt";
        File file = new File(filePath);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
            for (int i = 0; i < 3; i++) {
                bw.write("1123123");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy(String srcPath, String dstPath) {
        String path = FileUtils.path;
        File src = new File(path + srcPath);
        File dst = new File(path + dstPath);

        try (BufferedReader br = new BufferedReader(new FileReader(src));
             BufferedWriter bw = new BufferedWriter(new FileWriter(dst,true))){
            String contain = null;
            while ((contain=br.readLine())!=null){
                bw.write(contain);
                bw.newLine();
            }
            bw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
