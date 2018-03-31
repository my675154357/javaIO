package com.yema3.bufferedReaderWriter;

import org.junit.Test;

import java.io.*;

/**
 * @Author ：yema
 * @Description ：使用缓冲区流对象，复制文本文件
 *              数据源 BufferedReader+FlieReader 读取
 *              数据目的地 BufferedWriter+FileWriter写入
 *              读取文本，度一行，写一行，写换行
 * @Date ：Create in 16:41 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class Copy {

    @Test
    public void fun() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("F:\\data\\demo.java"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\data\\dir\\demo.java"));
        //读取文本，度一行，写一行，写换行
        String line = null;
        while ((line=br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
