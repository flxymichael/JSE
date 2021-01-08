package io;

import java.io.*;

/**
 * 数据流
 * DataInputStream 和DataOutputStream 可以在传输过程中保留数据的类型：八大基本+String
 * 1。写出后读取
 * 2。读取的顺序和写出保持一致
 *
 */
public class DataIOStream {
    public static void main(String[] args) throws IOException {

        //写出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));
        //操作数据类型+数据
        dataOutputStream.writeBoolean(false);
        dataOutputStream.writeUTF("编程辛酸泪，谁解其中味");
        dataOutputStream.writeInt(996);
        dataOutputStream.flush();//写完要刷新

        byte[] datas = byteArrayOutputStream.toByteArray();//任何东西都能存到字节数组里面去

        //读取 顺序应该与写出顺序保持一致
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));

        boolean b = dataInputStream.readBoolean();
        String s = dataInputStream.readUTF();
        int i = dataInputStream.readInt();
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
    }
}
