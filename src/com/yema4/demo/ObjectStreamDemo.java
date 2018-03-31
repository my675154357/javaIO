package com.yema4.demo;

import org.junit.Test;

import java.io.*;

/**
 * @Author ：yema
 * @Description ：io对象，实现Person对象的序列化与反序列化
 *              序列化是对象的序列化，如果Person类中age属性用static修饰，那么序列化读取到age=0，而不是25，25没有写
 *              进去。因为静态属性是属于类的，是共享变量；非静态属性是属于对象的，对象私有的成员变量。
 * @Date ：Create in 18:37 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class ObjectStreamDemo {

    /**
     *
     * 将对象写入到文件中保存，这个过程叫对象的序列化； java.io.ObjectOutputStream
     * writeObject(Object o)写出对象的方法
     * 在文件中将对象以流的形式读取，叫做对象的反序列化 java.io.ObjectInputStream
     * @throws IOException
     */
    @Test
    public void writeObject() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\data\\person.txt"));
        Person p = new Person("lisi",25);
        //调用序列化流的方法，写出对象
        oos.writeObject(p);
        oos.close();
    }

    @Test
    public void readObject() throws IOException,ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\data\\person.txt"));
        Person p = new Person();
        //调用序列化流的方法，读对象
        Object o = ois.readObject();//必须有对象的.class文件才能反序列化。所以会抛ClassNotFoundException
        System.out.println(o);
        ois.close();
    }
}
