package com.yema3.bufferedReaderWriter;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author ：yema
 * @Description ：字符输出流缓冲区 java.io.BufferedWriter 继承自 java.io.Writer
        BufferedWriter 具有自己特有的方法 newLine();换行写同\r\n（windows下），linux下是\n
        但是该方法具有平台无关性，推荐用方法，提高跨平台性
 * @Date ：Create in 11:40 2018/3/30
 * @Edit ：by Intellij IDEA
 */
public class BufferedWriterDemo {

    @Test
    public void fun() throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\data\\demo.java"));
        bw.write(100);
        bw.newLine();
        bw.flush();
        bw.write("你好".toCharArray());
        bw.newLine();
        bw.flush();
        bw.write("大家都好");
        bw.flush();
        bw.close();
    }
}
