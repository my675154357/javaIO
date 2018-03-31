package com.yema4.demo;

import org.junit.Test;

import java.io.*;

/**
 * @Author ：yema
 * @Description ：打印流java.io.PrintStream  java.io.PrintWriter 两个打印流方法一致，但一般用第二个。
 *          打印流特点：
 *              1.此流不负责数据源，只复制数据目的；
 *              2.永远不会抛io异常，但是可能抛别的异常
 *              3.为其他输出流添加功能
 * @Date ：Create in 11:05 2018/3/31
 * @Edit ：by Intellij IDEA
 */
public class PrintWriterDemo {

    /**
     * 打印流，向数据目的写数据，是String文件
     */
    @Test
    public void fun1() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("F:\\data\\a.txt"));
        //打印的是什么，文件中就是什么
        pw.println(100);
        //Write不同，会去编码
        pw.write(100);
        pw.close();
    }

    /**
     * 打印流，输出目的，是流对象
     * 可以是字节/字符输出流
     */
    @Test
    public void fun2() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("F:\\data\\a.txt"));
        //pw.println("打印流");
        pw.close();
    }

    /**
     * 打印流开启自动刷新
     * 必须满足：1.输出的数据目的必须是流对象 OutputStream Writer
     *          2.必须调用println(),printf(),format()中的任一个方法
     */
    @Test
    public void fun3() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("F:\\data\\a.txt"), true);
        pw.println("i");
        pw.println("love");
        pw.println("java");
        //开启了自动刷新，无需flush()
        pw.close();
    }

    /**
     * 打印流实现文本复制
     */
    @Test
    public void fun4() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("F:\\data\\a.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("F:\\data\\dir\\a.txt"),true);
        String line = null;
        while((line=br.readLine()) != null){
            pw.println(line);
        }
        pw.close();
        br.close();
    }
}
