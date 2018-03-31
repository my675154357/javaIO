package com.yema2.demo;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：将文件读入内存（程序），称为输入；从内存（程序）写出到文件，称为输出
 *              直接输出流：java.io.OutPutStream 是所有直接输出流的父类。里面都是写文件的方法
 *              这样的字节流，每次只操作文件中的1个字节，硬盘中的任何文件都可以，因为这些文件的最小单位就是直接。但是
 *              不能操作文夹，因为文件夹不具有字节的概念.
 *              write(int b) 写入一个字节
 *              write(byte[] b) 写入直接数组
 *              write(byte[] b,int len, int n) 从len索引开始写入，写n个
 *              close() 关闭流对象，并且释放与此流相关的资源。流对象操作文件的时候，自己不做，依赖于操作系统
 * @Date ：Create in 16:09 2018/3/29
 * @Edit ：by Intellij IDEA
 */

/**
 * FileOutPutStream 绑定输出的数据目的
 * 流对象的使用步骤：
 *  1.创建流对象的方法，绑定数据目的
 *  2.调用流对象的方法write
 *  3.close()
 */
public class FileOutPutStreamDemo {

    @Test
    public void fun1() throws IOException {
        //两个构造方法：参数为String或File。会创建文件。如果原本存在此文件，会直接覆盖
        FileOutputStream out = new FileOutputStream("F:\\data\\a.txt");
        //流对象的方法write

        //写一个字节。100的ASCII是d，所以显示d
        out.write(100);

        //写字节数组
        byte[] b = {65,66,67,68};
        out.write(b);

        //写字节数组的一部分，开始的索引，写几个
        out.write(b,1,2);

        //写字符串
        out.write("hello".getBytes());

        out.close();
    }

    /**
     * 文件的续写和换行
     * 构造方法的第二个参数：为true从末尾写，false从开头写
     * \r\n 换行
     * try catch处理
     * 如通是因为硬件问题，比如拔掉外设，移动存储损坏。这些问题，程序无法处理
     */
    @Test
    public void fun2() {
        FileOutputStream fos = null;
        try {
            File file = new File("F:\\data\\a.txt");
            fos = new FileOutputStream(file,true);
            fos.write("hello\r\nworld".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("文件写入失败，请重试");
        }finally {
            try {
                if (fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭资源失败");
            }
        }
    }
}
