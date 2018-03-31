package com.yema3.demo;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Author ：yema
 * @Description ：java.io.InputStreamReader 继承于 java.io.Reader
                    就是字符的输入流，写文本文件。
                    字节流通向字符流的桥梁，可以将字节流转换成字符流，因此称为转换流
            使用方式：
InputStreamReader(InputStream in) 接收所有的字节输出流。但是字节输入流FileInputStream
InputStreamReader(InputStream in, String charesetName)    指定编码方式，不区分大小写
 * @Date ：Create in 8:24 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class InputStreamReaderDemo {

    /**
     * 转换流对象OutputStreamWriter写文本，采用GBK编码写入
     */
    @Test
    public void fun1()throws IOException{
        //创建字节输入流，绑定数据文件
        FileInputStream fis = new FileInputStream("F:\\data\\a.txt");

        InputStreamReader isr = new InputStreamReader(fis,"utf-8");

        char[] c = new char[1024];
        int len = isr.read(c);//返回读物字符的个数
        System.out.println(new String(c,0,len));
        System.err.println(len);
        //只要关闭外层的流，内层的流也关了
        isr.close();
    }
}
