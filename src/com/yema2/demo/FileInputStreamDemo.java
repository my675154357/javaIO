package com.yema2.demo;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：java.io.InputStream 所有输入字节流的父类
 *                  读取任意文件，每次读一个字节
 *                  构造方法：为这个流数据绑定数据源
 *                 read()方法：
 *                  1.执行一次就自动读取下一个字节
 *                  2.返回的是读取到的字节ASCII码
 *                  3.读取到文件结尾，返回-1
 * @Date ：Create in 17:02 2018/3/29
 * @Edit ：by Intellij IDEA
 */
public class FileInputStreamDemo {

    /**
     * 读取字节
     * @throws IOException
     */
    @Test
    public void fun1() throws IOException {
        FileInputStream in = new FileInputStream("F:\\data\\a.txt");

        //接收read()方法返回值。
        int len = 0;

        while ((len=in.read()) != -1){
            //len这个变量不能省略，如果在下面字节输出in.read()，那就是又读了一次，就会漏掉上一次读的内容
            System.out.print((char) len);
        }

        in.close();
    }

    /**
     * 读取字节数组，数组起到了缓冲作用
     * @throws IOException
     */
    @Test
    public void fun2() throws IOException {
        FileInputStream in = new FileInputStream("F:\\data\\a.txt");
        //创建字节数组，定义了长度为2的空数组。一般定义数组长度为1024
        byte[] b = new byte[2];
        int len = 0;

        //返回读取到的有效字节数
        while((len = in.read(b)) != -1){
            /**
             * 假设a.txt中有内容为abcde。一次读2个字节，会循环3次，打印出abcded。但是我实际测试是打印abcde，可能我当
             * 前的jdk版本为此做了优化。但还是需要归究原因：
             * byte长度为2，第一次读：取到ab输出；第二次读：取到cd覆盖了ab输出；第三次读：取到e的时候读到了文件结尾的
             * 结束标记，系统将此标记返回给jvm，jvm就给read()方法返回-1。此时刚刚读到的e覆盖了上一次的c，数组第0位就是
             * e，但数组第1位还是上一次的d，所以就会输出ed。
             * 解决：利用String对象的重载。new String(b,0,len)表示从b的第0位读，读取长度为len
             */
            System.out.print(new String(b,0,len));
        }

        in.close();
    }
}
