package com.yema3.demo;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @Author ：yema
 * @Description ：java.io.OutputStreamWriter 继承于 java.io.Writer
                    就是字符的输出流，写文本文件。
                    字符流通向字节流的桥梁，可以将字符流转换成字节流，因此称为转换流
            使用方式：
    OutputStreamWriter(OutputStream out) 接收所有的字节输出流。但是字节输出流FileOutputStream
    OutputStreamWriter(OutputStream out, String charesetName)    指定编码方式，不区分大小写
 * @Date ：Create in 8:24 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class OutputStreamWriterDemo {

    /**
     * 转换流对象OutputStreamWriter写文本，采用GBK编码写入
     */
    @Test
    public void fun1()throws IOException{
        //创建字节输出流，绑定数据文件
        FileOutputStream fos = new FileOutputStream("F:\\data\\a.txt");
        //创建转换流对象，绑定字节输出流，使用GBK。默认是以本机编码方式，而本机编码就是GBK，所以也可以不用写
        //gbk存储，一个汉字占2个字节。“你好”应该占4个字节；utf-8存储，一个汉字3个字节。“你
        // 好”应该占6个字节。实际做的时候乱码了，下面写gbk的时候，文件显示6个字节；以utf-8存储的时候文件显示9个字
        // 节，字节数不对，文本就乱码了。
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        //使用转换流写数据
        osw.write("你好");

        //只要关闭外层的流，内层的流也关了
        osw.close();
    }
}
