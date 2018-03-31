package com.yema2.demo;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：字符输出流。所有字符输出流的父类。只能写文本文件
 *                 java.io.writer
 *                  write(int c) 写一个字符
 *                  write(char[] c) 写字符数组
 *                  write(char[], int, int)
 *                  wirte(String s)
 *                  构造方法：接收File或String
 *                  每写一次，在执行了flush()刷新了之后，才会将数据送达到目的地
 * @Date ：Create in 18:42 2018/3/29
 * @Edit ：by Intellij IDEA
 */
public class WriterDemo {

    @Test
    public void fun1() throws IOException {
        FileWriter fw = new FileWriter("F:\\data\\a.txt");

        //写一个字符
        fw.write(99);
        fw.flush();

        //写一个字符数组
        char[] c = {'a','b','c','d'};
        fw.write(c);
        fw.flush();//最好写一次刷新一次

        //写数组的一部分
        fw.write(c,2,2);
        fw.flush();

        //写字符串
        fw.write("hello");
        fw.flush();

        //关闭流要先刷新

        fw.close();
    }
}
