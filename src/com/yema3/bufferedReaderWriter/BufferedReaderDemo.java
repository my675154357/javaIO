package com.yema3.bufferedReaderWriter;

import org.junit.Test;

import java.io.*;

/**
 * @Author ：yema
 * @Description ：字符输出流缓冲区 java.io.BufferedReader 继承自 java.io.Reader
 *          readLine() 只返回了行的有效字符，不包含换行符
 * @Date ：Create in 11:40 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class BufferedReaderDemo {

    @Test
    public void fun() throws IOException{
        //定义行编号
        int lineNum = 0;
        BufferedReader br = new BufferedReader(new FileReader("F:\\data\\demo.java"));
        //调用缓冲流的方法readLine()读取文本行
        String s = null;
        while ((s = br.readLine()) != null){
            lineNum++;
            System.out.println(lineNum + "  " + s);
        }
        br.close();
    }
}
