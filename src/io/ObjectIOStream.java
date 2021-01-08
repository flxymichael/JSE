package io;

import java.io.*;
import java.util.Date;

/**
 * 对象流
 * 1。写出后读取
 * 2。读取的顺序和写出保持一直
 *
 * 对象---》（序列化）写出到---》file/database/memory-----》读入（反序列化）到内存中的obj
 * ObjectOutStream
 * ObjectInputStream
 *
 * 序列化也称为持久化
 */
public class ObjectIOStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(FileUtils.path+"asd.txt");//文件目录
        FileOutputStream fos = new FileOutputStream(file,false);//最底层的节点流
        BufferedOutputStream bos = new BufferedOutputStream(fos);//buffered加速
        ObjectOutputStream oos = new ObjectOutputStream(bos);//对象序列化

        oos.writeObject(new Employee("爷",24));
        oos.writeObject(new String("asdfghjkl"));
        oos.writeObject(new Date());
        oos.flush();
        FileUtils.freeSource(oos);


        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);


        //读取的顺序和写出保持一直
        Object employee = ois.readObject();
        Object string = ois.readObject();
        Object date = ois.readObject();

        FileUtils.freeSource(ois);

        //强转之前最好判断一下
        if (employee instanceof Employee){
            Employee e = (Employee)employee;
            System.out.println(e.getName()+"--->"+e.getAge());
        }
        if (string instanceof String){
            String s = (String)string;
            System.out.println(s);
        }
        if (date instanceof Date){
            Date d = (Date)date;
            System.out.println(d);
        }


    }

}

//要序列化的对象必须实现serializable接口
class Employee implements Serializable{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
